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
public class Variable_dec {
    Vector identifiers = new Vector();
    
    public Variable_dec(){
        identifiers=new Vector();
    }
    public void add(Variable_d vd){
        identifiers.add(0, vd);
    }  
}
