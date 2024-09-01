package ControllerBIN;

import Model.Paciente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author ANA MOREIRA
 */
public class Controller extends ControllerArquivo {
    
     private Paciente paciente = null;
    private ObjectInputStream leitor = null;
    private ObjectOutputStream escritor = null;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean ler() {
        try {
            leitor = new ObjectInputStream(new FileInputStream(Arquivo));
            paciente = (Paciente) leitor.readObject();
            leitor.close();
            return true;
        } catch (ClassNotFoundException erro) {
            System.err.println(erro.getMessage() + "Classe não encontrada.");
            return false;
        } catch (IOException erro) {
            System.err.println(erro.getMessage() + "Erro ao ler arquivo binário.");
            return false;
        }
    }

    @Override
    public boolean escrever(boolean append) {
        if (Arquivo != null) {
            try {
                escritor = new ObjectOutputStream(new FileOutputStream(Arquivo, append));
                escritor.writeObject(paciente);
                escritor.close();
                return true;
            } catch (IOException erro) {
                System.err.println(erro.getMessage() + "Erro ao escrever arquivo binário.");
                return false;
            }
        } else {
            return false;
        }
    }

    public static ObjectOutputStream criaEscritorObjeto(File arquivo) {
        ObjectOutputStream out = null;
        try {
            if (arquivo.exists()) {
                FileOutputStream fos = new FileOutputStream(arquivo, true);
                out = new ObjectOutputStream(fos) {
                    @Override
                    protected void writeStreamHeader() {
                        // do not write a header
                    }
                };
            } else {
                FileOutputStream fos = new FileOutputStream(arquivo, true);
                out = new ObjectOutputStream(fos);
            }
        } catch (IOException erro) {
            System.out.println("Erro ao criar arquivo. " + erro);
        }
        return out;
    }
}
