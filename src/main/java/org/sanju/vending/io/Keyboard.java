package org.sanju.vending.io;

import org.sanju.vending.Machine;
import org.sanju.vending.exception.ProductOutOfStockException;

/**
 * 
 * @author thosan
 *
 */
public class Keyboard {
	
	public static final Integer cancelCode = -999;
	
	private Machine machine;
	
	public Keyboard(final Machine machine){
		this.machine = machine;
	}
	
	public void one() throws ProductOutOfStockException{
		machine.selectProduct(1);
	}
	
	public void two() throws ProductOutOfStockException{
		machine.selectProduct(2);
	}
	
	public void three() throws ProductOutOfStockException{
		machine.selectProduct(3);
	}
	
	/**
	 * cancel the selection, return the money.
	 * @throws ProductOutOfStockException 
	 */
	public void cancel() throws ProductOutOfStockException{
		machine.selectProduct(cancelCode);
	}
}
