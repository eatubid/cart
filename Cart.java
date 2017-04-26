package com.test.amaysin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Cart implements ICart {
	PromoRule rule;
	private Map<String, Product> productMap;
	
	public Cart(PromoRule rule){
		this.rule = rule;
		this.productMap = new HashMap<String, Product>();
	}
	
	@Override
	public void addProduct(List<Product> productList){
		for(Product productItem: productList){
			for(Product p: rule.applyProductPromo(productItem)){
				productMap.put(p.getProductCode(), p);
			}
		}
	}
	
	@Override
	public void addProduct(List<Product> productList, String code){
		for(Product productItem: productList){
			for(Product p: rule.applyProductPromo(productItem, code)){
				productMap.put(p.getProductCode(), p);
			}
		}
	}
	
	public Collection<Product> getCartDetails(){
		return productMap.values();
	}
	
//	public Map<String, Product> getCartMap(){
//		return productMap;
//	}
	
	public double getCartTotalPrice(){
		double price = 0.0d;
		Iterator<Product> iterator = getCartDetails().iterator();
		while(iterator.hasNext()){
			price += iterator.next().getProductPrice();
		}
		
		return Math.round(price* 100.0) / 100.0;
	}
}
