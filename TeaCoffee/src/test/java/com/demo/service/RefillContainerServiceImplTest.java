package com.demo.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.demo.controller.TeaCoffeeMenuController;
import com.demo.domain.Container;

@RunWith(MockitoJUnitRunner.class)
public class RefillContainerServiceImplTest {

	@InjectMocks
	RefillContainerServiceImpl refillContainerServiceImpl;

	@Mock
	TeaCoffeeMenuController teaCoffeeMenuController;

	@Mock
	Container container;

	@Test
	public void shouldRefillContainerForTea() {

		doNothing().when(container).setTeaContainer(2000);
		refillContainerServiceImpl.refillContainer(2);
		verify(container).setTeaContainer(2000);
	}

	@Test
	public void shouldRefillContainerForCoffee() throws IOException {

		doNothing().when(container).setCoffeeContainer(2000);
		refillContainerServiceImpl.refillContainer(1);
		verify(container).setCoffeeContainer(2000);
	}

	@Test
	public void shouldRefillContainerForWater() throws IOException {

		doNothing().when(container).setWaterContainer(15000);
		refillContainerServiceImpl.refillContainer(4);
		verify(container).setWaterContainer(15000);
	}

	@Test
	public void shouldRefillContainerForSugar() throws IOException {

		doNothing().when(container).setSugarContainer(8000);
		refillContainerServiceImpl.refillContainer(3);
		verify(container).setSugarContainer(8000);
	}

	@Test
	public void shouldRefillContainerForMilk() throws IOException {

		doNothing().when(container).setMilkContainer(10000);
		refillContainerServiceImpl.refillContainer(5);
		verify(container).setMilkContainer(10000);
	}
}
