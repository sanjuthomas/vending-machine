package org.sanju.vending.io;

import org.sanju.vending.model.Product;
import org.sanju.vending.state.MachineState;
import org.sanju.vending.state.subscriber.Subscriber;

/**
 * 
 * @author thosan
 *
 */
public class ProductOutputter implements Subscriber{
	
	public Product eject(final Product product){
		System.out.println(">>>>>>>>>>> ejecting" + product);
		return product;
	}

	public void udpate(MachineState machineState) {
		if(machineState.readyToDisposeProduct()){
			eject(machineState.getSelectedProduct());
			try {
				machineState.productDisposed();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
