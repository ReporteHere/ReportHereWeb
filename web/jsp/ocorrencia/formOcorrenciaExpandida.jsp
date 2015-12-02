<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf" %>
<!DOCTYPE html>
<mtw:form klass="form-horizontal" action="EncaminharOcorrencia.mtw" method="post">
    <html>
        <head>
           <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <link href="../../css/estilo.css" rel="stylesheet" type="text/css" />
            <link href="../../css/bootstrap.css" type="text/css"/>
            <link href="css/reset.css" rel="stylesheet" media="screen"/>
            <link href="css/bootstrap.min.css" rel="stylesheet" media="screen"/>
            <link href="css/bootstrap-responsive.css" rel="stylesheet"/>
            <script language="javascript" type="text/javascript">
            <title>Ouvidor</title>
            <script language="javascript" type="text/javascript">
                function validaForm()
                {


                    if (document.getElementById('usuario').value == '')
                    {
                        alert('Deve-se selecionar para qual usuário encaminhar!');
                        document.getElementById('usuario').focus();
                        return false;
                    }

                    if (document.getElementById('form_formulario1').value == '')
                    {
                        alert('Preencher o campo Mensagem!');
                        document.getElementById('form_formulario1').focus();
                        return false;
                    }

                }
                //------------------------------------------------------------------------------------------------------
                function Enviar()
                {
                    if (validaForm())
                    {
                        document.getElementById('form1').submit();
                    }
                }
            </script>  

        </head>
        <body>

              <div id="Fundo_topo_geral"  >   
                <div id="form-horizontal" class="span10 offset1" align="justify">
                    <div id="logotipo">
                        <img src="imagem/report.png"  />
                        
                    </div>
                    <div id="form-horizontal" class="span10" align="center">
                        <div id='menu_ouvidor' ><ul>
                                <li class='active'><a href='OcorrenciaRead.mtw'><span>Home</span></a></li>
                                <li class='has-sub'><a href='#'><span>Cadastro</span></a>
                                    <ul>
                                        <li><a href='PerfilRead.mtw'><span>Perfil</span></a></li>
                                        <li><a href='TipoOcorrenciaRead.mtw'><span>Tipo Ocorrencia</span></a></li>
                                        <li><a href='UsuarioRead.mtw'><span>Usuário</span></a></li>
                                        <li><a href='TipoUsuarioRead.mtw'><span>Departamento</span></a></li>
                                    </ul>
                                </li>
                                <li class='has-sub'><a href='#'><span>Relatório</span></a>
                                    <ul>
                                        <li class='last'><a href='OcorrenciaGrafico.mtw'><span>Gráfico Ocorrências Registradas</span></a></li>
                                        <li class='last'><a href='OcorrenciaDepartamentoGrafico.mtw'><span>Grafico Ocorrências por Departamento</span></a></li>
                                        <li class='last'><a href='RelatorioChamados.mtw'><span>Relatório de Ocorrências</span></a></li>
                                        <li class='last'><a href='DepartamentoRead.mtw'><span>Relatório de Ocorrências Por Departamento</span></a></li>
                                    </ul>
                                </li>
                                <li class='last'><a href='UsuarioLogout.mtw'><span>Sair</span></a></li>
                                <li class="has-sub"></li>
                            </ul>

                        </div>   

                    </div>
                </div>
            </div>
            <div id="form-horizontal" class="container " >
                <div id="form-horizontal" class="span10 offset1" align="center">
                    <h4 align="center">&nbsp;&nbsp;</h4>
                    <div>
                        <legend>Visualizar Ocorrência</legend>
                        <div align="center" style="width: 600px; height: auto; ">
                            <div align="justify" style="widht: 100px; height: auto;">
                                <h5>Dados do Solicitante:</h5>
                                <strong>Nome do Solicitante:</strong> ${ocorrenciaExpandida.nome}<br><br>
                                <strong>Email do Solicitante:</strong> ${ocorrenciaExpandida.email}<br><br>
                                <strong>Perfil:</strong> ${ocorrenciaExpandida.perfil.nome}<br>
                            </div>
                            <legend>&nbsp;</legend>
                            <div align="justify" style="width: 600px; height: auto; ">
                                <h5>Dados da Ocorrência:</h5>
                                <strong>Protocolo:</strong> ${ocorrenciaExpandida.protocolo}<br><br>
                                <strong>Tipo de Ocorrencia:</strong> ${ocorrenciaExpandida.tipoOcorrencia.nome}<br><br>
                                <strong>Assunto:</strong> ${ocorrenciaExpandida.assunto}<br><br>
                                <strong>Descrição:</strong> ${ocorrenciaExpandida.descricao}<br><br>
                            </div>
                        </div><br>
                        <div align="center" >
                            <a href="FinalizarPorNaoConformidade.mtw?idOcorrencia=${ocorrenciaExpandida.id}" class="btn btn-danger ">Reprovar</a><br><br>
                            <div align="center" style="widht: 50px; height: auto;  margin-right: 0px;" >
                                <label>Enviar para:</label>
                                <mtw:select name="usuario.id" list="listaUsuario" id="usuario" klass="btn" emptyField="true" emptyFieldValue="Selecione..."/> 
                                <mtw:input type="hidden" name="ocorrenciaExtendida.id" value="${ocorrenciaExpandida.id}"/>
                            </div> <br>  

                            <div align="center" style="widht: 50px; height: auto; margin-top: 10px; margin-right: 0px;">
                                <!--<mtw:select name="usuario.id" list="listaUsuario" id="usuario" klass="btn" emptyField="true" emptyFieldValue="Selecione..."/>-->
                                <br><br>
                                <div align="center" class="tableRowEven" style="width: 600px; height: auto;">
                                <legend>Histórico</legend>   
                               
                                    <display:table name="usuarios" id="row" requestURI=""  sort="list">
                                        <display:column property="nome" title="Nome" style="width:20%;"/>
                                        <display:column property="tipoUsuario.nome" title="Departamento" style="width:20%;"/>
                                    </display:table>
                                <legend>&nbsp;</legend>
                                </div>
                            </div>                                
                            <div align="center"  >
                                <label>Mensagem:</label>
                                <textarea type="text" cols="200" rows="10" id="form-horizontal" class="input-xxlarge"name="mensagem" requerid></textarea>
                            </div>  
                        </div>
                        <div align="center">
                            <br> <input type="submit" class="btn btn-success" value="Enviar"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="OcorrenciaRead.mtw"  name="cancelar" class="btn btn-primary" value="cancelar">Cancelar</a>
                            <p> &nbsp;</p>
                        </div>       
                    </div>
                </div>
            </div>


            <div id="rodape" align="center" >
                <p class="label-info"> @ Faitec 2013 Repot Here Ouvidoria - Todos os Direitos Reservados.</p>
                <br>
                <div style="height: 70; width: 400px;">
                    <div  style="float: inside;">
                        <img src="imagem/LogoFAITEC.png"  />
                    </div>
                </div>
            </div>

        </body>
    </html>
</mtw:form>