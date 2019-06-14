package com.demo.service;

import com.demo.controller.ContainerController;
import com.demo.dao.MakeDrink;
import com.demo.domain.Container;
import com.demo.domain.Product;

public class MakeBlackCoffeeServiceImpl implements MakeDrink {

	final static  int BLACK_COFFEE_PRICE = 10;
	final static int COFFEE = 3;
	final static int WATER = 100;
	final static int SUGAR = 15;
	final static int WASTE_COFFEE = 0;
	final static int WASTE_WATER = 12;
	final static int WASTE_SUGAR = 2;

	ContainerController containerController;
	ProductRecord productRecord;

	public MakeBlackCoffeeServiceImpl() {
		containerController = new ContainerController();
		productRecord = new ProductRecord();
	}

	@Override
	public void makingDrink(int blackCoffeeQuantity) {
		int coffeeAvailableQuantity = containerController.getContainerData().getCoffeeContainer();
		int waterAvailableQuantity = containerController.getContainerData().getWaterContainer();
		int sugarAvailableQuantity = containerController.getContainerData().getSugarContainer();
		
		UpdateQuantity(blackCoffeeQuantity, coffeeAvailableQuantity, waterAvailableQuantity, sugarAvailableQuantity);
		productRecord.addProductInList(new Product("black coffee", blackCoffeeQuantity, blackCoffeeQuantity * BLACK_COFFEE_PRICE));
		productRecord.addWasteProductInList(new Container(WASTE_COFFEE * blackCoffeeQuantity, 0, WASTE_SUGAR * blackCoffeeQuantity, WASTE_WATER * blackCoffeeQuantity, 0));
		
		System.out.println("Your Bill for " + blackCoffeeQuantity + " cup tea is " + " = " + blackCoffeeQuantity * BLACK_COFFEE_PRICE);
		System.out.println("Please take your Coffee... Enjoy...\n");		
	}

	@Override
	public boolean isMaterialAvailable(int quantity) {
		int CoffeeQuantity = containerController.getContainerData().getCoffeeContainer();
		int sugarQuantity = containerController.getContainerData().getSugarContainer();
		int waterQuantity = containerController.getContainerData().getWaterContainer();

		if(quantity * COFFEE < CoffeeQuantity && quantity * WATER < waterQuantity &&  quantity * SUGAR < sugarQuantity)
			return true;

		return false;
	}

	private void UpdateQuantity(int blackCoffeeQuantity, int coffeeAvailableQuantity, int waterAvailableQuantity,
			int sugarAvailableQuantity) {
		int remainingCoffeeQuantity = subtractQuantity(coffeeAvailableQuantity, COFFEE * blackCoffeeQuantity);
		int remainingWaterQuantity = subtractQuantity(coffeeAvailableQuantity, WATER * blackCoffeeQuantity);
		int remainingSugarQuantity = subtractQuantity(coffeeAvailableQuantity, SUGAR * blackCoffeeQuantity);

		containerController.getContainerData().setCoffeeContainer(remainingCoffeeQuantity);
		containerController.getContainerData().setWaterContainer(remainingWaterQuantity);
		containerController.getContainerData().setSugarContainer(remainingSugarQuantity);		
	}
	
/*	public int subtractQuantity(int availbaleQuantity, int usedQuantity) {
		return availbaleQuantity - usedQuantity;
	}*/
}
