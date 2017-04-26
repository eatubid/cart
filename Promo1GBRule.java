package com.test.amaysin;

import java.util.ArrayList;
import java.util.List;

public class Promo1GBRule implements IPromo{
	
	@Override
	public List<Product> applyPromo(Product product){
		List<Product> pList = new ArrayList<Product>();
		if(product.getQty() % 3 == 0){
			product.setProductPrice(2 * (product.getQty()/3) * product.getProductPrice()/product.getQty());
			
			pList.add(product);
		}else{
			pList.add(product);
		}
		
		return pList;
	}

	@Override
	public List<Product> applyPromo(Product product, String promoCode) {
		// TODO Auto-generated method stub
		return null;
	}
}
