<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/imports.jspf"%>
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
         
    </head>   

    <body>
        <div id="Fundo_topo_geral">    
            <div id="form-horizontal" class="span10 offset1" align="justify"@media (max-width: 767px)>
                <div id="logotipo">
                    <img src="imagem/report.png"  />
                </div>
                <div id="form-horizontal" class="span10" align="center">
                <div id='cssmenu' >
                    <ul>
                        <!--<li><div style="width:125px; height:4px;" ></div></li>-->
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
                    <h5 align="center">&nbsp;</h5>
                    <legend>Ouvidoria</legend>
                    <font size="2.5" > É um órgão de comunicação com a comunidade em geral, criado em 15/03/10, vinculado à diretoria, que visa ao aperfeiçoamento do modelo administrativo e das ações institucionais da FAI.
                        A Ouvidoria tem como objetivo o aprimoramento institucional e o aumento progressivo do grau de satisfação com os serviços prestados pela instituição.
                    </font><br></br>
                    <legend>Como funciona?</legend>
                    <strong>1.</strong><font size="2.5"> O responsável pela ouvidoria é escolhido pela 
                        fundação mantenedora com mandato de dois anos podendo ser renovado uma vez.</font> 
                    <br></br>
                    <strong>2.</strong><font size="2.5"> Para entrar em contato com a Ouvidoria você deve preencher o formulário eletrônico. 
                        No entanto, se desejar, você poderá solicitar que sua identidade seja mantida em sigilo, no que será atendido se as razões do anonimato forem consideradas justificáveis.
                    </font>
                    <br></br>
                    <strong>3.</strong><font size="2.5"> A Ouvidoria, ao receber as observações(reclamações, denúncias, críticas, sugestões ou elogios) as encaminhará, 
                        quando devidamente apresentadas, ao setor mencionado na observação, cobrando a resposta que julgar adequada.
                    </font>
                    <br></br>
                    <strong>4.</strong><font size="2.5"> O responsável pelo departamento citado em sua manifestação terá o prazo de 10 dias úteis para responder à Ouvidoria, que se responsabilizará de transmitir a resposta.
                    </font>
                    <br></br>
                    <strong>5.</strong><font size="2.5"> Todas as manifestações recebidas são registradas e classificadas, resultando um relatório mensal que será utilizado pela diretoria para colaborar na detecção e solução dos problemas institucionais.
                    </font>
                <br><br>
                    <div align="left" style="height: 60px; width: 900px;">
                        <a href="OcorrenciaShowForm.mtw" class="btn btn-primary">&nbsp;&nbsp;Formulário eletrônico</a>
                    </div>            
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