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
public class Read_stament {
    Vector variables;

    public Read_stament() {
        this.variables = new Vector();
    }
    
     public void add(Input_variable i_v){
        variables.add(0, i_v);
    }
    
    
    
}
