# Dominos-App-using-Spring-Framework
A basic illustration of how to use Spring IOC and Spring Dependency Injection. The app gives ingridients of pizza using Spring IOC feature and the app also has discount service using constructor and setter dependency Injection.

//File name: Pizza.java

package com.dominosMontreal;

public interface Pizza {
	
	public String getPizza();
	
	public String getDailyDeals();

}

//File name: Discounts.java

package com.dominosMontreal;

public interface Discounts {
	
	public String getDiscounts();
}

//File name: Deals.java

package com.dominosMontreal;

public class Deals implements Discounts {

	@Override
	public String getDiscounts() {
		return "10% off on your selected pizza!";
	}

}

//File name: Extravaganza.java

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

//File name: Veggie.java

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

//File name: applicationContext.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

	<!-- add entry to enable component scanning -->

	<context:component-scan
		base-package="com.dominosMontreal" />
		
		<bean
		id = "myDiscounts"
		class = "com.dominosMontreal.Deals"></bean>
		
		<bean
		id = "ingridients"
		class = "com.dominosMontreal.Extravaganza">
		
		<!-- constructor injection -->
		<constructor-arg ref = "myDiscounts"/>
		
		</bean>
		
		<bean
		id = "myVeggiePizza"
		class = "com.dominosMontreal.Veggie">
		
		<!-- setter injection -->
		<property name="discounts" ref="myDiscounts"/>
		
		</bean>

</beans>

//File name: DominosApp.Java

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

//File name: SetterInjection.Java

package com.dominosMontreal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjection {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		Pizza thePizza = context.getBean("myVeggiePizza", Pizza.class);

		// call methods on the bean
		System.out.println(thePizza.getPizza());

		//call the method for discount service
		System.out.println(thePizza.getDailyDeals()); //setter injection

		// close the context
		context.close();

	}

}



