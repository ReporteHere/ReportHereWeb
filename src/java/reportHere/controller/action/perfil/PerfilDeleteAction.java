/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.perfil;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;

public class PerfilDeleteAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        Long id = input.getLong("id");
        if(id != null && id >0){
            ServiceLocator.getPerfilService().delete(id);
            consequence = SUCCESS;
        }
        return consequence;
    }


}
