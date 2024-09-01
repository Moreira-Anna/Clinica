/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Medico;
import java.io.Serializable;

/**
 *
 * @author Ana Moreira
 */
public class Consulta extends Medico {

        String dataCon;
        String Descricao;
        
    public Consulta() {
        dataCon = "";
        Descricao="";
    }
    public Consulta(String Data, String Desc) {
        this.dataCon = Data;
        this.Descricao = Desc;
    }

    public String getDataCon() {
        return dataCon;
    }

    public void setDataCon(String dataCon) {
        this.dataCon = dataCon;
    }

    public String getDescrição() {
        return Descricao;
    }

    public void setDescrição(String Descrição) {
        this.Descricao = Descrição;
    }
    
}
