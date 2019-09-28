<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.mail.*, javax.mail.internet.*, java.util.Properties" %>
<%
	String smtpServer = "smtp.naver.com";
	//사용하고자 하는 smtp서버의 계정 정보
	final String username = "titicaca-lake";
	final String password = "vkffksla8*";
	//보내는 사람 이메일 주소
	String fromMail = "titicaca-lake@naver.com";
	int smtpPort = 465;
	
	//받는 이
	String toMail = "ds0110818@gmail.com";
	//메일 제목
	String subject = "수업중에 보내드립니다.";
	//메일 내용
	String content = "네이버 smtp서버를 활용한 메일 전송 테스트 입니다.";
	content+="<br>전송 성공체크";
	
	Properties props = System.getProperties();
	props.put("mail.smtp.host", smtpServer);
	props.put("mail.smtp.port", smtpPort);
	props.put("mail.smtp.auth", true);//인증
	props.put("mail.smtp.ssl.enable", true);
	props.put("mail.smtp.host", smtpServer);
	props.put("mail.smtp.ssl.trust", smtpServer);
	//물리적으로 떨어져 있는 smtp서버에 접속하기 -인증처리-통과-전송가능함.
	Session mySession = Session.getDefaultInstance(props,new Authenticator(){
		protected PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication(username,password);
		}
	});
	try{
		Message msg = new MimeMessage(mySession);
		msg.setFrom(new InternetAddress(fromMail));
		msg.setRecipient(Message.RecipientType.TO,new InternetAddress(toMail));
		msg.setSubject(subject);
		msg.setText(content);
		Transport.send(msg);
		out.print("message sent successfully......");
	}catch(Exception e){
		e.printStackTrace();
	}
%>
