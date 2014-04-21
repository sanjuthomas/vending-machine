package org.sanju.vending.external;

import org.sanju.vending.enums.CoinType;
import org.sanju.vending.model.Coin;

/**
 * 
 * @author thosan
 *
 */
public class CoinDetector {
	
	/**
	 * In real case the coin would be measured based on it's weight and radios.
	 * 
	 * @param coin
	 * @return
	 */
	public CoinType detect(final Coin coin){
		return coin.getType();
	}
	
	public Double getCoinValue(final Coin coin){
		return detect(coin).value();
	}

}
