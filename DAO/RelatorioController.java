package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

// Ana Moreira

public class RelatorioController {

    private Connection conexao;
    private static final String PASTA_RELATORIOS = System.getProperty("user.dir") + "/src/relatorio";

    private static final File ARQUIVO_FONTE_RELATORIO_MEDICO = new File(PASTA_RELATORIOS, "Basic.jrxml");
    private static final File ARQUIVO_COMPILADO_RELATORIO_MEDICO = new File(PASTA_RELATORIOS, "Basic.jasper");
    private static final File RELATORIO_PDF_MEDICO = new File(PASTA_RELATORIOS, "Basic.pdf");

    private static final File ARQUIVO_FONTE_RELATORIO_PARAMETRIZADO = new File(PASTA_RELATORIOS, "parameter.jrxml");
    private static final File ARQUIVO_COMPILADO_RELATORIO_PARAMETRIZADO = new File(PASTA_RELATORIOS, "parameter.jasper");
    private static final File RELATORIO_PDF_PARAMETRIZADO = new File(PASTA_RELATORIOS, "parameter.pdf");

    private static final File ARQUIVO_FONTE_RELATORIO_MENSAL = new File(PASTA_RELATORIOS, "Group.jrxml");
    private static final File ARQUIVO_COMPILADO_RELATORIO_MENSAL = new File(PASTA_RELATORIOS, "Group.jasper");
    private static final File RELATORIO_PDF_MENSAL = new File(PASTA_RELATORIOS, "Group.pdf");


    public RelatorioController() {
        try {
            String caminho = System.getProperty("user.dir");
            File arquivoConfig = new File(caminho, "/src/DAO/bancoD.properties");
            JDBCUtil.init(arquivoConfig);
            conexao = JDBCUtil.getConnection();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    public void gerarRelatorioMedico(boolean exibirSeVisualizar) {
        try {
            if (!ARQUIVO_COMPILADO_RELATORIO_MEDICO.exists()) {
                JasperCompileManager.compileReportToFile(ARQUIVO_FONTE_RELATORIO_MEDICO.getAbsolutePath(), ARQUIVO_COMPILADO_RELATORIO_MEDICO.getAbsolutePath());
            }

            JasperPrint impressao = JasperFillManager.fillReport(ARQUIVO_COMPILADO_RELATORIO_MEDICO.getAbsolutePath(), null, conexao);

            if (exibirSeVisualizar) {
                JasperViewer.viewReport(impressao, false);
            } else {
                JasperExportManager.exportReportToPdfFile(impressao, RELATORIO_PDF_MEDICO.getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso: " + RELATORIO_PDF_MEDICO.getAbsolutePath());
            }
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar o relatório: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void gerarRelatorioComParametro(Map<String, Object> parametros, boolean exibirSeVisualizar) {
        try {
            if (!ARQUIVO_COMPILADO_RELATORIO_PARAMETRIZADO.exists()) {
                JasperCompileManager.compileReportToFile(ARQUIVO_FONTE_RELATORIO_PARAMETRIZADO.getAbsolutePath(), ARQUIVO_COMPILADO_RELATORIO_PARAMETRIZADO.getAbsolutePath());
            }

            JasperPrint impressao = JasperFillManager.fillReport(ARQUIVO_COMPILADO_RELATORIO_PARAMETRIZADO.getAbsolutePath(), parametros, conexao);

            if (exibirSeVisualizar) {
                JasperViewer.viewReport(impressao, false);
            } else {
                JasperExportManager.exportReportToPdfFile(impressao, RELATORIO_PDF_PARAMETRIZADO.getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso: " + RELATORIO_PDF_PARAMETRIZADO.getAbsolutePath());
            }
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar o relatório: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void gerarRelatorioMes(boolean exibirSeVisualizar) {
        try {
            if (!ARQUIVO_COMPILADO_RELATORIO_MENSAL.exists()) {
                JasperCompileManager.compileReportToFile(ARQUIVO_FONTE_RELATORIO_MENSAL.getAbsolutePath(), ARQUIVO_COMPILADO_RELATORIO_MENSAL.getAbsolutePath());
            }

            JasperPrint impressao = JasperFillManager.fillReport(ARQUIVO_COMPILADO_RELATORIO_MENSAL.getAbsolutePath(), null, conexao);

            if (exibirSeVisualizar) {
                JasperViewer.viewReport(impressao, false);
            } else {
                JasperExportManager.exportReportToPdfFile(impressao, RELATORIO_PDF_MENSAL.getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso: " + RELATORIO_PDF_MENSAL.getAbsolutePath());
            }
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar o relatório: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
