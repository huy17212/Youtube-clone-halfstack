package asm2.com.poly.service;

import java.util.List;

import asm2.com.poly.entity.history;

public interface historyService {
	List<history> findByUser(String username);
	List<history> findByUserAndIsLiked(String username);
	history findByUserAndViewId(Integer userId, Integer viewId);
	history create(history entity);
	history update(history entity);
}
