/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.usuario;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;

public class UsuarioDeleteAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        Long id = input.getLong("id");
        if(id != null && id >0){
            ServiceLocator.getUsuarioService().delete(id);
            consequence = SUCCESS;
        }
        return consequence;
    }
}

