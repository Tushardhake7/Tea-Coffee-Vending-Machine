package com.demo.service;

import com.demo.domain.Container;

public class RefillContainerServiceImpl {

	Container container;

	public RefillContainerServiceImpl() {
		super();
		container = new Container();
	}

	public void refillContainer(int input) {
		
		switch (input) {
		case 1:
			container.setCoffeeContainer(2000);
			System.out.println("Coffee container is filled successfully...");
			break;
		case 2:
			container.setTeaContainer(2000);
			System.out.println("Tea container is filled successfully...");
			break;
		case 3:
			container.setSugarContainer(8000);
			System.out.println("Sugar container is filled successfully...");
			break;
		case 4:
			container.setWaterContainer(15000);
			System.out.println("Water container is filled successfully...");
			break;
		case 5:
			container.setMilkContainer(10000);
			System.out.println("Milk container is filled successfully...");
			break;

		default:
			break;
		}
	}
}
