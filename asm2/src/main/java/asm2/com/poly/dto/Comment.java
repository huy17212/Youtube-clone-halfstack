package asm2.com.poly.dto;

public class Comment {
	private String avatar;
	private String Comment;
	private String nameChannel;
	
	public String getNameChannel() {
		return nameChannel;
	}
	public void setNameChannel(String NameChannel) {
		this.nameChannel = NameChannel;
	}
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	@Override
	public String toString() {
		return "Comment [avatar=" + avatar + ", Comment=" + Comment + ", nameChannel=" + nameChannel + "]";
	}
	
	
	
	
}
