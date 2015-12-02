/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.controller.action.ocorrencia;

import java.io.File;
import java.util.List;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import org.mentawai.core.BaseAction;
import reportHere.model.ServiceLocator;



public class OcorrenciaGraficoAction extends BaseAction{

        @Override
    public String execute() throws Exception {
            String consequence = ERROR;
            //Gráfico de Pizza utiliza ess instanciação
            DefaultPieDataset data = new DefaultPieDataset();

            List<Map<String, Object>> listMap = ServiceLocator.getOcorrenciaService().readCountOcorrencias();
            for (Map<String, Object> map : listMap) {
                data.setValue(map.get("nome").toString()+"\n"+map.get("qtde"), Double.parseDouble(map.get("qtde").toString()));
            }
            try {
		//cria o grafico..                                 //Titulo, dados que iram gerar o grafico, legenda, tooltips, urls
		JFreeChart grafico = ChartFactory.createPieChart3D("Análise das Ocorrências Registradas", data, true, true, false);
		File arq;
                String path = org.mentawai.core.ApplicationManager.getRealPath();
                
		arq = new File(path+"/imagem/graficos/ocorrenciaRegistradas.png");
//		arq = new File("D://ocorrenciaRegistradas.png");
		ChartUtilities.saveChartAsPNG(arq, grafico, 600, 450);
		consequence = SUCCESS;
		} catch (Exception e) {
		e.printStackTrace();
	}

            return consequence;
        }
}
