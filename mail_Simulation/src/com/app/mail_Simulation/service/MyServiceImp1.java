package com.app.mail_Simulation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.mail_Simulation.dao.MyDAO;
import com.app.mail_Simulation.model.MailInfo;
import com.app.mail_Simulation.model.UserInfo;
@Component
public class MyServiceImp1 implements MyService{
	@Autowired
	MyDAO md;

	@Override
	public boolean signup(UserInfo dto) {
		boolean b=md.signup(dto);
		return b;
	}

	@Override
	public UserInfo login(String email, String password) {
		UserInfo dto=md.login(email, password);
		return dto;
	}

	@Override
	public List<MailInfo> inbox() {
		List<MailInfo> list=md.inbox();
		return list;
	}

	@Override
	public List<MailInfo> sent() {
		List<MailInfo> list=md.sent();
		return list;
	}

	@Override
	public List<MailInfo> draft() {
		List<MailInfo> list=md.draft();
		return list;
	}

	@Override
	public UserInfo compose(String from, String to, String sub, String body) {
		UserInfo dto=md.compose(from, to, sub, body);
		return dto;
	}

	@Override
	public boolean forgot(String email, String password, String seqanswer, String cpassword) {
		boolean b=md.forgot(email, password, seqanswer, cpassword);
		return b;
	}

	@Override
	public boolean change(String password, String cpassword) {
		boolean b=md.change(password, cpassword);
		return b;
	}

	@Override
	public boolean delete(int id) {
		boolean b=md.delete(id);
		return b;
	}

	@Override
	public List<MailInfo> deletedMail() {
		List<MailInfo> list=md.deletedMail();
		return list;
	}

	@Override
	public MailInfo showInbox(int id) {
		MailInfo dto=md.showInbox(id);
		return dto;
	}

	@Override
	public MailInfo showSent(int id) {
		MailInfo dto=md.showSent(id);
		return dto;
	}

	@Override
	public MailInfo draftMail(int id) {
		MailInfo dto=md.draftMail(id);
		return dto;
	}

	@Override
	public UserInfo compMail(String from, String to, String sub, String body) {
		UserInfo dto=md.compMail(from, to, sub, body);
		return dto;
	}

	@Override
	public boolean deletedMail(int id) {
		boolean b=md.deletedMail(id); 
		return b;
	}

	@Override
	public boolean deleteinbox(int id) {
		boolean b=md.deleteinbox(id);
		return b;
	}

}
