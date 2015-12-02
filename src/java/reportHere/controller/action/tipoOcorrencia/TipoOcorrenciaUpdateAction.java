/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.tipoOcorrencia;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.TipoOcorrencia;

public class TipoOcorrenciaUpdateAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        Long id = input.getLong("id");
        String nome = input.getString("nome");
        TipoOcorrencia tipoOcorrencia = ServiceLocator.getTipoOcorrenciaService().readById(id);
        if (tipoOcorrencia == null) {
            addError("Nenhum tipo de ocorrencia encontrado");
        } else {
            tipoOcorrencia.setNome(nome);
            ServiceLocator.getTipoOcorrenciaService().update(tipoOcorrencia);
            consequence = SUCCESS;

        }
        return consequence;
    }
}
