/**
 * 
 */
package com.cdac.web.service;

import java.util.ArrayList;
import java.util.List;

import com.cdac.web.dao.IProductDao;
import com.cdac.web.dao.ProductDao;
import com.cdac.web.model.Product;

/**
 * @author Smita B Kumar
 *
 */
//accepting request from controller
		//validating the request
		//performing cerating calculation if required
		//then call dao and return to controller
public class ProductService implements IProductService {
	private IProductDao productDao= new ProductDao();
	/* (non-Javadoc)
	 * @see com.cdac.web.service.IProductService#getProductList()
	 */
	@Override
	public List<Product> getProductList() {
		
		return productDao.getProductList();
	}

}
