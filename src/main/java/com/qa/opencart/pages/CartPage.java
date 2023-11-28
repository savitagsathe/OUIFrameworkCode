package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class CartPage {
	
	private By cartButton=By.id("cart");
	
	public CartPage() {
		
		System.out.println("cart page constructor");
	}

public void addToCart() {
		
		System.out.println("add To Cart");
		System.out.println("add feature is done");
	}

}
