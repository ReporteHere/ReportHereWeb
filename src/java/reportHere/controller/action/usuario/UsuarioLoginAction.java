/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.usuario;

import org.mentawai.action.BaseLoginAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.Usuario;

public class UsuarioLoginAction extends BaseLoginAction{

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        String login = input.getString("login");
        String senha = input.getString("senha");

        Usuario usuarioLogado = ServiceLocator.getUsuarioService().login(login, senha);
        if(usuarioLogado != null){
            setSessionObj(usuarioLogado);
            session.setAttribute("usuarioLogado", usuarioLogado);
            consequence = SUCCESS;
        }
        return consequence;
    }
}
