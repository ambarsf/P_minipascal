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
public class Procedure_dec_part {
    Vector declarations = new Vector();
    
    public Procedure_dec_part(){
        declarations = new Vector();
    }
    
    public void add(Procedure_dec p_dec){
        declarations.add(0, p_dec);
    }
    
}
