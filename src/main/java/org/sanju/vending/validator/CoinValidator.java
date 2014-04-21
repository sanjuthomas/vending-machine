package org.sanju.vending.validator;

import org.sanju.vending.enums.CoinType;
import org.sanju.vending.model.Coin;

/**
 * 
 * @author thosan
 *
 */
public class CoinValidator {
	
	/**
	 * 
	 * @param coin
	 * @return
	 */
	public Boolean validate(final Coin coin){
		
		return CoinType.getValidCoinTypes().contains(coin.getCoinType());
	}

}
