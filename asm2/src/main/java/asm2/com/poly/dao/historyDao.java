package asm2.com.poly.dao;

import java.util.List;

import asm2.com.poly.entity.history;

public interface historyDao {
	List<history> findByUser(String username);
	List<history> findByUserAndIsLiked(String username);
	List<history> findByVideoid(Integer videoid);
	List<history> findByVideoid(int videoid, int no);
	history findByUserAndViewId(Integer userId, Integer viewId);
	history create(history entity);
	history update(history entity);
	
	
}
