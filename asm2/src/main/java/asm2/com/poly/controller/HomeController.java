package asm2.com.poly.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asm2.com.poly.dao.hibernateMethods;
import asm2.com.poly.entity.video;

@WebServlet(urlPatterns = {"/index", "/explore", "/subcription", "/library", "/history", "/share"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String whatServiceUNeed = req.getServletPath();

		switch (whatServiceUNeed) {

		case "/index": {
			hibernateMethods<video> dao = new hibernateMethods<video>();
			List<video> listvideos = dao.findAll(video.class, true);
			req.setAttribute("videos", listvideos);
			req.getRequestDispatcher("views/user/index.jsp").forward(req, resp);
			break;
		}

		case "/library": {
			req.getRequestDispatcher("views/user/repository.jsp").forward(req, resp);
			break;
		}
		default : {
			resp.sendRedirect("index");
		}

		}

	}
}
