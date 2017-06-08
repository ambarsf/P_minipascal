/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo_Intermedio;

/**
 *
 * @author ambarsuarez
 */
public class Etiqueta {
    private static int cont;
    private String etiq;

    public Etiqueta(String name) {
        this.etiq = name;
    }
    
    public Etiqueta(){
        this.etiq = "Etiq_"+cont++;
    }

    public void setEtiq(String etiq) {
        this.etiq = etiq;
    }

    @Override
    public String toString() {
        return etiq;
    }
    
    
    
    
    
}
