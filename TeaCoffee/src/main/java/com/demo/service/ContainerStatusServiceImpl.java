package com.demo.service;

import com.demo.controller.ContainerController;
import com.demo.domain.Container;

public class ContainerStatusServiceImpl {
	
	public void showContainerStatus(ContainerController containerController) {
	
		Container container = containerController.getContainerData();
		
		System.out.println(" Tea = " + container.getTeaContainer() + "\n Coffee = " + container.getCoffeeContainer()
				+ "\n Water = " + container.getWaterContainer() + "\n Milk = " + container.getMilkContainer()
				+ "\n Sugar = " + container.getSugarContainer() + "\n");
	}
}
