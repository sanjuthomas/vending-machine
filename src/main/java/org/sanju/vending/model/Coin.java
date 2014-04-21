package org.sanju.vending.model;

import org.sanju.vending.enums.CoinType;

/**
 * 
 * @author thosan
 *
 */
public class Coin {
	
	private CoinType coinType;
	
	public Coin(final CoinType coinType){
		this.coinType = coinType;
	}

	public CoinType getCoinType() {
		return coinType;
	}

}
