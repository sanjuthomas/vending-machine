package org.sanju.vending.state;

import java.util.ArrayList;
import java.util.List;

import org.sanju.vending.enums.State;
import org.sanju.vending.model.Product;
import org.sanju.vending.state.subscriber.Subscriber;

/**
 * 
 * @author thosan
 *
 */
public class MachineState {
	
	private List<Subscriber> subscribers = new ArrayList<Subscriber>();
	
	private State state = State.NO_CHANGE_DEFAULT;
	
	private Product product;
	
	private Double amount = 0.0;
	
	public void register(final Subscriber subscriber){
		subscribers.add(subscriber);
	}

	public String getMessage() {
		if(state.getMessage().length() == 0){
			return constructMessage();
		}
		return state.getMessage();
	}
	
	private String constructMessage(){
		final StringBuilder builder = new StringBuilder();
		builder.append("Selected product : "+product.getName());
		builder.append("\n");
		builder.append("Current balance : "+ amount);
		builder.append("\n");
		builder.append("Insert "+ (product.getPrice() - amount) +" more");
		return builder.toString();
	}
	
	public void setSelectedProduct(final Product product){
		this.product = product;
		state = State.PRODUCT_SELECTED;
		updateSubscribers();
	}
	
	public Product getSelectedProduct(){
		return product;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
		updateSubscribers();
	}
	
	private void updateSubscribers(){
		for(final Subscriber subscriber : subscribers){
			subscriber.udpate(this);
		}
	}
}
