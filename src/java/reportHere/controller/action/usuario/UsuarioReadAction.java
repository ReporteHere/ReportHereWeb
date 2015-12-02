/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.dao.UsuarioDAO;
import reportHere.model.pojo.TipoUsuario;
import reportHere.model.pojo.Usuario;

public class UsuarioReadAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        
        String nome = input.getString("nome");
        Map<String,Object> criteria = new HashMap<String, Object>();
        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        if(nome == null){
            listaUsuario = ServiceLocator.getUsuarioService().readByCriteria(criteria);
        }
        else{
            criteria.put(UsuarioDAO.CRITERION_NOME_I_LIKE, nome);
            listaUsuario = ServiceLocator.getUsuarioService().readByCriteria(criteria);
        }
        output.setValue("listaUsuario", listaUsuario);
         preLoadTipoUsuario();
         return SUCCESS;
    }
    
    private void preLoadTipoUsuario() throws Exception {

        Map<String,Object> criteria = new HashMap<String, Object>();
        List<TipoUsuario> lista = ServiceLocator.getTipoUsuarioService().readByCriteria(criteria);
        Map<Long,Object> listaTipoUsuario = new LinkedHashMap<Long, Object>();
        for (TipoUsuario tipoUsuario: lista) {
            if(tipoUsuario.getId()!= 1){
                listaTipoUsuario.put(tipoUsuario.getId(), tipoUsuario.getNome());
            }
        }
        output.setValue("listaTipoUsuario", listaTipoUsuario);
    }

    
}
