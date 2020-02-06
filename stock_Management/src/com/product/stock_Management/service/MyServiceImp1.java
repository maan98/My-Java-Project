package com.product.stock_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.stock_Management.doa.MyProductDOA;
import com.product.stock_Management.model.ProductDTO;
import com.product.stock_Management.model.SignUp;
@Component
public class MyServiceImp1 implements MyService{
     
	@Autowired
	MyProductDOA md;
	
	@Override
	public boolean signup(SignUp sdto) {
		boolean b=md.signup(sdto);
		return b;
	}

	@Override
	public SignUp login(String un, String password) {
		SignUp sdto=md.login(un, password);
		return sdto;
	}
	
	@Override
	public List<ProductDTO> product() {
		return md.product();
	}
	
	@Override
	public boolean addProduct(ProductDTO pdto) {
		boolean b=md.addProduct(pdto);
		return b;
	}

	@Override
	public boolean modifyProduct(ProductDTO pdto) {
		md.modifyProduct(pdto);
		return true;
	}

	@Override
	public List<ProductDTO> search(String search) {
		List<ProductDTO> list=md.search(search);
		return list;
	}

	@Override
	public ProductDTO update(int id) {
		
		return md.update(id);
	}

	@Override
	public boolean updateproduct(ProductDTO dto) {
		boolean b=md.updateproduct(dto);
		return b;
	}

	@Override
	public ProductDTO addtocart(int id) {
		
		return md.addtocart(id);
	}

	@Override
	public ProductDTO add(ProductDTO dto) {
		
		return md.add(dto);
	}

	@Override
	public ProductDTO delete(int id) {
		
		return md.delete(id);
	}

	
      
}
