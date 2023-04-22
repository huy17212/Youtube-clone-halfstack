package asm2.com.poly.dao.daoImpl;

import java.util.List;

import asm2.com.poly.dao.hibernateMethods;
import asm2.com.poly.dao.historyDao;
import asm2.com.poly.entity.history;

public class historyDaoImpl extends hibernateMethods<history> implements historyDao {

	@Override
	public List<history> findByUser(String username) {
		String sql  = "SELECT o FROM history o WHERE o.account.accountusername = ?0";
		return super.findMany(history.class, sql, username);
	}

	@Override
	public List<history> findByUserAndIsLiked(String username) {
		String sql  = "SELECT o FROM history o WHERE o.account.accountusername = ?0 AND o.isliked = 1";
		return super.findMany(history.class, sql, username);
	}

	@Override
	public history findByUserAndViewId(Integer idUser, Integer idVideo) {
		String sql  = "SELECT o FROM history o WHERE o.account.id = ?0 AND o.video.id = ?1";
		return super.findOne(history.class, sql, idUser, idVideo);
	}

	@Override
	public List<history> findByVideoid(Integer videoid) {
		String sql  = "SELECT o FROM history o WHERE o.video.id = ?0";
		return super.findMany(history.class, sql, videoid);
	}
	
	@Override
	public List<history> findByVideoid(int videoid, int no) {
		String sql  = "SELECT o FROM history o WHERE o.account.id is not null AND o.video.id = ?0";
		return super.findMany(history.class, sql, no);
	}

}
