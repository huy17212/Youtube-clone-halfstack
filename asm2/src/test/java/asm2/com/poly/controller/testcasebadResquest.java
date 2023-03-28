package asm2.com.poly.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

public class testcasebadResquest extends Mockito {

	@ParameterizedTest
	@ValueSource(strings = { "/index", "/explore", "/subcription", "/library", "/history", "/share", "/find",
			"/upload" })
	public void HomeController(String pathUrl) throws ServletException, IOException {
		try {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			HttpSession session = mock(HttpSession.class);
			Cookie mockCookie = mock(Cookie.class);

			when(request.getSession()).thenReturn(session);
			when(request.getServletPath()).thenReturn(pathUrl);
			when(request.getCookies()).thenReturn(new Cookie[] { mockCookie });

			new HomeController().doGet(request, response);
			Assertions.assertTrue(new HomeController().sign);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@ValueSource(strings = { "/login", "/logout", "/register", "/forgotpassword", "/subcriber" })
	public void AccountController(String pathUrl) throws ServletException, IOException {
		try {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			HttpSession session = mock(HttpSession.class);
			Cookie mockCookie = mock(Cookie.class);

			when(request.getSession()).thenReturn(session);
			when(request.getServletPath()).thenReturn(pathUrl);
			when(request.getCookies()).thenReturn(new Cookie[] { mockCookie });

			new AccountController().doGet(request, response);
			Assertions.assertTrue(new AccountController().sign);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@ValueSource(strings = { "/watch", "/dislike", "/like", "/subcribe" })
	public void VideoController(String pathUrl) throws ServletException, IOException {
		try {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			HttpSession session = mock(HttpSession.class);
			Cookie mockCookie = mock(Cookie.class);

			when(request.getSession()).thenReturn(session);
			when(request.getServletPath()).thenReturn(pathUrl);
			when(request.getCookies()).thenReturn(new Cookie[] { mockCookie });

			new VideoController().doGet(request, response);
			Assertions.assertTrue(new VideoController().sign);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
