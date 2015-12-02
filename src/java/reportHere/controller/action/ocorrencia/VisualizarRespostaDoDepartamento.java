/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportHere.controller.action.ocorrencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.dao.MensagemDAO;
import reportHere.model.pojo.Mensagem;
import reportHere.model.pojo.Ocorrencia;

public class VisualizarRespostaDoDepartamento extends BaseAction{

    @Override
    public String execute() throws Exception {
        
        String consenquece = ERROR;
        Long idOcorrencia = input.getLong("id");
        Ocorrencia ocorrenciaAtual = new Ocorrencia();
        ocorrenciaAtual = ServiceLocator.getOcorrenciaService().readById(idOcorrencia);
        
        Map<String,Object> criteria = new HashMap<String,Object>();
        criteria.put(MensagemDAO.CRITERION_OCORRENCIA_ID, idOcorrencia);
        criteria.put(MensagemDAO.CRITERION_TIPO_DIFER, "dp");
             
        List<Mensagem> listaMsg = new ArrayList<Mensagem>();
        listaMsg = ServiceLocator.getMensagemService().readByCriteria(criteria);
        
        output.setValue("ocorrenciaRespondida", ocorrenciaAtual);
        output.setValue("mensagemDepartamento", listaMsg.get(0));
        
        consenquece = SUCCESS;
        return consenquece;
    }
}
