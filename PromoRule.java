package com.test.amaysin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromoRule {
	IPromo promo;
	
	/**
	 * Lookup table for product with promo to eliminate looping
	 * through all the rules. 
	 */
	private static Map<String, Integer> productWithPromoMap;
	static{
		productWithPromoMap = new HashMap<String, Integer>();
		productWithPromoMap.put("ult_small", 1);
		productWithPromoMap.put("ult_medium", 2);
		productWithPromoMap.put("ult_large", 3);
	}
	
	public List<Product> applyProductPromo(Product product){
		List<Product> pList = new ArrayList<Product>();
		
		switch (productWithPromoMap.get(product.getProductCode())){
			case 1: 
					promo = new Promo1GBRule();
					break;
			case 2:
					promo = new Promo2GBRule();
					break;
			case 3:
					promo = new Promo5GBRule();
					break;
			default:
				break;
		}
		
		pList.addAll(promo.applyPromo(product));
		
		return pList;
	}
	
	public List<Product> applyProductPromo(Product product, String promoCode){
		List<Product> pList = new ArrayList<Product>();
		promo = new PromoWithCodeRule();
		
		pList.addAll(promo.applyPromo(product, promoCode));
				
		return pList;
	}
}
