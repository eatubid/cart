package com.test.amaysin;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ICart {
	public void addProduct(List<Product> productList);
	
	public void addProduct(List<Product> productList, String code);
	
	Collection<Product> getCartDetails();
	
//	Map<String, Product> getCartMap();
	
	public double getCartTotalPrice();
}
