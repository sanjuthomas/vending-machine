package org.sanju.vending.io;

import org.sanju.vending.state.MachineState;
import org.sanju.vending.state.subscriber.Subscriber;


/**
 * 
 * @author thosan
 *
 */
public class DisplayUnit implements Subscriber{
	
	/**
	 * For testing purpose I have added return type
	 * 
	 * @param message
	 * @return
	 */
	public String showMessage(final String message){
		System.out.println(">>>> " + message);
		return message;
	}
	
	/**
	 * 
	 */
	public void udpate(MachineState machineState) {
		this.showMessage(machineState.getMessage());
	}

}
