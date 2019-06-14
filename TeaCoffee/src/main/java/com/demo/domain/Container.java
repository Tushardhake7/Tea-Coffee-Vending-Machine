package com.demo.domain;

public class Container {
	private Integer teaContainer;
	private Integer coffeeContainer;
	private Integer sugarContainer;
	private Integer waterContainer;
	private Integer milkContainer;
	
	public Container() { }
	
	public Container(Integer teaContainer, Integer coffeeContainer, Integer sugarContainer, Integer waterContainer,
			Integer milkContainer) {
		super();
		this.teaContainer = teaContainer;
		this.coffeeContainer = coffeeContainer;
		this.sugarContainer = sugarContainer;
		this.waterContainer = waterContainer;
		this.milkContainer = milkContainer;
	}

	public Integer getTeaContainer() {
		return teaContainer;
	}

	public void setTeaContainer(Integer teaContainer) {
		this.teaContainer = teaContainer;
	}

	public Integer getCoffeeContainer() {
		return coffeeContainer;
	}

	public void setCoffeeContainer(Integer coffeeContainer) {
		this.coffeeContainer = coffeeContainer;
	}

	public Integer getSugarContainer() {
		return sugarContainer;
	}

	public void setSugarContainer(Integer sugarContainer) {
		this.sugarContainer = sugarContainer;
	}

	public Integer getWaterContainer() {
		return waterContainer;
	}

	public void setWaterContainer(Integer waterContainer) {
		this.waterContainer = waterContainer;
	}

	public Integer getMilkContainer() {
		return milkContainer;
	}

	public void setMilkContainer(Integer milkContainer) {
		this.milkContainer = milkContainer;
	}
}