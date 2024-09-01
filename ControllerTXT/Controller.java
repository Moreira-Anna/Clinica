package ControllerTXT;

import ControllerTXT.ControllerArquivo;
import ControllerTXT.ControllerArquivo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Ana Moreira
 */
public class Controller extends ControllerArquivo {

    private String texto = null;
    private BufferedReader leitor = null;
    private BufferedWriter escritor = null;

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return true caso a operação de leitura seja bem sucedida ou false caso
     * contrário.
     */
    @Override
    public boolean ler() {
        StringBuilder line = new StringBuilder();
        try {
            leitor = new BufferedReader(new FileReader(Arquivo));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                line.append(linha).append("\n");
            }
            setTexto(line.toString());
            return true;
        } catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado: " + erro.getMessage());
            return false;
        } catch (IOException erro) {
            System.err.println("Erro ao ler arquivo: " + erro.getMessage());
            return false;
        } finally {
            if (leitor != null) {
                try {
                    leitor.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar o leitor: " + e.getMessage());
                }
            }
        }
    }

@Override
public boolean escrever(boolean append) {
        if (Arquivo != null) {
            try {
                escritor = new BufferedWriter(new FileWriter(Arquivo, append));
                escritor.write(getTexto());
                return true;
            } catch (IOException erro) {
                System.err.println("Erro ao escrever no arquivo: " + erro.getMessage());
                return false;
            } finally {
                if (escritor != null) {
                    try {
                        escritor.close();
                    } catch (IOException e) {
                        System.err.println("Erro ao fechar o escritor: " + e.getMessage());
                    }
                }
            }
        } else {
            System.err.println("Arquivo não especificado.");
            return false;
        }
    }

}