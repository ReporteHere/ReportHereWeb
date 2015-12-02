/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.usuario;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.TipoUsuario;
import reportHere.model.pojo.Usuario;

public class UsuarioUpdateAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        Long id = input.getLong("id");
        String nome = input.getString("nome");
        String senha = input.getString("senha");
        String login = input.getString("login");
        TipoUsuario tipo = ServiceLocator.getTipoUsuarioService().readById(input.getLong("usuario.tipoUsuario.id"));
        Usuario usuario = ServiceLocator.getUsuarioService().readById(id);
        if (usuario == null) {
            addError("Nenhum TIPO encontrado");
        } else {
            usuario.setNome(nome);
            usuario.setSenha(senha);
            usuario.setLogin(login);
            usuario.setTipoUsuario(tipo);
            ServiceLocator.getUsuarioService().update(usuario);
            consequence = SUCCESS;

        }
        return consequence;
    }
}
