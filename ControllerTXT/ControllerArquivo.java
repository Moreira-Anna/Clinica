package ControllerTXT;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Ana Moreira
 *
 */
public abstract class ControllerArquivo {

    protected File Arquivo = null;

    public abstract boolean ler();

    public abstract boolean escrever(boolean append);

    /**
     * @return the arquivo
     */
    public File getArquivo() {
        return Arquivo;
    }

    /**
     * @param TextoBotao o texto para o botão de escolha do usuário
     */
    public void setArquivo(String TextoBotao) {
        Arquivo = null;
        String pastaInicial = System.getProperty("user.dir") + "/med/" + TextoBotao;

        // Verificar se o diretório "med" existe, senão criar
        File diretorioMed = new File(System.getProperty("user.dir") + "/med");
        if (!diretorioMed.exists()) {
            diretorioMed.mkdirs(); // Cria o diretório se não existir
        }

        Arquivo = new File(pastaInicial);
    }
}
