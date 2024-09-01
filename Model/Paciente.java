package Model;
import java.io.Serializable;

/**
 *
 * @author Ana Moreira
 */
public class Paciente extends Medico implements Serializable {
 

    String nomePac;
    String cpf;
    String telefonePac;
    private Consulta consulta;

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Paciente(Consulta consulta) {
        this.consulta = consulta;
    }

    public  Paciente() {
        nomePac = "";
        cpf = "";
        telefonePac = "";
    }

    public Paciente(String nomePac, String cpf, String telefonePac, String dataCon) {
        this.nomePac = nomePac;
        this.cpf = cpf;
        this.telefonePac = telefonePac;
    }

    public String getNomePac() {
        return nomePac;
    }

    public void setNomePac(String nomePac) {
        this.nomePac = nomePac;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefonePac() {
        return telefonePac;
    }

    public void setTelefonePac(String telefonePac) {
        this.telefonePac = telefonePac;
    }

    @Override
    public String toString() {
        return"";

    }
    

}
