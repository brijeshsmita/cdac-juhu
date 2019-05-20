/**
 * 
 */
package com.cdac.web.model;

import java.io.Serializable;

/**
 * @author Smita B Kumar
 *
 */
public class Product implements Serializable{
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String productName, float productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	private static final long serialVersionUID = -1572479999295147982L;
	private int productId;
	private String productName;
	private float productPrice;
	
}
