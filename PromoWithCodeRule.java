package com.test.amaysin;

import java.util.ArrayList;
import java.util.List;

public class PromoWithCodeRule implements IPromo {

	@Override
	public List<Product> applyPromo(Product product) {
		List<Product> pList = new ArrayList<Product>();
		
		product.setProductPrice(product.getProductPrice() * .1);
		pList.add(product);
		
		return pList;
	}
	
	@Override
	public List<Product> applyPromo(Product product, String promoCode){
		String pCode = "I<3AMAYSIM";
		List<Product> pList = new ArrayList<Product>();
		double discountPrice = product.getProductPrice() - (product.getProductPrice() * .1);
		
		if(pCode.equals(promoCode)){
			product.setProductPrice(discountPrice);
			pList.add(product);
		}
//		else{
//			pList.add(product);
//		}
		
		return pList;
	}

}
