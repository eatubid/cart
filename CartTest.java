package com.test.amaysin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CartTest {
	ICart cart;
	PromoRule rule = new PromoRule();
	List<Product> productList;
	Product p1;
	Product p2;
	
	final static String SMALL = "ult_small";
	final static String MEDIUM = "ult_medium";
	final static String LARGE = "ult_large";
	final static String ONE_GB = "1gb";
	
	Map<String, Double> productPriceMap;

	@Before
	public void setUp() throws Exception {
		cart = new Cart(rule);
		productList = new ArrayList<Product>();
		
		productPriceMap = new HashMap<String, Double>();
		productPriceMap.put(SMALL, 24.90);
		productPriceMap.put(MEDIUM, 29.90);
		productPriceMap.put(LARGE, 44.90);
		productPriceMap.put(ONE_GB, 9.90);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void scenario1() {
		System.out.println("\n[[[[[[[ SCENARIO 1 ]]]]]]]]]");
		
		int qty1 = 3;
		p1 = new Product();
		p1.setProductCode(SMALL);
		p1.setProductName("Unlimited 1GB");
		p1.setQty(qty1);
		p1.setProductPrice(qty1*productPriceMap.get(SMALL));
		productList.add(p1);

		p2 = new Product();
		p2.setProductCode(LARGE);
		p2.setProductName("Unlimited 5GB");
		p2.setQty(1);
		p2.setProductPrice(1*productPriceMap.get(LARGE));
		productList.add(p2);
		Assert.assertTrue("ProductList Empty.", productList.size()>0);
		
		showCartDetails(productList);
		
		cart.addProduct(productList);
		
		Assert.assertTrue("Promo ProductList Empty.", cart.getCartDetails().size()>0);
	
		showCartItemDetails(cart.getCartDetails());
	}
	
	@Test
	public void scenario2(){
		System.out.println("\n[[[[[[[ SCENARIO 2 ]]]]]]]]]");
		int qty1 = 2;
		p1 = new Product();
		p1.setProductCode(SMALL);
		p1.setProductName("Unlimited 1GB");
		p1.setQty(qty1);
		p1.setProductPrice(qty1*productPriceMap.get(SMALL));
		productList.add(p1);
		
		int qty2 = 4;
		p2 = new Product();
		p2.setProductCode(LARGE);
		p2.setProductName("Unlimited 5GB");
		p2.setQty(qty2);
		p2.setProductPrice(qty2*productPriceMap.get(LARGE));
		productList.add(p2);
		Assert.assertTrue("ProductList Empty.", productList.size()>0);
		
		showCartDetails(productList);
		
		cart.addProduct(productList);
		
		Assert.assertTrue("Promo ProductList Empty.", cart.getCartDetails().size()>0);
	
		showCartItemDetails(cart.getCartDetails());
	}
	
	@Test
	public void scenario3(){
		System.out.println("\n[[[[[[[ SCENARIO 3 ]]]]]]]]]");
		int qty1 = 1;
		p1 = new Product();
		p1.setProductCode(SMALL);
		p1.setProductName("Unlimited 1GB");
		p1.setQty(qty1);
		p1.setProductPrice(qty1*productPriceMap.get(SMALL));
		productList.add(p1);
		
		int qty2 = 2;
		p2 = new Product();
		p2.setProductCode(MEDIUM);
		p2.setProductName("Unlimited 2GB");
		p2.setQty(qty2);
		p2.setProductPrice(qty2*productPriceMap.get(MEDIUM));
		productList.add(p2);
		Assert.assertTrue("ProductList Empty.", productList.size()>0);
		
		showCartDetails(productList);
		
		cart.addProduct(productList);
		
		Assert.assertTrue("Promo ProductList Empty.", cart.getCartDetails().size()>0);
	
		showCartItemDetails(cart.getCartDetails());
	}
	
	@Test
	public void scenario4(){
		System.out.println("\n[[[[[[[ SCENARIO 4 ]]]]]]]]]");
		String promoCode = "I<3AMAYSIM";
		
		int qty1 = 1;
		p1 = new Product();
		p1.setProductCode(SMALL);
		p1.setProductName("Unlimited 1GB");
		p1.setQty(qty1);
		p1.setProductPrice(qty1*productPriceMap.get(SMALL));
		productList.add(p1);
		
		int qty2 = 1;
		p2 = new Product();
		p2.setProductCode(ONE_GB);
		p2.setProductName("1 GB Data-pack");
		p2.setQty(qty2);
		p2.setProductPrice(qty2*productPriceMap.get(ONE_GB));
		productList.add(p2);
		Assert.assertTrue("ProductList Empty.", productList.size()>0);
		
		showCartDetails(productList);
		
		cart.addProduct(productList, promoCode);
		
		Assert.assertTrue("Promo ProductList Empty.", cart.getCartDetails().size()>0);
		
		showCartItemDetails(cart.getCartDetails());
	}
	
	private void showCartDetails(List<Product> pList){
		System.out.println("------ CART -------");
		for(Product p: pList){
			System.out.print(p.getQty() + " X ");
			System.out.println(p.getProductName());
		}
	}
	
	private void showCartItemDetails(Collection<Product> pList){
		System.out.println("------ CART ITEMS -------");
		for(Product p: pList){
			System.out.print(p.getQty() + " X ");
			System.out.println(p.getProductName());
		}
		System.out.println("TOTAL : " + cart.getCartTotalPrice());
	}

}
