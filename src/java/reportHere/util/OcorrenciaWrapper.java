
package reportHere.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.displaytag.decorator.TableDecorator;
import reportHere.model.ServiceLocator;
import reportHere.model.dao.StatusOcorrenciaDAO;
import reportHere.model.pojo.Ocorrencia;
import reportHere.model.pojo.StatusOcorrencia;

public class OcorrenciaWrapper extends TableDecorator{
    
    public String getLinkStatus() throws Exception{
        String link = "";
        Ocorrencia ocorrencia = (Ocorrencia) getCurrentRowObject();        
        
        Map<String,Object> criteria = new HashMap<String,Object>();
        criteria.put(StatusOcorrenciaDAO.CRITERION_OCORRENCIA_EQ, ocorrencia.getId());
        
        List<StatusOcorrencia> listStatusOcorrencia = ServiceLocator.getStatusOcorrenciaService()
                .readByCriteria(criteria);
        Long status = listStatusOcorrencia.get(0).getStatus().getId();
        if(status==1){
            link = "<img src=\"imagem/amarela.png\" border=\"0\" onMouseOver=\"label(this,'Ocorrencia Recebida')\"/></a>";
        }else if(status==2){
            link = "<img src=\"imagem/blue.png\" border=\"0\" onMouseOver=\"label(this,'Ocorrencia Recebida')\"/></a>";
        }else if(status==3){
            link = "<img src=\"imagem/verde.png\" border=\"0\" onMouseOver=\"label(this,'Ocorrencia Recebida')\"/></a>";
        }
        return link;
    }
}
