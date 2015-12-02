/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.tipoOcorrencia;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.TipoOcorrencia;

public class TipoOcorrenciaShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {

        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            TipoOcorrencia tipoOcorrencia = new TipoOcorrencia();
            tipoOcorrencia = ServiceLocator.getTipoOcorrenciaService().readById(id);
            output.setValue("tipoOcorrencia", tipoOcorrencia);
            consequence = "UPDATE";
        }
        return consequence;
    }

}
