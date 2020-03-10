package com.dominosMontreal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DominosApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Pizza thePizza = context.getBean("ingridients", Pizza.class);
		
		// call methods on the bean
		System.out.println(thePizza.getPizza());
		
		//call the method for discount service
		System.out.println(thePizza.getDailyDeals()); //constructor injection
		
		// close the context
		context.close();
	}

}
