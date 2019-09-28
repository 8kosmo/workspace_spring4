package com.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsaSimulation {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
								("com\\di\\listBean.xml");
		InsaList insaList = (InsaList)context.getBean("insa");
		/*
		 * insaList() : InsaList
		 * insaList.listBean() : List<String>
		 * insaList.listBean.size() : String
		 */
		for(int i=0;i<insaList.listBean.size();i++) {
			System.out.println(insaList.listBean.get(i));			
		}
		//개선된 for문
		for(String insa : insaList.listBean) {
			System.out.println(insa);
		}
	}

}
