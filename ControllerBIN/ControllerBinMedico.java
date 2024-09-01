package ControllerBIN;

import Model.Medico;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import ControllerBIN.ControllerArquivo;

/**
 *
 * @author ANA MOREIRA
 */
public abstract class ControllerBinMedico extends ControllerArquivo {

    private String filePath;
    private ArrayList<Medico> med = new ArrayList<>();
    private ObjectInputStream ler = null;
    private ObjectOutputStream escreve = null;

    public ControllerBinMedico() {

    }

    public ControllerBinMedico(String filePath) {
        Arquivo = new File(filePath);
        this.filePath = filePath;
    }

    public ArrayList<Medico> getMedico() {
        return med;
    }

    public void setMedico(ArrayList<Medico> med) {
        this.med = med;
    }

    private void closeReader() {
        if (ler != null) {
            try {
                ler.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeWriter() {
        if (escreve != null) {
            try {
                escreve.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean ler() {
        if (Arquivo == null) {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado.");
            return false;
        }

        try {
            ler = new ObjectInputStream(new FileInputStream(Arquivo));
            Object obj;
            while ((obj = ler.readObject()) != null) {
                if (obj instanceof ArrayList<?>) {
                    ArrayList<?> list = (ArrayList<?>) obj;
                    if (!list.isEmpty() && list.get(0) instanceof Medico) {
                        med = (ArrayList<Medico>) list;
                        return true;
                    }
                }
            }
            throw new IOException("Formato de arquivo inválido ou vazio.");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "O arquivo não foi encontrado, será criado um arquivo!");
            e.printStackTrace();
            closeReader();
            return false;
        } catch (EOFException e) {
            System.err.println("erro : EOFException ");
            closeReader();
            return false;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
            closeReader();
            return false;
        } finally {
            closeReader();
        }
    }

    public boolean escrever(ArrayList<Medico> objects, String fileName, boolean append) {
        try {
            escreve = new ObjectOutputStream(new FileOutputStream(fileName, append));
            escreve.writeObject(objects);
            closeWriter();
            return true;
        } catch (IOException e) {
            // Exceção de E/S (IOException) - Tratar, logar ou relatar o erro de forma personalizada.
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            return false;
        } finally {
            closeWriter();
        }
    }

    public boolean escreveArquivo(ArrayList<Medico> objects, String fileName, boolean append) {
        return escrever(objects, fileName, append);
    }

    public class NaoEncontradoException extends Exception {

        public NaoEncontradoException(String message) {
            super(message);
        }
    }

    public List<Medico> delete(List<Medico> objects, String nome) {
        Iterator<Medico> iterator = objects.iterator();
        boolean Encontrado = false;

        while (iterator.hasNext()) {
            Medico obj = iterator.next();
            if (obj.getCfm().equals(nome)) {
                iterator.remove(); // Remove o elemento da lista
                Encontrado = true;
            }
        }

        if (Encontrado) {
            System.out.println(" excluído com sucesso.");
        } else {
            try {
                throw new NaoEncontradoException(" não encontrado. Falha ao excluir.");
            } catch (NaoEncontradoException e) {
                System.err.println(e.getMessage());
            }
        }

        return objects;
    }

   public ArrayList<Object> getObjects() {
    ArrayList<Object> objects = new ArrayList<>();
    try {
        ler = new ObjectInputStream(new FileInputStream(Arquivo));
        Object obj;
        while ((obj = ler.readObject()) != null) {
            objects.add(obj);
        }
        closeReader();
    } catch (EOFException e) {
        // final do arquivo alcançado, não é um erro, apenas pare de ler
        closeReader();
    } catch (IOException e) {
        // Trate a exceção de I/O aqui
        System.err.println("Erro de I/O ao ler objetos: " + e.getMessage());
        closeReader();
    } catch (ClassNotFoundException e) {
        // Trate a exceção de classe não encontrada aqui
        System.err.println("Classe não encontrada ao ler objetos: " + e.getMessage());
        closeReader();
    }
    return objects;
}

    public List<Medico> atualiza(List<Medico> objects, Medico novo) {
        for (Medico obj : objects) {
            if (obj.getCfm().equals(novo.getCfm())) {
                obj.setNomeMed(novo.getNomeMed());
                obj.setTelefoneMed(novo.getTelefoneMed());

            }

        }
        return objects;

    }

    public ArrayList<Medico> abrir() {
        try {
            FileInputStream fis = new FileInputStream(Arquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Medico> objetos = (ArrayList<Medico>) ois.readObject();
            return objetos;
        } catch (IOException e) {
            System.err.println("Erro ao abrir o arquivo: " + e.getMessage());
            return new ArrayList<>(); 
        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao deserializar objetos: " + e.getMessage());
            return new ArrayList<>(); 
        }
    }

    public boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    public void addMedico(String cfm, String nomeM, String telefone) {
        Medico M = new Medico();
        M.setCfm(cfm);
        M.setNomeMed(nomeM);
        M.setTelefoneMed(telefone);

        getMedico().add(M);

    }

}
