package com.min.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferInputStreamExp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int bufferSize = 512;
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("c://text.txt"));
		try {
		  byte[] byteBuffer = new byte[bufferSize];
		  int numberOfBytes;
		  do {
		    numberOfBytes = inputStream.read(byteBuffer, 0, bufferSize);
		  } while (numberOfBytes >= 0);
		}
		finally {
		  inputStream.close();
		}

	}
	
	public void test2() throws IOException {
		InputStream inStream = null;
	      BufferedInputStream bis = null;
	      
	      try{
	         // open input stream test.txt for reading purpose.
	         inStream = new FileInputStream("c:/test.txt");

	         // input stream is converted to buffered input stream
	         bis = new BufferedInputStream(inStream);			

	         // read until a single byte is available
	         while(bis.available()>0)
	         {
	            // read the byte and convert the integer to character
	            char c = (char)bis.read();

	            // print the characters
	            System.out.println("Char: "+c);;
	         }
	      }catch(Exception e){
	         // if any I/O error occurs
	         e.printStackTrace();
	      }finally{		
	         // releases any system resources associated with the stream
	         if(inStream!=null)
	            inStream.close();
	         if(bis!=null)
	            bis.close();
	      }
	}

	
}
