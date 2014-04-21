package org.sanju.vending;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.sanju.vending.enums.CoinType;
import org.sanju.vending.enums.State;
import org.sanju.vending.exception.InvalidCoinException;
import org.sanju.vending.model.Coin;

/**
 * 
 * @author thosan
 *
 */
public class TestMachine {
	
	private Machine machine;
	
	@Before
	public void setUp(){
		machine = new Machine();
	}
	
	@Test
	public void shouldShowTheDefaultMessage(){
		assertEquals(State.NO_CHANGE_DEFAULT.getMessage(), machine.getCurrentMessage());
	}
	
	@Test(expected = InvalidCoinException.class)
	public void shouldRejectPenny() throws InvalidCoinException{
		final Coin coin = new Coin(CoinType.PENNY);
		machine.acceptCoin(coin);
	}
	
	@Test
	public void shouldSelectProduct(){
		
	}
}
