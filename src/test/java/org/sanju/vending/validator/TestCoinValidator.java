package org.sanju.vending.validator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.sanju.vending.enums.CoinType;
import org.sanju.vending.model.Coin;

/**
 * 
 * @author thosan
 *
 */
public class TestCoinValidator {
	
	private CoinValidator coinValidator;
	
	@Before
	public void setUp(){
		coinValidator = new CoinValidator();
	}
	
	@Test
	public void shouldValidateNickel(){
		final Coin coin = new Coin(CoinType.NICKEL);
		assertTrue(coinValidator.validate(coin));
	}
	
	@Test
	public void shouldValidateDime(){
		final Coin coin = new Coin(CoinType.DIME);
		assertTrue(coinValidator.validate(coin));
	}
	
	@Test
	public void shouldValidateQuarter(){
		final Coin coin = new Coin(CoinType.QUARTER);
		assertTrue(coinValidator.validate(coin));
	}
	
	@Test
	public void shouldNotValidatePenny(){
		final Coin coin = new Coin(CoinType.PENNY);
		assertFalse(coinValidator.validate(coin));
	}

}
