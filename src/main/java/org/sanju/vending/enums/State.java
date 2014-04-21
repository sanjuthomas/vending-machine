package org.sanju.vending.enums;

/**
 * 
 * @author thosan
 *
 */
public enum State {
	
	DEFAULT("INSERT COIN"),	
	NO_CHANGE_DEFAULT("INSERT EXACT CHANGE ONLY"),
	PRODUCT_SELECTED(""),
	PRODUCT_DISPOSED("THANK YOU");
	
	private String message;

	State(final String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
}
