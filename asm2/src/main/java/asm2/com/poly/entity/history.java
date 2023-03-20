package asm2.com.poly.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class history {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="accountid", referencedColumnName = "id")
	private account account;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="videoid", referencedColumnName = "id")
	private video video;
	
	@Column(name = "vieweddate")
	private Date vieweddate;
	
	@Column(name = "isliked")
	private Boolean isliked;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "isshare")
	private Boolean isshare;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public account getAccountid() {
		return account;
	}

	public void setAccountid(account accountid) {
		this.account = accountid;
	}

	public video getVideoid() {
		return video;
	}

	public void setVideoid(video videoid) {
		this.video = videoid;
	}

	public Date getVieweddate() {
		return vieweddate;
	}

	public void setVieweddate(Date vieweddate) {
		this.vieweddate = vieweddate;
	}

	public Boolean getIsliked() {
		return isliked;
	}

	public void setIsliked(Boolean isliked) {
		this.isliked = isliked;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getIsshare() {
		return isshare;
	}

	public void setIsshare(Boolean isshare) {
		this.isshare = isshare;
	}
}
