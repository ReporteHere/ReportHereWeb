/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.usuario;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.TipoUsuario;
import reportHere.model.pojo.Usuario;

public class UsuarioCreateAction extends BaseAction{

    @Override
    public String execute() throws Exception {

      String consequence = SUCCESS;

      Usuario usuario = new Usuario();
      usuario.setLogin(input.getString("login"));
      usuario.setSenha(input.getString("senha"));
      usuario.setNome(input.getString("nome"));
      TipoUsuario tipoUsuario = ServiceLocator.getTipoUsuarioService().readById(input.getLong("tipoUsuario.id"));
      usuario.setTipoUsuario(tipoUsuario);
      ServiceLocator.getUsuarioService().create(usuario);
      
       return consequence;
    }
}
