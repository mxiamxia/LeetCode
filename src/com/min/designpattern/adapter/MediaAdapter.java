package com.min.designpattern.adapter;

public class MediaAdapter {
	AdvancedMediaPlayer advancedMusicPlayer;
	public MediaAdapter(String type) {
		if (type.equalsIgnoreCase("mp4")) {
			advancedMusicPlayer = new Mp4Player();
		} else {
			advancedMusicPlayer = new VlcPlayer();
		}
	}

	public void play(String fileName) {
		advancedMusicPlayer.play(fileName);
	}
}
