package asm2.com.poly.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asm2.com.poly.containt.finalVariable;
import asm2.com.poly.entity.account;
import asm2.com.poly.service.accountService;
import asm2.com.poly.service.Impl.accountServiceImpl;

@WebServlet(urlPatterns = { "/login", "/logout", "/register", "/forgotpassword","/subcriber" })
public class AccountController extends HttpServlet {

	accountService service = new accountServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession Sesstion = req.getSession();
		String whatServiceUNeed = req.getServletPath();
		switch (whatServiceUNeed) {
		case "/login":
			doGetLogin(req, resp);
			break;
		case "/logout":
			dogetLogout(req, resp, Sesstion);
			break;
		case "/register":
			dogetRegister(req, resp);
			break;
		default:
			break;
		}
	}

	private void dogetRegister(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("views/user/register.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String whatServiceUNeed = req.getServletPath();
		HttpSession session = req.getSession();
		switch (whatServiceUNeed) {
		case "/login":
			doPostLogin(req, resp, session);
			break;
		case "/register":
			doPostRegister(req, resp, session);
			break;
		case "/subcriber":
			doPostSubcriber(req, resp, session);
			break;
		default:
			break;
		}
	}

	private void doPostSubcriber(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		
	}

	private void doPostRegister(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		try {
			
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String username = req.getParameter("username");
			String file = req.getParameter("file");
			
			account account = new account();
			account.setAccountusername(username);
			account.setEmail(username);
			account.setAccountpassword(password);
			account.setAvatar(username);
			account.setAccountusername(username);
			account.setAccountusername(username);
			
			service.create(account);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private void doPostLogin(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			account entity = service.findByUsernameAndPassword(username, password);

			if (entity != null) {
				session.setAttribute(finalVariable.CURRENTUSER, entity);
				resp.sendRedirect("index");
			} else {
				resp.sendRedirect("login");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doGetLogin(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("views/user/login.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void dogetLogout(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		try {
			session.removeAttribute(finalVariable.CURRENTUSER);
			resp.sendRedirect("index");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
