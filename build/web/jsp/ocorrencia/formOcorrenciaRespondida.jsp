<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf" %>
<!DOCTYPE html>
<mtw:form klass="form-horizontal" action="FinalizarOcorrenciaConforme.mtw" method="post">
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="../../css/estilo.css" rel="stylesheet" type="text/css"/>
            <link href="../../css/reset.css" rel="stylesheet" media="screen"/>
            <link href="../../css/bootstrap.css" rel="stylesheet" media="screen"/>
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

            <div id="Fundo_topo_geral" align="center" style="margin-top:-8px;margin-left: -8px; margin-right: -8px;">    
                <div id="fundo_topo" align="left">
                    <div id="logotipo">
                        <img src="imagem/report.png"  />
                    </div>
                    <div id='menu_ouvidor' >
                        <ul>
                            <li class='active'><a href='OcorrenciaRead.mtw'><span>Home</span></a></li>
                            <li style="width: 750px; height: 5px;"></li>                            
                            <li class='last'><a href='UsuarioLogout.mtw'><span>Sair</span></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="Fundo_geral" style="margin-top: 6px; margin-left:1px;">
                <div id="meio" align="center" >
                    <h4 align="center">&nbsp;&nbsp;</h4>
                    <div>
                        <legend>Visualizar Ocorrência - Resposta Departamento</legend>
                        <div align="center" style="width: 600px; height: auto; ">
                            <div align="justify" style="widht: 100px; height: auto;">
                                <h5>Dados do Solicitante:</h5>
                                <strong>Nome do Solicitante:</strong> ${ocorrenciaRespondida.nome}<br><br>
                                <strong>Email do Solicitante:</strong> ${ocorrenciaRespondida.email}<br><br>
                                <strong>Perfil:</strong> ${ocorrenciaRespondida.perfil.nome}<br>
                            </div>
                            <legend>&nbsp;</legend>
                            <div align="justify" style="width: 600px; height: auto; ">
                                <h5>Dados da Ocorrência:</h5>
                                <strong>Protocolo:</strong> ${ocorrenciaRespondida.protocolo}<br><br>
                                <strong>Tipo de Ocorrencia:</strong> ${ocorrenciaRespondida.tipoOcorrencia.nome}<br><br>
                                <strong>Assunto:</strong> ${ocorrenciaRespondida.assunto}<br><br>
                                <strong>Descrição:</strong> ${ocorrenciaRespondida.descricao}<br><br>
                            </div>
                            <p>${mensagemDepartamento.descricao}</p>
                        </div><br>
                        <div align="center" >
                            <mtw:input type="hidden" name="ocorrenciaRespondida.id" value="${ocorrenciaRespondida.id}"/>
                            <div align="center">
                                <br> <input type="submit" class="btn btn-success" value="Encerrar"/>&nbsp;&nbsp;&nbsp;&nbsp;
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