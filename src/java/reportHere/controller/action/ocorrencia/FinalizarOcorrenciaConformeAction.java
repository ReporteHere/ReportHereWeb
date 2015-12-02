/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportHere.controller.action.ocorrencia;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.Ocorrencia;
import reportHere.model.pojo.Status;
import reportHere.model.pojo.StatusOcorrencia;

public class FinalizarOcorrenciaConformeAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        
        String consequence = ERROR;
        Long idOcorrencia = input.getLong("ocorrenciaRespondida.id");
        Ocorrencia ocorrenciaAtual = new Ocorrencia();
        ocorrenciaAtual = ServiceLocator.getOcorrenciaService().readById(idOcorrencia);
        ServiceLocator.getOcorrenciaService().update(ocorrenciaAtual);
        
        Status statusAtual = new Status();
        statusAtual = ServiceLocator.getStatusService().readById(new Long(4));
        StatusOcorrencia so = new StatusOcorrencia();
        so.setOcorrencia(ocorrenciaAtual);
        so.setStatus(statusAtual);
        ServiceLocator.getStatusOcorrenciaService().create(so);
        consequence = SUCCESS;
        
        return consequence;
    }
}
