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
public class MakeBlackTeaServiceImplTest {
	
	@InjectMocks
	MakeBlackTeaServiceImpl makeBlackTeaServiceImpl;
	
	@Mock
	ProductRecord productRecord;

	@Mock
	ContainerController containerController;

	@Test
	public void shouldReturnTrueWhenMaterialAvailableToMakeBlackTea() {
		
		Boolean expected = true;
		int blackTeaQuantity = 2;
		Container container = new Container(2000, 2000, 2000, 2000, 2000);
		
		when(containerController.getContainerData()).thenReturn(container);
		
		Boolean actual = makeBlackTeaServiceImpl.isMaterialAvailable(blackTeaQuantity);
		
		verify(containerController,atLeast(1)).getContainerData();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnFalseWhenMaterialNotAvailableToMakeBlackTea() {
		
		Boolean expected = false;
		int blackTeaQuantity = 2;
		Container container = new Container(0, 0, 0, 0, 0);
		
		when(containerController.getContainerData()).thenReturn(container);
		
		Boolean actual = makeBlackTeaServiceImpl.isMaterialAvailable(blackTeaQuantity);
		
		verify(containerController,atLeast(1)).getContainerData();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldSystemIsAbleToMakeBlackTea() {
		
		Container container = new Container(1, 0, 0, 0, 0);
		int blackTeaQuantity = 2;
		
		when(containerController.getContainerData()).thenReturn(container);
		
		makeBlackTeaServiceImpl.makingDrink(blackTeaQuantity);
		verify(containerController,atLeast(1)).getContainerData();
	}
}
