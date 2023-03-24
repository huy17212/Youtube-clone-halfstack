package asm2.com.poly.service.Impl;

import java.util.List;

import asm2.com.poly.dao.videoDao;
import asm2.com.poly.dao.daoImpl.videoDaoImpl;
import asm2.com.poly.entity.video;
import asm2.com.poly.service.videoService;

public class videoServiceImpl implements videoService {

	public videoDao service;
	
	public videoServiceImpl() {
		service = new videoDaoImpl();
	}
	
	@Override
	public video findById(Integer id) {
		return service.findById(id);
	}

	@Override
	public video findByHref(String href) {
		return service.findByHref(href);
	}

	@Override
	public List<video> findAll() {
		return service.findAll();
	}

	@Override
	public List<video> findAll(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public video create(video entity) {
		return service.create(entity);
	}

	@Override
	public video update(video entity) {
		return service.update(entity);
	}

	@Override
	public video delete(video entity) {
		return service.delete(entity);
	}

	@Override
	public List<video> findByTitle(String title) {
		return service.findByTitle(title);
	}

}
