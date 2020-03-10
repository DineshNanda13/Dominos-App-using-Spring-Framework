package com.dominosMontreal;

public class Veggie implements Pizza {
	
	private Discounts discounts;
	
	public Veggie(){}

	public void setDiscounts(Discounts discounts) {
		this.discounts = discounts;
	}

	@Override
	public String getPizza() {
		
		return "Veggie pizza includes: Fresh green peppers, onion, tomatoes and mushrooms";
	}

	@Override
	public String getDailyDeals() {
		return ("Through SI: "+discounts.getDiscounts());
	}

}
