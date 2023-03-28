package asm2.com.poly.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.Cookie;

import asm2.com.poly.entity.video;
import asm2.com.poly.service.videoService;
import asm2.com.poly.service.Impl.videoServiceImpl;

public class testRandomShufferData {
	
	public static void main(String[] args) {
		
		String a = "1,2,3,4,5,6,7,7";
		
		String[] b = a.split(",");
		
		for(int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	
	}

}
