/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportHere.controller.action.ocorrencia;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.Ocorrencia;
import reportHere.model.pojo.Usuario;

public class OcorrenciaExpandirAction extends BaseAction {

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        try {
            Ocorrencia ocorrencia = ServiceLocator.getOcorrenciaService().readById(input.getLong("id"));
            preloadUsuarios(ocorrencia.getId());
            mostrarUsuariosSelecionados(ocorrencia.getId());
            output.setValue("ocorrenciaExpandida", ocorrencia);
            consequence = SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consequence;
    }

    private void preloadUsuarios(Long idOcorrencia) throws Exception {
        try {
            Map<String, Object> criteria = new HashMap<String, Object>();
            List<Usuario> lista = ServiceLocator.getUsuarioService().filtrarUsuarios(idOcorrencia);

            Map<Long, Object> listaUsuario = new LinkedHashMap<Long, Object>();
            for (Usuario usuario : lista) {
                if(usuario.getTipoUsuario().getId() != 1){
                listaUsuario.put(usuario.getId(), usuario.getNome());
                }
            }
            output.setValue("listaUsuario", listaUsuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarUsuariosSelecionados(Long id)throws Exception {

        List<Usuario> listaUsuario = ServiceLocator.getUsuarioService().mostrarUsuarios(id);
        output.setValue("usuarios", listaUsuario);
    }
}
 