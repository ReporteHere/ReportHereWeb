/*
 * To change this template, choose Tools | Templates
 * and open the template in tFinalizarOcorrenciaConformeAction
 * he editor.
 */
package reportHere.controller;

import org.mentawai.action.LogoutAction;
import org.mentawai.core.ActionConfig;
import org.mentawai.core.ApplicationManager;
import static org.mentawai.core.ApplicationManager.ERROR;
import static org.mentawai.core.ApplicationManager.SUCCESS;
import org.mentawai.core.Forward;
import org.mentawai.core.Redirect;
import org.mentawai.core.StreamConsequence;
import reportHere.controller.action.mensagem.MensagemResultFormAction;
import reportHere.controller.action.ocorrencia.ConsultaOcorrenciaShowFormAction;
import reportHere.controller.action.ocorrencia.EncaminharOcorrenciaAction;
import reportHere.controller.action.ocorrencia.EncaminharOcorrenciaDepartamentoAction;
import reportHere.controller.action.ocorrencia.FinalizarOcorrenciaConformeAction;
import reportHere.controller.action.ocorrencia.FinalizarPorNaoConformidadeAction;
import reportHere.controller.action.ocorrencia.OcorrenciaCreateAction;
import reportHere.controller.action.ocorrencia.OcorrenciaDepartamentoGraficoAction;
import reportHere.controller.action.ocorrencia.OcorrenciaExpandirAction;
import reportHere.controller.action.ocorrencia.OcorrenciaExpandirDepartamentoAction;
import reportHere.controller.action.ocorrencia.OcorrenciaGraficoAction;
import reportHere.controller.action.ocorrencia.OcorrenciaLoginAction;
import reportHere.controller.action.ocorrencia.OcorrenciaReadAction;
import reportHere.controller.action.ocorrencia.OcorrenciaShowFormAction;
import reportHere.controller.action.ocorrencia.RelatorioChamadosAction;
import reportHere.controller.action.ocorrencia.RelatorioChamadosDepartamentoAction;
import reportHere.controller.action.ocorrencia.VisualizarRespostaDoDepartamento;
import reportHere.controller.action.perfil.PerfilCreateAction;
import reportHere.controller.action.perfil.PerfilDeleteAction;
import reportHere.controller.action.perfil.PerfilReadAction;
import reportHere.controller.action.perfil.PerfilShowFormAction;
import reportHere.controller.action.perfil.PerfilUpdateAction;
import reportHere.controller.action.status.StatusCriacaoAction;
import reportHere.controller.action.status.StatusEncaminhamentoAction;
import reportHere.controller.action.tipoOcorrencia.TipoOcorrenciaCreateAction;
import reportHere.controller.action.tipoOcorrencia.TipoOcorrenciaDeleteAction;
import reportHere.controller.action.tipoOcorrencia.TipoOcorrenciaReadAction;
import reportHere.controller.action.tipoOcorrencia.TipoOcorrenciaShowFormAction;
import reportHere.controller.action.tipoOcorrencia.TipoOcorrenciaUpdateAction;
import reportHere.controller.action.tipoUsuario.DepartamentoReadAction;
import reportHere.controller.action.tipoUsuario.TipoUsuarioCreateAction;
import reportHere.controller.action.tipoUsuario.TipoUsuarioDeleteAction;
import reportHere.controller.action.tipoUsuario.TipoUsuarioReadAction;
import reportHere.controller.action.tipoUsuario.TipoUsuarioShowFormAction;
import reportHere.controller.action.tipoUsuario.TipoUsuarioUpdateAction;
import reportHere.controller.action.usuario.UsuarioCreateAction;
import reportHere.controller.action.usuario.UsuarioDeleteAction;
import reportHere.controller.action.usuario.UsuarioLoginAction;
import reportHere.controller.action.usuario.UsuarioLoginShowFormAction;
import reportHere.controller.action.usuario.UsuarioReadAction;
import reportHere.controller.action.usuario.UsuarioShowFormAction;
import reportHere.controller.action.usuario.UsuarioUpdateAction;

