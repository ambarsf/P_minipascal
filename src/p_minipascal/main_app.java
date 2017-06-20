/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_minipascal;
import Codigo_Intermedio.Cuadruplos;
import java.util.*;
import java.io.*;
import java.util.Map;
import p_minipascal.Simbolo;


/**
 *
 * @author ambarsuarez
 */
public class main_app {
    public static void main(String argv[]){
        try{
            parser p = new parser(new Lexer(new FileReader("example6.pas")));
            p.parse();
            SymbolTable.imprimir();
            //imprimiendo Cuadruplos
            //Cuadruplos.Imprimir();
            //obteniendo los mensajes de los cuadruplos
            ArrayList<String> messages = new ArrayList();
            for (int i = 0; i < Cuadruplos.getCuadruplos().size(); i++) {
                if (Cuadruplos.getCuadruplos().get(i).getOperacion().matches("WRITE")){
                    messages.add(Cuadruplos.getCuadruplos().get(i).getArgumento1());
                }
            }
            //Creando codigo Final
            f_codegenerator  Codigo_final = new f_codegenerator(messages);
            Codigo_final.generateCode();
            Codigo_final.printCode();
            
        }catch(Exception e ){
            e.printStackTrace();
        }
    }

}
