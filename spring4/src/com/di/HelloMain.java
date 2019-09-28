package com.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class HelloMain {

	public static void main(String[] args) {
		Resource resource = new FileSystemResource("D:\\workspace_spring4\\spring4\\src\\com\\di\\helloBean.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		HelloBean helloBean = (HelloBean)factory.getBean("helloBean");
		HelloBean helloBean1 = (HelloBean)factory.getBean("helloBean");
		System.out.println(helloBean+" == "+helloBean1);
		System.out.println(helloBean.getGreeting("안녕!!"));
		System.out.println("=============================");
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
								("com\\di\\helloBean.xml");
		HelloBean helloBean2 = (HelloBean)context.getBean("helloBean");
		HelloBean helloBean3 = (HelloBean)context.getBean("helloBean");
		System.out.println(helloBean2+" == "+helloBean3);
		System.out.println(helloBean2.getGreeting("Hi~~~~"));
		

	}

}
