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
public class MakeBlackCoffeeServiceImplTest {

	@InjectMocks
	MakeBlackCoffeeServiceImpl makeBlackCoffeeServiceImpl;
	
	@Mock
	ProductRecord productRecord;

	@Mock
	ContainerController containerController;

	@Test
	public void shouldReturnTrueWhenMaterialAvailableToMakeBlackCoffee() {
		
		Boolean expected = true;
		int blackCoffeeQuantity = 2;
		Container container = new Container(2000, 2000, 2000, 2000, 2000);
		
		when(containerController.getContainerData()).thenReturn(container);
		
		Boolean actual = makeBlackCoffeeServiceImpl.isMaterialAvailable(blackCoffeeQuantity);
		
		verify(containerController,atLeast(1)).getContainerData();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnFalseWhenMaterialNotAvailableToMakeBlackCoffee() {
		
		Boolean expected = false;
		int blackCoffeeQuantity = 2;
		Container container = new Container(0, 0, 0, 0, 0);
		
		when(containerController.getContainerData()).thenReturn(container);
		
		Boolean actual = makeBlackCoffeeServiceImpl.isMaterialAvailable(blackCoffeeQuantity);
		
		verify(containerController,atLeast(1)).getContainerData();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldSystemIsAbleToMakeBlackCoffee() {
		
		Container container = new Container(1, 0, 0, 0, 0);
		int blackCoffeeQuantity = 2;
		
		when(containerController.getContainerData()).thenReturn(container);
		
		makeBlackCoffeeServiceImpl.makingDrink(blackCoffeeQuantity);
		verify(containerController,atLeast(1)).getContainerData();
	}
}
