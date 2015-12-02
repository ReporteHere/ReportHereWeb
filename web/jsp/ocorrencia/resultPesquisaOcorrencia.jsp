<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="OcorrenciaRead.mtw" method="post">
    <html xmlns="http://www.w3.org/1999/xhtml">
        <head>
            <title>Acompanhar Chamado</title>
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
                  <br/>
                   
                    <legend>Histórico da Ocorrência</legend>
                    
                    <div class="form-horizontal" align="right">
                        <display:table name="listOcorrencia" id="row" pagesize="10" requestURI="" defaultsort="1" sort="list" class="commonDisplayTag">
                            <display:column property="nome" sortable="true" title="Nome" style="width:20%;"/>
                            <display:column property="assunto" sortable="true" title="Assunto" style="20%;"/>
                            <display:column property="data" sortable="true" title="Data de Registro" style="20%;"/>
                            <display:column property="status" sortable="true" title="Status" style="20%;"/>
                            <display:column value="<a href='MensagemResultForm.mtw?id=${row.id}'><img src='../../imagem/view.png' /></a>" title="Visualizar" paramProperty="id" paramId="id" style="width:10;%" />
                        </display:table>
                    </div>
                    <h5 align="center"></h5><br><br>
                </div><br>
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

