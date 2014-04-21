package org.sanju.vending.inventory;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.sanju.vending.exception.ProductOutOfStockException;
import org.sanju.vending.model.Product;

/**
 * 
 * @author thosan
 *
 */
public class TestProductInventoryManager {
	
	private ProductInventoryManager productInventoryManager;
	
	@Before
	public void setUp(){
		productInventoryManager = new ProductInventoryManager();
	}
	
	@Test
	public void shouldLoadProduct() throws ProductOutOfStockException{
		final List<Product> products = new ArrayList<Product>();
		final Product product = new Product();
		product.setCode(1);
		product.setName("Cola");
		product.setPrice(1.0);
		for(int i=0; i<5; i++){
			products.add(product);
		}
		productInventoryManager.load(products);
		assertEquals(5, productInventoryManager.getStockCount(1).intValue());
	}
	

}
