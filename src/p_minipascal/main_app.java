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
            parser p = new parser(new Lexer(new FileReader("example1.pas")));
            p.parse();
            SymbolTable TablaSimbolos = new SymbolTable();
            
            Cuadruplos.Imprimir();
        }catch(Exception e ){
            e.printStackTrace();
        }
    }

}
