package org.sanju.vending.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author thosan
 *
 */
public enum CoinType {
	
	 PENNY(0.1),
     NICKEL(0.5),
     DIME(0.10),
     QUARTER(0.25);

     private Double coinValue;

     public Double value() {
    	 return coinValue;
     }

     CoinType(final Double value){
       coinValue = value;
     }
     
     private static List<CoinType> validCoinTypes = new ArrayList<CoinType>();
     
     static{
    	 validCoinTypes.add(NICKEL);
    	 validCoinTypes.add(DIME);
    	 validCoinTypes.add(QUARTER);
     }
     
     public static List<CoinType> getValidCoinTypes(){
    	 return validCoinTypes;
     }
     
}