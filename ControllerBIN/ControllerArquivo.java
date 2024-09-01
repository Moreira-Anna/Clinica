/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerBIN;

import java.io.File;
import javax.swing.JFileChooser;

import java.io.File;
import java.io.IOException;

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
public void setArquivo(String nomeArquivo) {
    Arquivo = null;
    String pastaInicial = System.getProperty("user.dir") + File.separator + "med" + File.separator + nomeArquivo;

    File diretorioMed = new File(System.getProperty("user.dir") + File.separator + "med");
    if (!diretorioMed.exists()) {
        diretorioMed.mkdirs(); // Cria o diretório se não existir
    }

    Arquivo = new File(pastaInicial);

    if (!Arquivo.exists()) {
        try {
            Arquivo.createNewFile(); // Cria o arquivo se não existir
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }
}


}


