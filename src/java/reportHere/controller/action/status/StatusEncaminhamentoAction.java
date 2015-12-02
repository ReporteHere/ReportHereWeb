/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.status;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.Ocorrencia;
import reportHere.model.pojo.Status;
import reportHere.model.pojo.StatusOcorrencia;

public class StatusEncaminhamentoAction extends BaseAction{

    @Override
    public String execute() throws Exception {


        String consequence = ERROR;
        Status status = ServiceLocator.getStatusService().readById(new Long(2));
        //pegando da session o id da ocorrencia
        Long idOcorrencia = (Long)session.getAttribute("idOcorrencia");
        //limpando a session
        session.removeAttribute("idOcorrencia");
        Ocorrencia ocorrencia = ServiceLocator.getOcorrenciaService().readById(idOcorrencia);
        if(status.getId() == 2 && ocorrencia != null){
            StatusOcorrencia statusOcorrencia = new StatusOcorrencia();
            statusOcorrencia.setOcorrencia(ocorrencia);
            statusOcorrencia.setStatus(status);
            ServiceLocator.getStatusOcorrenciaService().create(statusOcorrencia);
            consequence = SUCCESS;

        }
        return consequence;
    }
}
