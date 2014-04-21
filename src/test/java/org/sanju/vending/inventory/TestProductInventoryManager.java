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
	
	@Test
	public void shouldLoadProducts() throws ProductOutOfStockException{
		
		final List<Product> colas = new ArrayList<Product>();
		final Product cola = new Product();
		cola.setCode(1);
		cola.setName("Cola");
		cola.setPrice(1.0);
		for(int i=0; i<3; i++){
			colas.add(cola);
		}
		productInventoryManager.load(colas);
		
		final List<Product> chips = new ArrayList<Product>();
		final Product chip = new Product();
		chip.setCode(2);
		chip.setName("Chip");
		chip.setPrice(1.0);
		for(int i=0; i<3; i++){
			chips.add(chip);
		}
		productInventoryManager.load(chips);
		
		final List<Product> candies = new ArrayList<Product>();
		final Product candy = new Product();
		candy.setCode(3);
		candy.setName("Chip");
		candy.setPrice(1.0);
		for(int i=0; i<3; i++){
			candies.add(candy);
		}
		productInventoryManager.load(candies);
		
		assertEquals(3, productInventoryManager.getStockCount(1).intValue());
		assertEquals(3, productInventoryManager.getStockCount(2).intValue());
		assertEquals(3, productInventoryManager.getStockCount(3).intValue());
	}
	
	@Test
	public void shouldReduceTheStock() throws ProductOutOfStockException{
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
		assertEquals(product, productInventoryManager.getProduct(1));
		assertEquals(4, productInventoryManager.getStockCount(1).intValue());
		assertEquals(product, productInventoryManager.getProduct(1));
		assertEquals(3, productInventoryManager.getStockCount(1).intValue());
	}
	
	@Test(expected = ProductOutOfStockException.class)
	public void shouldFireProductOutOfStockException() throws ProductOutOfStockException{
		productInventoryManager.getProduct(1);
	}

}
