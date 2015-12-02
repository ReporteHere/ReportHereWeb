/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportHere.controller.action.perfil;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.Perfil;

public class PerfilUpdateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        Long id = input.getLong("id");
        String nome = input.getString("nome");
        Perfil perfil = ServiceLocator.getPerfilService().readById(id);
        if (perfil == null) {
            addError("Nenhum perfil encontrado");
        } else {
            perfil.setNome(nome);
            ServiceLocator.getPerfilService().update(perfil);
            consequence = SUCCESS;

        }

        return consequence;
    }
}
