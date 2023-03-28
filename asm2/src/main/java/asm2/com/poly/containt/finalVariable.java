package asm2.com.poly.containt;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import asm2.com.poly.dto.videoDTO;

public class finalVariable {
	static final long millis=System.currentTimeMillis(); 
	
	public static final String CURRENTUSER = "current_user";
	public static final String CURRENTVIDEO = "current_video";
	public static final Date CURRENTDATE = new java.sql.Date(millis);
}
