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
    public static int cont=0;
    private String etiq;
    public static String cicloActual = "";

    public Etiqueta(String name) {
        this.etiq = name;
    }
    
    public Etiqueta(){
        this.etiq = "Etiq_"+cont++;
    }

    public void setEtiq(String etiq) {
        this.etiq = etiq;
    }

    public static int getCont() {
        return cont;
    }
   
    @Override
    public String toString() {
        return etiq;
    }
    
    
    
    
    
}
