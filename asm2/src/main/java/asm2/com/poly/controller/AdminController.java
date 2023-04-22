package asm2.com.poly.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import asm2.com.poly.containt.finalVariable;
import asm2.com.poly.dao.daoImpl.subcriberServiceImpl;
import asm2.com.poly.entity.account;
import asm2.com.poly.entity.subcriber;
import asm2.com.poly.service.Impl.accountServiceImpl;

/**
 * Servlet implementation class AdminController
 */
@WebServlet(urlPatterns = { "/AdminPowerSystem", "/AdminInsert", "/AdminUpdate", "/AdminDelete", "/AdminSearch" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String whatserviceUneed = request.getServletPath();

		switch (whatserviceUneed) {
		case "/AdminPowerSystem":

			List<account> listAllAccount = new accountServiceImpl().findAll();

			List<account> temp = new ArrayList();
			for (account item : listAllAccount) {
				if (item.getIsadmin().equals(false)) {
					temp.add(item);
				}
			}

			request.setAttribute("listAllAccount", temp);
			request.getRequestDispatcher("views/admin/accountManagement.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String whatServiceUneed = req.getServletPath();
		switch (whatServiceUneed) {
		case "/AdminInsert": {
			System.out.print("Hey there");
			Boolean sign;
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String username = req.getParameter("username");
			String file = req.getParameter("avatar");
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
				new accountServiceImpl().create(account);
				subcriber subcriber = new subcriber();
				subcriber.setAccountid(account.getId());
				subcriber.setListsubcriber("");
				new subcriberServiceImpl().create(subcriber);
				resp.sendRedirect("AdminPowerSystem");
			}

			break;
		}
		case "/AdminUpdate": {
			Boolean sign;
			PrintWriter out = resp.getWriter();
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String username = req.getParameter("username");
			String nameChannel = req.getParameter("nameChannel");
			Integer id = Integer.parseInt(req.getParameter("id"));

			account account = new accountServiceImpl().findById(id);
			account.setEmail(email);
			account.setAccountpassword(password);
			account.setAccountusername(username);
			account.setNameChannel(nameChannel);
			account.setDateupdate(finalVariable.CURRENTDATE);

			new accountServiceImpl().update(account);
			resp.sendRedirect("AdminPowerSystem");
			break;
		}
		case "/AdminDelete": {

			String thingShouldBeDelete = req.getParameter("idsDelete");
			PrintWriter out = resp.getWriter();

			List<account> mylist = new accountServiceImpl().findAll();
			List<account> mylist3 = new accountServiceImpl().findAll();
			List<account> mylist2 = new ArrayList<>();

			String[] msnv = thingShouldBeDelete.split(",");
			int k = 0;

			for (account item : mylist) {
				for (String itemk : msnv) {
					if (Integer.parseInt(itemk) == item.getId()) {
						item.setIsactive(false);
						new accountServiceImpl().update(item);
						mylist3.remove(k);
						break;
					} else {
						continue;
					}
				}
				k++;
			}

			String thing = new Gson().toJson(mylist3);
			out.print(thing);
			break;
		}
		case "/AdminSearch": {
			PrintWriter out = resp.getWriter();
			Integer searchId = Integer.valueOf(req.getParameter("searchId"));
			String searchEmail = req.getParameter("searchEmail");
			String searchAvatar = req.getParameter("searchAvatar");
			String searchNameChannel = req.getParameter("searchNameChannel");

			List<account> accounts = new accountServiceImpl().findAll();
			List<account> temp = new ArrayList<>();
			for (account item : accounts) {
				if (item.getId().equals(searchId) && item.getEmail().equals(searchEmail)
						&& item.getAvatar().equals(searchAvatar) && item.getNameChannel().equals(searchNameChannel)) {
					temp.add(item);
				}
			}
			String thing = new Gson().toJson(temp);
			out.print(thing);
		}
		}
	}
}
