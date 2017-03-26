/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package necessities;

/**
 *
 * @author ambarsuarez
 */
public class Program {
    
    public String iden;
    public Block block; 
    
    public Program(String id){
        iden = id;
    }
    
    public Program (Block blok){
        block = blok;
    }
    
    public Program (String id, Block bl){
        iden = id;
        block = bl;
    }
    
    @Override
    public String toString(){
        return "PROGRAM to String";
    }
	    
}
