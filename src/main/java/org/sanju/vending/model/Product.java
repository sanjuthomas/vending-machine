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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price
				+ "]";
	}
	
}
