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
	
	private Double amount;

	public String getMessage() {
		return state.getMessage();
	}
	
	public void setSelectedProduct(final Product product){
		this.product = product;
	}
	
	public Product getSelectedProduct(){
		return product;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
	}
	
}
