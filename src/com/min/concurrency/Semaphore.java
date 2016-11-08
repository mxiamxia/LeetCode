package com.min.concurrency;

//Import the necessary Java synchronization and scheduling classes.

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

import com.sun.corba.se.spi.orbutil.fsm.Action;

/**
* @class PingPongRight
*
* @brief This class implements a Java program that creates two
*        instances of the PlayPingPongThread and start these thread
*        instances to correctly alternate printing "Ping" and "Pong",
*        respectively, on the console display.
*/
public class Semaphore
{
 /**
  * @class SimpleSemaphore
  *
  * @brief This class provides a simple counting semaphore
  *        implementation using Java a ReentrantLock and a
  *        ConditionObject.
  */
 static public class SimpleSemaphore
 {
     /**
      * Constructor initialize the data members. 
      */
     public SimpleSemaphore (int permits)
     { 
         // TODO - You fill in here.
     	count = permits;
     }

     /**
      * Acquire one permit from the semaphore.
      */
     public void acquire() throws InterruptedException
     {
         // TODO - You fill in here.
     	lock.lock();
     	try {
     		if(count==0){
         		condition.await();
         	}
         	count--;
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				lock.unlock();
			}
     }

     /**
      * Return one permit to the semaphore.
      */
     void release() throws InterruptedException
     {
         // TODO - You fill in here.
     	lock.lock();
     	try {
     		if(count==0){
         		condition.signal();
     		}
     		count++;
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				lock.unlock();
			}
     }

     /**
      * Define a ReentrantLock to protect the critical section.
      */
     // TODO - You fill in here.
     ReentrantLock lock = new ReentrantLock();

     /**
      * Define a ConditionObject to wait while the number of permits
      * is 0.
      */
     // TODO - You fill in here.
     final Condition condition = lock.newCondition();

     /**
      * Define a count of the number of available permits.
      */
     // TODO - You fill in here.
     private int count;
 }

 /**
  * Number of iterations to run the test program.
  */
 public static int mMaxIterations = 10;
 
 /**
  * Latch that will be decremented each time a thread exits.
  */
 public static CountDownLatch latch = new CountDownLatch(20); // TODO - You fill in here

 /**
  * @class PlayPingPongThread
  *
  * @brief This class implements the ping/pong processing algorithm
  *         using the SimpleSemaphore to alternate printing "ping"
  *         and "pong" to the console display.
  */
 public static class PlayPingPongThread extends Thread
 {
     /**
      * Constructor initializes the data member.
      */
     public PlayPingPongThread (CountDownLatch latch, SimpleSemaphore ping,SimpleSemaphore pong, String action)
     {
         // TODO - You fill in here.
     	this.latch=latch;
     	this.ping = ping;
     	this.pong = pong;
     	this.action=action;
     	this.count =1;
     }

     /**
      * Main event loop that runs in a separate thread of control
      * and performs the ping/pong algorithm using the
      * SimpleSemaphores.
      */
     public void run () 
     {
     	try {
     		while(count<=10){
     			ping.acquire();
     			System.out.println(action + "! (" + count + ")");
     			pong.release();
     			count++;
     			latch.countDown();
     		}
     	} catch (Exception e) {
     		// TODO: handle exception
     	}finally{
     	}
     }

     /**
      * String to print (either "ping!" or "pong"!) for each
      * iteration.
      */
     // TODO - You fill in here.

     /**
      * The two SimpleSemaphores use to alternate pings and pongs.
      */
     // TODO - You fill in here.
     private String action;
     CountDownLatch latch;
     SimpleSemaphore ping;
     SimpleSemaphore pong;
     private int count;
 }

 /**
  * The main() entry point method into PingPongRight program. 
  */
 public static void main(String[] args) {
 	try {         
 		// Create the ping and pong SimpleSemaphores that control
 		// alternation between threads.

 		// TODO - You fill in here.
 		SimpleSemaphore pingSem = new SimpleSemaphore(1);
 		SimpleSemaphore pongSem= new SimpleSemaphore(0);

 		System.out.println("Ready...Set...Go!");

 		// Create the ping and pong threads, passing in the string
 		// to print and the appropriate SimpleSemaphores.
 		PlayPingPongThread ping =
 				new PlayPingPongThread(latch, pingSem, pongSem, "Ping");
 		PlayPingPongThread pong =
 				new PlayPingPongThread(latch, pongSem, pingSem, "Pong");
 		ping.start();
 		pong.start();


 		// Initiate the ping and pong threads, which will call the
 		// run() hook method.


 		// Use barrier synchronization to wait for both threads to
 		// finish.

 		// TODO - replace replace the following line with a
 		// CountDownLatch barrier synchronizer call that waits for
 		// both threads to finish.
 		latch.await();
 		throw new java.lang.InterruptedException();
 	} 
 	catch (java.lang.InterruptedException e)
 	{System.out.println("Exception");}

 	System.out.println("Done!");
 }
}
