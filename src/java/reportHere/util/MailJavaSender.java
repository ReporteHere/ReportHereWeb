package reportHere.util;


import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import com.sun.mail.smtp.SMTPSendFailedException;

public class MailJavaSender {
	
	public static String MAIL_STATUS = "";

	// cria as propriedades necessárias para o envio de email
	public String senderMail(final MailJava mail) throws UnsupportedEncodingException, javax.mail.MessagingException {

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", mail.getSmtpHostMail());
		props.setProperty("mail.smtp.auth", mail.getSmtpAuth());
		props.setProperty("mail.smtp.starttls.enable", mail.getSmtpStarttls());
		props.setProperty("mail.smtp.port", mail.getSmtpPortMail());
		props.setProperty("mail.mime.charset", mail.getCharsetMail());
                props.setProperty("mail.smtp.socketFactory.port", "587");
                props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Autendicador auth = Autendicador.getInstance();
		auth.setUser (mail.getUserMail());
		auth.setPassword (mail.getPassMail()); 

		// Cria a sessao passando as propriedades e a autenticação
		Session session = Session.getDefaultInstance(props, auth);
		// Gera um log no console referente ao processo de envio
		session.setDebug(true);

		// cria a mensagem setando o remetente e seus destinatários
		Message msg = new MimeMessage(session);
		// aqui seta o remetente
		msg.setFrom(new InternetAddress(mail.getUserMail(), mail.getFromNameMail()));
		
		// preenchendo lista de destino PARA
		
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mail.getToMailsUsers()));
		
		
		// preenchendo lista de destino CÓPIA
		for (Map.Entry<String, String> map : mail.getToMailsCopia().entrySet()) {
			msg.addRecipient(Message.RecipientType.CC,
					new InternetAddress(map.getKey(), map.getValue()));
		}

		// adicona o email oculto
		msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(mail.getEmailOculto(), "email oculto"));
		
		// Adiciona um Assunto a Mensagem
		msg.setSubject(mail.getSubjectMail());

		// Cria o objeto que recebe o texto do corpo do email
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent(mail.getBodyMail(), mail.getTypeTextMail());

		// Monta a mensagem SMTP inserindo o conteudo, texto e anexos
		Multipart mps = new MimeMultipart();
		for (int index = 0; index < mail.getFileMails().size(); index++) {

			// Cria um novo objeto para cada arquivo, e anexa o arquivo
			MimeBodyPart attachFilePart = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(mail.getFileMails().get(index));
			attachFilePart.setDataHandler(new DataHandler(fds));
			attachFilePart.setFileName(fds.getName());

			// adiciona os anexos da mensagem
			mps.addBodyPart(attachFilePart, index);

		}

		// adiciona o corpo texto da mensagem
		mps.addBodyPart(textPart);

		// adiciona a mensagem o conteúdo texto e anexo
		msg.setContent(mps);

		// Envia a Mensagem
		
		try {
			Transport.send(msg);
			MAIL_STATUS = "SUCCESS";
			return MAIL_STATUS;
		} catch (SMTPSendFailedException emailException) {
			emailException.printStackTrace();
			MAIL_STATUS = "Cause: "+emailException.getCause()+"Message: "+
			emailException.getMessage()+"StackTrace: "+emailException.getStackTrace();			
			return MAIL_STATUS;	
		}
		
	}

	public void senderMailSemAnexo(final MailJava mail) throws UnsupportedEncodingException, MessagingException, javax.mail.MessagingException {

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", mail.getSmtpHostMail());
		props.setProperty("mail.smtp.auth", mail.getSmtpAuth());
		props.setProperty("mail.smtp.starttls.enable", mail.getSmtpStarttls());
		props.setProperty("mail.smtp.port", mail.getSmtpPortMail());
		props.setProperty("mail.mime.charset", mail.getCharsetMail());
		
		Autendicador auth = Autendicador.getInstance();
		auth.setUser (mail.getUserMail());
		auth.setPassword (mail.getPassMail()); 

		// Cria a sessao passando as propriedades e a autenticação
		Session session = Session.getDefaultInstance(props, auth);
		// Gera um log no console referente ao processo de envio
		session.setDebug(true);

		// cria a mensagem setando o remetente e seus destinatários
		Message msg = new MimeMessage(session);
		// aqui seta o remetente
		msg.setFrom(new InternetAddress(mail.getUserMail(), mail.getFromNameMail()));
		
		// ---------------------------------------------------------------------------------------------------------
		
		// preenchendo lista de destino PARA
		
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mail.getToMailsUsers()));
		
		
		// preenchendo lista de destino CÓPIA
		for (Map.Entry<String, String> map : mail.getToMailsCopia().entrySet()) {
			msg.addRecipient(Message.RecipientType.CC,
					new InternetAddress(map.getKey(), map.getValue()));
		}

		// adicona o email oculto
		msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(mail.getEmailOculto(), "email oculto"));
		
		// Adiciona um Assunto a Mensagem
		msg.setSubject(mail.getSubjectMail());

		// Cria o objeto que recebe o texto do corpo do email
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent(mail.getBodyMail(), mail.getTypeTextMail());

		// Monta a mensagem SMTP inserindo o conteudo, texto e anexos
		Multipart mps = new MimeMultipart();
		
		if(mail.getFileMails() != null){
			for (int index = 0; index < mail.getFileMails().size(); index++) {
	
				// Cria um novo objeto para cada arquivo, e anexa o arquivo
				MimeBodyPart attachFilePart = new MimeBodyPart();
				FileDataSource fds = new FileDataSource(mail.getFileMails().get(index));
				attachFilePart.setDataHandler(new DataHandler(fds));
				attachFilePart.setFileName(fds.getName());
	
				// adiciona os anexos da mensagem
				mps.addBodyPart(attachFilePart, index);
	
			}
		}
		// adiciona o corpo texto da mensagem
		mps.addBodyPart(textPart);

		// adiciona a mensagem o conteúdo texto e anexo
		msg.setContent(mps);

		// Envia a Mensagem
		Transport.send(msg);
	}

}
