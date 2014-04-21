package org.sanju.vending.inventory;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.sanju.vending.enums.CoinType;
import org.sanju.vending.exception.CoinTypeNotAvailableException;
import org.sanju.vending.model.Coin;

/**
 * 
 * @author thosan
 *
 */
public class TestCoinInventoryManager {
	
	private CoinInventoryManager coinInventoryManager;
	
	@Before
	public void setUp(){
		coinInventoryManager = new CoinInventoryManager();
	}
	
	@Test
	public void shouldLoadCoins() throws CoinTypeNotAvailableException{
		final List<Coin> coins = new ArrayList<Coin>();
		for(int i=0; i<3; i++){
			coins.add(new Coin(CoinType.QUARTER));
		}
		coinInventoryManager.load(coins);
		assertEquals(3, coinInventoryManager.getCountByCoinType(CoinType.QUARTER));
	}
	
	@Test(expected = CoinTypeNotAvailableException.class)
	public void shouldThrowCoinTypeNotAvailableException() throws CoinTypeNotAvailableException{
		coinInventoryManager.getCountByCoinType(CoinType.DIME);
	}

}
