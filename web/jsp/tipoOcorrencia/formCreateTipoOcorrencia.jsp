<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen"/>
        <title>Ouvidor</title>
    </head>
    <body>
        <div id="Fundo_topo_geral" align="center" style="margin-top:-8px;margin-left: -8px; margin-right: -8px;">    
            <div id="fundo_topo" align="left">
                <div id="logotipo">
                    <img src="imagem/report.png"  />
                </div>
                <div id='menu_ouvidor' >
                    <ul>
                        <li class='active'><a href='OcorrenciaRead.mtw'><span>Home</span></a></li>
                        <li class='has-sub'><a href='#'><span>Cadastro</span></a>
                            <ul>
                                <li><a href='PerfilRead.mtw'><span>Perfil</span></a></li>
                                <li><a href='TipoOcorrenciaRead.mtw'><span>Tipo Ocorrencia</span></a></li>
                                <li><a href='UsuarioRead.mtw'><span>Usuário</span></a></li>
                                <li><a href='TipoUsuarioRead.mtw'><span>Departamento</span></a></li>
                            </ul>
                        </li>
                        <li class='last'><a href='Logout.mtw'><span>Sair</span></a></li>
                    </ul>
                </div> 
            </div>
        </div>
        <div id="Fundo_geral" style="margin-top: 6px; margin-left:6px;">
            <div id="meio" >
                <div id="conteudo_meio">                        
                    <h4 align="center">&nbsp;</h4>
                    <h3 align="left">Cadastrar</h3>
                    <div id="box_form" >
                        <mtw:form action="TipoOcorrenciaCreate.mtw" name="cadastro"><br>
                            Novo tipo de ocorrência: <mtw:input name="nome" type="text"/><br>
                            <h5 align="center">&nbsp;</h5>
                            <p>
                                <button  name="salvar" class="btn btn-success" value="Salvar">Salvar</button>
                                <a href="TipoOcorrenciaRead.mtw"  name="cancelar" class="btn btn-primary" onclick="javascript:history.back();" value="cancelar">Cancelar</a>

                            </p>
                        </mtw:form>
                    </div>
             </div>
                </div>  <br><br>
            </div>  
            <div id="rodape" align="center" style="margin-left: 0px;margin-top: 2px;width: 1365px;">
                <p> @ Faitec 2013 Repot Here Ouvidoria - Todos os Direitos Reservados.</p>
            </div> 

</body>
</html>
