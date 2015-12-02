package reportHere.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;


public class MailService {
	
    @SuppressWarnings("unchecked")
	public static void enviar(Map<String, Object> args) throws MessagingException, javax.mail.MessagingException {
        MailJava mj = new MailJava();
        //configuracoes de envio
        mj.setSmtpHostMail("smtp.gmail.com");
        mj.setSmtpPortMail("587");
        mj.setSmtpAuth("true");
        mj.setSmtpStarttls("true");
        mj.setCharsetMail("ISO-8859-1");
        
        mj.setUserMail((String) args.get("emailRemetente"));
        mj.setFromNameMail((String) args.get("nomeRemetente"));
        mj.setPassMail((String) args.get("senhaRemetente"));       
        mj.setSubjectMail((String) args.get("assunto"));
        mj.setBodyMail(htmlMessage((String) args.get("corpoEmail")));
        mj.setTypeTextMail(MailJava.TYPE_TEXT_HTML);

        //set com o mapa de emails
        mj.setToMailsUsers((String) args.get("destinatarios"));
        mj.setToMailsCopia((Map<String, String>) args.get("destinatariosCopia"));

        //seta quantos anexos desejar
        List<String> files = new ArrayList<String>();
        
        files.add((String) args.get("danfe"));
        
        mj.setFileMails(files);
        
        mj.setEmailOculto((String) args.get("emailOculto"));

        try {
            args.put("MAIL_STATUS", new MailJavaSender().senderMail(mj));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        //args.put("MAIL_STATUS", "error"); // colocado para testar sem enviar

    }

    private static String htmlMessage(String html) {
        String retorno ="";
        return html;
    }

    @SuppressWarnings("unchecked")
	public static void enviarSemAnexo(Map<String, Object> args) throws MessagingException, javax.mail.MessagingException {
        MailJava mj = new MailJava();
        //configuracoes de envio
        mj.setSmtpHostMail("smtp.gmail.com");
        mj.setSmtpPortMail("587");
        mj.setSmtpAuth("true");
        mj.setSmtpStarttls("true");
        mj.setCharsetMail("ISO-8859-1");
        
        mj.setUserMail((String) args.get("emailRemetente"));
        mj.setFromNameMail((String) args.get("nomeRemetente"));
        mj.setPassMail((String) args.get("senhaRemetente"));       
        mj.setSubjectMail((String) args.get("assunto"));
        mj.setBodyMail(htmlMessage((String) args.get("corpoEmail")));
        mj.setTypeTextMail(MailJava.TYPE_TEXT_HTML);

        //set com o mapa de emails
        mj.setToMailsUsers((String) args.get("destinatarios"));
        mj.setToMailsCopia((Map<String, String>) args.get("destinatariosCopia"));

        mj.setEmailOculto((String) args.get("emailOculto"));

        try {
            new MailJavaSender().senderMailSemAnexo(mj);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } 
    }
}
