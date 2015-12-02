/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.tipoUsuario;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.TipoUsuario;

public class TipoUsuarioUpdateAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        Long id = input.getLong("id");
        String nome = input.getString("nome");
        TipoUsuario tipoUsuario = ServiceLocator.getTipoUsuarioService().readById(id);
        if (tipoUsuario == null) {
            addError("Nenhum Tipo de Usuario encontrado");
        } else {
            tipoUsuario.setNome(nome);
            ServiceLocator.getTipoUsuarioService().update(tipoUsuario);
            consequence = SUCCESS;
        }

        return consequence;
    }
}
