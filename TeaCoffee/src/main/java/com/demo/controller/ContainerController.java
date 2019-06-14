package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.demo.domain.Container;

public class ContainerController {

	public Container container;
	
	public ContainerController() {}
	
	public ContainerController(Container container) {
		super();
		this.container = container;
	}

	public Container getContainerData() {
		Map<String, Integer> containerData = InitializeContainer();
		if(container == null) {
			container = new Container(containerData.get("teaContainer"), containerData.get("coffeeContainer"), 
					containerData.get("sugarContainer"), containerData.get("waterContainer"), 
					containerData.get("milkContainer"));
		}
		return container;
	}

	public Map InitializeContainer() {
		Map<String, Integer> containerData = new HashMap<>();
		containerData.put("teaContainer", 2000);
		containerData.put("coffeeContainer", 2000);
		containerData.put("sugarContainer", 8000);
		containerData.put("waterContainer", 15000);
		containerData.put("milkContainer", 10000);
		return containerData;
	}
}
