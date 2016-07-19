package com.javatest.onlineBilling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatest.onlineBilling.daoservice.BillingDaoService;
import com.javatest.onlineBilling.daoservice.ProductDaoService;
import com.javatest.onlineBilling.model.BillingModel;
import com.javatest.onlineBilling.model.Cart;
import com.javatest.onlineBilling.model.Product;

@RestController
@RequestMapping("/")
public class BillingController {
	
	@Autowired
	private BillingDaoService billingDaoService;	
	
	@Autowired
	private ProductDaoService productDaoService;
	
	@RequestMapping(method = RequestMethod.GET,value = "/{userName}/bill")
	public ResponseEntity<BillingModel> generateBill(@RequestParam String userName){
		BillingModel bill = billingDaoService.generateBill(userName);
		HttpStatus status = HttpStatus.OK;
		if(bill==null){
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<BillingModel>(bill,status);		
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{username}/cart")
	public ResponseEntity<Cart> addToCard(@RequestParam String userName,@RequestBody Long productId){
		Cart cart = billingDaoService.addToCart(productId,userName);
		return new ResponseEntity<Cart>(cart,HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/products")
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<List<Product>>(productDaoService.getProductList(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{username}/cart")
	public ResponseEntity<Cart> getCart(@RequestParam String userName){
		Cart cart = billingDaoService.getCart(userName);
		HttpStatus status = HttpStatus.OK;
		if(cart == null){
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Cart>(cart,status);
	}
}
