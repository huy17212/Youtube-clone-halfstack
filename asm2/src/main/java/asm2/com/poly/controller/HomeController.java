package asm2.com.poly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import asm2.com.poly.containt.killingAllThread;
import asm2.com.poly.dao.historyDao;
import asm2.com.poly.dao.daoImpl.subcriberServiceImpl;
import asm2.com.poly.dto.videoDTO;
import asm2.com.poly.dto.videoDTOMethods;
import asm2.com.poly.entity.account;
import asm2.com.poly.entity.history;
import asm2.com.poly.entity.repository;
import asm2.com.poly.entity.repositoryStatus;
import asm2.com.poly.entity.video;
import asm2.com.poly.service.accountService;
import asm2.com.poly.service.historyService;
import asm2.com.poly.service.repositoryService;
import asm2.com.poly.service.subcriberService;
import asm2.com.poly.service.videoService;
import asm2.com.poly.service.Impl.accountServiceImpl;
import asm2.com.poly.service.Impl.historyServiceImpl;
import asm2.com.poly.service.Impl.repositoryServiceImpl;
import asm2.com.poly.service.Impl.videoServiceImpl;

@WebServlet(urlPatterns = { "/index", "/explore", "/subcription", "/library", "/history", "/find", "/upload",
		"/playlist" })
public class HomeController extends HttpServlet {
	Boolean sign = false;
	private static final long serialVersionUID = 1L;

	videoService videoService = new videoServiceImpl();
	repositoryService repositoryService = new repositoryServiceImpl();
	accountService accountService = new accountServiceImpl();
	subcriberService subcribeService = new subcriberServiceImpl();
	historyService historyService = new historyServiceImpl();

	List<videoDTO> ListVideoInIndex;
	List<videoDTO> ListUuTien;
	List<videoDTO> ListKhongUuTien;
	List<videoDTO> anotherList;

	String password;
	String username;
	List<Cookie> listCookie;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		new killingAllThread().killingAllThread();
		HttpSession session = req.getSession();
		String whatServiceUNeed = req.getServletPath();
		Cookie[] arrayCookie = req.getCookies();
		
