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
public class Writes {
    Vector values;
    
    public Writes(){
        values = new Vector();
    }
    
    public void add(Output_value o_v){
        values.add(0, o_v);
    }
    
    
    
    
}
