package com.test.amaysin;

import java.util.ArrayList;
import java.util.List;

public class Promo2GBRule implements IPromo{

	@Override
	public List<Product> applyPromo(Product product) {
		List<Product> pList = new ArrayList<Product>();
		pList.add(product);
		
		if(product.getQty()>0){
			Product p = new Product();
			p.setProductCode("1gb");
			p.setProductName("1 GB Data-pack");
			p.setQty(product.getQty());
			
			pList.add(p);
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
