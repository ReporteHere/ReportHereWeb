package reportHere.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class PreparaEmail {
	
	public static void inserirParametrosEmail(Map<String, Object> args, String emails, String emailsCopia, boolean enviarCopiaOcultaAoGrupo) {
		
		
		
		// configura��es e email oculto
		configurarNomeEmailRemetenteAndContaOculta(args, enviarCopiaOcultaAoGrupo);
		
		List<String> listEmails = new ArrayList<String>();
		listEmails.addAll(Arrays.asList(emails.split(",")));
		List<String> listEmailsCopia = new ArrayList<String>();
		listEmailsCopia.addAll(Arrays.asList(emailsCopia.split(",")));
		
		
	
		args.put("listaDeDominiosPara", args.get("emailRemetente"));
		args.put("listaDeEnvioPara", args.get("emailRemetente"));
		
		args.put("destinatarios", emails);
		//--------------------------------------------------------------------------
		
		List<String> listaDelistaDeEnvioCopia = new ArrayList<String>();
		// for abaixo usado pra preencher a lista de c�pias do email
		Map<String, String> destinatariosCopia = new HashMap<String, String>();
		for(int i = 0; i < listEmailsCopia.size(); i++){
			
			if(validarEmails(listEmailsCopia.get(i))){
				
				if(emailcheck(listEmailsCopia.get(i))){
					
					String[] cadaEmail = listEmailsCopia.get(i).split("@");
					
					if(cadaEmail.length == 2){ // se quebrou, pelo menos tem "@"
						destinatariosCopia.put(listEmailsCopia.get(i), cadaEmail[0]);
						listaDelistaDeEnvioCopia.add(listEmailsCopia.get(i));
					}
					
				}
				
			}
			
		}
		args.put("listaDelistaDeEnvioCopia", listaDelistaDeEnvioCopia);
		
        args.put("destinatariosCopia", destinatariosCopia);
    
	}

	public static void configurarNomeEmailRemetenteAndContaOculta(Map<String, Object> args, boolean enviarCopiaOcultaAoGrupo) {

		args.put("emailRemetente", "reportherefaitec@gmail.com");
		args.put("nomeRemetente", "Report Here");
		args.put("senhaRemetente", "faitec13");
		args.put("emailOculto", "reportherefaitec@gmail.com"); 
				
	}
	
	public static boolean validarEmails(String email) {
		
		boolean result = true;	 
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}

		return result;
	}

	public static boolean emailcheck(String emailAddress) {
		String expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";  
		CharSequence inputStr = emailAddress;   
		Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);  
		Matcher matcher = pattern.matcher(inputStr);  
		return matcher.matches();
	}

}
