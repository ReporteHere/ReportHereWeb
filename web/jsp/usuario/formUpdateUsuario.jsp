<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf" %>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <link href="../../css/estilo.css" rel="stylesheet" type="text/css" />
            <link href="../../css/bootstrap.css" type="text/css"/>
            <link href="css/reset.css" rel="stylesheet" media="screen"/>
            <link href="css/bootstrap.min.css" rel="stylesheet" media="screen"/>
            <link href="css/bootstrap-responsive.css" rel="stylesheet"/>
        <title>Alterar Usuário</title>
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
                    <h4 align="center">&nbsp;</h4>
                    <legend>Alterar Usuário</legend>                    
                        <mtw:form action="UsuarioUpdate.mtw" name="cadastro"><br>
                          <div id="form-horizontal" >
                            <div class="control-group"> 
                                <input type="hidden" value="${usuario.id}" id="id" name="id"/><br>
                                <div class="control-group">
                                    <label class="control-label" for="inputNome">Nome:</label>
                                    <div class="controls">    
                                        <mtw:input type="text" klass="input-medium" id="nome" name="nome" value="${usuario.nome}"/>  <br>                                   
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="inputNome">Login:</label>
                                    <div class="controls">    
                                        <mtw:input type="text" klass="input-medium" id="login" name="login" value="${usuario.login}"/>  <br>                                   
                                    </div>
                                </div>    
                                <div class="control-group">
                                    <label class="control-label" for="inputNome">Senha:</label>
                                    <div class="controls">    
                                        <mtw:input type="text" klass="input-medium" id="senha" name="senha" value="${usuario.senha}"/>  <br>                                   
                                    </div>
                                </div>  
                                <div class="control-group">
                                    <label class="control-label" for="inputNome">Departamento:</label>
                                    <div class="controls">    
                                        <mtw:select name="usuario.tipoUsuario.id" list="listaTipoUsuario" id="tipoUsuario" emptyField="true" emptyFieldValue="Selecione..." />  <br>                                   
                                    </div>
                                </div>  
                                <p><br>
                                    <button  name="salvar" class="btn btn-success" value="Salvar">Salvar</button>
                                    <a href="UsuarioRead.mtw"  name="cancelar" class="btn btn-primary" value="cancelar">Cancelar</a>
                                </p>
                            </div> 
                           </div>     
                        </mtw:form>
                 </div><br><br><br>
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
