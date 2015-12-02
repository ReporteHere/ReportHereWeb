<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"></link>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <link href="css/estilo.css" rel="stylesheet" type="text/css" />
            <link href="css/bootstrap.css" type="text/css"/>
            <link href="css/reset.css" rel="stylesheet" media="screen"/>
            <link href="css/bootstrap.min.css" rel="stylesheet" media="screen"/>
            <link href="css/bootstrap-responsive.css" rel="stylesheet" media="screen"/>
            <link href="css/bootstrap-responsive.min.css" media="screen"/>
        <title>Alterar Tipo de Ocorrência</title>
        <script language="javascript" type="text/javascript">
            function validaForm()
            {
                if (document.getElementById('nome').value == '')
                {
                    alert('O campo Tipo de Ocorrência é obrigatório.');
                    document.getElementById('nome').focus();
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

                <div id="form-horizontal" class="span10 offset1" align="justify">  
                    <legend>Alterar Tipo de Ocorrência</legend>
                    <mtw:form action="TipoOcorrenciaUpdate.mtw" name="cadastro">
                        <div id="form-horizontal" ><br>
                            <input type="hidden" value="${tipoOcorrencia.id}" id="id" name="id"/>
                            <div class="control-group">
                                <label class="control-label" for="inputNome">Tipo de Ocorrencia:</label>
                                <div class="controls">    
                                    <mtw:input type="text" klass="input-medium" id="nome" name="nome" value="${tipoOcorrencia.nome}"/>  <br>                                   
                                </div>
                            </div>
                            <p>
                                <button  name="salvar" class="btn btn-success" value="Salvar" onclick="return validaForm()">Salvar</button>
                                <a href="TipoOcorrenciaRead.mtw"  name="cancelar" class="btn btn-primary" value="cancelar">Cancelar</a>
                            </p>
                        </div>
                    </mtw:form>
                </div><br><br><br>
            </div>  
      
        <div id="rodape" align="center" style="margin-left: 0px;">
            <p><div class="label-info"> @ Faitec 2013 Repot Here Ouvidoria - Todos os Direitos Reservados.</div></p>
        </div> 
    </body>
</html>
