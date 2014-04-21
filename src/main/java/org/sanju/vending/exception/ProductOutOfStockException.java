package org.sanju.vending.exception;

/**
 * 
 * @author thosan
 *
 */
public class ProductOutOfStockException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ProductOutOfStockException(final String message){
		super(message);
	}
	
	public ProductOutOfStockException(){
		this("Product is out of stock!, Select another product");
	}
}
