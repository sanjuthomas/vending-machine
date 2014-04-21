package org.sanju.vending.model;

import org.sanju.vending.enums.CoinType;

/**
 * 
 * @author thosan
 *
 */
public class Coin {
	
	private CoinType type;
	
	public Coin(final CoinType coinType){
		this.type = coinType;
	}

	public CoinType getType() {
		return type;
	}

}
