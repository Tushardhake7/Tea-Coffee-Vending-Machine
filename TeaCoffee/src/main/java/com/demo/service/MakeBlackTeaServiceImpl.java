package com.demo.service;

import com.demo.controller.ContainerController;
import com.demo.dao.MakeDrink;
import com.demo.domain.Container;
import com.demo.domain.Product;

public class MakeBlackTeaServiceImpl implements MakeDrink {

	final static int BLACK_TEA_PRICE = 5;
	final static int TEA = 3;
	final static int WATER = 100;
	final static int SUGAR = 15;
	final static int WASTE_TEA = 0;
	final static int WASTE_WATER = 12;
	final static int WASTE_SUGAR = 2;

	private ContainerController containerController;
	private ProductRecord productRecord;
	
	public MakeBlackTeaServiceImpl() {
		containerController = new ContainerController();
		productRecord = new ProductRecord();
	}


	@Override
	public void makingDrink(int blackTeaQuantity) {

		int teaAvailableQuantity = containerController.getContainerData().getTeaContainer();
		int waterAvailableQuantity = containerController.getContainerData().getWaterContainer();
		int sugarAvailableQuantity = containerController.getContainerData().getSugarContainer();
		
		UpdateQuantity(blackTeaQuantity, teaAvailableQuantity, waterAvailableQuantity, sugarAvailableQuantity);
		productRecord.addProductInList(new Product("black tea", blackTeaQuantity, blackTeaQuantity * BLACK_TEA_PRICE));
		productRecord.addWasteProductInList(new Container(WASTE_TEA * blackTeaQuantity, 0, WASTE_SUGAR * blackTeaQuantity, WASTE_WATER * blackTeaQuantity, 0));
		
		System.out.println("Your Bill for " + blackTeaQuantity + " cup tea is " + " = " + blackTeaQuantity * BLACK_TEA_PRICE);
		System.out.println("Please take your Coffee... Enjoy...\n");		
	}
	
	@Override
	public boolean isMaterialAvailable(int quantity) {
		int teaQuantity = containerController.getContainerData().getTeaContainer();
		int sugarQuantity = containerController.getContainerData().getSugarContainer();
		int waterQuantity = containerController.getContainerData().getWaterContainer();

		if(quantity * TEA < teaQuantity && quantity * WATER < waterQuantity &&  quantity * SUGAR < sugarQuantity)
			return true;

		return false;
	}


	private void UpdateQuantity(int blackTeaQuantity, int teaAvailableQuantity, int waterAvailableQuantity,
			int sugarAvailableQuantity) {
		int remainingTeaQuantity = subtractQuantity(teaAvailableQuantity, TEA * blackTeaQuantity);
		int remainingWaterQuantity = subtractQuantity(teaAvailableQuantity, WATER * blackTeaQuantity);
		int remainingSugarQuantity = subtractQuantity(teaAvailableQuantity, SUGAR * blackTeaQuantity);

		containerController.getContainerData().setTeaContainer(remainingTeaQuantity);
		containerController.getContainerData().setWaterContainer(remainingWaterQuantity);
		containerController.getContainerData().setSugarContainer(remainingSugarQuantity);
	}
	
/*	public int subtractQuantity(int availbaleQuantity, int usedQuantity) {
		return availbaleQuantity - usedQuantity;
	}*/
}