public class AppManager extends ApplicationManager {

    @Override
    public void loadActions() {

        ActionConfig ac = null;

        //AUTENTICAÇÃO
        ac = new ActionConfig("UsuarioLoginShowForm", UsuarioLoginShowFormAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/usuario/usuarioLogin.page"));
        this.add(ac);

        ac = new ActionConfig("UsuarioLogin", UsuarioLoginAction.class);
        ac.addConsequence(SUCCESS, new Forward("OcorrenciaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/usuario/usuarioLogin.page"));
        this.add(ac);

        ac = new ActionConfig("UsuarioLogout", LogoutAction.class);
        ac.addConsequence(SUCCESS, new Forward("index.page"));
        this.add(ac);

        //PERFIL SHOW FORM
        ac = new ActionConfig("PerfilShowForm", PerfilShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/perfil/formCreatePerfil.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/perfil/formUpdatePerfil.page"));
        this.add(ac);

        //PERFIL CREATE
        ac = new ActionConfig("PerfilCreate", PerfilCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("PerfilRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/perfil/formCreatePerfil.page"));
        this.add(ac);

        //PERFIL READ
        ac = new ActionConfig("PerfilRead", PerfilReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/perfil/listPerfil.page"));
        ac.addConsequence(ERROR, new Forward("jsp/perfil/listPerfil.page"));
        this.add(ac);

        //PERFIL DELETE
        ac = new ActionConfig("PerfilDelete", PerfilDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("PerfilRead.mtw"));
        ac.addConsequence(ERROR, new Forward("PerfilRead.mtw"));
        this.add(ac);

        //PERFIL UPDATE
        ac = new ActionConfig("PerfilUpdate", PerfilUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("PerfilRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/perfil/formUpdatePerfil.page"));
        this.add(ac);


        //TIPO OCORRENCIA SHOW FORM
        ac = new ActionConfig("TipoOcorrenciaShowForm", TipoOcorrenciaShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/tipoOcorrencia/formCreateTipoOcorrencia.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/tipoOcorrencia/formUpdateTipoOcorrencia.page"));
        this.add(ac);


        //TIPO OCORRENCIA CREATE
        ac = new ActionConfig("TipoOcorrenciaCreate", TipoOcorrenciaCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoOcorrenciaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoOcorrencia/formCreateTipoOcorrencia.page"));
        this.add(ac);

        //TIPO OCORRENCIA READ
        ac = new ActionConfig("TipoOcorrenciaRead", TipoOcorrenciaReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/tipoOcorrencia/listTipoOcorrencia.page"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoOcorrencia/listTipoOcorrencia.page"));
        this.add(ac);

        //TIPO OCORRENCIA DELETE
        ac = new ActionConfig("TipoOcorrenciaDelete", TipoOcorrenciaDeleteAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoOcorrenciaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("TipoOcorrenciaRead.mtw"));
        this.add(ac);

        //TIPO OCORRENCIA UPDATE
        ac = new ActionConfig("TipoOcorrenciaUpdate", TipoOcorrenciaUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoOcorrenciaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoOcorrencia/formUpdateTipoOcorrencia.page"));
        this.add(ac);

        //OCORRENCIA SHOW FORM
        ac = new ActionConfig("OcorrenciaShowForm", OcorrenciaShowFormAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/ocorrencia/formCreateOcorrencia.page"));
        this.add(ac);

        //OCORRENCIA CREATE
        ac = new ActionConfig("OcorrenciaCreate", OcorrenciaCreateAction.class);
        ac.addConsequence(SUCCESS, new Forward("StatusCriacao.mtw"));
        ac.addConsequence(ERROR, new Forward("OcorrenciaShowForm.mtw"));
        this.add(ac);

        //OCORRENCIA READ
        ac = new ActionConfig("OcorrenciaRead", OcorrenciaReadAction.class);
        ac.addConsequence("OUVIDOR", new Forward("jsp/ocorrencia/listOcorrencia.page"));
        ac.addConsequence("DEPARTAMENTO", new Forward("jsp/ocorrencia/listOcorrenciaDepartamento.page"));
        ac.addConsequence(ERROR, new Forward("OcorrenciaShowForm.mtw"));
        this.add(ac);

        //OCORRENCIA EXPANDIR 
        ac = new ActionConfig("OcorrenciaExpandir", OcorrenciaExpandirAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/ocorrencia/formOcorrenciaExpandida.page"));
        ac.addConsequence(ERROR, new Redirect("OcorrenciaRead.mtw"));
        this.add(ac);

        //OCORRENCIA ENCAMINHAR
        ac = new ActionConfig("EncaminharOcorrencia", EncaminharOcorrenciaAction.class);
        ac.addConsequence(SUCCESS, new Redirect("StatusEncaminhamento.mtw"));
        ac.addConsequence(ERROR, new Redirect("OcorrenciaRead.mtw"));
        this.add(ac);


        //TIPO USUARIO SHOW FORM
        ac = new ActionConfig("TipoUsuarioShowForm", TipoUsuarioShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/tipoUsuario/formCreateTipoUsuario.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/tipoUsuario/formUpdateTipoUsuario.page"));
        this.add(ac);

        //TIPO USUARIO CREATE
        ac = new ActionConfig("TipoUsuarioCreate", TipoUsuarioCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoUsuarioRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoUsuario/formCreateTipoUsuario.page"));
        this.add(ac);

        //TIPO USUARIO READ
        ac = new ActionConfig("TipoUsuarioRead", TipoUsuarioReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/tipoUsuario/listTipoUsuario.page"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoUsuario/listTipoUsuario.page"));
        this.add(ac);

        //TIPO USUARIO DELETE
        ac = new ActionConfig("TipoUsuarioDelete", TipoUsuarioDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("TipoUsuarioRead.mtw"));
        ac.addConsequence(ERROR, new Forward("TipoUsuarioRead.mtw"));
        this.add(ac);

        //TIPO USUARIO UPDATE
        ac = new ActionConfig("TipoUsuarioUpdate", TipoUsuarioUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoUsuarioRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoUsuario/formUpdateTipoUsuario.page"));
        this.add(ac);

        //SET STATUS CRIACAO
        ac = new ActionConfig("StatusCriacao", StatusCriacaoAction.class);
        ac.addConsequence(SUCCESS, new Redirect("index.page"));
        ac.addConsequence(ERROR, new Forward("OcorrenciaShowForm.mtw"));
        this.add(ac);

        //SET STATUS ENCAMINHAMENTO
        ac = new ActionConfig("StatusEncaminhamento", StatusEncaminhamentoAction.class);
        ac.addConsequence(SUCCESS, new Redirect("OcorrenciaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("OcorrenciaRead.mtw"));
        this.add(ac);

        //USUARIO SHOW FORM
        ac = new ActionConfig("UsuarioShowForm", UsuarioShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/usuario/formCreateUsuario.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/usuario/formUpdateUsuario.page"));
        this.add(ac);

        //USUARIO CREATE
        ac = new ActionConfig("UsuarioCreate", UsuarioCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("UsuarioRead.mtw"));
        this.add(ac);

        //USUARIO UPDATE
        ac = new ActionConfig("UsuarioUpdate", UsuarioUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("UsuarioRead.mtw"));
        ac.addConsequence(ERROR, new Forward("UsuarioShowForm.mtw"));
        this.add(ac);

        //USUARIO DELETE
        ac = new ActionConfig("UsuarioDelete", UsuarioDeleteAction.class);
        ac.addConsequence(SUCCESS, new Redirect("UsuarioRead.mtw"));
        ac.addConsequence(ERROR, new Redirect("UsuarioRead.mtw"));
        this.add(ac);

        //USUARIO READ
        ac = new ActionConfig("UsuarioRead", UsuarioReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/usuario/listUsuario.page"));
        this.add(ac);

        //grafico de ocorrencia registradas
        ac = new ActionConfig("OcorrenciaGrafico", OcorrenciaGraficoAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/ocorrencia/formGraficoTodasOcorrencias.page"));
        ac.addConsequence(ERROR, new Forward("OcorrenciaRead.mtw"));
        this.add(ac);

         //grafico de ocorrencia registradas por departamento
        ac = new ActionConfig("OcorrenciaDepartamentoGrafico", OcorrenciaDepartamentoGraficoAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/ocorrencia/formGraficoOcorrenciasDepartamento.page"));
        ac.addConsequence(ERROR, new Forward("OcorrenciaRead.mtw"));
        this.add(ac);

        //AUTENTICAÇÃO CONSULTA OCORRENCIA
        ac = new ActionConfig("ConsultaOcorrenciaShowForm", ConsultaOcorrenciaShowFormAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/ocorrencia/consultaOcorrenciaLogin.page"));
        this.add(ac);

        ac = new ActionConfig("OcorrenciaLogin", OcorrenciaLoginAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/ocorrencia/resultPesquisaOcorrencia.page"));
        ac.addConsequence(ERROR, new Forward("jsp/ocorrencia/consultaOcorrenciaLogin.page"));
        this.add(ac);

        //LISTA DE MENSAGENS POR OCORRENCIAS
        ac = new ActionConfig("MensagemResultForm", MensagemResultFormAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/mensagem/listMensagens.page"));
        this.add(ac);

        //OCORRENCIA EXPANDIR
        ac = new ActionConfig("OcorrenciaExpandirDepartamento", OcorrenciaExpandirDepartamentoAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/ocorrencia/formOcorrenciaExpandidaDepartamento.page"));
        ac.addConsequence(ERROR, new Redirect("OcorrenciaRead.mtw"));
        this.add(ac);

        //ENCAMINHAR OCORRENCIA POR DEPARTAMENTO
        ac = new ActionConfig("EncaminharOcorrenciaDepartamento", EncaminharOcorrenciaDepartamentoAction.class);
        ac.addConsequence(SUCCESS, new Forward("OcorrenciaRead.mtw"));
        this.add(ac);
        
        //RELATORIO DE PORCENTAGENS DOS CHAMADOS
        ac = new ActionConfig("RelatorioChamados", RelatorioChamadosAction.class);
        ac.addConsequence("PDF", new StreamConsequence("application/pdf"));
        ac.addConsequence(ERROR, new Redirect("OcorrenciaRead.mtw"));
        this.addActionConfig(ac);
        
        //ENCERRAR OCORRENCIA POR NAO CONFORMIDADE
        ac = new ActionConfig("FinalizarPorNaoConformidade", FinalizarPorNaoConformidadeAction.class);
        ac.addConsequence(SUCCESS, new Forward("OcorrenciaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("OcorrenciaRead.mtw"));
        this.addActionConfig(ac);
        
        //VISUALIZAR RESPOSTA DEPARTAMENTO
        ac = new ActionConfig("VisualizarRespostaDoDepartamento", VisualizarRespostaDoDepartamento.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/ocorrencia/formOcorrenciaRespondida.page"));
        ac.addConsequence(ERROR, new Forward("OcorrenciaRead.mtw"));
        this.addActionConfig(ac);
        
        
        //ENCERRAR OCORRENCIA CONFORME
        ac = new ActionConfig("FinalizarOcorrenciaConforme", FinalizarOcorrenciaConformeAction.class);
        ac.addConsequence(SUCCESS, new Redirect("OcorrenciaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("OcorrenciaRead.mtw"));
        this.addActionConfig(ac);
        
        //ESCOLHER DEPARTAMENTO PARA RELATORIO DE OCORRENCIAS
        ac = new ActionConfig("DepartamentoRead", DepartamentoReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/ocorrencia/formReadDepartamentos.page"));
        this.add(ac);
        
        //RELATORIO DE PORCENTAGENS DOS CHAMADOS
        ac = new ActionConfig("RelatorioChamadosDepartamento", RelatorioChamadosDepartamentoAction.class);
        ac.addConsequence("PDF", new StreamConsequence("application/pdf"));
        ac.addConsequence(ERROR, new Redirect("OcorrenciaRead.mtw"));
        this.addActionConfig(ac);

        

    }
}
