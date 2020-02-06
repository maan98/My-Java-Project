package com.app.mail_Simulation.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class UserInfo {
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	private int id;
	private String userName;
	@Column(unique=true)
	private String email;
	private String sequestion;
	private String seqanswer;
	private String password;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="id")
	private List<MailInfo> mlist;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSequestion() {
		return sequestion;
	}
	public void setSequestion(String sequestion) {
		this.sequestion = sequestion;
	}
	public String getSeqanswer() {
		return seqanswer;
	}
	public void setSeqanswer(String seqanswer) {
		this.seqanswer = seqanswer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<MailInfo> getMlist() {
		return mlist;
	}
	public void setMlist(List<MailInfo> mlist) {
		this.mlist = mlist;
	}

}
