/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.tipoOcorrencia;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;


public class TipoOcorrenciaDeleteAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        Long id = input.getLong("id");
        if(id != null && id >0){
            ServiceLocator.getTipoOcorrenciaService().delete(id);
            consequence = SUCCESS;
        }
        return consequence;
    }

}
