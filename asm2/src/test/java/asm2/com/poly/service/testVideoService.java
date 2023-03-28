package asm2.com.poly.service;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import asm2.com.poly.dao.videoDao;
import asm2.com.poly.dao.daoImpl.videoDaoImpl;
import asm2.com.poly.entity.video;

public class testVideoService {
	videoDao dao = new videoDaoImpl();

	@ParameterizedTest
	@CsvSource({ "1", "2" })
	public void findById(Integer id) {
		video video = dao.findById(id);
		Assertions.assertNotNull(video);
	};

	@ParameterizedTest
	@CsvSource({ "9wrBeWc944U", "9wrBeWc944U", "dsadv9wrBeWc944U", "9wrBeWc944Uz" })
	void findByHref(String href) {
		video video = dao.findByHref(href);
		Assertions.assertNotNull(video);
	};

	@Test
	void findAll() {
		List<video> video = dao.findAll();
		Assertions.assertNotNull(video);
	};

	@ParameterizedTest
	@CsvSource({ "1, 10", "2, n", "5, 2", "10, -1" })
	void findAll(Integer pageNumber, Integer pageSize) {
		List<video> video = dao.findAll();
		Assertions.assertNotNull(video);
	};

	@ParameterizedTest
	@CsvSource({ "ph, pe, f4, java, kk1, dasd, Code" })
	void findByTitle(String title) {
		List<video> video = dao.findByTitle(title);
		Assertions.assertNotNull(video);
	};

	@ParameterizedTest()
	@CsvFileSource(resources = { "/testVideoService.csv" }, numLinesToSkip = 0)
	void create(int id, String title, String discription, String href, String poster, int views, int shares, Boolean isactive, int likenumber, int commentsnumber,String hashtag, String uploader  ) {
		video entity = new video();
		entity.setId(id);
		entity.setTitle(title);
		entity.setDiscription(discription);
		entity.setHref(href);
		entity.setPoster(poster);
		entity.setViews(views);
		entity.setShares(shares);
		entity.setIsactive(isactive);
		entity.setLikenumber(likenumber);
		entity.setCommentnumber(commentsnumber);
		entity.setHashtag(hashtag);
		entity.setDatecreate(null);
		entity.setDateupdate(null);
		entity.setUploader(uploader);
		video video = dao.create(entity);
		Assertions.assertNotNull(video);
	};

	@ParameterizedTest()
	@CsvFileSource(resources = { "/testVideoService.csv" }, numLinesToSkip = 0)
	void delete(int id, String title, String discription, String href, String poster, int views, int shares, Boolean isactive, int likenumber, int commentsnumber,String hashtag, String uploader  ) {
		video entity = new video();
		entity.setId(id);
		entity.setTitle(title);
		entity.setDiscription(discription);
		entity.setHref(href);
		entity.setPoster(poster);
		entity.setViews(views);
		entity.setShares(shares);
		entity.setIsactive(isactive);
		entity.setLikenumber(likenumber);
		entity.setCommentnumber(commentsnumber);
		entity.setHashtag(hashtag);
		entity.setDatecreate(null);
		entity.setDateupdate(null);
		entity.setUploader(uploader);
		video video = dao.delete(entity);
		Assertions.assertNotNull(video);
	};

	@ParameterizedTest()
	@CsvFileSource(resources = { "/testVideoService.csv" }, numLinesToSkip = 0)
	void update(int id, String title, String discription, String href, String poster, int views, int shares, Boolean isactive, int likenumber, int commentsnumber,String hashtag, String uploader  ) {
		video entity = new video();
		entity.setId(id);
		entity.setTitle(title);
		entity.setDiscription(discription);
		entity.setHref(href);
		entity.setPoster(poster);
		entity.setViews(views);
		entity.setShares(shares);
		entity.setIsactive(isactive);
		entity.setLikenumber(likenumber);
		entity.setCommentnumber(commentsnumber);
		entity.setHashtag(hashtag);
		entity.setDatecreate(null);
		entity.setDateupdate(null);
		entity.setUploader(uploader);
		video video = dao.update(entity);
		Assertions.assertNotNull(video);
	};
}
