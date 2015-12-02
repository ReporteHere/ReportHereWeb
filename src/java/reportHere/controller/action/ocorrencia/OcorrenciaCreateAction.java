/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportHere.controller.action.ocorrencia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.Ocorrencia;
import reportHere.model.pojo.Perfil;
import reportHere.model.pojo.TipoOcorrencia;
import reportHere.util.EmailUtil;

public class OcorrenciaCreateAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("ddMMyyyyHHmmss");

        String tipoUsuario = input.getString("anonimo");
        Ocorrencia ocorrencia = new Ocorrencia();

        if(tipoUsuario.equals("sim")){
            ocorrencia.setAnonimo(true);
        }else{
            ocorrencia.setAnonimo(false);
        }
        ocorrencia.setNome(input.getString("nome"));
        ocorrencia.setAssunto(input.getString("assunto"));
        ocorrencia.setDescricao(input.getString("descricao"));
        ocorrencia.setEmail(input.getString("email"));

        String aux = formatador.format(data);
        ocorrencia.setProtocolo((System.currentTimeMillis())/6);
        ocorrencia.setSenha(aux.toString());
        Perfil perfil = ServiceLocator.getPerfilService().readById(input.getLong("perfil.id"));
        TipoOcorrencia tipoOcorrencia = ServiceLocator.getTipoOcorrenciaService().readById(input.getLong("tipoOcorrencia.id"));
        ocorrencia.setPerfil(perfil);
        ocorrencia.setTipoOcorrencia(tipoOcorrencia);
        ServiceLocator.getOcorrenciaService().create(ocorrencia);
        session.setAttribute("ocorrenciaCriada", ocorrencia.getId());
        consequence = SUCCESS;

         Map<String, Object> mapaOcorrencia = new HashMap<String, Object>();
        mapaOcorrencia.put("email", ocorrencia.getEmail());
        mapaOcorrencia.put("assunto", ocorrencia.getAssunto());
        mapaOcorrencia.put("senha", ocorrencia.getSenha());
        mapaOcorrencia.put("protocolo", ocorrencia.getProtocolo());
        mapaOcorrencia.put("descricao", ocorrencia.getDescricao());
        mapaOcorrencia.put("nome", ocorrencia.getNome());
        mapaOcorrencia.put("tipoRelator", ocorrencia.getPerfil().getNome());
        mapaOcorrencia.put("tipoOcorrencia", ocorrencia.getTipoOcorrencia().getNome());
        
        EmailUtil eu = new EmailUtil();
        eu.informar(mapaOcorrencia);

        
        return consequence;
    }
    
}
