/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.ocorrencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.dao.OcorrenciaDAO;
import reportHere.model.dao.StatusOcorrenciaDAO;
import reportHere.model.pojo.Ocorrencia;
import reportHere.model.pojo.StatusOcorrencia;
import reportHere.model.pojo.Usuario;

public class OcorrenciaReadAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        
        String consequence = ERROR;
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        Map<String,Object> criteria = new HashMap<String, Object>();
        
        if(usuario.getId()==1){
            List<Ocorrencia> listOcorrencia = ServiceLocator.getOcorrenciaService().readByCriteria(criteria);
             List<Map<String,Object>> listMap = new ArrayList<Map<String, Object>>();
            
            for (int i = 0; i<listOcorrencia.size(); i++) {
                Ocorrencia o = listOcorrencia.get(i);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("protocolo", o.getProtocolo());
                map.put("nome", o.getNome());
                map.put("assunto", o.getAssunto());
                
        Map<String,Object> criteriaParametros = new HashMap<String,Object>();
        Long idOcorrencia = o.getId();
        criteriaParametros.put(StatusOcorrenciaDAO.CRITERION_OCORRENCIA_EQ, idOcorrencia);
        
        List<StatusOcorrencia> listStatusOcorrencia = ServiceLocator.getStatusOcorrenciaService()
                .readByCriteria(criteriaParametros);
        Long status = listStatusOcorrencia.get(0).getStatus().getId();
        if(status==1){
            map.put("status","&nbsp;&nbsp;<img src=\"imagem/preto.png\" width=\"10px\" height=\"10px\" border=\"0\" onMouseOver=\"label(this,'Ocorrencia Recebida')\"/></a>");
            map.put("visualizar", "<a href='OcorrenciaExpandir.mtw?id="+o.getId()+"'><img src='../../imagem/view.png' /></a>");
        }else if(status==2){
            map.put("visualizar", "<a href='OcorrenciaExpandir.mtw?id="+o.getId()+"'><img src='../../imagem/view.png' /></a>");
            map.put("status","&nbsp;&nbsp;<img src=\"imagem/amarela.png\" border=\"0\" onMouseOver=\"label(this,'Ocorrencia Recebida')\"/></a>");
        }else if(status==3){
            map.put("status","&nbsp;&nbsp;<img src=\"imagem/blue.png\" border=\"0\" onMouseOver=\"label(this,'Ocorrencia Recebida')\"/></a>");
            map.put("visualizar", "&nbsp;<a href='VisualizarRespostaDoDepartamento.mtw?id="+o.getId()+"'><img width=\"32px\" height=\"32px\" src='../../imagem/check.png' /></a>");
        } else if(status==4){
            map.put("status","&nbsp;&nbsp;<img src=\"imagem/verde.png\" border=\"0\" onMouseOver=\"label(this,'Ocorrencia Recebida')\"/></a>");
            map.put("visualizar", "&nbsp;<a href='MensagemResultForm.mtw?id="+o.getId()+"'><img width=\"32px\" height=\"32px\" src='../../imagem/apenasvisualizar.png' /></a>");
        }else{
            map.put("status","&nbsp;&nbsp;<img src=\"imagem/red.png\" border=\"0\" onMouseOver=\"label(this,'Ocorrencia Recebida')\"/></a>");
            map.put("visualizar", "");
        }
        map.put("id", o.getId());
         listMap.add(map);       
                 
                
            }
            
            output.setValue("lista", listMap);
            output.setValue("usuario", usuario);
            consequence = "OUVIDOR";
        }
        else{
            criteria.put(OcorrenciaDAO.CRITERION_USUARIO_EQ,usuario.getId());
            List<Ocorrencia> lista = ServiceLocator.getOcorrenciaService().readByCriteraEncaminhamento(criteria);
            
           
            
            output.setValue("lista", lista);
            output.setValue("usuario", usuario);
            consequence = "DEPARTAMENTO";
        }

        return consequence;

    }

}
