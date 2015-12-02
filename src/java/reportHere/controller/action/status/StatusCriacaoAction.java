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

public class StatusCriacaoAction extends BaseAction{

    @Override
    public String execute() throws Exception {


        String consequence = ERROR;
        Long idOcorrencia = (Long)session.getAttribute("ocorrenciaCriada");
        session.removeAttribute("ocorrenciaCriada");
        Ocorrencia ocorrencia = ServiceLocator.getOcorrenciaService().readById(idOcorrencia);
        Status status = ServiceLocator.getStatusService().readById(new Long(1));
        if(ocorrencia.getId()!= null && status.getId() == 1){
            StatusOcorrencia statusOcorrencia = new StatusOcorrencia();
            statusOcorrencia.setOcorrencia(ocorrencia);
            statusOcorrencia.setStatus(status);
            ServiceLocator.getStatusOcorrenciaService().create(statusOcorrencia);
            consequence = SUCCESS;
        }
        return consequence;
    }
}
