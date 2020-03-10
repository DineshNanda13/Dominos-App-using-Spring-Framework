package com.dominosMontreal;

public class Extravaganza implements Pizza {
	
	private Discounts discounts;
	
	public Extravaganza(Discounts discounts) {
		this.discounts = discounts;
	}

	@Override
	public String getPizza() {
		return "Pizza Extravaganza includes: loads of pepperoni, ham and italian sausage";
	}

	@Override
	public String getDailyDeals() {
		
		return ("Through CI: "+discounts.getDiscounts());
	}

}
