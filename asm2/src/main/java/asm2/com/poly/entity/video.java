package asm2.com.poly.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class video {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "discription")
	private String discription;
	
	@Column(name = "href")
	private String href;
	
	@Column(name = "poster")
	private String poster;
	
	@Column(name = "views")
	private Integer views;
	
	@Column(name = "shares")
	private Integer shares;
	
	@Column(name = "isactive")
	private Boolean isactive;
	
	@Column(name = "likenumber")
	private Integer likenumber;
	
	@Column(name = "commentnumber")
	private Integer commentnumber;
	
	@Column(name = "hashtag")
	private String hashtag;
	
	@Column(name = "datecreate")
	private Date datecreate;
	
	@Column(name = "dateupdate")
	private Date dateupdate;
	
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
	
	

	@Override
	public String toString() {
		return "video [id=" + id + ", title=" + title + ", discription=" + discription + ", href=" + href + ", poster="
				+ poster + ", views=" + views + ", shares=" + shares + ", isactive=" + isactive + ", likenumber="
				+ likenumber + ", commentnumber=" + commentnumber + ", hashtag=" + hashtag + ", datecreate="
				+ datecreate + ", dateupdate=" + dateupdate + "]";
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

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
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

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public Date getDatecreate() {
		return datecreate;
	}

	public void setDatecreate(Date datecreate) {
		this.datecreate = datecreate;
	}

	public Date getDateupdate() {
		return dateupdate;
	}

	public void setDateupdate(Date dateupdate) {
		this.dateupdate = dateupdate;
	}
	
}
