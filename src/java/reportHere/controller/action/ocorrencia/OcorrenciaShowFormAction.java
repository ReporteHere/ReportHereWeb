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
import reportHere.model.pojo.Perfil;
import reportHere.model.pojo.TipoOcorrencia;

public class OcorrenciaShowFormAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        
        preLoadPerfil();
        preLoadTipoOcorrencia();
        return SUCCESS;
    }

    private void preLoadPerfil() throws Exception {
        Map<String,Object> criteria = new HashMap<String, Object>();
        List<Perfil> lista = ServiceLocator.getPerfilService().readByCriteria(criteria);
        Map<Long,Object> listaPerfis = new LinkedHashMap<Long, Object>();
        for (Perfil perfil : lista) {
            listaPerfis.put(perfil.getId(), perfil.getNome());
        }
        output.setValue("listaPerfis", listaPerfis);
    }

    private void preLoadTipoOcorrencia() throws Exception {
        Map<String,Object> criteria = new HashMap<String, Object>();
        List<TipoOcorrencia> lista = ServiceLocator.getTipoOcorrenciaService().readByCriteria(criteria);
        Map<Long,Object> listaTipoOcorrencia = new LinkedHashMap<Long, Object>();
        for (TipoOcorrencia tipoOcorrencia : lista) {
            listaTipoOcorrencia.put(tipoOcorrencia.getId(), tipoOcorrencia.getNome());
        }
        output.setValue("listaTiposOcorrencia", listaTipoOcorrencia);
    }
    
}
