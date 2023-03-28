package asm2.com.poly.thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import asm2.com.poly.entity.video;
import asm2.com.poly.service.videoService;
import asm2.com.poly.service.Impl.videoServiceImpl;

public class testcasethread {
	videoService servicevideo = new videoServiceImpl();
	video video = new video();
	
	@Test
	public void testWatchTime1() {
		threadCountView view  = new threadCountView();
		view.run();
		Assertions.assertTrue(view.sign);
	}
	
	@Test
	public void testWatchTime2() {
		threadCountView view  = new threadCountView(servicevideo, video);
		view.run();
		Assertions.assertTrue(view.sign);
	}
}
