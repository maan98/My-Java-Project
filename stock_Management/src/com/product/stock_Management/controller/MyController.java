package com.product.stock_Management.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.product.stock_Management.model.OrderInfoDTO;
import com.product.stock_Management.model.ProductDTO;
import com.product.stock_Management.model.SignUp;
import com.product.stock_Management.service.MyService;
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
	public ModelAndView signup(@ModelAttribute SignUp sdto) {
		boolean b=ms.signup(sdto);
		if(b) {
		return new ModelAndView("login","success","Sign up successfull");
		}else {
			return new ModelAndView("signup","failed","Sign up failed");
		}
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam String userName,String password) {
		SignUp sdto=ms.login(userName, password);
		if(sdto!=null) {
			session.setAttribute("un1", sdto.getUserName());
			List<ProductDTO> list=ms.product();
		return new ModelAndView("home","list",list);
		}else {
			return new ModelAndView("login","failed","login failed try again");
		}
	}
	
	@RequestMapping("/addpro")
	public ModelAndView addpro() {
		if(session.getAttribute("un1")!=null) {
		return new ModelAndView("addproduct");
	}else {
		  return new ModelAndView("login","failed","Login First");
	  }
	}
	
	@RequestMapping(value="/addproduct",method =RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute ProductDTO pdto) {
		if(session.getAttribute("un1")!=null) {
		boolean b=ms.addProduct(pdto);
		if(b) {
			return new ModelAndView("success","success","Product successfully added");
			}else {
			return new ModelAndView("success","failed","product not added try again");
		}
	}else {
		  return new ModelAndView("login","failed","Login First");
	  }
	}
	
	@RequestMapping("/modyproduct")
	public ModelAndView modifyProduct() {
		if(session.getAttribute("un1")!=null) {
		List<ProductDTO> list=ms.product();
		return new ModelAndView("modify","list",list);
	}else {
		  return new ModelAndView("login","failed","Login First");
	  }
	}
	@RequestMapping("/addtocart")
	public ModelAndView addToCart(@RequestParam int id) {
		if(session.getAttribute("un1")!=null) {
		ProductDTO dto=ms.addtocart(id);
		return new ModelAndView("addtocart","dto",dto);
	}else {
		  return new ModelAndView("login","failed","Login First");
	  }
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public ModelAndView search(@RequestParam String search) {
		if(session.getAttribute("un1")!=null) {
		List<ProductDTO> list=ms.search(search);
		if(list.isEmpty()) {
		   return new ModelAndView("success","failed","product not available");	
		}else {
		return new ModelAndView("search","list",list);
		}
	}else {
		  return new ModelAndView("login","failed","Login First");
	  }
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam int id) {
		if(session.getAttribute("un1")!=null) {
		ProductDTO dto=ms.update(id);
		return new ModelAndView("updateproduct","dto",dto);
	}else {
		  return new ModelAndView("login","failed","Login First");
	  }
	}
	
	@RequestMapping(value="/updateproduct",method=RequestMethod.POST)
	public ModelAndView updateproduct(@ModelAttribute ProductDTO dto) {
		if(session.getAttribute("un1")!=null) {
		boolean b=ms.updateproduct(dto);
		if(b) {
			return new ModelAndView("success","success","updated successfully");
		}else {
			return new ModelAndView("success","failed","not updated");
		}
	}else {
		  return new ModelAndView("login","failed","Login First");
	  }
	}
	
	@RequestMapping(value="/addcart",method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute ProductDTO dto) {
		if(session.getAttribute("un1")!=null) {
		ProductDTO pdto=ms.add(dto);
		if(pdto!=null) {
			return new ModelAndView("cart","dto",pdto);
		}else {
			return new ModelAndView("success","failed","out of stock or limited stock");
		}
	}else {
		  return new ModelAndView("login","failed","Login First");
	  }
	}
	
	@RequestMapping("/home")
	public ModelAndView home() {
		if(session.getAttribute("un1")!=null) {
		List<ProductDTO> list=ms.product();
		return new ModelAndView("home","list",list);
	}else {
		  return new ModelAndView("login","failed","Login First");
	  }
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id) {
		 if(session.getAttribute("un1")!=null) {
		ProductDTO dto=ms.delete(id);
		if(dto==null) {
			List<ProductDTO> list=ms.product();
			return new ModelAndView("home","list",list);
		}else {
			List<ProductDTO> list=ms.product();
			return new ModelAndView("home","list",list);
		}
		 }else {
			  return new ModelAndView("login","failed","Login First");
		  }
	}
	 @RequestMapping("/logout")
	  public ModelAndView logout() {
		  if(session.getAttribute("un1")!=null) {
		  session.invalidate();
		  return new ModelAndView("login","success","logout success");
		  }else {
			  return new ModelAndView("login","failed","Login First");
		  }
	  }

}
