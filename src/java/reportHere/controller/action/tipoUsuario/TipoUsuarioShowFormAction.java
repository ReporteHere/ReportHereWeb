/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.tipoUsuario;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.TipoUsuario;

public class TipoUsuarioShowFormAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario = ServiceLocator.getTipoUsuarioService().readById(id);
            output.setValue("tipoUsuario", tipoUsuario);
            consequence = "UPDATE";
        }
        return consequence;
    }
}
