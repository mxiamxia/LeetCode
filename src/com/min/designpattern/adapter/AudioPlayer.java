package com.min.designpattern.adapter;

public class AudioPlayer implements MediaPlayer {

	@Override
	public void play(String type, String file) {
		// TODO Auto-generated method stub
		if (type.equalsIgnoreCase("mp4")) {
			MediaAdapter adapter = new MediaAdapter("mp4");
			adapter.play(file);
		} else if (type.equalsIgnoreCase("vlc")) {
			MediaAdapter adapter = new MediaAdapter("vlc");
			adapter.play(file);
		} else {
			this.play(file);
		}

	}

	private void play(String file) {
		// TODO Auto-generated method stub
		System.out.print("Playing audio");
	}

}
