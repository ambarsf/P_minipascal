/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_minipascal;

import java.io.File;

/**
 *
 * @author ambarsuarez
 */
public class Main_jflex {
    public static void main(String[] args){
        File f = new File ("src//p_minipascal//Lexer.flex");
        jflex.Main.generate(f);
    }
    
}
