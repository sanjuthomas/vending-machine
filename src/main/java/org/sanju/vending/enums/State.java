package org.sanju.vending.enums;

/**
 * 
 * @author thosan
 *
 */
public enum State {

	DEFAULT("INSERT COIN");
	
	private String message;
	
	State(final String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
}
