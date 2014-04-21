package org.sanju.vending.state;

import org.sanju.vending.enums.State;
import org.sanju.vending.model.Product;

/**
 * 
 * @author thosan
 *
 */
public class MachineState {
	
	private State state = State.NO_CHANGE_DEFAULT;
	
	private Product product;

	public String getMessage() {
		return state.getMessage();
	}
	
	public void setCurrentProductSelected(final Product product){
		this.product = product;
	}
	
	public Product getCurrentProductSelected(){
		return product;
	}
	
}
