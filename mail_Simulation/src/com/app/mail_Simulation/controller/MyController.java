package com.app.mail_Simulation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.mail_Simulation.model.MailInfo;
import com.app.mail_Simulation.model.UserInfo;
import com.app.mail_Simulation.service.MyService;
@RequestMapping("/")
@Component
public class MyController {
	@Autowired
	MyService ms;
	
	  @Autowired 
	  HttpSession session;
	 
	
	@RequestMapping("/link1")
	public String m1() {
		return "signup";
	}
	@RequestMapping("/link2")
	public String m2() {
		return "login";
	}
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ModelAndView signup(@ModelAttribute UserInfo dto) {
		boolean b=ms.signup(dto);
		if(b) {
		return new ModelAndView("login","success","Sign up successfull");
		}else {
			return new ModelAndView("signup","error","Sign up failed mail alredy used");
		}
	}
	
	  @RequestMapping(value="/login",method=RequestMethod.POST) 
	  public ModelAndView login(@RequestParam String email,String password) { 
		  UserInfo sdto=ms.login(email, password); 
		  if(sdto!=null) {
	  session.setAttribute("email1", sdto.getEmail()); 
	  return new ModelAndView("home","sdto",sdto); 
	  }else { 
		  return new ModelAndView("login","error","login failed try again");
		  }
		  }
	  
	  @RequestMapping("/inbox") 
	  public ModelAndView inbox() {
		  if(session.getAttribute("email1")!=null) {
		 List<MailInfo> list=ms.inbox();
		  return new ModelAndView("inbox","list",list);
		  }else {
			  return new ModelAndView("login","error","Login First");
		  }
		  }
	  
	  @RequestMapping("/sent") 
	  public ModelAndView sent() {
		  if(session.getAttribute("email1")!=null) {
		 List<MailInfo> list=ms.sent();
		  return new ModelAndView("sent","list",list); 
		  }else {
			  return new ModelAndView("login","error","Login First");
		  }
		  }
	  @RequestMapping("/draft")
		public ModelAndView draft() {
		  if(session.getAttribute("email1")!=null) {
		  List<MailInfo> list=ms.draft();
		  return new ModelAndView("draft","list",list);
	  }else {
		  return new ModelAndView("login","error","Login First");
	  }
		}
	  @RequestMapping("/compose")
		public ModelAndView m5() {
		  if(session.getAttribute("email1")!=null) {
		  String email=(String) session.getAttribute("email1");
			return new ModelAndView("compose","msg",email);
		  }else {
			  return new ModelAndView("login","error","Login First");
		  }
		}
	  
