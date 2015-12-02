/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.ocorrencia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.Status;

public class OcorrenciaLoginAction extends BaseAction{
     @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        Long protocolo = input.getLong("protocolo");
        String senha = input.getString("senha");
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put("protocolo", protocolo);
        criteria.put("senha", senha);

        List<Map<String,Object>> listMap = ServiceLocator.getOcorrenciaService().readByStatusOcorrencia(criteria);
      
        if(listMap.size()>0){
            output.setValue("listOcorrencia", listMap);
            output.setValue("id", listMap.get(0).get("id"));
            consequence = SUCCESS;
        }else{
            addError("Protocolo ou Senha Inválidos");
        }
        return consequence;
    }
}
