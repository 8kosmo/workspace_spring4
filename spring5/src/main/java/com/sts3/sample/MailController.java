package com.sts3.sample;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * http://localhost:8000/sample/mail/emailSend.jsp
 * 로 처리한걸 Controller를 통해 처리해보자
 */
@Controller
@RequestMapping("/mail/*")
public class MailController {
	Logger logger = LoggerFactory.getLogger(MailController.class);
	//true이면 주입받는 클래스가 없으면 예외발생 시킴
	//false이면 클래스 없어도 런타임시 예외 발생 안함.
	@Autowired(required=false)
	private JavaMailSender mailSender;
	
	@GetMapping(value="mailSend")
	public String mailSend() {
		logger.info("called mailSend successful");
		//insert here etc...
		//보내는 사람 메일주소
		final String fromMail = "titicaca-lake@naver.com";
		//받는 사람 메일 주소
		final String toMail = "ds0110818@gmail.com";
		//메일 제목
		String subject = "수업중에 보내드립니다.";
		//메일 내용
		String content = "네이버 smtp서버를 활용한 메일 전송 테스트 입니다.";
		try {
			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper =
					new MimeMessageHelper(msg,true,"UTF-8");
			msgHelper.setFrom(fromMail);
			msgHelper.setTo(toMail);
			msgHelper.setSubject(subject);
			msgHelper.setText(content);
			mailSender.send(msg);
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return "redirect:./mailSendOk.jsp";
	}
}
