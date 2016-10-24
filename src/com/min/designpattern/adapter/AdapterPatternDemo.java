package com.min.designpattern.adapter;

public class AdapterPatternDemo {
	
	
	public static void main(String[] args) {
		AudioPlayer player = new AudioPlayer();
		player.play("mp3", "file1");
		player.play("mp4", "file1");
		player.play("vlc", "file1");
	}

}
