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
public class Temp {
    private static int cont;
    String temp;

    public Temp() {
        this.temp = "t"+cont++;     
    }
    
    public Temp(String temp){
        this.temp = temp;
    }

    @Override
    public String toString() {
        return temp;
    }
    
    
    
    
}
