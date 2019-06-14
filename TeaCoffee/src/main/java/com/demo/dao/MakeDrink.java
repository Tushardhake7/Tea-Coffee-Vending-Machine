package com.demo.dao;

public interface MakeDrink {
	
	public void makingDrink(int quantity);
	
	public boolean isMaterialAvailable(int quantity);
	
	default public int subtractQuantity(int availbaleQuantity, int usedQuantity) {
		return availbaleQuantity - usedQuantity;
	}
}
