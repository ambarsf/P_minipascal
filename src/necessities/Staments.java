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
public class Staments {
    Vector values;
    
    public Staments(){
        values = new Vector();
    }
    
    public void add(Stament st){
        values.add(0, st);
    }
    
}
