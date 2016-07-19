package com.javatest.onlineBilling.daoservice;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.javatest.onlineBilling.model.CatagoryEnum;
import com.javatest.onlineBilling.model.Product;

@Component
public class ProductDaoService {

	private List<Product> productList ;
	
	@PostConstruct
	public void init(){
		productList = new ArrayList<Product>();
		loadProducts();
	}	
	
	private void loadProducts(){
		productList.add(new Product(1L,"Pendrive" ,"16GB pendrive",800D,CatagoryEnum.CATAGERY_A));
		productList.add(new Product(2L,"Motorole Ear phone" ,"Motorole Ear phone",1500D,CatagoryEnum.CATAGERY_A));
		productList.add(new Product(3L,"Mobile cover for one plus two" ,"Mobile cover for one plus two",300D,CatagoryEnum.CATAGERY_A));
		productList.add(new Product(4L,"MOTO g 8GB while phone" ,"MOTO g 8GB phone",14000D,CatagoryEnum.CATAGERY_A));
		productList.add(new Product(12L,"MOTO g 16GB while phone" ,"MOTO g 16GB phone",2000D,CatagoryEnum.CATAGERY_A));
		
		productList.add(new Product(5L,"Leather jacket" ,"Leather jacket",1990D,CatagoryEnum.CATAGERY_B));
		productList.add(new Product(6L,"Raincoat" ,"Raincoat",1000D,CatagoryEnum.CATAGERY_B));
		productList.add(new Product(7L,"Indian Ethnic dress" ,"Indian Ethnic dress",1399D,CatagoryEnum.CATAGERY_B));
		productList.add(new Product(11L, "Denim", "Denim", 899D, CatagoryEnum.CATAGERY_B));
		
		productList.add(new Product(8L,"School Bag" ,"16GB pendrive",800D,CatagoryEnum.CATAGERY_C));
		productList.add(new Product(9L,"Trolly Bag" ,"16GB pendrive",800D,CatagoryEnum.CATAGERY_C));
		productList.add(new Product(10L,"School Accessaries Combo" ,"All school needs",800D,CatagoryEnum.CATAGERY_C));
		
	}
	
	public List<Product> getProductList(){
		return productList;
	}
	
	public Product getProductById(Long productId){
		for(Product p : productList){
			if(p.getId().equals(productId))
				return p;
		}
		return null;
	}
}
