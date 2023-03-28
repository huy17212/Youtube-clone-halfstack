package asm2.com.poly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asm2.com.poly.containt.finalVariable;
import asm2.com.poly.dto.videoDTO;
import asm2.com.poly.dto.videoDTOMethods;
import asm2.com.poly.entity.account;
import asm2.com.poly.entity.repository;
import asm2.com.poly.entity.repositoryStatus;
import asm2.com.poly.entity.video;
import asm2.com.poly.service.accountService;
import asm2.com.poly.service.repositoryService;
import asm2.com.poly.service.videoService;
import asm2.com.poly.service.Impl.accountServiceImpl;
import asm2.com.poly.service.Impl.repositoryServiceImpl;
import asm2.com.poly.service.Impl.videoServiceImpl;

@WebServlet(urlPatterns = { "/index", "/explore", "/subcription", "/library", "/history", "/share", "/find",
		"/upload" })
public class HomeController extends HttpServlet {
	Boolean sign = false;
	private static final long serialVersionUID = 1L;

	videoService videoService = new videoServiceImpl();
	repositoryService repositoryService = new repositoryServiceImpl();
	accountService accountService = new accountServiceImpl();
	
	List<videoDTO> ListVideoInIndex;
	List<videoDTO> ListUuTien;
	List<videoDTO> ListKhongUuTien;

	// 1 doGet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String whatServiceUNeed = req.getServletPath();
		Cookie[] arrayCookie = req.getCookies();
		List<Cookie> listCookie = Arrays.asList(arrayCookie);

		switch (whatServiceUNeed) {
		case "/index": {
			sign = true;
			videoDTOMethods dto = new videoDTOMethods();
			ListVideoInIndex = dto.parseToListVideoDTOObject(ListVideoInIndex, listCookie);
			req.setAttribute("videos", ListVideoInIndex);
			
			req.getRequestDispatcher("views/user/index.jsp").forward(req, resp);
			break;
		}

		case "/library": {
			sign = true;
			req.getRequestDispatcher("views/user/repository.jsp").forward(req, resp);
			break;
		}
		case "/find": {
			sign = true;
			String whatUNeedToFind = req.getParameter("fin");
			List<video> videosfind = videoService.findByTitle(whatUNeedToFind);

			req.setAttribute("videos", videosfind);
			req.getRequestDispatcher("views/user/find.jsp").forward(req, resp);
			break;
		}
		case "/explore": {
			sign = true;
			break;
		}
		case "/subcription": {
			sign = true;
			break;
		}
		case "/history": {
			sign = true;
			break;
		}
		case "/share": {
			sign = true;
			break;
		}
		case "/upload": {
			sign = true;
			if (session.getAttribute(finalVariable.CURRENTUSER) != null) {
				req.getRequestDispatcher("views/user/upload.jsp").forward(req, resp);
			} else {
				resp.sendError(403);
			}
			break;
		}
		default: {
			resp.sendRedirect("index");
		}

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String whatServiceUNeed = req.getServletPath();
		HttpSession session = req.getSession();
		switch (whatServiceUNeed) {
		case "/upload": {
			doPostUpload(req, resp, session);
			break;
		}
		}
	}

	private void doPostUpload(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		try {
			req.setCharacterEncoding("UTF-8");
			// add a new video to table video
			video video = new video();
			String poster = req.getParameter("poster");
			String title = req.getParameter("title");
			String discription = req.getParameter("discription");
			String href = req.getParameter("href");
			String hashtag = req.getParameter("hashtag");
			String isactive = req.getParameter("isactive");
			video.setTitle(title);
			video.setDiscription(discription);
			video.setHref(href);
			video.setPoster(poster);
			video.setViews(0);
			video.setLikenumber(0);
			video.setCommentnumber(0);
			video.setHashtag(hashtag);
			video.setDatecreate(finalVariable.CURRENTDATE);
			video.setDateupdate(finalVariable.CURRENTDATE);
			video.setShares(0);
			video.setIsactive(Integer.parseInt(isactive) == 1 ? true : false);
			videoService.create(video);

			// add a new video to account repository
			repositoryStatus repositoryStatus = new repositoryStatus();
			repositoryStatus.setId(3);
			repositoryStatus.setStatus("upload");

			repository repository = new repository();
			repository.setAccountid((account) session.getAttribute(finalVariable.CURRENTUSER));
			repository.setVideoid(video);
			repository.setDatecreate(finalVariable.CURRENTDATE);
			repository.setDateupdate(finalVariable.CURRENTDATE);
			repository.setStatusid(repositoryStatus);

			repositoryService.create(repository);
			resp.sendRedirect("index");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
