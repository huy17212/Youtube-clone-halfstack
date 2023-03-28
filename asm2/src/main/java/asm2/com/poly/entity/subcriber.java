package asm2.com.poly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subcriber")
public class subcriber {
	
	@Id
	@Column(name = "accountid")
	private Integer accountid;
	
	@Column(name = "listsubcriber")
	private String listsubcriber;

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public String getListsubcriber() {
		return listsubcriber;
	}

	public void setListsubcriber(String listsubcriber) {
		this.listsubcriber = listsubcriber;
	}
}
