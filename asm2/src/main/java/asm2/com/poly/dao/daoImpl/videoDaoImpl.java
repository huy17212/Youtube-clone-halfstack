package asm2.com.poly.dao.daoImpl;

import java.util.List;

import asm2.com.poly.dao.hibernateMethods;
import asm2.com.poly.dao.videoDao;
import asm2.com.poly.entity.video;

public class videoDaoImpl extends hibernateMethods<video> implements videoDao {

	@Override
	public video findById(Integer id) {
		return super.findById(video.class, id);
	}

	@Override
	public video findByHref(String href) {
		String sql = "SELECT o FROM video o WHERE o.href = ?0";
		return super.findOne(video.class, sql, href);
	}

	@Override
	public List<video> findAll() {
		return super.findAll(video.class, true);
	}

	@Override
	public List<video> findAll(Integer pageNumber, Integer pageSize) {
		return null;
	}

	@Override
	public video delete(video entity) {
		return null;
	}
	
}
