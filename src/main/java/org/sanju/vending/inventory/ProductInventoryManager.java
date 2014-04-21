package org.sanju.vending.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.sanju.vending.exception.ProductOutOfStockException;
import org.sanju.vending.model.Product;

/**
 * 
 * @author thosan
 *
 */
public class ProductInventoryManager {
	
	private Map<Integer, List<Product>> productMap = new HashMap<Integer, List<Product>>();
	
	public void load(final List<Product> products){
		for(final Product product : products){
			this.load(product);
		}
	}
	
	public void load(final Product product){
		List<Product> products = productMap.get(product.getCode());
		if(null == products){
			products = new ArrayList<Product>();
		}
		products.add(product);
		productMap.put(product.getCode(), products);
	}
	
	
	public Product getProduct(final Integer code) throws ProductOutOfStockException{
		final List<Product> products = productMap.get(code);
		if(CollectionUtils.isNotEmpty(products)){
			decreamentStock(code);
			return products.get(products.size()-1);
		}
		throw new ProductOutOfStockException();
	}
	
	private void decreamentStock(final Integer code){
		productMap.get(code).remove(productMap.get(code).size()-1);
	}
	
	public Integer getStockCount(final Integer code) throws ProductOutOfStockException{
		final List<Product> products = productMap.get(code);
		if(CollectionUtils.isNotEmpty(products)){
			return products.size();
		}
		throw new ProductOutOfStockException();
	}

}
