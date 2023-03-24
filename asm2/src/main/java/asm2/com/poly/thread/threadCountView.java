package asm2.com.poly.thread;

import asm2.com.poly.entity.video;
import asm2.com.poly.service.videoService;

public class threadCountView extends Thread {
	
	public videoService servicevideo;
	public video video;
	
	
	public threadCountView(videoService servicevideo, video video) {
		this.servicevideo = servicevideo;
		this.video = video;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 60; i++) {
					Thread.sleep(1000);
					i++;
					if(i == 59) {
						video.setViews(video.getViews() + 1);
						this.servicevideo.update(video);
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
