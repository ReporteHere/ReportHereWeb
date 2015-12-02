<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="OcorrenciaLogin.mtw" method="post">
    <html>
        <head>
            <title>Report Here - Login</title>
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


                    if (document.getElementById('protocolo').value == '')
                    {
                        alert('O campo Protocolo é obrigatório.');
                        document.getElementById('protocolo').focus();
                        return false;
                    }

                    if (document.getElementById('senha').value == '')
                    {
                        alert('O campo Senha é obrigatório!');
                        document.getElementById('senha').focus();
                        return false;
                    }

                    return true

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
                <div id="form-horizontal" class="span10 offset2" >
                    <br> <br> 		
                    <div id="Login" style="margin-left: 60px;">
                        <br>
                        <p></p><h4 align="center" style="color:#FFF; margin-top:7px;">Consulta Chamado</h4>
                        <div> 
                            <div align="center" >

                                <table class="tabela" border="0" cellpadding="0" cellspacing="0">                                             
                                    <tr >
                                        <td  rowspan="4">
                                            <img src="imagem/restrito.png" width="150" height="150" />
                                        </td>
                                        <th>Protocolo</th>
                                        <td><mtw:input type="text" klass="input-medium" name="protocolo" id="protocolo" /></td>
                                    </tr>
                                    <tr>
                                        <th>Senha</th>
                                        <td><mtw:input type="text" klass="input-medium" name="senha" id="senha"/></td>
                                    </tr>

                                    <tr><!--<input type="submit" class="botao1" name="entrar" value="Acessar"/>-->
                                        <td></td>
                                        <td><button class="btn btn-primary" name="entrar" value="Acessar" onclick="return validaForm()">Acessar</button></td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    <br><br><br>
                </div>
            </div> 
            <div id="rodape" align="center" >
                <p class="label-info"> @ Faitec 2013 Repot Here Ouvidoria - Todos os Direitos Reservados.</p>
                <br>
                <div style="height: 70; width: 400px;">
                    <div  style="float: inside;">
                        <img src="../../imagem/LogoFAITEC.png"  />
                    </div>
                </div>
            </div>   
        </body>
    </html>
</mtw:form>