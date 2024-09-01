package Model;

import java.io.Serializable;

/**
 *
 * @author Ana Moreira
 */
public  class Medico implements Serializable {
    private static long serialVersionUID = 2L;

     String nomeMed;
     String telefoneMed;
     String cfm;
    
    public Medico(){
        nomeMed = " ";
        telefoneMed= "";
        cfm = "";
    }

    public Medico(String nomeMed, String telefoneMed, String cfm) {
        this.nomeMed = nomeMed;
        this.telefoneMed = telefoneMed;
        this.cfm = cfm;
    }

    public String getNomeMed() {
        return nomeMed;
    }

    public void setNomeMed(String nomeMed) {
        this.nomeMed = nomeMed;
    }

    public String getTelefoneMed() {
        return telefoneMed;
    }

    public void setTelefoneMed(String telefoneMed) {
        this.telefoneMed = telefoneMed;
    }

    public String getCfm() {
        return cfm;
    }

    public void setCfm(String cfm) {
        this.cfm = cfm;
    }

}
