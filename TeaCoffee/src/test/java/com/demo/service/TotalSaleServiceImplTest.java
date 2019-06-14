package com.demo.service;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.demo.domain.Product;

@RunWith(MockitoJUnitRunner.class)
public class TotalSaleServiceImplTest {
	
	@InjectMocks
	TotalSaleServiceImpl totalSaleServiceImpl;
	
	@Mock
	ProductRecord productRecord;

	@Mock
	Logger logger;
	
	@Test
	public void shouldReturnTotalSaleOfProduct() throws IOException  {
		
		Product product = new Product("tea", 1, 10);
		Product product1 = new Product("black tea", 1, 15);
		Product product2 = new Product("black coffee", 1, 15);
		Product product3 = new Product("coffee", 1, 15);
		List<Product> productList = new ArrayList<Product>();
		productList.add(product);
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		
		doNothing().when(logger).info(anyString());
		when(productRecord.getProductFromList()).thenReturn(productList);
		
		totalSaleServiceImpl.totalSaleOfProduct();
		verify(logger, times(5)).info(anyString());
	}

}
