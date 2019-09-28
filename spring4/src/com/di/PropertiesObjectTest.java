package com.di;

import java.util.Enumeration;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesObjectTest {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com\\di\\mapBean.xml");
		PropertiesObject pobj =
				(PropertiesObject)context.getBean("propsObject");
		Properties props = pobj.someProps;
		System.out.println(props.getProperty("/di/testList.sp4"));
		System.out.println(props.getProperty("/di/testAdd.sp4"));
		System.out.println(props.getProperty("/di/testUpd.sp4"));
		System.out.println(props.getProperty("/di/testDel.sp4"));
		System.out.println("================");
		Enumeration en = props.keys();
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
			String key = (String)en.nextElement();
			System.out.println(props.getProperty(key));
		}
	}

}
