/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerTXT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Model.Medico;
import java.util.StringTokenizer;

/**
 *
 * @author ANA MOREIRA
 */
public class ControllerTxtMed extends Controller {

    public Medico M = new Medico();

    public Medico lerMedico(String CFM) {
        // Verifica se o CFM tem mais de 7 
        if (CFM.length() > 7) {
            throw new IllegalArgumentException("O CFM não pode ter mais de 7 caracteres.");
        }

        try ( BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\naahs\\Downloads\\Clinica\\med\\ListaMedico.TXT"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length >= 1 && partes[0].trim().equals(CFM)) {
                    M.setCfm(partes[0]);
                    M.setNomeMed(partes[1]);
                    M.setTelefoneMed(partes[2]);
                    return M;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro de E/S ao ler o médico: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.err.println("Erro: " + e.getMessage());
        }
        return null;
    }

    public void GravarMedico() {
        String cfm = M.getCfm();
        if (cfm.length() > 8) { // Permitindo até 7 casas decimais, então o comprimento máximo é 8
            System.err.println("Erro: CFM não pode ter mais de 7 números.");
            return;
        }
        String aux = cfm + ";" + M.getNomeMed() + ";" + M.getTelefoneMed() + "\n";
        setTexto(aux);
        try {
            setArquivo("ListaMedico.TXT");
            escrever(true);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.err.println("Erro de E/S ao gravar o médico: " + e.getMessage());
        }

    }

    public ArrayList<Medico> ListaMed() {
        try {
            setArquivo("ListaMedico.TXT");
            ler();
            String aux = getTexto();
            ArrayList<Medico> listaMedico = new ArrayList<>();
            StringTokenizer tokens = new StringTokenizer(aux, ";\n");
            while (tokens.hasMoreTokens()) {
                M.setCfm(tokens.nextToken());
                M.setNomeMed(tokens.nextToken());
                M.setTelefoneMed(tokens.nextToken());

                listaMedico.add(M);
            }
            return listaMedico;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.err.println("Erro ao converter um número: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void excluirMedico(String cfm) {
        List<Medico> lista = ListaMed();
        lista.removeIf(med -> med.getCfm().equals(cfm));
        setArquivo("ListaMedico.TXT");
        setTexto(lista.toString().replace("[]", ""));
        escrever(false);
    }

    public void editarMedico(String cfm, String nome, String telefone) {

        boolean medicoEncontrado = false;
        try ( BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\naahs\\Downloads\\Clinica\\med\\ListaMedico.TXT"))) {
            StringBuilder arquivoAtualizado = new StringBuilder();
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length >= 1 && partes[0].trim().equals(cfm)) {
                    linha = cfm + ";" + nome + ";" + telefone;
                    medicoEncontrado = true;
                }
                arquivoAtualizado.append(linha).append("\n");
            }
            try ( BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\naahs\\Downloads\\Clinica\\med\\ListaMedico.TXT"))) {
                bw.write(arquivoAtualizado.toString());
            }
            if (!medicoEncontrado) {
                throw new RuntimeException("Médico não encontrado para editar.");
            }
            System.out.println("Médico atualizado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro de E/S ao editar o médico: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Erro ao editar o médico: " + e.getMessage());
        }
    }

    public Medico getMEd() {
        return M;
    }

    public void setMedico(Medico M) {
        this.M = M;
    }

    public void setMedico(String cfm, String NomeMed, String TelefoneMed) {
        this.M.setCfm(cfm);
        this.M.setNomeMed(NomeMed);
        this.M.setTelefoneMed(TelefoneMed);

    }

    public void setMed(String NomeMed) {
        this.M.setNomeMed(NomeMed);

    }

}
