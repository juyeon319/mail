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
		//�߽����� ���̵�� ��й�ȣ�� �Է��Ѵ�.
		String id ="daehwan553@naver.com";	
		String passwd = "gkfndpt8975!";
		
		//email ��ü ����
		Email email = new SimpleEmail();
		
		// SMTP ���� ���ἳ��
		email.setHostName("smtp.naver.com");
		email.setSmtpPort(587);	//���̹��� 587
		email.setCharset("euc-kr");
		email.setAuthentication(id, passwd);	
				
		// SMTP SSL, TLS ����
		email.setSSLOnConnect(true);
		email.setStartTLSEnabled(true);
		
		try {
	        // �߽��� ID
	        email.setFrom(id);
	
	        // ������ ID(�ټ�����)
	        email.addTo("juyeon98p@naver.com");
	        //email.addTo("daehwan553@naver.com");
	        
	        // ���� ���� ����
	        email.setSubject("�����Դϴ�.");
	
	        // ���� ���� ����
	        email.setMsg("�����Դϴ�.");
	
	        // ���� ����
	        email.send();
	        System.out.println("���� �߼ۿ� �����Ͽ����ϴ�.");
      } catch (Exception e) {
          System.out.println("���� �߼ۿ� �����Ͽ����ϴ�." + e.getMessage());
      }
}
	
	public void HtmlMailSend() {
		//�߽����� ���̵�� ��й�ȣ�� �Է��Ѵ�.
		String id ="daehwan553@naver.com";	
		String passwd = "gkfndpt8975!";
		
		// HtmlEmail ��ü ����
		HtmlEmail email = new HtmlEmail();
		
		// SMTP ���� ���ἳ��
		email.setHostName("smtp.naver.com");
		email.setSmtpPort(587);
		email.setAuthentication(id, passwd);

		// SMTP SSL, TLS ����
		email.setSSLOnConnect(true);
		email.setStartTLSEnabled(true);
		
		// �̸��� ���뿡 �Ϻην� ��ġ�� �̹��� ���ϰ�ü �غ�
		File imgFile = new File("���");
		
		try {
			// �߽��� ID
	        email.setFrom(id);
	
	        // ������ ID(�ټ�����)
	        email.addTo("juyeon98p@naver.com");
	        //email.addTo("daehwan553@naver.com");
	        
	        // �̸��� ���� ����
	        email.setSubject("Html�����׽�Ʈ");
	        
	        // ���� ����
	        StringBuilder sb = new StringBuilder();
			sb.append("<html>");
			sb.append("<head>");
			sb.append("<meta charset='utf-8'>");
			sb.append("</head>");
			sb.append("<body>");
			sb.append("html�׽�Ʈ<br>");
			sb.append("<img src=cid:" + email.embed(imgFile) + " width='300' height='150'><br>");
			sb.append("test�̹����Դϴ�.<br>");
			sb.append("</body>");
			sb.append("</html>");
			
			// ���ڼ� ����
			email.setCharset("utf-8");
			email.setHtmlMsg(sb.toString());
			
	        // ���� ����
	        email.send();
	        System.out.println("���� �߼ۿ� �����Ͽ����ϴ�.");
      } catch (Exception e) {
          System.out.println("���� �߼ۿ� �����Ͽ����ϴ�." + e.getMessage());
      }
}
		
		
	}
		
