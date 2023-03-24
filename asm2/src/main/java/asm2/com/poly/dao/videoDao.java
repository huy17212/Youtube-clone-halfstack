package asm2.com.poly.dao;

import java.util.List;

import asm2.com.poly.entity.video;

public interface videoDao {
	
	video findById(Integer id);
	video findByHref(String href);
	List<video> findAll();
	List<video> findAll(Integer pageNumber, Integer pageSize);
	List<video> findByTitle(String title);
	video create (video entity);
	video update (video entity);
	video delete (video entity);
	
}
