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
import reportHere.model.pojo.Usuario;


public class EncaminharOcorrenciaAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        Usuario usuario = new Usuario();
        usuario.setId(input.getLong("usuario.id"));
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setId(input.getLong("ocorrenciaExtendida.id"));
        //setando na session o id da ocorrencia para criar o status caminhamento
        session.setAttribute("idOcorrencia", input.getLong("ocorrenciaExtendida.id"));
        DepartamentoOcorrencia departamentoOcorrencia = new DepartamentoOcorrencia();
        departamentoOcorrencia.setOcorrencia(ocorrencia);
        departamentoOcorrencia.setUsuario(usuario);
        ServiceLocator.getDepartamentoOcorrenciaService().create(departamentoOcorrencia);

        Mensagem msg = new Mensagem();
        msg.setDescricao(input.getString("mensagem"));
        msg.setOcorrencia(ocorrencia);
        msg.setTipo("ov");

        ServiceLocator.getMensagemService().create(msg);

        consequence = SUCCESS;
        return consequence;
    }
}
