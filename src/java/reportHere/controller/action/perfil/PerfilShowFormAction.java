/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportHere.controller.action.perfil;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.Perfil;

public class PerfilShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            Perfil perfil = new Perfil();
            perfil = ServiceLocator.getPerfilService().readById(id);
            output.setValue("perfil", perfil);
            consequence = "UPDATE";
        }
        return consequence;
    }
}
