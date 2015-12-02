<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="OcorrenciaRead.mtw" method="post">
    <html xmlns="http://www.w3.org/1999/xhtml">
        <head>
            <title>Departamento</title>
           <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <link href="../../css/estilo.css" rel="stylesheet" type="text/css" />
            <link href="../../css/bootstrap.css" type="text/css"/>
            <link href="css/reset.css" rel="stylesheet" media="screen"/>
            <link href="css/bootstrap.min.css" rel="stylesheet" media="screen"/>
            <link href="css/bootstrap-responsive.css" rel="stylesheet"/>
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
                            <h2 class="" align="center"></h2><br>
                            <h5 align="center"></h5>
                            <legend>Ocorrências</legend>
                            <div class="form-horizontal" align="right">
                                <display:table name="lista" id="row" pagesize="10" requestURI="" defaultsort="1" sort="list" class="commonDisplayTag">
                                    <display:column property="protocolo"  sortable="true" title="Protocolo" style="width:20%;"/>
                                    <display:column property="nome" sortable="true" title="Nome" style="width:20%;"/>
                                    <display:column property="assunto" sortable="true" title="Assunto" style="20%;"/>
                                    <display:column value="<a href='OcorrenciaExpandirDepartamento.mtw?id=${row.id}'><img src='../../imagem/view.png' /></a>" title="Visualizar" paramProperty="id" paramId="id" style="width:10;%" />
                                </display:table>
                            </div><br><br>
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

