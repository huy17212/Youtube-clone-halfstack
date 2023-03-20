package asm2.com.poly.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asm2.com.poly.containt.finalVariable;
import asm2.com.poly.entity.account;
import asm2.com.poly.entity.history;
import asm2.com.poly.entity.video;
import asm2.com.poly.service.historyService;
import asm2.com.poly.service.videoService;
import asm2.com.poly.service.Impl.historyServiceImpl;
import asm2.com.poly.service.Impl.videoServiceImpl;

@WebServlet(urlPatterns = {"/watch", "/dislike", "/like"})
public class VideoController extends HttpServlet {

	private videoService serviceVideo = new videoServiceImpl();
	private historyService serviceHistory = new historyServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sesstion = req.getSession();
		String whatServiceUNeed = req.getServletPath();
		String href;
		switch (whatServiceUNeed) {
		case "/watch":
			href = req.getParameter("href");
			doGetWatch(req, resp, href, sesstion);
			break;

		case "/dislike"	:{
			href = req.getParameter("href");
			doGetDislike(req, resp, sesstion, href);
			break;
		}
		case "/like":{
			href = req.getParameter("href");
			doGetLike(req, resp, sesstion, href);
			break;
		}
		default:
			resp.sendRedirect("index");
			break;
		}
	}

	private void doGetLike(HttpServletRequest req, HttpServletResponse resp, HttpSession sesstion, String href) {
		try {
			resp.setContentType("application/json");
			video video = serviceVideo.findByHref(href);
			
			account account =(account) sesstion.getAttribute(finalVariable.CURRENTUSER);
			
			history historyUserWatchVideo = serviceHistory.findByUserAndViewId(account.getId(), video.getId());
			video.setLikenumber(video.getLikenumber() + 1);

			historyUserWatchVideo.setIsliked(true);
			
			video result2 = serviceVideo.update(video);
			history result1 = serviceHistory.update(historyUserWatchVideo);
			if(result1 != null && result2 != null) {
				resp.setStatus(204);
			}else {
				resp.setStatus(400);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void doGetDislike(HttpServletRequest req, HttpServletResponse resp, HttpSession sesstion, String href) {
		try {
			resp.setContentType("application/json");
			video video = serviceVideo.findByHref(href);
			account account =(account) sesstion.getAttribute(finalVariable.CURRENTUSER);
			history historyUserWatchVideo = serviceHistory.findByUserAndViewId(account.getId(), video.getId());
			
			historyUserWatchVideo.setIsliked(false);
			video.setLikenumber(video.getLikenumber() - 1);
			
			video result1 = serviceVideo.update(video);
			history result2 = serviceHistory.update(historyUserWatchVideo);
			if(result1 != null && result2 != null) {
				resp.setStatus(204);
			}else {
				resp.setStatus(400);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void doGetWatch(HttpServletRequest req, HttpServletResponse resp, String href, HttpSession session) {
		try {
			video video = serviceVideo.findByHref(href);
			req.setAttribute("video", video);

			account currentuser = (account) session.getAttribute(finalVariable.CURRENTUSER);

			if (currentuser != null) {
				history historyUserWatchVideo = serviceHistory.findByUserAndViewId(currentuser.getId(), video.getId());
				req.setAttribute("history", historyUserWatchVideo);
			} else {
				
			}
			
			req.getRequestDispatcher("views/user/video.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
