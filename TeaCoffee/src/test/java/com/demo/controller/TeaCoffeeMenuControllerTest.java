package com.demo.controller;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.demo.service.ContainerStatusServiceImpl;
import com.demo.service.MakeBlackCoffeeServiceImpl;
import com.demo.service.MakeBlackTeaServiceImpl;
import com.demo.service.MakeCoffeeServiceImpl;
import com.demo.service.MakeTea;
import com.demo.service.RefillContainerServiceImpl;
import com.demo.service.ResetContainerServiceImpl;
import com.demo.service.TotalSaleServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TeaCoffeeMenuControllerTest {

	@InjectMocks
	TeaCoffeeMenuController teaCoffeeMenuController;

	@Mock
	InputScanner inputScanner;

	@Mock
	RefillContainerServiceImpl refillContainerServiceImpl;

	@Mock
	TotalSaleServiceImpl totalSaleServiceImpl;

	@Mock
	ContainerStatusServiceImpl containerStatusServiceImpl;

	@Mock
	ResetContainerServiceImpl resetContainerServiceImpl;

	@Mock
	MakeTea makeTea;

	@Mock
	MakeCoffeeServiceImpl makeCoffeeServiceImpl;

	@Mock
	MakeBlackTeaServiceImpl makeBlackTeaServiceImpl;

	@Mock
	MakeBlackCoffeeServiceImpl makeBlackCoffeeServiceImpl;

	@Mock
	ContainerController containerController;

	@Test
	public void shouldRepeatShowMenuWhenUserInputIsZero() throws IOException {
		
		when(inputScanner.nextInt()).thenReturn(0);
		teaCoffeeMenuController.repeatMenu();
		verify(inputScanner, atLeast(1)).nextInt();
	}

	@Test
	public void shouldCheckMakeCoffeeWithInvalidInput() throws IOException {
		
		when(inputScanner.nextInt()).thenReturn(1);
		when(makeCoffeeServiceImpl.isMaterialAvailable(anyInt())).thenReturn(false);

		teaCoffeeMenuController.showMenu();
		verify(makeCoffeeServiceImpl).isMaterialAvailable(1);
	}

	@Test
	public void shouldCheckMakeCoffeeWithvalidInput() throws IOException {

		when(inputScanner.nextInt()).thenReturn(1);
		when(makeCoffeeServiceImpl.isMaterialAvailable(Mockito.anyInt())).thenReturn(true);
		doNothing().when(makeCoffeeServiceImpl).makingDrink(anyInt());
		
		teaCoffeeMenuController.showMenu();
		verify(inputScanner, atLeast(1)).nextInt();
	}

	@Test
	public void shouldCheckMakeTeaWithInvalidInput() throws IOException {
		
		when(inputScanner.nextInt()).thenReturn(2);
		when(makeTea.isMaterialAvailable(anyInt())).thenReturn(false);

		teaCoffeeMenuController.showMenu();
		verify(makeTea).isMaterialAvailable(2);
	}

	@Test
	public void shouldMakeTeaWithValidInput() throws IOException {
		
		when(inputScanner.nextInt()).thenReturn(2);
		when(makeTea.isMaterialAvailable(anyInt())).thenReturn(true);
		doNothing().when(makeTea).makingDrink(anyInt());
		
		teaCoffeeMenuController.showMenu();
		verify(makeTea).isMaterialAvailable(anyInt());
	}

	@Test
	public void shouldMakeBlackCoffeeWithInvalidInput() throws IOException {
		
		when(inputScanner.nextInt()).thenReturn(3);
		when(makeBlackCoffeeServiceImpl.isMaterialAvailable(Mockito.anyInt())).thenReturn(false);

		teaCoffeeMenuController.showMenu();
		verify(makeBlackCoffeeServiceImpl).isMaterialAvailable(3);
	}

	@Test
	public void shouldMakeBlackCoffeeWithValidInput() throws IOException {
		
		when(inputScanner.nextInt()).thenReturn(3);
		when(makeBlackCoffeeServiceImpl.isMaterialAvailable(anyInt())).thenReturn(true);
		doNothing().when(makeBlackCoffeeServiceImpl).makingDrink(anyInt());

		teaCoffeeMenuController.showMenu();
		verify(inputScanner, atLeast(1)).nextInt();
	}

	@Test
	public void shouldMakeBlackTeaWithInvalidInput() throws IOException {
		
		when(inputScanner.nextInt()).thenReturn(4);
		when(makeBlackTeaServiceImpl.isMaterialAvailable(Mockito.anyInt())).thenReturn(false);

		teaCoffeeMenuController.showMenu();
		verify(makeBlackTeaServiceImpl).isMaterialAvailable(4);
	}

	@Test
	public void shouldMakeBlackTeaWithValidInput() throws IOException {
		
		when(inputScanner.nextInt()).thenReturn(4);
		when(makeBlackTeaServiceImpl.isMaterialAvailable(anyInt())).thenReturn(true);
		doNothing().when(makeBlackTeaServiceImpl).makingDrink(anyInt());

		teaCoffeeMenuController.showMenu();
		verify(inputScanner, atLeast(1)).nextInt();
	}

	@Test
	public void shouldCheckRefillContainer() throws IOException {
		
		when(inputScanner.nextInt()).thenReturn(5).thenReturn(1);
		doNothing().when(refillContainerServiceImpl).refillContainer(Mockito.anyInt());

		teaCoffeeMenuController.showMenu();
		verify(refillContainerServiceImpl).refillContainer(Mockito.anyInt());
	}

	@Test
	public void shouldCheckTotalSale() throws IOException {
		
		when(inputScanner.nextInt()).thenReturn(6).thenReturn(1);
		doNothing().when(totalSaleServiceImpl).totalSaleOfProduct();

		teaCoffeeMenuController.showMenu();
		verify(totalSaleServiceImpl).totalSaleOfProduct();
	}

	@Test
	public void shouldCheckContainerStatus() throws IOException {
		
		when(inputScanner.nextInt()).thenReturn(7).thenReturn(1);
		teaCoffeeMenuController.showMenu();
		verify(containerStatusServiceImpl).showContainerStatus(containerController);
	}

	@Test
	public void shouldCheckResetContainer() throws IOException {
		
		when(inputScanner.nextInt()).thenReturn(8).thenReturn(1);
		teaCoffeeMenuController.showMenu();
		verify(resetContainerServiceImpl).resetContainer(containerController);
	}


	@Test
	public void shouldExitFromContainer() throws IOException {
		
		when(inputScanner.nextInt()).thenReturn(9);
		teaCoffeeMenuController.showMenu();
	}

	@Test
	public void shouldReturnWithDefault() throws IOException {
		
		when(inputScanner.nextInt()).thenReturn(10);
		teaCoffeeMenuController.showMenu();
	}
}