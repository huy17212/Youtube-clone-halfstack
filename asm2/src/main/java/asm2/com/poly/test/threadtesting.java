package asm2.com.poly.test;

import java.util.Set;

import asm2.com.poly.entity.video;
import asm2.com.poly.service.Impl.videoServiceImpl;
import asm2.com.poly.thread.threadCountView;

public class threadtesting {

	public static void main(String[] args) {

		threadCountView thread = new threadCountView(new videoServiceImpl(), new video());
		thread.setName("countView");
		thread.start();

		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		for (Thread element : threadSet) {
			if (element.getName().equals("countView")) {
				element.stop();
				System.out.println("stop thanh cong");
			}
		}

	}
}
