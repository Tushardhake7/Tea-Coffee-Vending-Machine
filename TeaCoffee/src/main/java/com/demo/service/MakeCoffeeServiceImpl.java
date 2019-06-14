package com.demo.service;

import com.demo.controller.ContainerController;
import com.demo.dao.MakeDrink;
import com.demo.domain.Container;
import com.demo.domain.Product;

public class MakeCoffeeServiceImpl implements MakeDrink {
	
	final static Integer COFFEE_PRICE = 15;
	final static Integer COFFEE = 4;
	final static Integer WATER =20;
	final static Integer MILK = 80;
	final static Integer SUGAR = 15;

	final static Integer WASTE_COFFEE = 1;
	final static Integer WASTE_WATER = 3;
	final static Integer WASTE_MILK = 8;
	final static Integer WASTE_SUGAR = 2;

	ContainerController containerController;
	ProductRecord productRecord;
	
	public MakeCoffeeServiceImpl() {
		containerController = new ContainerController();
		productRecord = new ProductRecord();
	}
	
	@Override
	public boolean isMaterialAvailable(int quantity) {
		int coffeeQuantity = containerController.getContainerData().getCoffeeContainer();
		int sugarQuantity = containerController.getContainerData().getSugarContainer();
		int waterQuantity = containerController.getContainerData().getWaterContainer();
		int milkQuantity = containerController.getContainerData().getMilkContainer();

		if(quantity * COFFEE < coffeeQuantity && quantity * WATER < waterQuantity && quantity * MILK < milkQuantity && quantity * SUGAR < sugarQuantity)
			return true;

		return false;
	}
	
	@Override
	public void makingDrink(int coffeeQuantity) {
		int coffeeAvailableQuantity = containerController.getContainerData().getCoffeeContainer();
		int waterAvailableQuantity = containerController.getContainerData().getWaterContainer();
		int milkAvailableQuantity = containerController.getContainerData().getMilkContainer();
		int sugarAvailableQuantity = containerController.getContainerData().getSugarContainer();

		UpdateQuantity(coffeeQuantity, coffeeAvailableQuantity, waterAvailableQuantity, milkAvailableQuantity, sugarAvailableQuantity);

		productRecord.addProductInList(new Product("tea", coffeeQuantity, coffeeQuantity * COFFEE_PRICE));

		productRecord.addWasteProductInList(new Container(WASTE_COFFEE * coffeeQuantity, 0, WASTE_SUGAR * coffeeQuantity, WASTE_WATER * coffeeQuantity, WASTE_MILK * coffeeQuantity));

		System.out.println("Your Bill for " + coffeeQuantity + " cup tea is " + " = " + coffeeQuantity * COFFEE_PRICE);
		System.out.println("Please take your coffee... Enjoy...\n");
	}

	private void UpdateQuantity(int coffeeQuantity, int coffeeAvailableQuantity, int waterAvailableQuantity,
			int milkAvailableQuantity, int sugarAvailableQuantity) {
		
		int remainingCoffeeQuantity = subtractQuantity(coffeeAvailableQuantity, COFFEE * coffeeQuantity);
		int remainingWaterQuantity = subtractQuantity(coffeeAvailableQuantity, WATER * coffeeQuantity);
		int remainingMilkQuantity = subtractQuantity(coffeeAvailableQuantity, MILK * coffeeQuantity);
		int remainingSugarQuantity = subtractQuantity(coffeeAvailableQuantity, SUGAR * coffeeQuantity);
		
		containerController.getContainerData().setCoffeeContainer(remainingCoffeeQuantity);
		containerController.getContainerData().setWaterContainer(remainingWaterQuantity);
		containerController.getContainerData().setMilkContainer(remainingMilkQuantity);
		containerController.getContainerData().setSugarContainer(remainingSugarQuantity);
	}
}
