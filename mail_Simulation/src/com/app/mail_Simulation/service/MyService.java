package com.app.mail_Simulation.service;

import java.util.List;

import com.app.mail_Simulation.model.MailInfo;
import com.app.mail_Simulation.model.UserInfo;

public interface MyService {
	public boolean signup(UserInfo dto);
	public UserInfo login(String email,String password);
	public List<MailInfo> inbox();
	public List<MailInfo> sent();
	public List<MailInfo> draft();
	public UserInfo compose(String from,String to,String sub,String body);
	public boolean forgot(String email,String password,String seqanswer,String cpassword);
	public boolean change(String password,String cpassword);
	public boolean delete(int id);
	public List<MailInfo> deletedMail();
	public MailInfo showInbox(int id);
	public MailInfo showSent(int id);
	public MailInfo draftMail(int id);
	public UserInfo compMail(String from,String to,String sub,String body);
	public boolean deletedMail(int id);
	public boolean deleteinbox(int id); 
}
