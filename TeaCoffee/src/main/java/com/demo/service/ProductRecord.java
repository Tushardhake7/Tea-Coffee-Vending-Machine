package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.domain.Container;
import com.demo.domain.Product;

public class ProductRecord {

	public List<Product> productList;
	List<Container> wasteProductList = new ArrayList();

	public List<Product> getProductList(List<Product> productList) {
		if(productList == null){
			productList = new ArrayList<>();
			productList.add(new Product("tea", 0, 0));
			productList.add(new Product("coffee", 0, 0));
			productList.add(new Product("black tea", 0, 0));
			productList.add(new Product("black coffee", 0, 0));
		}
		return productList;
	}
	
	public void addProductInList(Product product) {
		getProductList(productList).add(product);
	}
	
	public List<Product> getProductFromList() {
		return getProductList(productList);
	}

	public void addWasteProductInList(Container container) {
		wasteProductList.add(container);
	}

	public List<Container> getWasteProductFromList() {
		return wasteProductList;
	}
}







/*package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.domain.Container;
import com.demo.domain.Product;

public class ProductRecord {

	public List<Product> productList;
	List<Container> wasteProductList = new ArrayList();

	public List<Product> getProductList(List<Product> productList) {
		if(productList == null) {
			productList = new ArrayList<>();
			productList.add(new Product("tea", 0, 0));
			productList.add(new Product("coffee", 0, 0));
			productList.add(new Product("black tea", 0, 0));
			productList.add(new Product("black coffee", 0, 0));
		}
		return productList;
	}
	
	public void addProductInList(Product product) {
		getProductList(productList).add(product);
	}
	
	public List<Product> getProductFromList() {
		return getProductList(productList);
	}

	public void addWasteProductInList(Container container) {
		wasteProductList.add(container);
	}

	public List<Container> getWasteProductFromList() {
		return wasteProductList;
	}
}
*/