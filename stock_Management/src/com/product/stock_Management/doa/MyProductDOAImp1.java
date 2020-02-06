package com.product.stock_Management.doa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.stock_Management.model.OrderInfoDTO;
import com.product.stock_Management.model.ProductDTO;
import com.product.stock_Management.model.SignUp;
@Component
public class MyProductDOAImp1 implements MyProductDOA{
    
	@Autowired
	SessionFactory sf;
	
	@Override
	public boolean signup(SignUp sdto) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(SignUp.class);
		cr.add(Restrictions.eq("userName", sdto.getUserName()));
		SignUp dto=(SignUp) cr.uniqueResult();
		if(dto!=null) {
		return false;
		}else {
			ss.save(sdto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}
	}

	@Override
	public SignUp login(String un, String password) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(SignUp.class);
		cr.add(Restrictions.eq("userName", un));
		cr.add(Restrictions.eq("password", password));
		SignUp sdto=(SignUp) cr.uniqueResult();
		ss.close();
		return sdto;
		
	}
	
	@Override
	public List<ProductDTO> product() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(ProductDTO.class);
		List<ProductDTO> list=cr.list();
		return list;
	}
	
	@Override
	public boolean addProduct(ProductDTO pdto) {
		Session ss=sf.openSession();
		ss.save(pdto);
		ss.beginTransaction().commit();
		ss.close();
		return true;
	}

	@Override
	public boolean modifyProduct(ProductDTO pdto) {
		Session ss=sf.openSession();
		ss.saveOrUpdate(pdto);
		return true;
	}

	@Override
	public List<ProductDTO> search(String search) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(ProductDTO.class);
		Criterion name=Restrictions.like("pName", search, MatchMode.ANYWHERE);
		Criterion company=Restrictions.like("cName", search, MatchMode.ANYWHERE);
		Criterion category=Restrictions.like("category", search, MatchMode.ANYWHERE);
		Criterion complete=Restrictions.disjunction().add(name).add(company).add(category);
		cr.add(complete);
		List<ProductDTO> plist=cr.list();
		ss.close();
		return plist;
	}

	@Override
	public ProductDTO update(int id) {
	    Session ss=sf.openSession();
	    Criteria cr=ss.createCriteria(ProductDTO.class);
	    cr.add(Restrictions.eq("pid", id));
	    ProductDTO dto=(ProductDTO) cr.uniqueResult();
	    ss.close();
		return dto;
	}

	@Override
	public boolean updateproduct(ProductDTO dto) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(ProductDTO.class);
		cr.add(Restrictions.eq("pid", dto.getPid()));
		ProductDTO dto1=(ProductDTO) cr.uniqueResult();
		if(dto1!=null) {
			dto1.setcName(dto.getcName());
			dto1.setpName(dto.getpName());
			dto1.setCategory(dto.getCategory());
			dto1.setQuantity(dto.getQuantity());
			dto1.setPrice(dto.getPrice());
			ss.update(dto1);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else {
			ss.close();
		return false;
		}
	}

	@Override
	public ProductDTO addtocart(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(ProductDTO.class);
		cr.add(Restrictions.eq("pid", id));
		ProductDTO dto=(ProductDTO) cr.uniqueResult();
		if(dto!=null) {
			ss.close();
		return dto;
		}else {
			ss.close();
			return null;
		}
	}

	@Override
	public ProductDTO add(ProductDTO dto) {
		Session ss=sf.openSession();
		ProductDTO pdto=ss.get(ProductDTO.class, dto.getPid());
		if((pdto.getQuantity()-dto.getQuantity())>=0) {
		pdto.setQuantity(pdto.getQuantity()-dto.getQuantity());
		OrderInfoDTO odto=new OrderInfoDTO();
		double totalPrice=dto.getPrice()*dto.getQuantity();
		odto.setTotalPrice(totalPrice);
		odto.setTotalPriceWithGST((totalPrice*0.18)+totalPrice);
		List<OrderInfoDTO> list=pdto.getOlist();
		list.add(odto);
		ss.saveOrUpdate(pdto);
		ss.beginTransaction().commit();
		ss.close();
		return pdto;
		}else {
			return null;
		}
	}

	@Override
	public ProductDTO delete(int id) {
		Session ss=sf.openSession();
		ProductDTO dto=ss.load(ProductDTO.class, id);
		ss.delete(dto);
		ss.beginTransaction().commit();
		ss.close();
		return null;
	}

	
	
	

}
