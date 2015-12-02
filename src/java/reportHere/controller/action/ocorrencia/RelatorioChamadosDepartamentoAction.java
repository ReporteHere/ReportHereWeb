package reportHere.controller.action.ocorrencia;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import org.mentawai.core.BaseAction;
import reportHere.controller.AppManager;
import reportHere.model.ConnectionManager;

public class RelatorioChamadosDepartamentoAction extends BaseAction {

    private String m_sUrl = null;
    private String m_sDriver = null;
    private String m_sUser = null;
    private String m_sPassword = null;

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;

        try {
            String path = org.mentawai.core.ApplicationManager.getRealPath();

            HashMap parameters = new HashMap<String, Object>();
            Long valor = new Long(input.getLong("idDepartamento"));
            parameters.put("idTipo", valor);

            Connection conn = ConnectionManager.getInstance().getConnection();
            // Preenche o relatório com os dados. Gera o arquivo                                    
            JasperPrint report = JasperFillManager.fillReport(path + "/imagem/jaspers/ChamadosDepartamento.jasper", parameters, conn);

            byte[] saida = JasperExportManager.exportReportToPdf(report);

            output.setValue("stream", saida);
            consequence = "PDF";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consequence;
    }
}
