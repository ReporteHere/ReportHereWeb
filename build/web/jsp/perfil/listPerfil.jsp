<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form action="PerfilRead.mtw" klass="form-horizontal" method="post">
    <html> 
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
            <script language="javascript" type="text/javascript">
                function validaForm()
                {

                    if (document.getElementById('nomePerfil').value == '')
                    {
                        alert('O campo Novo Perfil é obrigatório.');
                        document.getElementById('nomePerfil').focus();
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
                   
                    <div class="input-append">
                        <legend>Consulta de Perfis</legend>
                        <mtw:input name="nome" id="nome" klass="span2" size="20"/>
                        <button class="btn" onmouseover="label('Pesquisar')" alt="">Pesquisar</button>
                        <a href="#myModal" data-toggle="modal" role="button" class="btn" type="button">Inserir</a>
                    </div>
                    <h5 align="center">&nbsp;</h5>
                    <div class="table table-bordered table-condensed table-hover" align="left" style="margin-top: 20px;">                                
                        <display:table cellpadding="20" id="row" pagesize="8" requestURI="" name="listaPerfis" class="commonDisplayTag">
                            <display:column property="nome"  title="Nome" sortable="true" class="ColunaNome"/>
                            <display:column value="<a href='./PerfilShowForm.mtw?id=${row.id}'><img src='../../imagem/edit.png' alt='editar' /></a>" title="Editar" class="ColunaBotao"/>
                            <display:column value="<a href='./PerfilDelete.mtw?id=${row.id}'><img src='../../imagem/delete.png' /></a>" class="deleteLink" title="Excluir"/>
                        </display:table>
                    </div>
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

<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Inserir Perfil</h3>
    </div>
    <div class="modal-body">
        <mtw:form action="PerfilCreate.mtw" method="post"><br>
            Novo Perfil: <mtw:input id="nomePerfil" name="nome" type="text"/><br>
            <h5 align="center">&nbsp;</h5>
            <button name="salvar" class="btn btn-success" value="salvar" onclick="return validaForm()">Salvar</button>
            <a href="PerfilRead.mtw" name="cancelar" class="btn btn-primary"  value="cancelar">Cancelar</a>
        </mtw:form>
    </div>
    <div class="modal-footer">   
    </div>
</div>

<div class="modal hide" id="confirmDelete">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>Atenção</h3>
    </div>
    <div class="modal-body">
        <p>Você deseja realmente excluir?</p>
        <div class="alert alert-error">
            Atenção: esta operação não pode ser desfeita.
        </div>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn btn-danger">Sim, desejo excluir.</a>
        <a href="#" class="btn" data-dismiss="modal">Cancelar</a>
    </div>
</div>

<script>
    $(function(){
        $("td.deleteLink a").click(function(){
            $('#confirmDelete').modal('show');
            $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
            return false; 
        });
    });
</script>    