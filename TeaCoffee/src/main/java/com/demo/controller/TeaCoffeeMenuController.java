package com.demo.controller;

import java.io.IOException;
import java.util.logging.Logger;

import com.demo.service.ContainerStatusServiceImpl;
import com.demo.service.MakeBlackCoffeeServiceImpl;
import com.demo.service.MakeBlackTeaServiceImpl;
import com.demo.service.MakeCoffeeServiceImpl;
import com.demo.service.MakeTea;
import com.demo.service.ProductRecord;
import com.demo.service.RefillContainerServiceImpl;
import com.demo.service.ResetContainerServiceImpl;
import com.demo.service.TotalSaleServiceImpl;



public class TeaCoffeeMenuController {
	public InputScanner inputScanner;
	MakeTea makeTea;
	MakeCoffeeServiceImpl makeCoffeeServiceImpl;
	MakeBlackTeaServiceImpl makeBlackTeaServiceImpl;
	MakeBlackCoffeeServiceImpl makeBlackCoffeeServiceImpl;
	ContainerStatusServiceImpl containerStatusServiceImpl;
	ContainerController containerController;
	RefillContainerServiceImpl refillContainerServiceImpl;
	TotalSaleServiceImpl totalSaleServiceImpl;
	ResetContainerServiceImpl resetContainerServiceImpl;

	public TeaCoffeeMenuController() {
		inputScanner = new InputScanner();
		makeTea = new MakeTea();
		makeCoffeeServiceImpl = new MakeCoffeeServiceImpl();
		makeBlackTeaServiceImpl = new MakeBlackTeaServiceImpl();
		makeBlackCoffeeServiceImpl = new MakeBlackCoffeeServiceImpl();
		containerStatusServiceImpl = new ContainerStatusServiceImpl();
		containerController = new ContainerController();
		refillContainerServiceImpl = new RefillContainerServiceImpl();
		totalSaleServiceImpl = new TotalSaleServiceImpl(new ProductRecord(), Logger.getLogger(Logger.GLOBAL_LOGGER_NAME));
		resetContainerServiceImpl = new ResetContainerServiceImpl();
	}

	public void repeatMenu() throws IOException {
		if (getChoiceFromUser() == 0)
			showMenu();
	}

	public int getChoiceFromUser() {
		return inputScanner.nextInt();
	}	

	public void showMenu() throws IOException {
		System.out.println("Select Option Form Below List : " + "\n" + "1.COFFEE " + "\n" + "2.TEA" + "\n" + "3.BLACK COFFEE" + "\n"
				+ "4.BLACK TEA" + "\n" + "5.REFILL CONTAINER" + "\n" + "6.TOTAL SALE" + "\n" + "7.CONTAINER STATUS"
				+ "\n" + "8.Reset Container" + "\n" + "9.EXIT TCVM..");

		System.out.println("Enter your choice: ");
		Integer inputChoice = getChoiceFromUser();

		switch (inputChoice) {
		case 1:
			System.out.println("Enter Quantity FOr Coffee: ");
			Integer coffeeQuantity = getChoiceFromUser();

			if (!makeCoffeeServiceImpl.isMaterialAvailable(coffeeQuantity)) {
				System.out.println("NOT ENOUGH MATERIAL...");
				System.out.println("Press 0 for Main Menu....");
				repeatMenu();
			} else {
				makeCoffeeServiceImpl.makingDrink(coffeeQuantity);
				System.out.println("Press 0 for Main Menu....");
				repeatMenu();
			}
			break;			


		case 2:
			System.out.println("Enter Quantity For Tea: ");
			Integer teaQuantity = getChoiceFromUser();


			if(!makeTea.isMaterialAvailable(teaQuantity)) {
				System.out.println("NOT ENOUGH MATERIAL....");
				System.out.println("Press 0 for Main Menu....");
				repeatMenu();
			} else {
				makeTea.makingDrink(teaQuantity);
				System.out.println("Press 0 for Main Menu....");
				repeatMenu();
			}
			break;			

		case 3:
			System.out.println("Enter Quantity For Black Coffee: ");
			Integer blackCoffeeQuantity = getChoiceFromUser();

			if (!makeBlackCoffeeServiceImpl.isMaterialAvailable(blackCoffeeQuantity)) {
				System.out.println("NOT ENOUGH MATERIAL...");
				System.out.println("Press 0 for Main Menu....");
				repeatMenu();
			} else {
				makeBlackCoffeeServiceImpl.makingDrink(blackCoffeeQuantity);
				System.out.println("Press 0 for Main Menu....");
				repeatMenu();
			}
			break;

		case 4:
			System.out.println("Enter Quantity For Black Tea: ");
			Integer blackTeaQuantity = getChoiceFromUser();

			if (!makeBlackTeaServiceImpl.isMaterialAvailable(blackTeaQuantity)) {
				System.out.println("NOT ENOUGH MATERIAL...");
				System.out.println("Press 0 for Main Menu....");
				repeatMenu();
			} else {
				makeBlackTeaServiceImpl.makingDrink(blackTeaQuantity);
				System.out.println("Press 0 for Main Menu....");
				repeatMenu();
			}
			break;

		case 5:
			System.out.println("Enter 1 for Coffee, 2 for Tea, 3 for Sugar, 4 for Water , 5 for Milk ");
			refillContainerServiceImpl.refillContainer(getChoiceFromUser());
			System.out.println("Press 0 for Main Menu....");
			repeatMenu();
			break;

		case 6:
			System.out.println("Product Total Sale... ");
			totalSaleServiceImpl.totalSaleOfProduct();
			System.out.println("Press 0 for Main Menu....");
			repeatMenu();
			break;

		case 7:
			System.out.println("Container Status... ");
			containerStatusServiceImpl.showContainerStatus(containerController);
			System.out.println("Press 0 for Main Menu....");
			repeatMenu();
			break;

		case 8:
			resetContainerServiceImpl.resetContainer(containerController);
			System.out.println("Press 0 for Main Menu....");
			repeatMenu();
			break;

		case 9:
			System.out.println("Exit From Tea Coffee Vendor Machine... ");
			break;

		default:
			System.out.println("You have entered wrong input ..");
		}
	}
}
