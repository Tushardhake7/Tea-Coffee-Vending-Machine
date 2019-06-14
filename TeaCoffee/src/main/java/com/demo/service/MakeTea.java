package com.demo.service;

import com.demo.controller.ContainerController;
import com.demo.dao.MakeDrink;
import com.demo.domain.Container;
import com.demo.domain.Product;

public class MakeTea implements MakeDrink {
	final static Integer TEA_PRICE = 10;
	final static Integer TEA = 5;
	final static Integer WATER = 60;
	final static Integer MILK = 40;
	final static Integer SUGAR = 15;

	final static Integer WASTE_TEA = 1;
	final static Integer WASTE_WATER = 5;
	final static Integer WASTE_MILK = 4;
	final static Integer WASTE_SUGAR = 2;

	ContainerController containerController;
	ProductRecord productRecord;

	public MakeTea() {
		containerController = new ContainerController();
		productRecord = new ProductRecord();
	}

	public MakeTea(ContainerController containerController, ProductRecord productRecord) {
		super();
		this.containerController = containerController;
		this.productRecord = productRecord;
	}

	@Override
	public boolean isMaterialAvailable(int quantity) {
		int teaQuantity = containerController.getContainerData().getTeaContainer();
		int sugarQuantity = containerController.getContainerData().getSugarContainer();
		int waterQuantity = containerController.getContainerData().getWaterContainer();
		int milkQuantity = containerController.getContainerData().getMilkContainer();

		if(quantity * TEA < teaQuantity && quantity * WATER < waterQuantity && quantity * MILK < milkQuantity && quantity * SUGAR < sugarQuantity)
			return true;

		return false;
	}
	
	@Override
	public void makingDrink(int teaQuantity) {

		int teaAvailableQuantity = containerController.getContainerData().getTeaContainer();
		int waterAvailableQuantity = containerController.getContainerData().getWaterContainer();
		int milkAvailableQuantity = containerController.getContainerData().getMilkContainer();
		int sugarAvailableQuantity = containerController.getContainerData().getSugarContainer();

		UpdateQuantity(teaQuantity, teaAvailableQuantity, waterAvailableQuantity, milkAvailableQuantity, sugarAvailableQuantity);

		productRecord.addProductInList(new Product("tea", teaQuantity, teaQuantity * TEA_PRICE));

		productRecord.addWasteProductInList(new Container(WASTE_TEA * teaQuantity, 0, WASTE_SUGAR * teaQuantity, WASTE_WATER * teaQuantity, WASTE_MILK * teaQuantity));

		System.out.println("Your Bill for " + teaQuantity + " cup tea is " + " = " + teaQuantity * TEA_PRICE);
		System.out.println("Please take your tea... Enjoy...\n");
	}

	public void UpdateQuantity(int quantity, int teaAvailableQuantity, int waterAvailableQuantity, int milkAvailableQuantity, int sugarAvailableQuantity) {
		int remainingTeaQuantity = subtractQuantity(teaAvailableQuantity, TEA * quantity);
		int remainingWaterQuantity = subtractQuantity(teaAvailableQuantity, WATER * quantity);
		int remainingMilkQuantity = subtractQuantity(teaAvailableQuantity, MILK * quantity);
		int remainingSugarQuantity = subtractQuantity(teaAvailableQuantity, SUGAR * quantity);

		containerController.getContainerData().setTeaContainer(remainingTeaQuantity);
		containerController.getContainerData().setWaterContainer(remainingWaterQuantity);
		containerController.getContainerData().setMilkContainer(remainingMilkQuantity);
		containerController.getContainerData().setSugarContainer(remainingSugarQuantity);
	}
}
