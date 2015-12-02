/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.perfil;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.Perfil;


public class PerfilCreateAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        String nome = input.getString("nome");
        if(nome.equals("")){
           addError("Favor Preencher o campo.");
        }else{
            Perfil perfil = new Perfil();
            perfil.setNome(nome);     
            ServiceLocator.getPerfilService().create(perfil);
            consequence = SUCCESS;
        }
        return consequence;
    }



}
