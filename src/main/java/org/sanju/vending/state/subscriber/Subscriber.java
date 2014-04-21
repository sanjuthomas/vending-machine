package org.sanju.vending.state.subscriber;

import org.sanju.vending.state.MachineState;

/**
 * 
 * @author thosan
 *
 */
public interface Subscriber {
	
	public void udpate(final MachineState machineState);

}
