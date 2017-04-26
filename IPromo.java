package com.test.amaysin;

import java.util.List;

public interface IPromo {
	public List<Product> applyPromo(Product product);
	
	public List<Product> applyPromo(Product product, String promoCode);
}
