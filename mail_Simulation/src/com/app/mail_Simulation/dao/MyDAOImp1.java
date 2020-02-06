package com.app.mail_Simulation.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.mail_Simulation.model.MailInfo;
import com.app.mail_Simulation.model.UserInfo;
@Component
public class MyDAOImp1 implements MyDAO{
	
	  @Autowired 
	  HttpSession session;
	 @Autowired
	 SessionFactory sf;

	@Override
	public boolean signup(UserInfo sdto) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("email", sdto.getEmail()));
		UserInfo dto=(UserInfo) cr.uniqueResult();
		if(dto!=null) {
		return false;
		}else {
			sdto.setSequestion("What is Your Pet Name");
			ss.save(sdto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}
	}

	@Override
	public UserInfo login(String email, String password) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("email", email));
		cr.add(Restrictions.eq("password", password));
		UserInfo sdto=(UserInfo) cr.uniqueResult();
		return sdto;
		
	}

	@Override
	public List<MailInfo> inbox() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email1=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("toId",email1));
		cr.add(Restrictions.eq("inboxStatus", "MailInbox"));
		List<MailInfo> mlist=cr.list();
		return mlist;
	}

	@Override
	public List<MailInfo> sent() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email1=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("fromId",email1));
		cr.add(Restrictions.eq("status", "MailSent"));
		List<MailInfo> mlist=cr.list();
		return mlist;
	}

	@Override
	public List<MailInfo> draft() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email1=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("fromId",email1));
		cr.add(Restrictions.eq("status", "DraftMail"));
		List<MailInfo> mlist=cr.list();
		return mlist;
	}

	@Override
	public UserInfo compose(String from, String to, String sub, String body) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("email", from));
		UserInfo dto=(UserInfo) cr.uniqueResult();
		cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("email", to));
		UserInfo udto=(UserInfo) cr.uniqueResult();
		List<MailInfo> list;
		if(udto!=null) {
		MailInfo mdto=new MailInfo();
		mdto.setFromId(from);
		mdto.setToId(to);
		mdto.setSubject(sub);
		mdto.setMessage(body);
		mdto.setStatus("MailSent");
		mdto.setInboxStatus("MailInbox");
		list=dto.getMlist();
		list.add(mdto);
		dto.setMlist(list);
		ss.save(dto);
		ss.beginTransaction().commit();
		ss.close();
		return dto;
		}else {
			MailInfo mdto=new MailInfo();
			mdto.setFromId(from);
			mdto.setToId(to);
			mdto.setSubject(sub);
			mdto.setMessage(body);
			mdto.setStatus("DraftMail");
			list=dto.getMlist();
			list.add(mdto);
			dto.setMlist(list);
			ss.save(dto);
			ss.beginTransaction().commit();
			ss.close();
			return null;
		}
	}

	@Override
	public boolean forgot(String email, String password, String seqanswer, String cpassword) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("seqanswer", seqanswer));
		UserInfo dto=(UserInfo) cr.uniqueResult();
		if(dto!=null) {
			if(password.equals(cpassword)) {
				dto.setPassword(cpassword);
				ss.saveOrUpdate(dto);
				ss.beginTransaction().commit();
				ss.close();
				return true;
			}else {
			ss.close();
			return false;
			}
		}else {
		ss.close();
		return false;
   }
	}

	@Override
	public boolean change(String password, String cpassword) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		String email=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("email", email));
		UserInfo dto=(UserInfo) cr.uniqueResult();
		if(dto!=null) {
			if(password.equals(cpassword)) {
				dto.setPassword(cpassword);
				ss.saveOrUpdate(dto);
				ss.beginTransaction().commit();
				ss.close();
			return true;
			}else {
				ss.close();
				return false;
			}
		}else {
			ss.close();
			return false;
		}
		
	}

	@Override
	public boolean delete(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		cr.add(Restrictions.eq("id", id));
		MailInfo dto=(MailInfo) cr.uniqueResult();
		if(dto!=null) {
			dto.setStatus("deletedMail");
			ss.saveOrUpdate(dto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else {
			ss.close();
		return false;
		}
	}

	@Override
	public List<MailInfo> deletedMail() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		String email1=(String) session.getAttribute("email1");
		cr.add(Restrictions.eq("fromId",email1));
		Criterion status=Restrictions.eq("status", "deletedMail");
		Criterion inboxstatus=Restrictions.eq("inboxStatus", "deletedMail");    
		Criterion satus=Restrictions.disjunction().add(status).add(inboxstatus);
		cr.add(satus);
		List<MailInfo> mlist=cr.list();
		return mlist;
				
	}

	@Override
	public MailInfo showInbox(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		cr.add(Restrictions.eq("id", id));
		MailInfo dto=(MailInfo) cr.uniqueResult();
		return dto;
	}

	@Override
	public MailInfo showSent(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		cr.add(Restrictions.eq("id", id));
		MailInfo dto=(MailInfo) cr.uniqueResult();
		return dto;
	}

	@Override
	public MailInfo draftMail(int id) {
	   Session ss=sf.openSession();
	   Criteria cr=ss.createCriteria(MailInfo.class);
	   cr.add(Restrictions.eq("id", id));
	   MailInfo dto=(MailInfo) cr.uniqueResult();
		return dto;
	}

	@Override
	public UserInfo compMail(String from, String to, String sub, String body) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserInfo.class);
		cr.add(Restrictions.eq("email", to));
		UserInfo udto=(UserInfo) cr.uniqueResult();
		List<MailInfo> list;
		if(udto!=null) {
			int eid=(int) session.getAttribute("eid");
			cr=ss.createCriteria(MailInfo.class);
			cr.add(Restrictions.eq("id", eid));
			MailInfo mdto=(MailInfo) cr.uniqueResult();
			mdto.setFromId(from);
			mdto.setToId(to);
			mdto.setSubject(sub);
			mdto.setMessage(body);
			mdto.setStatus("MailSent");
			mdto.setInboxStatus("MailInbox");
			list=udto.getMlist();
			list.add(mdto);
			udto.setMlist(list);
			ss.update(udto);
			ss.beginTransaction().commit();
			ss.close();
			return udto;
			}else {
				int eid=(int) session.getAttribute("eid");
				cr=ss.createCriteria(MailInfo.class);
				cr.add(Restrictions.eq("id", eid));
				MailInfo mdto=(MailInfo) cr.uniqueResult();
				mdto.setFromId(from);
				mdto.setToId(to);
				mdto.setSubject(sub);
				mdto.setMessage(body);
				mdto.setStatus("DraftMail");
				list=udto.getMlist();
				list.add(mdto);
				udto.setMlist(list);
				ss.update(udto);
				ss.beginTransaction().commit();
				ss.close();
				return null;
			}
	}

	@Override
	public boolean deletedMail(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		cr.add(Restrictions.eq("id", id));
		MailInfo dto=(MailInfo) cr.uniqueResult();
		if(dto!=null) {
			ss.delete(dto);
			ss.beginTransaction().commit();
			ss.close();
		return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteinbox(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailInfo.class);
		cr.add(Restrictions.eq("id", id));
		MailInfo dto=(MailInfo) cr.uniqueResult();
		if(dto!=null) {
			dto.setInboxStatus("deletedMail");
			ss.saveOrUpdate(dto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else {
			ss.close();
		return false;
		}
	}
	
}
