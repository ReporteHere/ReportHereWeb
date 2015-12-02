
package reportHere.util;

import java.util.HashMap;

import java.util.Map;

public class EmailUtil {
    public  void informar(Map<String, Object> mapOcorrencia) throws Exception {

		StringBuffer corpoEmail = new StringBuffer();

		corpoEmail.append("Ocorrencia encaminhada para o ouvidor.").append("<br/>");
		corpoEmail.append("Segue protocolo e senha para acompanhamento de chamado.").append("<br/>");
                corpoEmail.append("Protocolo: <b>").append(mapOcorrencia.get("protocolo")).append("</b>").append("<br/>");
                corpoEmail.append("Senha: <b>").append(mapOcorrencia.get("senha")).append("</b>").append("<br/>").append("<br/>");
                corpoEmail.append("Atenciosamente,").append("<br/>");
                corpoEmail.append("FAI - Centro de Ensino Superior em Gestão, Informática e Educação").append("<br/>");
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("corpoEmail", corpoEmail.toString());
		args.put("assunto", "Chamado Aberto - "+mapOcorrencia.get("assunto").toString().toUpperCase());

		String emails = (String) mapOcorrencia.get("email");
		String emailsCopia = "";

		PreparaEmail.inserirParametrosEmail(args, emails, emailsCopia, false);


		try {
			MailService.enviarSemAnexo(args);
		} catch (javax.mail.MessagingException e) {
			e.printStackTrace();
		} 

	}
}
