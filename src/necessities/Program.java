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
    public Block block; //idk si tiene que ir aqui este :(
    
    public Program(Identifier id){
        iden = id;
    }
    
    public Program (Block blok){
        block = blok;
    }
    
}
