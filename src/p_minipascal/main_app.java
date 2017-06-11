/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_minipascal;

import java.io.*;


/**
 *
 * @author ambarsuarez
 */
public class main_app {
    public static void main(String argv[]){
        try{
            parser p = new parser(new Lexer(new FileReader("example6.pas")));
            p.parse();
        }catch(Exception e ){
            e.printStackTrace();
        }
    }
   //Character ch = (Character)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value.toString().charAt(0);

}
