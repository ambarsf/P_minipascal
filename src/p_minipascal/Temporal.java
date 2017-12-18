/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_minipascal;

/**
 *
 * @author ambarsuarez
 */
public class Temporal {
    private static int cont =0;
    public static String temp;

    public Temporal() {
        this.temp = "t_"+cont++;     
    }

    public String getTemporal() {
        return temp;
    }

    public void setTemporal(String temp) {
        this.temp = temp;
    }
    

    @Override
    public String toString() {
        return temp;
    }
    
}
