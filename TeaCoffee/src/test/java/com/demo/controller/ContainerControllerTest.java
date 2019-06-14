package com.demo.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.demo.dao.MakeDrink;
import com.demo.service.MakeBlackCoffeeServiceImpl;
import com.demo.service.MakeBlackTeaServiceImpl;
import com.demo.service.MakeCoffeeServiceImpl;
import com.demo.service.MakeTea;

@RunWith(MockitoJUnitRunner.class)
public class ContainerControllerTest {
	
	@InjectMocks
	ContainerController containerController;

	@Mock
	MakeDrink makeDrink;

	@Test
	public void shouldContainerWithMaximumCapicity() throws IOException {

		assertNotNull(containerController.getContainerData().getTeaContainer());
		assertNotNull(containerController.getContainerData().getCoffeeContainer());
		assertNotNull(containerController.getContainerData().getSugarContainer());
		assertNotNull(containerController.getContainerData().getWaterContainer());
		assertNotNull(containerController.getContainerData().getMilkContainer());
	}

	@Test
	public void shouldContainersFilledWithNeededMaterialForMakingDrink() throws IOException {

		MakeDrink teaAvailability = new MakeTea();
		MakeDrink coffeeAvailability = new MakeCoffeeServiceImpl();
		MakeDrink blackteaAvailability = new MakeBlackTeaServiceImpl();
		MakeDrink blackCoffeeAvailability = new MakeBlackCoffeeServiceImpl();

		assertTrue(teaAvailability.isMaterialAvailable(2));
		assertTrue(coffeeAvailability.isMaterialAvailable(2));
		assertTrue(blackteaAvailability.isMaterialAvailable(4));
		assertTrue(blackCoffeeAvailability.isMaterialAvailable(1));
		assertFalse(teaAvailability.isMaterialAvailable(200000));
		assertFalse(coffeeAvailability.isMaterialAvailable(200000));
		assertFalse(blackteaAvailability.isMaterialAvailable(200000));
		assertFalse(blackCoffeeAvailability.isMaterialAvailable(200000));
	}
}