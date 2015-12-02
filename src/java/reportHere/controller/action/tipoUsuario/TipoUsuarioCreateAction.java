/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.tipoUsuario;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.TipoUsuario;

public class TipoUsuarioCreateAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        String nome = input.getString("nome");
        if(nome.equals("")){
           addError("Favor Preencher o campo.");
        }else{
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setNome(nome);
            ServiceLocator.getTipoUsuarioService().create(tipoUsuario);
            consequence = SUCCESS;
        }
        return consequence;
    }



}
