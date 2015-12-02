/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.tipoUsuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.dao.TipoUsuarioDAO;
import reportHere.model.pojo.TipoUsuario;

public class TipoUsuarioReadAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        String nome = input.getString("nome");
        String consequence = ERROR;
        Map<String, Object> criteria = new HashMap<String, Object>();
        try {
            if(nome == null){
                List<TipoUsuario> listTiposUsuario = ServiceLocator.getTipoUsuarioService().readByCriteria(criteria);
                output.setValue("listTipoUsuario", listTiposUsuario);
                consequence = SUCCESS;
            }else{
                criteria.put(TipoUsuarioDAO.CRITERION_NOME_I_LIKE, nome);
                List<TipoUsuario> listTiposUsuario = ServiceLocator.getTipoUsuarioService().readByCriteria(criteria);
                output.setValue("listTipoUsuario", listTiposUsuario);
                consequence = SUCCESS;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return consequence;
    }
}
