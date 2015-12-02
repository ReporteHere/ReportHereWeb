/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.usuario;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.TipoUsuario;
import reportHere.model.pojo.Usuario;

public class UsuarioShowFormAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        String consequence = "CREATE";
        Long id = input.getLong("id");
        if(id != null && id > 0){
            consequence = "UPDATE";
            Usuario usuario = ServiceLocator.getUsuarioService().readById(id);
            output.setValue("usuario", usuario);
        }
        preLoadTipoUsuario();
        return consequence;
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
