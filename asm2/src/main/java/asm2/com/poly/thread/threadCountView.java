package asm2.com.poly.thread;

import asm2.com.poly.entity.video;
import asm2.com.poly.myException.failToIncreView;
import asm2.com.poly.service.videoService;

public class threadCountView extends Thread {
	
	public videoService servicevideo;
	public video video;
	Boolean sign = false;
	
	
	public threadCountView(videoService servicevideo, video video) {
		this.servicevideo = servicevideo;
		this.video = video;
	}

	public threadCountView() {
		
	}
	
	@Override
	public void run() throws NullPointerException {
		try {
			for (int i = 0; i < 60; i++) {
					Thread.sleep(1000);
					System.out.print(i);
					if(i == 59) {
						sign = true;
						video.setViews(video.getViews() + 1);
						this.servicevideo.update(video);
						stop();
					}
			}
		} catch (Exception e) {
			sign = false;
			e.printStackTrace();
		}
	}
}
