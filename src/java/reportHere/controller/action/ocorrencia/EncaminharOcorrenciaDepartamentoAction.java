/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.ocorrencia;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.pojo.DepartamentoOcorrencia;
import reportHere.model.pojo.Mensagem;
import reportHere.model.pojo.Ocorrencia;
import reportHere.model.pojo.Status;
import reportHere.model.pojo.StatusOcorrencia;
import reportHere.model.pojo.Usuario;

public class EncaminharOcorrenciaDepartamentoAction extends BaseAction{

        @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");


        Long idOcorrencia = input.getLong("ocorrenciaExtendida.id");

        Ocorrencia ocorrencia = ServiceLocator.getOcorrenciaService().readById(idOcorrencia);

        Mensagem msg = new Mensagem();
        msg.setDescricao(input.getString("mensagem"));
        msg.setOcorrencia(ocorrencia);
        msg.setTipo("dp");
        ServiceLocator.getMensagemService().create(msg);

        Status s = new Status();
        Long intStatus = new Long("3");
        s = ServiceLocator.getStatusService().readById(intStatus);

        StatusOcorrencia so = new StatusOcorrencia();
        so.setOcorrencia(ocorrencia);
        so.setStatus(s);
        ServiceLocator.getStatusOcorrenciaService().create(so);

        consequence = SUCCESS;
        return consequence;
    }
}
