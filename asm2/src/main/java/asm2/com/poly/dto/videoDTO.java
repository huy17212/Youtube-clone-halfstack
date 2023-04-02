package asm2.com.poly.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class videoDTO {

	private Integer id;

	private String title;

	private String discription;

	private String href;

	private String poster;

	private Integer views;

	private Integer shares;

	private Integer likenumber;

	private Integer commentnumber;
	
	private String dayUpload;
	
	private String hashtag;

	private String uploader;
	
	private Integer idUploader;

	private String avatar;
	
	public Integer getIdUploader() {
		return idUploader;
	}

	public void setIdUploader(Integer idUploader) {
		this.idUploader = idUploader;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getShares() {
		return shares;
	}

	public void setShares(Integer shares) {
		this.shares = shares;
	}

	public Integer getLikenumber() {
		return likenumber;
	}

	public void setLikenumber(Integer likenumber) {
		this.likenumber = likenumber;
	}

	public Integer getCommentnumber() {
		return commentnumber;
	}

	public void setCommentnumber(Integer commentnumber) {
		this.commentnumber = commentnumber;
	}

	public String getDayUpload() {
		return dayUpload;
	}

	public void setDayUpload(String dayUpload) {
		this.dayUpload = dayUpload;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
	
}
