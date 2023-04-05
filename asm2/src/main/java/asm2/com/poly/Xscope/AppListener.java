package asm2.com.poly.Xscope;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class AppListener implements HttpSessionListener, ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent e) {
// TODO: ghi số đếm trong application scope vào file
	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
// TODO: đọc số đếm trước đây từ file vào application scope
	}
	Integer number = 0;
	@Override
	public void sessionCreated(HttpSessionEvent e) {
		System.out.print("co tung nay nguoi vao ne: " + number+1);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
	}
}