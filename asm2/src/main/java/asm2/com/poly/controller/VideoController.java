package asm2.com.poly.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import asm2.com.poly.containt.finalVariable;
import asm2.com.poly.dao.daoImpl.subcriberServiceImpl;
import asm2.com.poly.dto.videoDTO;
import asm2.com.poly.dto.videoDTOMethods;
import asm2.com.poly.entity.account;
import asm2.com.poly.entity.history;
import asm2.com.poly.entity.subcriber;
import asm2.com.poly.entity.video;
import asm2.com.poly.service.historyService;
import asm2.com.poly.service.subcriberService;
import asm2.com.poly.service.videoService;
import asm2.com.poly.service.Impl.historyServiceImpl;
import asm2.com.poly.service.Impl.videoServiceImpl;
import asm2.com.poly.thread.threadCountView;

@WebServlet(urlPatterns = { "/watch", "/dislike", "/like", "/subcribe" })
public class VideoController extends HttpServlet {

	private videoService serviceVideo = new videoServiceImpl();
	private historyService serviceHistory = new historyServiceImpl();
	private subcriberService serviceSubcriber = new subcriberServiceImpl();
	private history historyUserWatchVideo;
	Boolean sign = false;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sesstion = req.getSession();
		String whatServiceUNeed = req.getServletPath();
		String href;
		switch (whatServiceUNeed) {
		case "/watch":
			sign = true;
			href = req.getParameter("href");
			doGetWatch(req, resp, href, sesstion);
			break;

		case "/dislike": {
			sign = true;
			href = req.getParameter("href");
			doGetDislike(req, resp, sesstion, href);
			break;
		}
		case "/like": {
			sign = true;
			href = req.getParameter("href");
			doGetLike(req, resp, sesstion, href);
			break;
		}
		case "/subcribe": {
			sign = true;
			Integer idCurrentUser = Integer.parseInt(req.getParameter("currentUserid"));
			doGetSubcribe(req, resp, sesstion, idCurrentUser);
		}
		case "/unsubcribe": {
			sign = true;
			Integer idCurrentUser = Integer.parseInt(req.getParameter("currentUserid"));
			doGetUnSubcribe(req, resp, sesstion, idCurrentUser);
		}
		default:
			resp.sendRedirect("index");
			break;
		}
	}

	private void doGetUnSubcribe(HttpServletRequest req, HttpServletResponse resp, HttpSession sesstion,
			Integer idCurrentUser) {
		// TODO Auto-generated method stub
		
	}

	private void doGetSubcribe(HttpServletRequest req, HttpServletResponse resp, HttpSession sesstion,
			Integer idCurrentUser) {
		resp.setContentType("application/json");
		Integer currentChannelId = Integer.parseInt(req.getParameter("currentUserid"));
		account currentUser = (account) sesstion.getAttribute(finalVariable.CURRENTUSER);
		subcriber subcriber = serviceSubcriber.findById(currentUser.getId());

		String[] arr = subcriber.getListsubcriber().split(",");

	}

	private void doGetLike(HttpServletRequest req, HttpServletResponse resp, HttpSession sesstion, String href) {
		try {
			resp.setContentType("application/json");
			video video = serviceVideo.findByHref(href);

			account account = (account) sesstion.getAttribute(finalVariable.CURRENTUSER);

			history historyUserWatchVideo = serviceHistory.findByUserAndViewId(account.getId(), video.getId());
			video.setLikenumber(video.getLikenumber() + 1);

			historyUserWatchVideo.setIsliked(true);

			video result2 = serviceVideo.update(video);
			history result1 = serviceHistory.update(historyUserWatchVideo);

			if (result1 != null && result2 != null) {
				resp.setStatus(204);
			} else {
				resp.setStatus(400);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doGetDislike(HttpServletRequest req, HttpServletResponse resp, HttpSession sesstion, String href) {
		try {
			resp.setContentType("application/json");
			video video = serviceVideo.findByHref(href);
			account account = (account) sesstion.getAttribute(finalVariable.CURRENTUSER);
			history historyUserWatchVideo = serviceHistory.findByUserAndViewId(account.getId(), video.getId());

			historyUserWatchVideo.setIsliked(false);
			video.setLikenumber(video.getLikenumber() - 1);

			video result1 = serviceVideo.update(video);
			history result2 = serviceHistory.update(historyUserWatchVideo);
			if (result1 != null && result2 != null) {
				resp.setStatus(204);
			} else {
				resp.setStatus(400);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	videoDTO video;
	List<videoDTO> listvideo;

	private void doGetWatch(HttpServletRequest req, HttpServletResponse resp, String href, HttpSession session) {
		try {
			video videok = serviceVideo.findByHref(href);
			String whatServiceUNeed = req.getServletPath();
			Cookie[] arrayCookie = req.getCookies();
			List<Cookie> listCookie = Arrays.asList(arrayCookie);

			listvideo = new videoDTOMethods().parseToListVideoDTOObject(listvideo, listCookie);

			for (videoDTO item : listvideo) {
				if (item.getHref().equals(videok.getHref()))
					video = item;
			}
			req.setAttribute("videos", listvideo);
			req.setAttribute("video", video);

			account currentuser = (account) session.getAttribute(finalVariable.CURRENTUSER);

			if (currentuser != null) {
				historyUserWatchVideo = serviceHistory.findByUserAndViewId(currentuser.getId(), videok.getId());
				if (historyUserWatchVideo != null) {
					req.setAttribute("history", historyUserWatchVideo);
				} else {
					history history = new history();
					history.setAccountid(currentuser);
					history.setVideoid(videok);
					history.setIsliked(false);
					history.setIsshare(false);
					serviceHistory.create(history);
					req.setAttribute("history", historyUserWatchVideo);
				}
			}
			threadCountView thread = new threadCountView(serviceVideo, videok);
			thread.start();

			Cookie array[] = req.getCookies();

			for (Cookie item : array) {
				if (item.getName().equals(videok.getHashtag())) {
					continue;
				} else {
					Cookie newContent = new Cookie(videok.getHashtag(), videok.getHashtag());
					newContent.setMaxAge(60 * 60 * 24);
					resp.addCookie(newContent);
					break;
				}
			}

			req.getRequestDispatcher("views/user/video.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
