/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.tipoOcorrencia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.dao.TipoOcorrenciaDAO;
import reportHere.model.pojo.TipoOcorrencia;

public class TipoOcorrenciaReadAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        String nome = input.getString("nome");
        String consequence = ERROR;
        Map<String, Object> criteria = new HashMap<String, Object>();
        try {
            if(nome == null){
                List<TipoOcorrencia> listaTipoOcorrencia = ServiceLocator.getTipoOcorrenciaService().readByCriteria(criteria);
                output.setValue("listaTipoOcorrencia", listaTipoOcorrencia);
                consequence = SUCCESS;
            }else{
                criteria.put(TipoOcorrenciaDAO.CRITERION_NOME_I_LIKE, nome);
                List<TipoOcorrencia> listaTipoOcorrencia = ServiceLocator.getTipoOcorrenciaService().readByCriteria(criteria);
                output.setValue("listaTipoOcorrencia", listaTipoOcorrencia);
                consequence = SUCCESS;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return consequence;

    }
}
