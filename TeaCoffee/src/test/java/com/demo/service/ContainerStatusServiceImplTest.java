package com.demo.service;

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
public class ContainerStatusServiceImplTest {

	@InjectMocks
	ContainerStatusServiceImpl containerStatusServiceImpl;

	@Mock
	ContainerController containerController;
	
	@Test
	public void shouldContainerShowCurrentStatus() {
		
		Container container = new Container(1, 0, 0, 0, 0);
		when(containerController.getContainerData()).thenReturn(container);
		
		containerStatusServiceImpl.showContainerStatus(containerController);
		verify(containerController, atLeast(1)).getContainerData();
	}
}
