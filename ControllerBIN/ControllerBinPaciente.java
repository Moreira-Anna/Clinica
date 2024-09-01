package ControllerBIN;

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
import Model.Consulta;
import Model.Paciente;

/**
 *
 * @author ANA MOREIRA
 */
public abstract class ControllerBinPaciente extends ControllerArquivo {

    private String filePath;
    private ArrayList<Paciente> pac = new ArrayList<>();
    private ObjectInputStream ler = null;
    private ObjectOutputStream escreve = null;

    public ControllerBinPaciente() {

    }

    public ControllerBinPaciente(String filePath) {
        Arquivo = new File(filePath);
        this.filePath = filePath;
    }

    public ArrayList<Paciente> getPaciente() {
        return pac;
    }

    public void setPaciente(ArrayList<Paciente> pac) {
        this.pac = pac;
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
                    if (!list.isEmpty() && list.get(0) instanceof Paciente) {
                        pac = (ArrayList<Paciente>) list;
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

    public boolean escrever(ArrayList<Paciente> objects, String fileName, boolean append) {
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

    public boolean escreveArquivo(ArrayList<Paciente> objects, String fileName, boolean append) {
        return escrever(objects, fileName, append);
    }

    public class NaoEncontradoException extends Exception {

        public NaoEncontradoException(String message) {
            super(message);
        }
    }

    public List<Paciente> delete(List<Paciente> objects, String cpf) {
        Iterator<Paciente> iterator = objects.iterator();
        boolean Encontrado = false;

        while (iterator.hasNext()) {
            Paciente obj = iterator.next();
            if (obj.getCpf().equals(cpf)) {
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

    public List<Paciente> atualiza(List<Paciente> objects, Paciente novo) {
        for (Paciente obj : objects) {
            if (obj.getCpf().equals(novo.getCpf())) {
                obj.setNomePac(novo.getNomePac());
                obj.setTelefonePac(novo.getTelefonePac());

            }

        }
        return objects;

    }

    public ArrayList<Paciente> abrir() {
        try {
            FileInputStream fis = new FileInputStream(Arquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Paciente> objetos = (ArrayList<Paciente>) ois.readObject();
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
       
    public void addPac(String cpf, String nomeM, String telefone, String data, String des) {
        Paciente pac = new Paciente();
        pac.setCpf(cpf);
        pac.setNomePac(nomeM);
        pac.setTelefonePac(telefone);

        Consulta consulta = new Consulta();
        consulta.setDataCon(data);
        consulta.setDescrição(des);

        // Adiciona a consulta ao paciente
        pac.setConsulta(consulta);

        getPaciente().add(pac);
    }
}
