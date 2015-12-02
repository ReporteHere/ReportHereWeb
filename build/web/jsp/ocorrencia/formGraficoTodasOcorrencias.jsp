<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="OcorrenciaRead.mtw" method="post">
    <html xmlns="http://www.w3.org/1999/xhtml">
        <head>
            <title>Ouvidor</title>
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

                <div id="form-horizontal" class="span10 offset1" >

                    <div id="form-horizontal" class="span10 offset1" >
                        <br>
                            <h4> Gráfico de todas as Ocorrências</h4>
                            <div>
                                <img src="imagem/graficos/ocorrenciaRegistradas.png"  />
                            </div><br>
                                <a href="OcorrenciaRead.mtw"  name="cancelar" class="btn btn-primary" onclick="javascript:history.back();" value="cancelar">Voltar</a>
                                <h3>&nbsp;</h3>
                                </div>
                                </div>
                                </div>
                                <br>
                                    <br>

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

