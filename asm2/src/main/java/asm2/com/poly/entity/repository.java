package asm2.com.poly.entity;

import java.util.Date;

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
@Table(name = "repository")
public class repository {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="accountid", referencedColumnName = "id")
	private account accountid;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="videoid", referencedColumnName = "id")
	private video videoid;
	
	@Column(name = "datecreate")
	private Date datecreate;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="statusid", referencedColumnName = "id")
	private repositoryStatus statusid;
	
	@Column(name = "dateupdate")
	private Date dateupdate;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public account getAccountid() {
		return accountid;
	}
	public void setAccountid(account accountid) {
		this.accountid = accountid;
	}
	public video getVideoid() {
		return videoid;
	}
	public void setVideoid(video videoid) {
		this.videoid = videoid;
	}
	public Date getDatecreate() {
		return datecreate;
	}
	public void setDatecreate(Date datecreate) {
		this.datecreate = datecreate;
	}
	public repositoryStatus getStatusid() {
		return statusid;
	}
	public void setStatusid(repositoryStatus statusid) {
		this.statusid = statusid;
	}
	public Date getDateupdate() {
		return dateupdate;
	}
	public void setDateupdate(Date dateupdate) {
		this.dateupdate = dateupdate;
	}
	@Override
	public String toString() {
		return "repository [id=" + id + ", accountid=" + accountid + ", videoid=" + videoid + ", datecreate="
				+ datecreate + ", statusid=" + statusid + ", dateupdate=" + dateupdate + "]";
	}
	
	
	
	
}
