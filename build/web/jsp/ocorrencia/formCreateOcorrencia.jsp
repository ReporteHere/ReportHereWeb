<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Report Here</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"></link>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="css/estilo.css" rel="stylesheet" type="text/css" />
        <link href="css/bootstrap.css" type="text/css"/>
        <link href="css/reset.css" rel="stylesheet" media="screen"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen"/>
        <link href="css/bootstrap-responsive.css" rel="stylesheet" media="screen"/>
        <link href="css/bootstrap-responsive.min.css" media="screen"/>

        <script language="javascript" type="text/javascript">
            function validaForm()
            {


                if (document.getElementById('nome').value == '')
                {
                    alert('O campo Nome é obrigatório.');
                    document.getElementById('nome').focus();
                    return false;
                }

                if (document.getElementById('email').value == '')
                {
                    alert('O campo E-mail é obrigatório!');
                    document.getElementById('email').focus();
                    return false;
                }

                if (document.getElementById('perfil').value == '')
                {
                    alert('O campo Perfil é obrigatório!');
                    document.getElementById('perfil').focus();
                    return false;
                }

                if (document.getElementById('tipoOcorrencia').value == '')
                {
                    alert('O campo Tipo Ocorrência é obrigatório!');
                    document.getElementById('tipoOcorrencia').focus();
                    return false;
                }

                if (document.getElementById('descricao').value == '')
                {
                    alert('O campo Descrição é obrigatório!');
                    document.getElementById('descricao').focus();
                    return false;
                }

                if (document.getElementById('assunto').value == '')
                {
                    alert('O campo Assunto é obrigatório.');
                    document.getElementById('assunto').focus();
                    return false;
                }


                return true
                Enviar()

            }

            //------------------------------------------------------------------------------------------------------
            function Enviar()
            {
                if (validaForm())
                {
                    document.getElementById('form1').submit();
                }
            }
            //------------------------------------------------------------------------------------------------------

            function contChar(v_txtArea)
            {
                var v_limit = 2000;
                var v_inftxt, v_lenTxt;

                if (v_txtArea.value.length > v_limit)
                {
                    v_txtArea.value = v_txtArea.value.substring(0, v_limit);
                }
                else
                {
                    if (!v_txtArea.value.length)
                        v_lenTxt = 0;
                    else
                        v_lenTxt = v_txtArea.value.length;

                    v_inftxt = "Máximo 2000 caracteres<br>" + (v_limit - v_lenTxt) + " caracteres restantes";
                    document.getElementById('contChar').innerHTML = v_inftxt;
                }
            }

            //-------------------------------------------------------------------------------------------------------

            function bloqueiatext()
            {

                if (document.form1.descricao.value.length >= 400)
                {
                    window.alert("Limite máximo de caracteres!");
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
                    <div id='cssmenu' >
                        <ul>
                            <!--<li><div style="width:0px; height:4px;" ></div></li>-->
                            <li><a href='index.jsp'><span>Ouvidoria</span></a></li>
                            <li><a href='OcorrenciaShowForm.mtw'><span>Relatar</span></a></li>
                            <li><a href='ConsultaOcorrenciaShowForm.mtw'><span>Acompanhar Relato</span></a></li>
                            <li><a href='UsuarioLoginShowForm.mtw'><span>Acesso Restrito</span></a></li>
                        </ul>
                    </div>   

                </div>
            </div>
        </div>
        <div id="form-horizontal" class="container " >

            <div id="form-horizontal" class="span10 offset1" align="justify">
                <mtw:form klass="form-horizontal" action="OcorrenciaCreate.mtw" method="post">
                    <br> <h4 align="center"><legend>Formulário de solicitação</legend></h4><br>
                            <div class="alert alert-danger">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                Obrigatório o preenchimento de todos os campos!
                            </div>
                            <div id="form-horizontal" class="span10 ">
                                <div class="control-group">
                                    <label class="control-label" for="inputNome">Nome:</label>
                                    <div class="controls">    
                                        <mtw:input type="text" klass="input-xxlarge" size="65" id="nome" name="nome"/>  <br>                                   
                                            <mtw:outError field="nome">
                                                <font color="red">Nome</font>
                                                </mtw:outError>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="inputEmail">E-mail:</label>
                                    <div class="controls">    
                                        <input type="email" klass="input-xxlarge" size="65"  id="email" name="email" required />
                                        <mtw:outError field="email">
                                            <font color="red"><mtw:out /></font>
                                            </mtw:outError>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="inputEmail">Anônimo:</label>
                                    <div class="controls"> 
                                        <select name="anonimo" id="anonimo" class="input-large">
                                            <option value="sim">Não</option>
                                            <option value="nao">Sim</option>
                                        </select><br>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="inputPerfil">Perfil:</label>
                                    <div class="controls">
                                        <mtw:select name="perfil.id" klass="input-large" list="listaPerfis" id="perfil" emptyField="true" emptyFieldValue="Selecione..."/>        
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="inputTipoOcorrencia">Tipo do relato:</label>
                                    <div class="controls">
                                        <mtw:select name="tipoOcorrencia.id" klass="input-large" list="listaTiposOcorrencia" id="tipoOcorrencia" emptyField="true" emptyFieldValue="Selecione..."/>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="inputAssunto">Assunto:</label>
                                    <div class="controls">    
                                        <mtw:input type="text" klass="input-xxlarge" size="65" id="assunto" name="assunto"  />
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="inputDescricao">Descrição:</label>
                                    <div class="controls"> 
                                        <textarea type="text" cols="65" rows="10" id="descricao" class="input-xxlarge" name="descricao" onkeyup="contChar(this)" onkeydown="contChar(this)"></textarea>
                                        <div id="contChar" class="text-info" style="margin-top: 3px; ">Máximo 2000 caracteres <br><b>2000</b> caracteres restantes </div>
                                    </div>
                                </div>
                                <div align="left" style="margin-left: 180px;">

                                    <!--                                            <button class="botaoForm_Oco">Enviar</button><br>-->
                                    <button class="btn btn-primary" onclick="return validaForm()">&nbsp; Enviar &nbsp;</button>
                                </div>
                                <br><br>
                                        </div><br></mtw:form>  </div>
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
