package org.sanju.vending.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author thosan
 *
 */
public enum CoinType {
	
	 PENNY(1.0),
     NICKEL(5.0),
     DIME(10.0),
     QUARTER(25.0);

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