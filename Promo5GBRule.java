package com.test.amaysin;

import java.util.ArrayList;
import java.util.List;

public class Promo5GBRule implements IPromo{
	
	@Override
	public List<Product> applyPromo(Product product){
		List<Product> pList = new ArrayList<Product>();
		if(product.getQty()>3){
			product.setProductPrice(product.getQty() * 39.90);
			
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
