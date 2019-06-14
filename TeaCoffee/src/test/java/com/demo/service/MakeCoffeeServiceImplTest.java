package com.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.demo.controller.ContainerController;
import com.demo.domain.Container;

@RunWith(MockitoJUnitRunner.class)
public class MakeCoffeeServiceImplTest {
	
	@InjectMocks
	MakeCoffeeServiceImpl makeCoffeeServiceImpl;
	
	@Mock
	ProductRecord productRecord;

	@Mock
	ContainerController containerController;

	@Test
	public void shouldReturnTrueWhenMaterialAvailableToMakeCoffee() {
		
		Boolean expected = true;
		int coffeeQuantity = 2;
		Container container = new Container(2000, 2000, 2000, 2000, 2000);
		
		when(containerController.getContainerData()).thenReturn(container);
		
		Boolean actual = makeCoffeeServiceImpl.isMaterialAvailable(coffeeQuantity);
		
		verify(containerController,atLeast(1)).getContainerData();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnFalseWhenMaterialNotAvailableToMakeCoffee() {
		
		Boolean expected = false;
		int coffeeQuantity = 2;
		Container container = new Container(0, 0, 0, 0, 0);
		
		when(containerController.getContainerData()).thenReturn(container);
		
		Boolean actual = makeCoffeeServiceImpl.isMaterialAvailable(coffeeQuantity);
		
		verify(containerController,atLeast(1)).getContainerData();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldSystemIsAbleToMakeCoffee() {
		
		Container container = new Container(1, 0, 0, 0, 0);
		int coffeeQuantity = 2;
		
		when(containerController.getContainerData()).thenReturn(container);
		
		makeCoffeeServiceImpl.makingDrink(coffeeQuantity);
		verify(containerController,atLeast(1)).getContainerData();
	}
}
