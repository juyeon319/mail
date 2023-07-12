package mailingService;

import java.io.File;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

public class CommonMail {

	public static void main(String[] args) {
		CommonMail cm = new CommonMail();
		
		cm.textMailSend();
	}
	
	public void textMailSend() {
		//발신자의 아이디와 비밀번호를 입력한다.
		String id ="daehwan553@naver.com";	
		String passwd = "gkfndpt8975!";
		
		//email 객체 생성
		Email email = new SimpleEmail();
		
		// SMTP 서버 연결설정
		email.setHostName("smtp.naver.com");
		email.setSmtpPort(587);	//네이버는 587
		email.setCharset("euc-kr");
		email.setAuthentication(id, passwd);	
				
		// SMTP SSL, TLS 설정
		email.setSSLOnConnect(true);
		email.setStartTLSEnabled(true);
		
		try {
	        // 발신자 ID
	        email.setFrom(id);
	
	        // 수신자 ID(다수가능)
	        email.addTo("juyeon98p@naver.com");
	        //email.addTo("daehwan553@naver.com");
	        
	        // 메일 제목 설정
	        email.setSubject("제목입니다.");
	
	        // 메일 본문 설정
	        email.setMsg("본문입니다.");
	
	        // 메일 전송
	        email.send();
	        System.out.println("메일 발송에 성공하였습니다.");
      } catch (Exception e) {
          System.out.println("메일 발송에 실패하였습니다." + e.getMessage());
      }
}
	
	public void HtmlMailSend() {
		//발신자의 아이디와 비밀번호를 입력한다.
		String id ="daehwan553@naver.com";	
		String passwd = "gkfndpt8975!";
		
		// HtmlEmail 객체 생성
		HtmlEmail email = new HtmlEmail();
		
		// SMTP 서버 연결설정
		email.setHostName("smtp.naver.com");
		email.setSmtpPort(587);
		email.setAuthentication(id, passwd);

		// SMTP SSL, TLS 설정
		email.setSSLOnConnect(true);
		email.setStartTLSEnabled(true);
		
		// 이메일 내용에 일부로써 배치할 이미지 파일객체 준비
		File imgFile = new File("경로");
		
		try {
			// 발신자 ID
	        email.setFrom(id);
	
	        // 수신자 ID(다수가능)
	        email.addTo("juyeon98p@naver.com");
	        //email.addTo("daehwan553@naver.com");
	        
	        // 이메일 제목 설정
	        email.setSubject("Html메일테스트");
	        
	        // 본문 설정
	        StringBuilder sb = new StringBuilder();
			sb.append("<html>");
			sb.append("<head>");
			sb.append("<meta charset='utf-8'>");
			sb.append("</head>");
			sb.append("<body>");
			sb.append("html테스트<br>");
			sb.append("<img src=cid:" + email.embed(imgFile) + " width='300' height='150'><br>");
			sb.append("test이미지입니다.<br>");
			sb.append("</body>");
			sb.append("</html>");
			
			// 문자셋 설정
			email.setCharset("utf-8");
			email.setHtmlMsg(sb.toString());
			
	        // 메일 전송
	        email.send();
	        System.out.println("메일 발송에 성공하였습니다.");
      } catch (Exception e) {
          System.out.println("메일 발송에 실패하였습니다." + e.getMessage());
      }
}
		
		
	}
		
