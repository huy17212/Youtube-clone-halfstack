package asm2.com.poly.containt;

import java.util.Set;

public class killingAllThread {

	public void killingAllThread() {
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		for (Thread element : threadSet) {
			if (element.getName().equals("countView")) {
				element.stop();
				System.out.println("stop thanh cong");
			}
		}
	}
}
