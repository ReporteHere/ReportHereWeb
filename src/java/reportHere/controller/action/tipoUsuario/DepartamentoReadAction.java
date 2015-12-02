
package reportHere.controller.action.tipoUsuario;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.TipoUsuario;
import reportHere.model.pojo.Usuario;


public class DepartamentoReadAction extends BaseAction{
     @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        preloadTipoUsuarios();
        return consequence;
     }
     private void preloadTipoUsuarios() throws Exception {
        try {
            Map<String, Object> criteria = new HashMap<String, Object>();
            List<TipoUsuario> lista = ServiceLocator.getTipoUsuarioService().readByCriteria(criteria);
            Map<Long, Object> map = new HashMap<Long, Object>();
            for (TipoUsuario tu : lista) {  
                if(tu.getId()!=1){
                    map.put(tu.getId(), tu.getNome());
                }
                
            }            
            output.setValue("map", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
