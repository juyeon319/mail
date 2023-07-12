package mailingService;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class javaMail {

	public static void main(String[] args) {
		String host = "smtp.naver.com";	
		String user = "id@naver.com";	//발신자 아이디
		String password = "password";		//발신자 비밀번호
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.naver.com");
		props.put("mail.smtp.port", 587);		//네이버는 587
		props.put("mail.smtp.auth", true);
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			//수신자 아이디
			//여러 명 가능
			InternetAddress[] addArray = new InternetAddress[3];
			addArray[0] = new InternetAddress("daehwan553@naver.com");
			addArray[1] = new InternetAddress("tpzha67@naver.com");
			addArray[2] = new InternetAddress("hawxri@naver.com");
					
			message.addRecipients(Message.RecipientType.TO, addArray);
			
			//한명
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress("daehwan553@naver.com"));
			//메일제목
			message.setSubject("malinig Test 테스트~");
			//메일 내용
			message.setText("TEST테스트");
			
			Transport.send(message);
			System.out.println("메일 발송 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
