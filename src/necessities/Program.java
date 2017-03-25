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
    
    public Identifier iden;
    public Block block; 
    
    public Program(Identifier id){
        iden = id;
    }
    
    public Program (Block blok){
        block = blok;
    }
    
    public Program (Identifier id, Block bl){
        iden = id;
        block = bl;
    }    
}