	  @RequestMapping("/comp") 
	  public ModelAndView compose(@RequestParam String to,String sub,String body) {
		  if(session.getAttribute("email1")!=null) {
		  String from=(String) session.getAttribute("email1");
		  UserInfo b=ms.compose(from,to,sub,body);
		 if(b!=null) {
		  return new ModelAndView("successpage","success","mail sent successfully"); 
		 }else {
			 return new ModelAndView("home","error","mail not sent, saved in draft ");
		 }
		  }else {
			  return new ModelAndView("login","error","Login First");
		  }
		 
	  }
	  @RequestMapping("/logout")
	  public ModelAndView logout() {
		  if(session.getAttribute("email1")!=null) {
		  session.invalidate();
		  return new ModelAndView("login","success","logout success");
		  }else {
			  return new ModelAndView("login","error","Login First");
		  }
	  }
	  @RequestMapping("/delete")
	  public ModelAndView delete(@RequestParam int id) {
		  if(session.getAttribute("email1")!=null) {
		  boolean b=ms.delete(id);
		  if(b) {
		  return new ModelAndView("home","success","deleted successfully");
		  }else {
			  return new ModelAndView("home","error","delete failed");
		  }
	  }else {
		  return new ModelAndView("login","error","Login First");
	  }
	  }
	  @RequestMapping("/deleteinbox")
	  public ModelAndView deleteinbox(@RequestParam int id) {
		  if(session.getAttribute("email1")!=null) {
		  boolean b=ms.deleteinbox(id);
		  if(b) {
		  return new ModelAndView("home","success","deleted successfully");
		  }else {
			  return new ModelAndView("home","error","delete failed");
		  }
		  }else {
			  return new ModelAndView("login","error","Login First");
		  }
	  }
	  @RequestMapping("/fpass")
	  public ModelAndView forgot() {
		  return new ModelAndView("forgot");
	  }
	  @RequestMapping(value="/forgot",method=RequestMethod.POST)
	  public ModelAndView forgot(@RequestParam String email,String password,String seqanswer,String cpassword) {
		  boolean b=ms.forgot(email, password, seqanswer, cpassword);
		  if(b) {
		  return new ModelAndView("login","success","Password Changed Successfully");
		  }else {
			  return new ModelAndView("forgot","error","Invalid details or worng password");
		  }
	  }
	  @RequestMapping("/change")
	  public ModelAndView change() {
		  if(session.getAttribute("email1")!=null) {
		  return new ModelAndView("change");
	  }else {
		  return new ModelAndView("login","error","Login First");
	  }
	  }
	  @RequestMapping(value="/chang",method=RequestMethod.POST)
	  public ModelAndView change(@RequestParam String password,String cpassword) {
		  if(session.getAttribute("email1")!=null) {
		  boolean b=ms.change( password,cpassword);
		  if(b) {
		  return new ModelAndView("home","success","Password Changed Successfully");
		  }else {
			  return new ModelAndView("change","error","Invalid details or worng password");
		  }
		  }else {
			  return new ModelAndView("login","error","Login First");
		  }
	  }
	  @RequestMapping("/deleteMail")
	  public ModelAndView deleted() {
		  if(session.getAttribute("email1")!=null) {
		  List<MailInfo> list=ms.deletedMail();
		  return new ModelAndView("deletedMail","list",list);
	  }else {
		  return new ModelAndView("login","error","Login First");
	  }
		}
	  @RequestMapping("/showInbox")
	  public ModelAndView showInbox(@RequestParam int id) {
		  if(session.getAttribute("email1")!=null) {
			  MailInfo dto=ms.showInbox(id);
		  return new ModelAndView("showInbox","dto",dto);
		  }else {
			  return new ModelAndView("login","error","Login First");
		  }
	  }
	  @RequestMapping("/showSent")
	  public ModelAndView showSent(@RequestParam int id) {
		  if(session.getAttribute("email1")!=null) {
			  MailInfo dto=ms.showSent(id);
		  return new ModelAndView("showSent","dto",dto);
		  }else {
			  return new ModelAndView("login","error","Login First");
		  }
	  }
	  @RequestMapping("/draftMail")
	  public ModelAndView draft(@RequestParam int draftMail) {
		  session.setAttribute("eid", draftMail);
		  if(session.getAttribute("email1")!=null) {
			  MailInfo dto=ms.draftMail(draftMail);
		  return new ModelAndView("composeMail","dto",dto);
		  }else {
			  return new ModelAndView("login","error","Login First");
		  }
	  }
	  @RequestMapping("/compMail")
	  public ModelAndView compMail(@RequestParam String to,String sub,String body) {
		  if(session.getAttribute("email1")!=null) {
		  String from=(String) session.getAttribute("email1");
		  UserInfo b=ms.compMail(from,to,sub,body);
		 if(b!=null) {
		  return new ModelAndView("successpage","success","mail sent successfully"); 
		 }else {
			 return new ModelAndView("home","error","mail not sent, saved in draft ");
		 }
	  }else {
		  return new ModelAndView("login","error","Login First");
	  }

	  }
	  @RequestMapping("/perdelete")
	  public ModelAndView perDelete(@RequestParam int id) {
		  if(session.getAttribute("email1")!=null) {
		  boolean b=ms.deletedMail(id);
		  if(b) {
			  List<MailInfo> list=ms.deletedMail();
			  return new ModelAndView("deletedMail","list",list);
		  }else {
			  List<MailInfo> list=ms.deletedMail();
			  return new ModelAndView("deletedMail","list",list);
		  }
		  }else {
			  return new ModelAndView("login","error","Login First");
		  }
	  }
	  
	  
	 

}
