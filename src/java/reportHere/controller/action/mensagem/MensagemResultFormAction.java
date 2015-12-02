/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.mensagem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;
import reportHere.model.dao.MensagemDAO;
import reportHere.model.pojo.Mensagem;


public class MensagemResultFormAction extends BaseAction{

    @Override
    public String execute() throws Exception {

        Long id = input.getLong("id");

        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put(MensagemDAO.CRITERION_OCORRENCIA_ID, id);

        List<Mensagem> listMensagem = new ArrayList<Mensagem>();
        listMensagem = ServiceLocator.getMensagemService().readByCriteria(criteria);

        output.setValue("listMensagem", listMensagem);

        return SUCCESS;
    }


}
