package asm2.com.poly.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.Cookie;

import asm2.com.poly.containt.finalVariable;
import asm2.com.poly.entity.account;
import asm2.com.poly.entity.repository;
import asm2.com.poly.entity.video;
import asm2.com.poly.service.accountService;
import asm2.com.poly.service.repositoryService;
import asm2.com.poly.service.videoService;
import asm2.com.poly.service.Impl.accountServiceImpl;
import asm2.com.poly.service.Impl.repositoryServiceImpl;
import asm2.com.poly.service.Impl.videoServiceImpl;

public class videoDTOMethods {

	List<videoDTO> ListUuTien = new ArrayList<videoDTO>();
	List<videoDTO> ListKhongUuTien = new ArrayList<videoDTO>();
	videoService videoService = new videoServiceImpl();
	repositoryService repositoryService = new repositoryServiceImpl();
	accountService accountService = new accountServiceImpl();

	public List<videoDTO> parseToListVideoDTOObject(List<videoDTO> ListVideoInIndex, List<Cookie> listCookie) {

		List<video> videos = videoService.findAll();
		ListVideoInIndex = new ArrayList<>();
		ListUuTien = new ArrayList<>();
		ListKhongUuTien = new ArrayList<>();

		List<repository> CurrentUserRepository = repositoryService.findAll();

		for (video item : videos) {
			videoDTO entity = new videoDTO();
			entity.setId(item.getId());
			entity.setTitle(item.getTitle());
			entity.setDiscription(item.getDiscription());
			entity.setHref(item.getHref());
			entity.setPoster(item.getPoster());
			entity.setViews(item.getViews());
			entity.setShares(item.getShares());
			entity.setLikenumber(item.getLikenumber());
			entity.setCommentnumber(item.getCommentnumber());

			// Su ly tinh ngay video

			int month = Integer.parseInt((item.getDatecreate() + "").substring(
					(item.getDatecreate() + "").indexOf("-") + 1, (item.getDatecreate() + "").indexOf("-") + 3));
			int day = Integer
					.parseInt((item.getDatecreate() + "").substring((item.getDatecreate() + "").lastIndexOf("-") + 1,
							(item.getDatecreate() + "").lastIndexOf("-") + 3));
			int year = Integer.parseInt((item.getDatecreate() + "").substring(0, 4));

			int month1 = Integer.parseInt(
					(finalVariable.CURRENTDATE + "").substring((finalVariable.CURRENTDATE + "").indexOf("-") + 1,
							(finalVariable.CURRENTDATE + "").indexOf("-") + 3));
			int day1 = Integer.parseInt(
					(finalVariable.CURRENTDATE + "").substring((finalVariable.CURRENTDATE + "").lastIndexOf("-") + 1,
							(finalVariable.CURRENTDATE + "").lastIndexOf("-") + 3));
			int year1 = Integer.parseInt((finalVariable.CURRENTDATE + "").substring(0, 4));

			if (year1 - year != 0) {
				entity.setDayUpload(year1 - year + " years ago");
			} else if (month1 - month != 0) {
				entity.setDayUpload(Math.abs(month1 - month) + " months ago");
			} else if (day1 - day != 0) {
				entity.setDayUpload(30 - day + " days ago");
			} else {
				entity.setDayUpload("few minutes ago");
			}
			entity.setHashtag(item.getHashtag());
			entity.setUploader(item.getUploader());

			for (repository inItem : CurrentUserRepository) {
				if (inItem.getVideoid().getId() == item.getId()) {
					account account = accountService.findById(inItem.getAccountid().getId());
					entity.setAvatar(account.getAvatar());
					entity.setIdUploader(inItem.getAccountid().getId());
					break;
				}
			}
			

			boolean mySign = true; // sign danh dau day la listUuTien hay k UuTien
			for (Cookie cookie : listCookie) {
				if (cookie.getValue().length() <= 5 && cookie.getValue().equals(entity.getHashtag())) {
					ListUuTien.add(entity);
					mySign = false;
					break;
				}
			}
			if (mySign) {
				ListKhongUuTien.add(entity);
			}
		}
		Collections.shuffle(ListUuTien);
		Collections.shuffle(ListKhongUuTien);

		ListVideoInIndex.addAll(ListUuTien);
		ListVideoInIndex.addAll(ListKhongUuTien);
		return ListVideoInIndex;

	}
}
