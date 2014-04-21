package org.sanju.vending.io;

import java.util.ArrayList;
import java.util.List;

import org.sanju.vending.exception.InvalidCoinException;
import org.sanju.vending.external.CoinDetector;
import org.sanju.vending.model.Coin;
import org.sanju.vending.validator.CoinValidator;

/**
 * 
 * @author thosan
 *
 */
public class CoinInputter {
	
	private Double currentAmount = new Double(0.0);
	private List<Coin> coins = new ArrayList<Coin>();
	private CoinValidator coinValidator;
	private CoinDetector coinDetector;
	
	public CoinInputter(final CoinValidator coinValidator, final CoinDetector coinDetector){
		this.coinValidator = coinValidator;
		this.coinDetector = coinDetector;
	}
	
	public void accept(final Coin coin) throws InvalidCoinException{
		if(coinValidator.validate(coin)){
			coins.add(coin);
			currentAmount += coinDetector.getCoinValue(coin);
		}else{
			throw new InvalidCoinException();
		}
	}
	
	public Double getAmount(){
		return currentAmount;
	}
	
	public List<Coin> returnMoney(){
		final List<Coin> temp = coins;
		coins = new ArrayList<Coin>();
		currentAmount = new Double(0.0);
		return temp;
	}

}
