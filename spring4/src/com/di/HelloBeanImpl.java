package com.di;
/*
 * 스프링에서는 절대로 직접 인스턴스화 하지 않는다.
 * 만일 인스턴스화를 하게 되면 스프링의 빈관리를 못받게 되는 것임.
 * 대신 setter객체 주입법과 생성자 객체 주입법으로 객체를 주입
 * 받아서 사용하게 됨
 * setter객체 주입법은 자바 코드로 처리하고
 * 생성자 객체주입법은 xml코드로 처리함.
 * 스프링 안에는 빈즈들을 관리해주는 클래스가 있음.
 * ApplicationContext 와
 * BeanFactory
 * 두 개의 클래스가 빈관리를 전담하게 됨
 * ApplicationContext는 org.springframework.context
 * 에서 제공되고 
 * spring-context-4.3.25.jar
 * BeanFactory는 org.springframework.beans에서 제공됨.
 * spring-beans-4.3.25.jar
 * 
 * IoC(Inversion of Conversion) Container임 - 스프링은
 * 역제어라고 함.
 * 기존 방식
 * 자바 기반으로 어플리케이션을 개발할 때 자바 객체를 생성하고 서로간의 의존관계를 연결시키는
 * 작업에 대한 제어권은 보통 개발되는 어플리케이션에 있음.
 * 문제제기
 * 컴포넌트 간의 결합도가 높아서 컴포넌트의 확장 및 재사용이 어려운 문제점이 발생됨.
 * IoC사용시
 * 제어권이 Container에게 넘어가 객체의 생명주기를 컨테이너가 전담하게 됨.
 * 예)Sevlet, EJB
 * 장점 : 컴포넌트간의 결합도가 낮아져 컴포넌트의 재사용 및 확장이 쉽고 컴포넌트의 의존관계 변경이
 *      쉬움.
 * IoC에서 이야기하는 제어권의 역전이란?
 * 객체의 생성 및 생명주기에 대한 제어권이 개발자에서 Container로 넘어갔다는 것을 의미.
 * 
 * 스프링 컨테이너의 유형
 * Spring Container는 BeanFactory와 ApplicationContext라는 두 가지 유형의 
 * 컨테이너를 제공함.
 * BeanFactory
 * 객체를 관리하는 고급 설정 기법임.
 * Bean 들에 대한 생성, 소멸, 라이프사이클과 같이 컨테이너가 빈을 관리하기 위한 
 * 필요한 기능 제공함.
 * XmlBeanFactory
 * 어플리케이션을 구성하는 객체들의 속성 및 참조관계를 XML기반의 속성 정의 파일에 정의함으로써
 * 컨테이너가 관리 할 수 있도록 해줌
 * Resource resource = new FileSystemResource("bean.xml");
 * BeanFactory factory = new XmlBeanFactory(resource);
 * 
 * 
 * ApplicationContext
 * BeanFactory의 모든 기능을 제공함.
 * Spring AOP 기능, 메시지 자원 핸들링, 이벤트 위임 추가 제공함.     
 */
public class HelloBeanImpl implements HelloBean{
	String msg = null;
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String getGreeting(String msg) {
		return "Spring!!! "+this.msg;
	}
	//Bean이 초기화된 후 호출되는 메소드
	public void initMethod() {
		System.out.println("initMethod 호출 성공");
	}
	//Bean이 소멸되기 전에 호출되는 메소드
	public void destroyMethod() {
		System.out.println("destroyMethod 호출 성공");		
	}
	
}







