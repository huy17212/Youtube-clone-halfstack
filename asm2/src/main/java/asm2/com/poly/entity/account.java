package asm2.com.poly.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="accountusername")
	private String accountusername;
	
	@Column(name="email")
	private String email;
	
	@Column(name="accountpassword")
	private String accountpassword;
	
	@Column(name="avatar")
	private String avatar;
	
	@Column(name="isadmin")
	private Boolean isadmin;
	
	@Column(name="isactive")
	private Boolean isactive;
	
	@Column(name="datecreate")
	private Date datecreate;
	
	@Column(name="dateupdate")
	private Date dateupdate;
	
	@Column(name = "nameChannel")
	private String nameChannel;
	
	public String getNameChannel() {
		return nameChannel;
	}

	public void setNameChannel(String nameChannel) {
		this.nameChannel = nameChannel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountusername() {
		return accountusername;
	}

	public void setAccountusername(String accountusername) {
		this.accountusername = accountusername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountpassword() {
		return accountpassword;
	}

	public void setAccountpassword(String accountpassword) {
		this.accountpassword = accountpassword;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Boolean getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(Boolean isadmin) {
		this.isadmin = isadmin;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
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
