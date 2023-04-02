package asm2.com.poly.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asm2.com.poly.containt.finalVariable;
import asm2.com.poly.containt.killingAllThread;
import asm2.com.poly.dao.daoImpl.subcriberServiceImpl;
import asm2.com.poly.entity.account;
import asm2.com.poly.entity.subcriber;
import asm2.com.poly.myException.failToLogin;
import asm2.com.poly.myException.failToRegister;
import asm2.com.poly.service.accountService;
import asm2.com.poly.service.Impl.accountServiceImpl;

@WebServlet(urlPatterns = { "/login", "/logout", "/register", "/forgotpassword", "/subcriber"})
public class AccountController extends HttpServlet {
	Boolean sign = false;
	accountService service = new accountServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		new killingAllThread().killingAllThread();
		HttpSession Sesstion = req.getSession();
		String whatServiceUNeed = req.getServletPath();
		switch (whatServiceUNeed) {
		case "/login":
			sign = true;
			doGetLogin(req, resp);
			break;
		case "/logout":
			sign = true;
			dogetLogout(req, resp, Sesstion);
			break;
		case "/register":
			sign = true;
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
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doPostSubcriber(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

	}

	private void doPostRegister(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws failToRegister, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String username = req.getParameter("username");
		String file = req.getParameter("file");
		String nameChannel = req.getParameter("nameChannel");

		account account = new account();
		account.setAccountusername(username);
		account.setEmail(email);
		account.setAccountpassword(password);
		account.setAvatar(file);
		account.setDatecreate(finalVariable.CURRENTDATE);
		account.setDateupdate(finalVariable.CURRENTDATE);
		account.setNameChannel(nameChannel);
		account.setIsadmin(false);
		account.setIsactive(true);

		if (username == null || password == null || file == null || email == null) {
			sign = false;
		} else {
			service.create(account);
			subcriber subcriber = new subcriber();
			subcriber.setAccountid(account.getId());
			subcriber.setListsubcriber("");
			new subcriberServiceImpl().create(subcriber);
			resp.sendRedirect("login");

		}
	}

	private void doPostLogin(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws IOException, failToLogin, ServletException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Object rememberme = req.getParameter("rememberme");

		if (rememberme != null) {
			if (rememberme.toString().equals("on")) {
				Cookie cookieusername = new Cookie("username", username);
				Cookie cookiepassword = new Cookie("password", password);
				cookieusername.setMaxAge(60 * 60 * 24 * 365);
				cookiepassword.setMaxAge(60 * 60 * 24 * 365);
				resp.addCookie(cookieusername);
				resp.addCookie(cookiepassword);
			} else {
				Cookie[] cookies = req.getCookies();
				for (Cookie cookie : cookies) {
					if (cookie.getName().equalsIgnoreCase("username")
							|| cookie.getName().equalsIgnoreCase("password")) {
						cookie.setMaxAge(0);
						resp.addCookie(cookie);
					}
				}
			}
		}

		account entity = service.findByUsernameAndPassword(username, password);
		if (entity != null) {
			session.setAttribute(finalVariable.CURRENTUSER, entity);
			resp.sendRedirect("index");
		} else {
			resp.sendRedirect("login");
			sign = false;
		}

	}

	String username;
	String password;

	private void doGetLogin(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Cookie[] cookies = req.getCookies();

			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					username = cookie.getValue();
				}
				if (cookie.getName().equals("password")) {
					password = cookie.getValue();
				}
			}
			account account = new accountServiceImpl().findByUsernameAndPassword(username, password);
			if (account != null) {
				resp.sendRedirect("autoLogin?id=" + account.getId());
			};

			req.getRequestDispatcher("views/user/login.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void dogetLogout(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		try {
			session.removeAttribute(finalVariable.CURRENTUSER);
			Cookie[] arrayCookie = req.getCookies();
			List<Cookie> listCookie = Arrays.asList(arrayCookie);

			for (Cookie cookie : listCookie) {
				System.out.print(cookie.getName());
				if (cookie.getName().length() <= 5) {
					cookie.setMaxAge(0);
				}
				resp.addCookie(cookie);
			}

			resp.sendRedirect("index");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private boolean isContainSpecialCharacter(String string) {
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(string);
		boolean isStringContainsSpecialCharacter = matcher.find();
		if (isStringContainsSpecialCharacter) {
			return true;
		}
		return false;
	}
}
