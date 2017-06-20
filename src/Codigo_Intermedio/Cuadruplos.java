/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo_Intermedio;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author ambarsuarez
 */
public class Cuadruplos {
    static ArrayList<Cuadruplo> Cuadruplos = new ArrayList();

    public Cuadruplos() {
        ArrayList<Cuadruplo> Cuadruplos = new ArrayList();
    }
    
    static public void Imprimir(){
        //Collections.reverse(Cuadruplos);
        System.out.println(String.format("%-15s%-30s%-30s%-15s" , "OP", "ARG1","  ARG2","  RES"));     
        for (int i = 0; i < Cuadruplos.size(); i++) {
            System.out.println(Cuadruplos.get(i));
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    
    
    static public void add(Cuadruplo cuad){
        Cuadruplos.add(cuad);
    }
    
    static public void addy(Cuadruplo cuad){
        Cuadruplos.add(0,cuad);
    }
    
}
