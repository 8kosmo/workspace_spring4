package com.di;

import java.util.List;
/*
 * InsaList 안에 선언한 listBean은 xml에 정의된 collection. 즉 List를 받는 변수 임
 * setter메소드는 필수 적임
 * 왜냐하면 직접 인스턴스화는 안하더라도 변수는 선언해야 사용할 수 있으니까.....
 * 하지 않아도 되는 일
 * List<String>에 대한 별도의 초기화 및 객체 생성은 필요없음.
 * 초기화 값은 listBean.xml에 들어 있음.
 * 그 정보를 가져오는 방법은 ApplicationContext를 사용함.
 * 그 정보를 가져올 때 호출하는 메소드는 getBean()
 */
public class InsaList {
	List<String> listBean = null;

	public void setListBean(List<String> listBean) {
		this.listBean = listBean;
	}
}
