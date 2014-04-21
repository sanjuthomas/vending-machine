package org.sanju.vending.exception;

/**
 * 
 * @author thosan
 *
 */
public class CoinTypeNotAvailableException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public CoinTypeNotAvailableException(final String message){
		super(message);
	}
	
	public CoinTypeNotAvailableException(){
		this("Requested coin is not in the stock!");
	}

}
