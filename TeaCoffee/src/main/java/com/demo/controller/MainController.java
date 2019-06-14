package com.demo.controller;

import java.io.IOException;

public class MainController {
	public static void main(String[] args) throws IOException {
		new ContainerController().getContainerData();
		TeaCoffeeMenuController teaCoffeeMenuController = new TeaCoffeeMenuController();
		teaCoffeeMenuController.showMenu();
	}
}
