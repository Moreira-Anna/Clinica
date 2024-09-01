/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerTXT;

import Model.Paciente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Model.Consulta;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author ANA MOREIRA
 */
public class ControllerTxtPac extends Controller {

    public Paciente P = new Paciente();
    public Consulta C = new Consulta();

    public Paciente lerPaciente(String cpf) {
        try {
            setArquivo("InformaçãoPaciente.TXT");
            ler();
            String aux = getTexto();

            StringTokenizer tokens = new StringTokenizer(aux, ";\n");

            while (tokens.hasMoreTokens()) {
                String cpfPaciente = tokens.nextToken();
                if (cpfPaciente.equals(cpf)) {
                    Paciente paciente = new Paciente();
                    paciente.setCpf(cpfPaciente);
                    paciente.setNomePac(tokens.nextToken());
                    paciente.setTelefonePac(tokens.nextToken());

                    Consulta consulta = new Consulta();
                    consulta.setDataCon(tokens.nextToken());
                    consulta.setDescrição(tokens.nextToken());

                    paciente.setConsulta(consulta); // Associa a consulta ao paciente
                    return paciente;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro  " + e.getMessage());
        }
        return null;
    }

 public void GravarPaciente() {
        // Verifica se o CPF tem mais de 11 caracteres
        if (P.getCpf().length() > 11) {
            JOptionPane.showMessageDialog(null, "O CPF não pode ter mais de 11 dígitos. Por favor, verifique e tente novamente.");
            return; 
        }

        String aux = P.getCpf() + ";" + P.getNomePac() + ";" + P.getTelefonePac() + ";" + C.getDataCon() + ";" + C.getDescrição() + "\n";
        setTexto(aux);
        try {
            setArquivo("InformaçãoPaciente.TXT");
            escrever(true);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.err.println("Erro de E/S ao gravar o médico: " + e.getMessage());
        }
    }

    public ArrayList<Paciente> ListaP() {
        try {
            setArquivo("InformaçãoPaciente.TXT");
            ler();
            String aux = getTexto();
            ArrayList<Paciente> listaPacientes = new ArrayList<>();
            StringTokenizer tokens = new StringTokenizer(aux, ";\n");
            while (tokens.hasMoreTokens()) {
                Paciente paciente = new Paciente();
                paciente.setNomePac(tokens.nextToken());
                paciente.setCpf(tokens.nextToken());
                paciente.setTelefonePac(tokens.nextToken());

                Consulta consulta = new Consulta();
                consulta.setDataCon(tokens.nextToken());
                consulta.setDescrição(tokens.nextToken());

                paciente.setConsulta(consulta); 
                listaPacientes.add(paciente);
            }
            return listaPacientes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void ExcluirPaciente(String cpf) {
        ArrayList<Paciente> listaPacientes = ListaP();
        listaPacientes.removeIf(paciente -> paciente.getCpf().equals(cpf));
        StringBuilder sb = new StringBuilder();
        for (Paciente paciente : listaPacientes) {
            sb.append(paciente.toString()).append(System.lineSeparator());
        }
        setArquivo("InformaçãoPaciente.TXT");
        setTexto(sb.toString());
        escrever(false);
    }

    public void editarPaciente(String cpf, String nome, String telefone, String data, String descricao) {
        boolean pacienteEncontrado = false; 
        try ( BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\naahs\\Downloads\\Clinica\\med\\InformaçãoPaciente.TXT"))) {
            StringBuilder arquivoAtualizado = new StringBuilder();
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length >= 1 && partes[0].trim().equals(cpf)) {
                    linha = cpf + ";" + nome + ";" + telefone + ";" + data + ";" + descricao;
                    pacienteEncontrado = true; 
                }
                arquivoAtualizado.append(linha).append("\n");
            }
            try ( BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\naahs\\Downloads\\Clinica\\med\\InformaçãoPaciente.TXT"))) {
                bw.write(arquivoAtualizado.toString());
            }
            if (!pacienteEncontrado) {
                throw new RuntimeException("Paciente não encontrado para editar.");
            }
            System.out.println("Paciente atualizado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro de E/S ao editar o paciente: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Erro ao editar o paciente: " + e.getMessage());
        }
    }

    public Paciente getP() {
        return P;
    }

    public void setP(Paciente P) {
        this.P = P;
    }

    public void setPaciente(String cpf, String NomeP, String TelefoneP, String data, String Descrição) {
        this.P.setCpf(cpf);
        this.P.setNomePac(NomeP);
        this.P.setTelefonePac(TelefoneP);
        this.C.setDataCon(data);
        this.C.setDescrição(Descrição);

    }

}
