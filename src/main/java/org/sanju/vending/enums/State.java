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
	PRODUCT_READEY_TO_BE_DISPOSED("YOUR PRODUCT IS ON THE WAY"),
	PRODUCT_DISPOSED("THANK YOU");
	
	private String message;

	State(final String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
}
