<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf" %>
<!DOCTYPE html>
<mtw:form klass="form-horizontal" action="EncaminharOcorrenciaDepartamento.mtw" method="post">
    <html>
        <head>
          <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <link href="../../css/estilo.css" rel="stylesheet" type="text/css" />
            <link href="../../css/bootstrap.css" type="text/css"/>
            <link href="css/reset.css" rel="stylesheet" media="screen"/>
            <link href="css/bootstrap.min.css" rel="stylesheet" media="screen"/>
            <link href="css/bootstrap-responsive.css" rel="stylesheet"/>
            <title>Ouvidor</title>
            <script language="javascript" type="text/javascript">
                function validaForm()
                {

                    if (document.getElementById('form_formulario1').value == '')
                    {
                        alert('O campo Mensagem é obrigatório.');
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
                    <div id="form-horizontal" class="span10" style="margin-left: " align="center">
                    <div id='menu_ouvidor' >
                        <ul>
                            <li class='active'><a href='OcorrenciaRead.mtw'><span>Home</span></a></li>                         
                            
                            <li class='last'><a href='UsuarioLogout.mtw'><span>Sair</span></a></li>
                        </ul>
                    </div> 
                </div>
            </div>  
            </div>                        
                    <div id="form-horizontal" class="container " >

                <div id="form-horizontal" class="span10 offset1" align="justify">  
                            <h4 align="center">&nbsp;&nbsp;</h4>
                            <div class="form-horizontal span7 offset1">
                                <legend>Visualizar Ocorrência</legend>
                                <div align="center" style="width: 600px; height: auto;">
                                    <div align="center" style="width: 600px; height: auto; ">
                                        <h5>Dados do Solicitante:</h5>
                                        <strong>Nome do Solicitante:</strong> ${ocorrenciaExpandida.nome}<br><br>
                                        <strong>Email do Solicitante:</strong> ${ocorrenciaExpandida.email}<br><br>
                                        <strong>Perfil:</strong> ${ocorrenciaExpandida.perfil.nome}<br>
                                    </div>

                                    <div align="center" style="width: 600px; height: auto; ">
                                        <h5>Dados da Ocorrência:</h5>
                                        <strong>Protocolo:</strong> ${ocorrenciaExpandida.protocolo}<br><br>
                                        <strong>Tipo de Ocorrencia:</strong> ${ocorrenciaExpandida.tipoOcorrencia.nome}<br><br>
                                        <strong>Assunto:</strong> ${ocorrenciaExpandida.assunto}<br><br>
                                        <strong>Descrição:</strong> ${ocorrenciaExpandida.descricao}<br><br>
                                    </div>

                                    <h4 align="center">&nbsp;&nbsp;</h4>
                                </div><br>
                                <div align="center" style="widht: 50px; height: auto; margin-right: 0px;">
                                    Mensagem:<br/>
                                   <textarea type="text" cols="200" rows="10" id="form-horizontal" class="input-xxlarge"name="mensagem" requerid> </textarea>
                                    <mtw:input type="hidden" name="ocorrenciaExtendida.id" value="${ocorrenciaExpandida.id}"/><br/><br>
                                </div>
                                
                                <div align="left" class="" style="widht: 50px; height: auto; margin-top: 140px; margin-bottom: 20px;">
                                    <input type="submit" class="btn btn-success" value="Enviar" onclick="return validaForm()"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <button  name="cancelar" class="btn btn-primary"  value="cancelar">Cancelar</button>
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