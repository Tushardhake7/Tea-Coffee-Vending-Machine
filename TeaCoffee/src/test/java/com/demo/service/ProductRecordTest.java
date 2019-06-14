package com.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.demo.domain.Container;
import com.demo.domain.Product;

@RunWith(MockitoJUnitRunner.class)
public class ProductRecordTest {

	@InjectMocks
	ProductRecord productRecord;

	@Mock
	List<Product> productList;

	@Mock
	Product product;

	@Test
	public void shouldGetProductDetailsWhenProductListIsNull() {
		
		productList = null;
		List expected = new ArrayList<>();
		expected.add(new Product("tea", 0, 0));
		expected.add(new Product("coffee", 0, 0));
		expected.add(new Product("black tea", 0, 0));
		expected.add(new Product("black coffee", 0, 0));

		List actual = productRecord.getProductList(productList);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldAddProductDetailsToMaintainProductRecord() {
		
		productRecord.addProductInList(new Product("tea", 1, 10));
		assertNotNull(productRecord.getProductList(productList));
	}

	@Test
	public void shouldGetProductFromList() {		
		assertNotNull(productRecord.getProductFromList());
	}

	@Test
	public void shouldSystemAddWasteProductInList() {
		productRecord.addWasteProductInList(new Container(2000, 2000, 2000, 2000, 2000));
		assertNotNull(productRecord.wasteProductList);
	}

	@Test
	public void shouldSystemGetWasteProductList() {		
		assertNotNull(productRecord.getWasteProductFromList());
	}
}