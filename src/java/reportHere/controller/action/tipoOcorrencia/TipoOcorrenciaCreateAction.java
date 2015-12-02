/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.tipoOcorrencia;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.TipoOcorrencia;

public class TipoOcorrenciaCreateAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        String nome = input.getString("nome");
        if(nome.equals("")){
           addError("Favor Preencher o campo.");
        }else{
            TipoOcorrencia tipoOcorrencia = new TipoOcorrencia();
            tipoOcorrencia.setNome(nome);
            ServiceLocator.getTipoOcorrenciaService().create(tipoOcorrencia);
            consequence = SUCCESS;
        }
        return consequence;

    }
}
