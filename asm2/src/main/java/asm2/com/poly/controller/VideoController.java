package asm2.com.poly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
import asm2.com.poly.dto.videoDTO;
import asm2.com.poly.dto.videoDTOMethods;
import asm2.com.poly.entity.account;
import asm2.com.poly.entity.history;
import asm2.com.poly.entity.repository;
import asm2.com.poly.entity.repositoryStatus;
import asm2.com.poly.entity.subcriber;
import asm2.com.poly.entity.video;
import asm2.com.poly.service.historyService;
import asm2.com.poly.service.subcriberService;
import asm2.com.poly.service.videoService;
import asm2.com.poly.service.Impl.historyServiceImpl;
import asm2.com.poly.service.Impl.repositoryServiceImpl;
import asm2.com.poly.service.Impl.videoServiceImpl;
import asm2.com.poly.thread.threadCountView;

@WebServlet(urlPatterns = { "/watch", "/dislike", "/like", "/subcribe", "/unsubcribe", "/share", "/unshare", "/save",
		"/unsave" })
public class VideoController extends HttpServlet {

	private videoService serviceVideo = new videoServiceImpl();
	private historyService serviceHistory = new historyServiceImpl();
	private subcriberService serviceSubcriber = new subcriberServiceImpl();
	private history historyUserWatchVideo;
	Boolean sign = false;
	threadCountView thread;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		new killingAllThread().killingAllThread();
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
			break;
		}
		case "/unsubcribe": {
			sign = true;
			Integer idCurrentUser = Integer.parseInt(req.getParameter("currentUserid"));
			doGetUnSubcribe(req, resp, sesstion, idCurrentUser);
			break;
		}
		case "/share": {
			href = req.getParameter("href").toString();
			doGetShare(req, resp, sesstion, href);
			break;
		}
		case "/unshare": {
			href = req.getParameter("href").toString();
			doGetUnshare(req, resp, sesstion, href);
			break;
		}
		case "/save": {
			href = req.getParameter("href").toString();
			doGetSave(req, resp, sesstion, href);
			break;
		}
		case "/unsave": {
			href = req.getParameter("href").toString();
			doGetUnsave(req, resp, sesstion, href);
			break;
		}
		default:
			resp.sendRedirect("index");
			break;
		}
	}

	private void doGetUnsave(HttpServletRequest req, HttpServletResponse resp, HttpSession sesstion, String href) {
		account account = (account) sesstion.getAttribute(finalVariable.CURRENTUSER);
		video video = serviceVideo.findByHref(href);
		
		repositoryStatus repo = new repositoryStatus();
		repo.setId(2);
		List<repository> repository = new repositoryServiceImpl().findAllByStatusId(account, repo);
		
		for (repository item : repository) {
			if (item.getAccountid().getId().equals(account.getId()) && item.getVideoid().getId().equals(video.getId())) {
				repository result1 = new repositoryServiceImpl().delete(item);
				history historyUserWatchVideo = serviceHistory.findByUserAndViewId(account.getId(), video.getId());
				historyUserWatchVideo.setIslater(false);
				history result2 = serviceHistory.update(historyUserWatchVideo);
				if (result1 != null && result2 != null) {
					resp.setStatus(204);
					return;
				} else {
					resp.setStatus(400);
					return;
				}
			}
		}
	}

	private void doGetSave(HttpServletRequest req, HttpServletResponse resp, HttpSession sesstion, String href) {
		try {
			resp.setContentType("application/json");
			video video = serviceVideo.findByHref(href);
			account account = (account) sesstion.getAttribute(finalVariable.CURRENTUSER);

			repository repository = new repository();
			repository.setAccountid(account);
			repository.setVideoid(video);
			repositoryStatus status = new repositoryStatus();
			status.setId(2);
			repository.setStatusid(status);
			repository.setDatecreate(finalVariable.CURRENTDATE);
			repository.setDateupdate(finalVariable.CURRENTDATE);
			repository = new repositoryServiceImpl().create(repository);

			history historyUserWatchVideo = serviceHistory.findByUserAndViewId(account.getId(), video.getId());
			historyUserWatchVideo.setIslater(true);
			history result1 = serviceHistory.update(historyUserWatchVideo);

			if (result1 != null && repository != null) {
				resp.setStatus(204);
			} else {
				resp.setStatus(400);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doGetUnshare(HttpServletRequest req, HttpServletResponse resp, HttpSession sesstion,
			String hrefvideo) {
		try {
			resp.setContentType("application/json");
			video video = serviceVideo.findByHref(hrefvideo);
			account account = (account) sesstion.getAttribute(finalVariable.CURRENTUSER);
			history historyUserWatchVideo = serviceHistory.findByUserAndViewId(account.getId(), video.getId());

			historyUserWatchVideo.setIsshare(false);
			video.setShares(video.getShares() - 1);

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

	private void doGetShare(HttpServletRequest req, HttpServletResponse resp, HttpSession sesstion, String hrefvideo) {
		try {
			resp.setContentType("application/json");
			video video = serviceVideo.findByHref(hrefvideo);

			account account = (account) sesstion.getAttribute(finalVariable.CURRENTUSER);

			history historyUserWatchVideo = serviceHistory.findByUserAndViewId(account.getId(), video.getId());
			video.setShares(video.getShares() + 1);

			historyUserWatchVideo.setIsshare(true);

			video result2 = serviceVideo.update(video);
			history result1 = serviceHistory.update(historyUserWatchVideo);

			repository repository = new repository();
			repository.setAccountid(account);
			repository.setVideoid(video);
			repository.setDatecreate(finalVariable.CURRENTDATE);
			repository.setDateupdate(finalVariable.CURRENTDATE);
			repositoryStatus repo = new repositoryStatus();
			repo.setId(2);
			repository.setStatusid(repo);

			if (result1 != null && result2 != null) {
				resp.setStatus(204);
			} else {
				resp.setStatus(400);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	List<String> listUnsupcriber;

	private void doGetUnSubcribe(HttpServletRequest req, HttpServletResponse resp, HttpSession sesstion,
			Integer idCurrentUser) {
		try {

			String listSubcriber = serviceSubcriber
					.findById(((account) sesstion.getAttribute(finalVariable.CURRENTUSER)).getId()).getListsubcriber();
			String[] list;

			if (listSubcriber.contains(",") == true) {
				list = listSubcriber.split(",");
				listUnsupcriber = new LinkedList<String>(Arrays.asList(list));
				for (String item : listUnsupcriber) {
					int number = Integer.parseInt(item);
					if (number == idCurrentUser) {
						listUnsupcriber.remove(item);
						break;
					}
				}
				subcriber subcriber = new subcriber();
				subcriber.setAccountid(((account) sesstion.getAttribute(finalVariable.CURRENTUSER)).getId());
				subcriber.setListsubcriber(String.join(",", listUnsupcriber));
				serviceSubcriber.update(subcriber);
			} else {
				if (Integer.parseInt(listSubcriber) == idCurrentUser) {
					listSubcriber = "";
				}
				subcriber subcriber = new subcriber();
				subcriber.setAccountid(((account) sesstion.getAttribute(finalVariable.CURRENTUSER)).getId());
				subcriber.setListsubcriber(listSubcriber);
				serviceSubcriber.update(subcriber);
			}
			resp.setStatus(204);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(404);
		}
	}

	private void doGetSubcribe(HttpServletRequest req, HttpServletResponse resp, HttpSession sesstion,
			Integer idCurrentUser) {
		resp.setContentType("application/json");
		try {

			Integer currentChannelId = Integer.parseInt(req.getParameter("currentUserid"));
			account currentUser = (account) sesstion.getAttribute(finalVariable.CURRENTUSER);
			subcriber subcriber = serviceSubcriber.findById(currentUser.getId());
			if (subcriber.getListsubcriber().equals("")) {
				subcriber.setListsubcriber(subcriber.getListsubcriber().trim() + idCurrentUser);
			} else {
				subcriber.setListsubcriber(subcriber.getListsubcriber().trim() + "," + idCurrentUser);
			}
			subcriber entity = serviceSubcriber.update(subcriber);

			if (entity != null) {
				resp.setStatus(204);
			} else {
				resp.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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
	String[] arrSubcribe;

	private void doGetWatch(HttpServletRequest req, HttpServletResponse resp, String href, HttpSession session) {
		try {
			video videok = serviceVideo.findByHref(href);
			System.out.println("idvideo" + videok.getId());
			String whatServiceUNeed = req.getServletPath();
			Cookie[] arrayCookie = req.getCookies();
			List<Cookie> listCookie = Arrays.asList(arrayCookie);

			account currentUser = (account) session.getAttribute(finalVariable.CURRENTUSER);
			if (currentUser != null) {
				subcriber subcriber = serviceSubcriber.findById(currentUser.getId());
				arrSubcribe = subcriber.getListsubcriber().split(",");
			}

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
					history.setVieweddate(finalVariable.CURRENTDATE);
					history.setIsliked(false);
					history.setIsshare(false);
					history.setIslater(false);
					serviceHistory.create(history);
					req.setAttribute("history", historyUserWatchVideo);
				}
			}
			thread = new threadCountView(serviceVideo, videok);
			thread.setName("countView");
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
			Boolean isSubcribe = true;
			try {
				if (currentUser != null) {
					for (String item : arrSubcribe) {
						if (video.getIdUploader().equals(Integer.parseInt(item.trim()))) {
							isSubcribe = false;
						}
					}
				}
			} catch (Exception e) {
				isSubcribe = true;
			}
			req.setAttribute("isSubcribe", isSubcribe);

			if (session.getAttribute(finalVariable.CURRENTUSER) != null) {
				List<account> listAccountSubcriber = new ArrayList<>();
				listAccountSubcriber = new subcriberServiceImpl().findByAccountSubcriber(listAccountSubcriber,
						(account) session.getAttribute(finalVariable.CURRENTUSER));
				req.setAttribute("listAccountSubcriber", listAccountSubcriber);
			}

			req.getRequestDispatcher("views/user/video.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
