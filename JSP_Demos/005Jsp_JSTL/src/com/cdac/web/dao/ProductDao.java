/**
 * 
 */
package com.cdac.web.dao;

import java.util.ArrayList;
import java.util.List;

import com.cdac.web.model.Product;

/**
 * @author Smita B Kumar
 *
 */
public class ProductDao implements IProductDao {

	/* (non-Javadoc)
	 * @see com.cdac.web.dao.IProductDao#getProductList()
	 */
	@Override
	public List<Product> getProductList() {
		List<Product> productList= new ArrayList<>();
		Product p1 = new Product(101, "iPhone", 78788.99f);
		Product p2= new Product(102, "Samsung", 56666.99f);
		Product p3 = new Product(103, "Mi", 10000.99f);
		Product p4 = new Product(104, "Vivo", 10000.99f);
		productList.add(p1);productList.add(p2);productList.add(p3);productList.add(p4);
		
		return productList;
	}

}
