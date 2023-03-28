package asm2.com.poly.controller;



import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import asm2.com.poly.myException.failToLogin;

public class testcaseAccountController extends Mockito {

	@ParameterizedTest
	@CsvSource({ "accUser, abc", "dasdsa, dsasad"})
	public void testAccountLogin(String username, String password) throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);

		when(request.getSession()).thenReturn(session);
		when(request.getServletPath()).thenReturn("/login");
		when(request.getParameter("username")).thenReturn(username);
		when(request.getParameter("password")).thenReturn(password);


		AccountController con = new AccountController();
		con.doPost(request, response);
		
		Assertions.assertTrue(con.sign);
	}

	@ParameterizedTest
	@CsvSource({", abc, hahuytri2K3@gmail.com, anh1.jpg", "%^$&#^, , hahuytri2K3@gmail.com, anh1.jpg",
			"ðasdasdadsdsdsdsda, --, hahuytri2K3@gmail.com, anh1.jpg", "ðâsdasd, abc, hahuytri2K3@gmail.com, anh1.jpg",
			"dsadasds, abc, hahuytri2K3@gmail.com, anh1.jpg","accUser3, abc, hahuytri2K3@gmail.com, anh1.jpg" })

	public void testServlet(String username, String password, String email, String file) throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);

		when(request.getSession()).thenReturn(session);
		when(request.getServletPath()).thenReturn("/register");
		when(request.getParameter("username")).thenReturn(username);
		when(request.getParameter("password")).thenReturn(password);
		when(request.getParameter("email")).thenReturn(email);
		when(request.getParameter("file")).thenReturn(file);

		AccountController con = new AccountController();
		con.doPost(request, response);
		Assertions.assertTrue(con.sign);
	}
	
	

}