		if (arrayCookie != null) {
			listCookie = Arrays.asList(arrayCookie);
		}
		switch (whatServiceUNeed) {
		case "/index": {
			if (session.getAttribute(finalVariable.CURRENTUSER) != null
					&& ((account) session.getAttribute(finalVariable.CURRENTUSER)).getIsadmin().equals(false)) {
				List<account> listAccountSubcriber = new ArrayList<>();
				listAccountSubcriber = subcribeService.findByAccountSubcriber(listAccountSubcriber,
						(account) session.getAttribute(finalVariable.CURRENTUSER));
				req.setAttribute("listAccountSubcriber", listAccountSubcriber);
			}

			sign = true;
			videoDTOMethods dto = new videoDTOMethods();
			ListVideoInIndex = dto.parseToListVideoDTOObject(ListVideoInIndex, listCookie);

			req.setAttribute("videos", ListVideoInIndex);
			req.getRequestDispatcher("views/user/index.jsp").forward(req, resp);
			break;

		}

		case "/library": {
			sign = true;
			// get account from session
			account account = (account) session.getAttribute(finalVariable.CURRENTUSER);

			// create the for loop through to get the list show all subcriber person
			if (session.getAttribute(finalVariable.CURRENTUSER) != null) {
				List<account> listAccountSubcriber = new ArrayList<>();
				listAccountSubcriber = new subcriberServiceImpl().findByAccountSubcriber(listAccountSubcriber,
						(account) session.getAttribute(finalVariable.CURRENTUSER));
				req.setAttribute("listAccountSubcriber", listAccountSubcriber);
			}

			List<videoDTO> videos = new ArrayList<>();
			videos = new videoDTOMethods().parseToListVideoDTOObject(videos);
			req.setAttribute("videos", videos);
			repositoryStatus rep = new repositoryStatus();

			rep.setId(3);
			List<repository> repoUploads = new repositoryServiceImpl().findAllByStatusId(account, rep);
			List<video> listupload = new ArrayList<>();
			// find DTO list upload;
			for (repository item : repoUploads) {
				video video = videoService.findById(item.getVideoid().getId());
				listupload.add(video);
			}
			List<videoDTO> listup = new ArrayList();
			listup = new videoDTOMethods().parseToListVideoDTOObject1(listup, listupload);
			req.setAttribute("listUpload", listup);

			rep.setId(1);
			List<video> listsha = new ArrayList<>();
			List<repository> repoShares = new repositoryServiceImpl().findAllByStatusId(account, rep);
			// find DTO list share
			for (repository item : repoShares) {
				video video = videoService.findById(item.getVideoid().getId());
				listsha.add(video);
			}
			List<videoDTO> listshare = new ArrayList();
			listshare = new videoDTOMethods().parseToListVideoDTOObject1(listshare, listsha);
			req.setAttribute("listShare", listshare);

			List<history> listhi = historyService.findByUserAndIsLiked(account.getAccountusername());
			List<video> listvi = new ArrayList<>();
			// find DTO list Like
			for (history item : listhi) {
				video video = videoService.findById(item.getVideo().getId());
				listvi.add(video);
			}
			req.setAttribute("numberUp", listup.size());
			req.setAttribute("numberSh", listsha.size());
			req.setAttribute("numberLi", listvi.size());

			List<videoDTO> listLike = new ArrayList();
			listLike = new videoDTOMethods().parseToListVideoDTOObject1(listLike, listvi);

			req.setAttribute("listLike", listLike);

			req.getRequestDispatcher("views/user/repository.jsp").forward(req, resp);
			break;
		}
		case "/find": {
			sign = true;
			anotherList = new ArrayList<>();
			String whatUNeedToFind = req.getParameter("fin");
			List<videoDTO> videosfind1 = new videoDTOMethods().parseToListVideoDTOObject(anotherList);

			if (session.getAttribute(finalVariable.CURRENTUSER) != null) {
				List<account> listAccountSubcriber = new ArrayList<>();
				listAccountSubcriber = new subcriberServiceImpl().findByAccountSubcriber(listAccountSubcriber,
						(account) session.getAttribute(finalVariable.CURRENTUSER));
				req.setAttribute("listAccountSubcriber", listAccountSubcriber);
			}

			for (videoDTO item : videosfind1) {
				if (item.getTitle().contains(whatUNeedToFind.trim())) {
					anotherList.add(item);
				}
			}

			Integer pagesize = 2;
			Integer pageNumber = (int) Math.ceil(anotherList.size() / pagesize);
			System.out.println("so luong phan tu voi trang " + pagesize);
			System.out.println("so trang dc chia ra " + pageNumber);
			System.out.println("so luong phan tu " + anotherList.size());

			req.setAttribute("videos", anotherList);
			req.setAttribute("pageSize", pagesize);
			req.setAttribute("pageNumber", pageNumber);
			req.setAttribute("videolength", anotherList.size() - 1);
			req.getRequestDispatcher("views/user/find.jsp").forward(req, resp);
			break;
		}
		case "/explore": {
			sign = true;
			List<videoDTO> listallVideo = new ArrayList();
			listallVideo = new videoDTOMethods().parseToListVideoDTOObject(listallVideo);
			List<videoDTO> ListStudy = new ArrayList<>();
			List<videoDTO> ListSong = new ArrayList<>();
			List<videoDTO> ListGame = new ArrayList<>();
			List<videoDTO> ListLeft = new ArrayList<>();

			for (videoDTO item : listallVideo) {
				if (item.getHashtag().equals("study")) {
					ListStudy.add(item);
				} else if (item.getHashtag().equals("song")) {
					ListSong.add(item);
				} else if (item.getHashtag().equals("game")) {
					ListGame.add(item);
				} else {
					ListLeft.add(item);
				}
			}
			if (ListStudy != null) {
				Collections.sort(ListStudy, new Comparator<videoDTO>() {
					@Override
					public int compare(videoDTO o1, videoDTO o2) {
						return o1.getViews() > o2.getViews() ? -1 : 1;
					}
				});
				req.setAttribute("ListStudysign", true);
				req.setAttribute("ListStudy", ListStudy);
			}

			if (ListSong != null) {
				Collections.sort(ListSong, new Comparator<videoDTO>() {
					@Override
					public int compare(videoDTO o1, videoDTO o2) {
						return o1.getViews() > o2.getViews() ? -1 : 1;
					}
				});
				req.setAttribute("ListSongsign", true);
				req.setAttribute("ListSong", ListSong);
			}

			if (ListGame != null) {
				Collections.sort(ListGame, new Comparator<videoDTO>() {
					@Override
					public int compare(videoDTO o1, videoDTO o2) {
						return o1.getViews() > o2.getViews() ? -1 : 1;
					}
				});
				req.setAttribute("ListGamesign", true);
				req.setAttribute("ListGame", ListGame);
			}

			req.getRequestDispatcher("views/user/explore.jsp").forward(req, resp);
			break;
		}
		case "/subcription": {
			sign = true;
			req.getRequestDispatcher("views/user/subcription.jsp").forward(req, resp);
			break;
		}
		case "/playlist": {
			req.getRequestDispatcher("views/user/playlist.jsp").forward(req, resp);
			break;
		}
		case "/history": {
			sign = true;
			List<videoDTO> listHisto = (List<videoDTO>) req.getSession().getAttribute("HISTORYVIDEOLIST");
			Collections.reverse(listHisto);
			req.setAttribute("listHisto", listHisto);
			req.getRequestDispatcher("views/user/history.jsp").forward(req, resp);
			break;
		}
		case "/upload": {
			sign = true;
			if (session.getAttribute(finalVariable.CURRENTUSER) != null) {
				List<account> listAccountSubcriber = new ArrayList<>();
				listAccountSubcriber = new subcriberServiceImpl().findByAccountSubcriber(listAccountSubcriber,
						(account) session.getAttribute(finalVariable.CURRENTUSER));
				req.setAttribute("listAccountSubcriber", listAccountSubcriber);
			}

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
		account currentUser = (account) session.getAttribute(finalVariable.CURRENTUSER);

		switch (whatServiceUNeed) {
		case "/upload": {
			doPostUpload(req, resp, session, currentUser);
			break;
		}
		}
	}

	private void doPostUpload(HttpServletRequest req, HttpServletResponse resp, HttpSession session,
			account currentUser) {
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
			video.setUploader(currentUser.getNameChannel());
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
