package asm2.com.poly.dto;

import java.util.ArrayList;
import java.util.List;

import asm2.com.poly.entity.account;
import asm2.com.poly.entity.history;
import asm2.com.poly.service.historyService;
import asm2.com.poly.service.Impl.accountServiceImpl;
import asm2.com.poly.service.Impl.historyServiceImpl;

public class commentDTOMethods {
	List<Comment> listComment;
	
	
	public List<Comment> TranformToUsefulListComment(List<history> listHistory){
		listComment = new ArrayList<Comment>();
		for(history item : listHistory) {
			if(item.getComment() !=  null && !item.getComment().contains(",")) {
				Comment comment = new Comment();
				account account = (account) new accountServiceImpl().findById(item.getAccount().getId());
				comment.setAvatar(account.getAvatar());
				comment.setComment(item.getComment());
				comment.setNameChannel(account.getNameChannel());
				listComment.add(comment);
				System.out.print(comment.toString());
			}else if(item.getComment() !=  null) {
				String[] arr = item.getComment().split(",");
				for(int i = 0; i < arr.length ; i++) {
					Comment comment = new Comment();
					account account = (account) new accountServiceImpl().findById(item.getAccount().getId());
					comment.setAvatar(account.getAvatar());
					comment.setComment(arr[i]);
					comment.setNameChannel(account.getNameChannel());
					listComment.add(comment);
					System.out.print("vkxx" + account.getNameChannel());
					System.out.print("vkxx2" + comment.getNameChannel());
				}
			}
		}
		return listComment;
	}

}
