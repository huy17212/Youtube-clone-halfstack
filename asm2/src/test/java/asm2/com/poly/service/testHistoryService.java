package asm2.com.poly.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import asm2.com.poly.entity.account;
import asm2.com.poly.entity.history;
import asm2.com.poly.entity.video;
import asm2.com.poly.service.Impl.historyServiceImpl;

public class testHistoryService {
	
	historyService service = new historyServiceImpl();
	
	@ParameterizedTest
	@CsvSource({ "accUser, accAdmin, f4, java, kk1, dasd, Code" })
	void findByUser(String username) {
		List<history> entity = service.findByUser(username);
		Assertions.assertNotNull(entity);
	};
	
	@ParameterizedTest
	@CsvSource({ "accUser, accAdmin, f4, java, kk1, dasd, Code" })
	void findByUserAndIsLiked(String username) {
		List<history> entity = service.findByUser(username);
		Assertions.assertNotNull(entity);
	};
	
	@ParameterizedTest()
	@CsvSource({ "accUser, 1"," pe, f4, java, kk1, dasd, Code" })
	void findByUserAndViewId(Integer userId, Integer viewId) {
		history entity = service.findByUserAndViewId(userId, viewId);
		Assertions.assertNotNull(entity);
	};
	
	@ParameterizedTest()
	@CsvFileSource(resources = { "/testHistoryService.csv" }, numLinesToSkip = 0)
	void create(Integer id, Integer accountid, Integer videoid, Boolean isliked, Boolean isshare) {
		history entity = new history();
		account account = new account();
		account.setId(accountid);
		
		video video = new video();
		video.setId(videoid);
		
		entity.setAccountid(account);
		entity.setVideoid(video);
		
		entity.setIsliked(isliked);
		entity.setIsshare(isshare);
		
		entity.setVieweddate(null);
		entity.setComment(null);
		
		entity = service.create(entity);
		
		Assertions.assertNotNull(entity);
	};
	
	@ParameterizedTest()
	@CsvFileSource(resources = { "/testHistoryService.csv" }, numLinesToSkip = 0)
	void update(Integer id, Integer accountid, Integer videoid, Boolean isliked, Boolean isshare) {
		history entity = new history();
		account account = new account();
		account.setId(accountid);
		
		video video = new video();
		video.setId(videoid);
		
		entity.setAccountid(account);
		entity.setVideoid(video);
		
		entity.setIsliked(isliked);
		entity.setIsshare(isshare);
		
		entity.setVieweddate(null);
		entity.setComment(null);
		
		entity = service.update(entity);
		
		Assertions.assertNotNull(entity);
	};
}
