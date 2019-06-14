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
public class MakeTeaTest {

	@InjectMocks
	MakeTea makeTea;

	@Mock
	ProductRecord productRecord;

	@Mock
	ContainerController containerController;

	@Test
	public void shouldReturnTrueWhenMaterialAvailableToMakeTea() {
		
		Boolean expected = true;
		int teaQuantity = 2;
		Container container = new Container(2000, 2000, 2000, 2000, 2000);
		
		when(containerController.getContainerData()).thenReturn(container);
		
		Boolean actual = makeTea.isMaterialAvailable(teaQuantity);
		
		verify(containerController,atLeast(1)).getContainerData();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnFalseWhenMaterialNotAvailableToMakeTea() {
		
		Boolean expected = false;
		int teaQuantity = 2;
		Container container = new Container(0, 0, 0, 0, 0);
		
		when(containerController.getContainerData()).thenReturn(container);
		
		Boolean actual = makeTea.isMaterialAvailable(teaQuantity);
		
		verify(containerController,atLeast(1)).getContainerData();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldSystemIsAbleToMakeTea() {
		
		Container container = new Container(1, 0, 0, 0, 0);
		int teaQuantity = 2;
		
		when(containerController.getContainerData()).thenReturn(container);
		
		makeTea.makingDrink(teaQuantity);
		verify(containerController,atLeast(1)).getContainerData();
	}

	@Test
	public void shouldReturnObject() {
		MakeTea makeTea = new MakeTea();
	}	
}
