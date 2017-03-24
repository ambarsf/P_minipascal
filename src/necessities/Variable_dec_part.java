/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package necessities;

import java.util.Vector;

/**
 *
 * @author ambarsuarez
 */
public class Variable_dec_part {
    private Vector declarations;
    
    public Variable_dec_part(){
        declarations = new Vector();
    }
    
    public void add(Variable_dec v_dec){
        declarations.add(0, v_dec);
    }
}
