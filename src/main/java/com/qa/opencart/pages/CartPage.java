package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class CartPage {
	
	private By cartButton=By.id("cart");
	private By cartButtontwo=By.id("cart2");

	
	public CartPage() {
		
		System.out.println("cart page constructor");
	}

public void addToCart() {
		
		System.out.println("add To Cart");
		System.out.println("todaus added feature is done");

	}

}
