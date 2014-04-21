package org.sanju.vending;

import java.util.List;

import org.sanju.vending.exception.InvalidCoinException;
import org.sanju.vending.exception.ProductOutOfStockException;
import org.sanju.vending.external.CoinDetector;
import org.sanju.vending.inventory.CoinInventoryManager;
import org.sanju.vending.inventory.ProductInventoryManager;
import org.sanju.vending.io.CoinInputter;
import org.sanju.vending.io.CoinOutputter;
import org.sanju.vending.io.DisplayUnit;
import org.sanju.vending.io.Keyboard;
import org.sanju.vending.io.ProductOutputter;
import org.sanju.vending.model.Coin;
import org.sanju.vending.model.Product;
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
	private Keyboard keyboard = new Keyboard(this);
	private ProductInventoryManager productInventoryManager = new ProductInventoryManager();
	private CoinInventoryManager coinInventoryManager = new CoinInventoryManager();
	private ProductOutputter productOutputter = new ProductOutputter();
	
	
	public Machine(){
		machineState.register(displayUnit);
		machineState.register(productOutputter);
		displayUnit.showMessage(machineState.getMessage());
	}
	
	/**
	 * This method is only for testing.
	 * 
	 * @return
	 */
	public void acceptCoin(final Coin coin) throws InvalidCoinException{
		coinInputter.accept(coin);
		machineState.setAmount(coinInputter.getAmount());
		//eject.. we are now taking only exact change, coinInventoryManager needs to be implemented
		if(coinInputter.getAmount().doubleValue() > machineState.getSelectedProduct().getPrice().doubleValue()){
			coinOutputter.eject(coinInputter.returnMoney());
			machineState = new MachineState();
			machineState.register(displayUnit);
			machineState.register(productOutputter);
			displayUnit.showMessage(machineState.getMessage());
		}
	}
	
	/**
	 * This method is only for testing.
	 * 
	 * @return
	 */
	public Keyboard getKeyboard(){
		return this.keyboard;
	}
	
	/**
	 * 
	 * @param code
	 * @throws ProductOutOfStockException
	 */
	public void selectProduct(final Integer code) throws ProductOutOfStockException{
		if(Keyboard.cancelCode.intValue() == code.intValue()){
			coinOutputter.eject(coinInputter.returnMoney());
			machineState = new MachineState();
			machineState.register(displayUnit);
			machineState.register(productOutputter);
			displayUnit.showMessage(machineState.getMessage());
		}else{
			final Product product = productInventoryManager.getProduct(code);
			machineState.setSelectedProduct(product);
		}
	}
	
	public void loadProducts(final List<Product> products){
		productInventoryManager.load(products);
	}
	
	
}
