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
public class Main_Cup {
    public static void main(String[] args){
        String params [] = {"-destdir", "src//minipascal","-parser", 
            "parser","src//p_minipascal//Parser.cup"};
        try{
            java_cup.Main.main(params);
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
}
