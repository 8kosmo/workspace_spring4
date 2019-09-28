package com.util;

public class HangulConversion {
	//화면에서 전송한 값을 euc-kr 인코딩 된 걸 컨버전 할 때
	public static String toKor(String en)
	{
		if(en==null) return null;
		try{
			return new String(en.getBytes("8859_1"),"euc-kr");
		} catch (Exception e) {
			return en;
		}
	}
	public static String toUTF(String en)
	{
		if(en==null) return null;
		try{
			return new String(en.getBytes("8859_1"),"utf-8");
		} catch (Exception e) {
			return en;
		}
	}
	//화면에서 전송한 값을 utf-8 인코딩 된 걸 컨버전 할 때
	//다국어 지원,  ajax는 디폴트 값임.
}
