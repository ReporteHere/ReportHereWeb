/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportHere.controller.action.ocorrencia;

import javax.sql.rowset.serial.SerialArray;
import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.Ocorrencia;
import reportHere.model.pojo.Status;
import reportHere.model.pojo.StatusOcorrencia;

public class FinalizarPorNaoConformidadeAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        
        
        String consequence = ERROR;
        Long idOcorrencia = input.getLong("idOcorrencia");
        Ocorrencia ocorrenciaAtual = new Ocorrencia();
        ocorrenciaAtual = ServiceLocator.getOcorrenciaService().readById(idOcorrencia);
        Status atualStatus = new Status();
        atualStatus = ServiceLocator.getStatusService().readById(new Long(5));
        
        ServiceLocator.getOcorrenciaService().update(ocorrenciaAtual);
        StatusOcorrencia novoStatusOcorrencia = new StatusOcorrencia();
        novoStatusOcorrencia.setOcorrencia(ocorrenciaAtual);
        novoStatusOcorrencia.setStatus(atualStatus);
        ServiceLocator.getStatusOcorrenciaService().create(novoStatusOcorrencia);
        consequence = SUCCESS;
        
        return consequence;
    } 
}
