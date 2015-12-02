/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.ocorrencia;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.Ocorrencia;

public class OcorrenciaExpandirDepartamentoAction extends BaseAction {
     @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        try {
            Ocorrencia ocorrencia = ServiceLocator.getOcorrenciaService().readById(input.getLong("id"));
            
            output.setValue("ocorrenciaExpandida", ocorrencia);
            consequence = SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consequence;
    }
}
