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
public class Temp {
    private static int cont =0;
    String temp;

    public Temp() {
        this.temp = "t"+cont++;     
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
    
    public String LastTemp(){
        int num = cont-1;
        String t = "t"+num;
        return t;
    }

    @Override
    public String toString() {
        return temp;
    }
    
    
    
    
}
