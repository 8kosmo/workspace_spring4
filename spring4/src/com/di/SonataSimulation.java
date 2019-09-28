package com.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SonataSimulation {

	public static void main(String[] args) {
		//객체 생성
		Sonata yourCar = new Sonata();
		//객체 소멸
		yourCar = null;//candidate상태로 전환되는코드임.
		yourCar = new Sonata();
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com\\di\\sonataBean.xml");
		Sonata myCar = (Sonata)context.getBean("myCar");
		System.out.println(myCar.carColor);
		System.out.println(myCar.speed);
		System.out.println(myCar.wheelNum);
		Sonata himCar = (Sonata)context.getBean("himCar");
		System.out.println(himCar.carColor);
		System.out.println(himCar);
		System.out.println(himCar.toString());
		Sonata herCar = (Sonata)context.getBean("herCar");
		System.out.println(herCar);
		
	}

}
