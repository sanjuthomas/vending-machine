package org.sanju.vending;

import org.sanju.vending.external.CoinDetector;
import org.sanju.vending.io.CoinInputter;
import org.sanju.vending.io.CoinOutputter;
import org.sanju.vending.io.DisplayUnit;
import org.sanju.vending.io.Keyboard;
import org.sanju.vending.state.MachineState;
import org.sanju.vending.validator.CoinValidator;

/**
 * 
 * @author thosan
 *
 */
public class Machine {
	
	private MachineState machineState = new MachineState();
	private CoinInputter coinInputter = new CoinInputter(new CoinValidator(), new CoinDetector());
	private CoinOutputter coinOutputter = new CoinOutputter();
	private DisplayUnit displayUnit = new DisplayUnit();
	private Keyboard keyboard = new Keyboard();
	
	public Machine(){
		displayUnit.showMessage(machineState.getMessage());
	}
	
	/**
	 * This method is only for testing.
	 * 
	 * @return
	 */
	public String getCurrentMessage(){
		return displayUnit.showMessage(machineState.getMessage());
	}
	
}
