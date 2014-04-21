package org.sanju.vending.model;

/**
 * 
 * @author thosan
 *
 */
public class Product {
	
	private Integer code;
	private String name;
	private Double price;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(final Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(final Double price) {
		this.price = price;
	}
}
