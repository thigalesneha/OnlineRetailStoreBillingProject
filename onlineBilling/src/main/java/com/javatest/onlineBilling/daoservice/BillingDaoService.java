package com.javatest.onlineBilling.daoservice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javatest.onlineBilling.exception.ProductNotFoundException;
import com.javatest.onlineBilling.exception.UserNotFoundException;
import com.javatest.onlineBilling.model.BillingModel;
import com.javatest.onlineBilling.model.Cart;
import com.javatest.onlineBilling.model.CatagoryEnum;
import com.javatest.onlineBilling.model.Product;

@Component
public class BillingDaoService {

	private Map<String,Cart> userCartMap;
	
	@Autowired
	private ProductDaoService productDaoService;
	
	@PostConstruct
	public void init(){
		userCartMap = new HashMap<String, Cart>();
	}
	
	public Cart addToCart(Long productId,String userName) throws ProductNotFoundException{
		Cart cart = userCartMap.get(userName);
		if(cart==null){
			cart = new Cart();
			userCartMap.put(userName, cart);
		}
		Product product = productDaoService.getProductById(productId);
		if(product == null){
			throw new ProductNotFoundException();
		}
		Integer quantityOld = cart.getProductMap().get(product);
		if(quantityOld == null){
			cart.getProductMap().put(product, 1);
		}else{
			cart.getProductMap().put(product, quantityOld+1);
		}
		cart.setUserName(userName);
		return cart;
	}
	
	public BillingModel generateBill(String userName){
		BillingModel bill = new BillingModel();
		Cart cart = userCartMap.get(userName);
		if(cart==null){
			throw new UserNotFoundException("There is not cart for user:"+userName);
		}
		Map<Product, Integer> productMap = cart.getProductMap();
		Set<Entry<Product, Integer>> entrySet = productMap.entrySet();
		Integer totalItemCount = 0;
		Double totalAmount = 0.0;
		Double totalTax = 0.0;
		for( Entry<Product, Integer> entry : entrySet){
			totalItemCount = totalItemCount + entry.getValue();
			totalAmount = totalAmount+entry.getKey().getPrice()*entry.getValue();
			totalTax = totalTax+(entry.getKey().getPrice()*getSalesTax(entry.getKey().getCategory()))* entry.getValue();
		}
		bill.setNoOfItems(totalItemCount);
		bill.setBillAmount(totalAmount);
		bill.setTaxAmount(totalTax);
		bill.setTotalBillAmount(totalAmount+totalTax);
		userCartMap.remove(userName);
		return bill;
	}
	
	public Cart getCart(String userName){
		return userCartMap.get(userName);
	}
	
	
	public Double getSalesTax(CatagoryEnum category){
		if(CatagoryEnum.CATAGERY_A.equals(category)){
			return 0.1;
		}else if(CatagoryEnum.CATAGERY_B.equals(category)){
			return 0.2;
		}
		else{
			return 0.0;
		}
	}
}
