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
public class Block {
    
    Variable_dec_part   v_declarations;
    Procedure_dec_part  p_declarations;
    Compound_stament        stament_part;
    
    public Block(Variable_dec_part v_dec){
        v_declarations = v_dec;
    }
    
    public Block(Procedure_dec_part p_dec){
        p_declarations = p_dec;
    }


    public Block(Variable_dec_part v_declarations, Procedure_dec_part p_declarations, Compound_stament stament_part) {
        this.v_declarations = v_declarations;
        this.p_declarations = p_declarations;
        this.stament_part = stament_part;
    }
    
}
    
   