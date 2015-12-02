/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportHere.controller.action.perfil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.dao.PerfilDAO;
import reportHere.model.pojo.Perfil;

public class PerfilReadAction extends BaseAction {

    @Override
    public String execute() throws Exception {

        String nome = input.getString("nome");
        String consequence = ERROR;
        Map<String, Object> criteria = new HashMap<String, Object>();
        try {
            if(nome == null){
                List<Perfil> listPerfis = ServiceLocator.getPerfilService().readByCriteria(criteria);
                output.setValue("listaPerfis", listPerfis);
                consequence = SUCCESS;    
            }else{
                criteria.put(PerfilDAO.CRITERION_NOME_I_LIKE, nome);
                List<Perfil> listPerfis = ServiceLocator.getPerfilService().readByCriteria(criteria);
                output.setValue("listaPerfis", listPerfis);
                consequence = SUCCESS;    
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return consequence;
    }
}
