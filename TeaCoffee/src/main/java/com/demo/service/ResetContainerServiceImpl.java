package com.demo.service;

import com.demo.controller.ContainerController;
import com.demo.domain.Container;

public class ResetContainerServiceImpl {
	
	Container container;
	ContainerController containerController = new ContainerController();
	
	public ResetContainerServiceImpl() {
		super();
		container = new Container();
	}
	
	public void resetContainer(ContainerController containerController) {
		container = containerController.getContainerData();
		container.setTeaContainer(2000);
		container.setCoffeeContainer(2000);
		container.setWaterContainer(15000);
		container.setMilkContainer(10000);
		container.setSugarContainer(8000);
		System.out.println("Container Reset Successfully...");
		}

}
