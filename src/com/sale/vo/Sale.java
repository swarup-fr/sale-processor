package com.sale.vo;

import java.math.BigDecimal;

public class Sale implements IMessage {
	private String product;
	private BigDecimal value;
	
	public Sale() {
		
	}
	
	public Sale(String product, BigDecimal value) {
		this.product = product;
		this.value = value;
	}
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
}
