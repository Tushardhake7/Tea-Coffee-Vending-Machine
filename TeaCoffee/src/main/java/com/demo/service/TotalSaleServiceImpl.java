package com.demo.service;

import java.io.IOException;
import java.util.logging.Logger;

public class TotalSaleServiceImpl {

	ProductRecord productRecord;
	Logger logger;
	//final static Logger logger = Logger.getLogger(TeaCoffeeMenuController.class);
	
	public TotalSaleServiceImpl(ProductRecord productRecord) {
		super();
		this.productRecord = productRecord;
		
	}
	
	 public TotalSaleServiceImpl(ProductRecord productRecord, Logger logger) {
		super();
		this.productRecord = productRecord;
		this.logger = logger;
	} 
 
	public void totalSaleOfProduct() throws IOException {

		Integer totalCoffeeSaleQuantity = productRecord.getProductFromList().stream()
				.filter(product -> product.getProductName().equals("coffee"))
				.map(product -> product.getProductQuantity())
				.reduce(Integer::sum).get();

		Integer totalTeaSaleQuantity = productRecord.getProductFromList().stream()
				.filter(product -> product.getProductName().equals("tea")).map(product -> product.getProductQuantity())
				.reduce(Integer::sum).get();

		Integer totalBlackCoffeeSaleQuantity = productRecord.getProductFromList().stream()
				.filter(product -> product.getProductName().equals("black coffee"))
				.map(product -> product.getProductQuantity())
				.reduce(Integer::sum).get();

		Integer totalBlackTeaSaleQuantity = productRecord.getProductFromList().stream()
				.filter(product -> product.getProductName().equals("black tea")).map(product -> product.getProductQuantity())
				.reduce(Integer::sum).get();

		Integer totalCoffeeSalePrice = productRecord.getProductFromList().stream()
				.filter(product -> product.getProductName().equals("coffee")).map(product -> product.getProductPrice())
				.reduce(Integer::sum).get();

		Integer totalTeaSalePrice = productRecord.getProductFromList().stream()
				.filter(product -> product.getProductName().equals("tea")).map(product -> product.getProductPrice())
				.reduce(Integer::sum).get();

		Integer totalBlackCoffeeSalePrice = productRecord.getProductFromList().stream()
				.filter(product -> product.getProductName().equals("black coffee")).map(product -> product.getProductPrice())
				.reduce(Integer::sum).get();

		Integer totalBlackTeaSalePrice = productRecord.getProductFromList().stream()
				.filter(product -> product.getProductName().equals("black tea")).map(product -> product.getProductPrice())
				.reduce(Integer::sum).get();

		Integer totalSalePrice = productRecord.getProductFromList().stream().map(product -> product.getProductPrice())
				.reduce(Integer::sum).get();

		logger.info("Total coffee quantity = " + totalCoffeeSaleQuantity + ", price = " + totalCoffeeSalePrice);
		logger.info("Total coffee quantity = " + totalTeaSaleQuantity + ", price = " + totalTeaSalePrice);
		logger.info("Total coffee quantity = " + totalBlackCoffeeSaleQuantity + ", price = " + totalBlackCoffeeSalePrice);
		logger.info("Total coffee quantity = " + totalBlackTeaSaleQuantity + ", price = " + totalBlackTeaSalePrice);
		logger.info("Total All Product Sell price = " + totalSalePrice);
	}
}
