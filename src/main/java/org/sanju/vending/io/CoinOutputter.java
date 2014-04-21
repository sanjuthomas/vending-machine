package org.sanju.vending.io;

import java.util.ArrayList;
import java.util.List;

import org.sanju.vending.model.Coin;

/**
 * 
 * @author thosan
 *
 */
public class CoinOutputter {
	
	private Double amount = new Double(0.0);
	
	public Double eject(final List<Coin> coins){
		for(final Coin coin : coins){
			amount += coin.getCoinType().value();
		}
		return amount;
	}
	
	public Double eject(final Coin coin){
		final List<Coin> coins = new ArrayList<Coin>();
		coins.add(coin);
		return eject(coins);
	}
}
