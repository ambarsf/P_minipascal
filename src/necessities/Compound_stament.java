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
public class Compound_stament {
    
    Vector staments;

    public Compound_stament(Vector staments) {
        this.staments = new Vector();
    }
    
    public void add(Stament st){
        staments.add(0, st);
    }
    
    
}
