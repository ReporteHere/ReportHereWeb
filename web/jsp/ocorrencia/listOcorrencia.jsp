<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="OcorrenciaRead.mtw" method="post">
    <html xmlns="http://www.w3.org/1999/xhtml">
        <head>
            <title>Ouvidor</title>
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
                    <div class="alert alert-block alert-success fade in  ">
                        <a class="close" data-dismiss="alert">&times;</a>
                        Bem Vindo <b>${usuario.nome}</b>!
                    </div></div>
                <div id="form-horizontal" class="span10 offset1" align="justify">                       
                   
                           
                        <legend >Ocorrências</legend>
                        <div class="form-horizontal" align="right">
                            <display:table name="lista" id="row" pagesize="10" requestURI="" defaultsort="1" sort="list" class="commonDisplayTag">

                                <display:column property="protocolo"  sortable="true" title="Protocolo" style="width:20%;"/>
                                <display:column property="nome" sortable="true" title="Nome" style="width:20%;"/>
                                <display:column property="assunto" sortable="true" title="Assunto" style="20%;"/>
                                <display:column property="status" sortable="true" title="Status" style="20%;"/>
                                <display:column property="visualizar" sortable="true" title="Visualizar" style="20%;"/>
                            </display:table>
                        </div><br><br>
                                </div>
                                <div id="form-horizontal" class="offset1">
                                    <tr>
                                        <td colspan="3">
                                            <fieldset><legend>Legendas</legend>
                                                &nbsp;<img src='imagem/preto.png' width="10px" height="10px" border='0'/> Chamado recebido, não encaminhado <br/>
                                                <img src='imagem/amarela.png' border='0'/> Chamado encaminhado, aguardando execução <br/>
                                                <img src='imagem/blue.png' border='0'/> Solicitação atendida pelo departamento <br/>
                                                <img src='imagem/verde.png' border='0'/> Chamado finalizado com conformidade <br/>
                                                <img src='imagem/red.png' border='0'/> Chamado finalizado por reprovoção <br/>
                                            </fieldset>
                                        </td>
                                    </tr>
                                </div><br><br>
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

