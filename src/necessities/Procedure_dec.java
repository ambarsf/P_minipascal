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
public class Procedure_dec {
    String ident;
    Block block;
    
    public Procedure_dec(String id){
        ident = id;
    }
    
    public Procedure_dec(Block bl){
        block = bl;
    }

    public Procedure_dec(String ident, Block block) {
        this.ident = ident;
        this.block = block;
    }

}
