package mailingService;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class CommonMail1 {

	public static void main(String[] args) throws MalformedURLException {
		CommonMail1 ms = new CommonMail1();
		
		ms.simpleSend();
//		ms.fileSend();
//		ms.htmlSend();
	} 
	
	public void simpleSend() {
		String id ="daehwan553@naver.com";	//아이디만
		String passwd = "gkfndpt8975!";
		
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
	        email.addTo("id@naver.com");
	        email.addTo("id@naver.com");
	        email.addTo("id@naver.com");
	        
	        // 이메일 제목 설정
	        email.setSubject("제목입니다.");
	
	        // 이메일 본문 설정
	        email.setMsg("본문입니다.");
	
	        // 이메일 보내기
	        email.send();
	
	        System.out.println("메일 발송에 성공하였습니다.");
      } catch (Exception e) {
          System.out.println("메일 발송에 실패하였습니다." + e.getMessage());
      }
}
		public void fileSend() {
			// 첨부파일과 함께 텍스트 이메일 보내기 - MultipartEmail 클래스
			String id ="아이디";	//아이디만
			String passwd = "비밀번호";
			
			// 첨부파일 생성을 위한 EmailAttachment 객체 생성
			EmailAttachment attachment = new EmailAttachment();
			attachment.setName("첨부파일.png"); //첨부파일의 이름설정
			attachment.setDescription("이미지 입니다.");
			//경로에 한글있으면 에러
			attachment.setPath( "D:\\AnneMarie.jpg");

			// MultipartEmail 객체 생성
			MultiPartEmail email = new MultiPartEmail();
			
			// SMTP 서버 연결설정
			email.setHostName("smtp.naver.com");
			email.setSmtpPort(587);
			email.setAuthentication(id, passwd);
			
			// SMTP SSL, TLS 설정
			email.setSSLOnConnect(true);
			email.setStartTLSEnabled(true);

			try {
				// 보내는 사람 설정
				email.setFrom(id+"@naver.com");
				
				// 받는 사람 설정(여러명가능)
				email.addTo("id@naver.com");
				
				// 제목 설정
				email.setSubject("파일첨부.");
				
				// 본문 설정
				email.setMsg("테스트!");
				
				// 첨부파일 추가
				email.attach(attachment);//파일 갯수만큼 증가
				
				// 메일 전송
				email.send();
				System.out.println("메일 전송 성공");
			} catch (EmailException e) {
				e.printStackTrace();
				System.out.println("메일 전송 실패");
			}
		}
		
//	public void urlSend() throws MalformedURLException {
//
//		String id ="daehwan553";
//		String passwd = "gkfndpt8975!";
//		
//		EmailAttachment attachment = new EmailAttachment();
//		attachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
//		attachment.setDisposition(EmailAttachment.ATTACHMENT);
//		attachment.setDescription("Apache logo");
//		attachment.setName("Apache logo");
//		
//		MultiPartEmail email = new MultiPartEmail();
//
//		// SMTP 서버 연결설정
//		email.setHostName("smtp.naver.com");
//		email.setSmtpPort(587);
//		email.setAuthentication(id, passwd);
//		
//		// SMTP SSL, TLS 설정
//		email.setSSLOnConnect(true);
//		email.setStartTLSEnabled(true);
//		
//		try {
//			// 보내는 사람 설정
//			email.setFrom(id+"@naver.com");
//			
//			// 받는 사람 설정(여러명가능)
//			email.addTo("juyeon98p@naver.com");
//			
//			// 제목 설정
//			email.setSubject("url 테스트");
//			
//			// 본문 설정
//			email.setMsg("테스트!");
//			
//			// url
//			email.attach(attachment);//파일 갯수만큼 증가
//			
//			// 메일 전송
//			email.send();
//			System.out.println("메일 전송 성공");
//		} catch (EmailException e) {
//			e.printStackTrace();
//			System.out.println("메일 전송 실패");
//		}
//	}
		
	public void htmlSend() {
		
		String id ="아이디";
		String passwd = "비밀번호";

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
		File imgFile = new File("D:\\webprogramming\\webgitgit\\webpro\\WebContent\\images\\Coca-Cola-logo.png");
		
		String result = "fail";
		
		try {
			// 보내는 사람 설정
			email.setFrom(id+"@naver.com");
			// 받는 사람 설정
			email.addTo("id@naver.com");

			// 제목 설정
			email.setSubject("html!테스트");
			
			// 본문 설정
			StringBuilder sb = new StringBuilder();
			sb.append("<html>");
			sb.append("<head>");
			sb.append("<meta charset='utf-8'>");
			sb.append("</head>");
			sb.append("<body>");
			sb.append("테스트!<br>");
			sb.append("<img src=cid:" + email.embed(imgFile) + " width='300' height='150'><br>");
			sb.append("test 테스트<br>");
			sb.append("</body>");
			sb.append("</html>");
			
			// 문자셋 설정
			email.setCharset("utf-8");
			email.setHtmlMsg(sb.toString());
			
			// 메일 전송
			email.send();
			System.out.println("메일 전송 성공!!");
		} catch (EmailException e) {
			e.printStackTrace();
			System.out.println("메일 전송 실패!!");
		}
	}
}
