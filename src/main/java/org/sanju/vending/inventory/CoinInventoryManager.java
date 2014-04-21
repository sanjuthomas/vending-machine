package org.sanju.vending.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.sanju.vending.enums.CoinType;
import org.sanju.vending.exception.CoinTypeNotAvailableException;
import org.sanju.vending.model.Coin;

/**
 * 
 * @author thosan
 *
 */
public class CoinInventoryManager {
	
	private Map<CoinType, List<Coin>> coinMap = new HashMap<CoinType, List<Coin>>();
	
	public void load(final List<Coin> coins){
		for(final Coin coin : coins){
			load(coin);
		}
	}
	
	public void load(final Coin coin){
		List<Coin> coins = coinMap.get(coin.getType());
		if(null == coins){
			coins = new ArrayList<Coin>();
		}
		coins.add(coin);
		coinMap.put(coin.getType(), coins); 
	}
	
	public int getCountByCoinType(final CoinType coinType) throws CoinTypeNotAvailableException{
		final List<Coin> coins = coinMap.get(coinType);
		if(CollectionUtils.isNotEmpty(coins)){
			return coins.size();
		}
		throw new CoinTypeNotAvailableException();
	}
	
}
