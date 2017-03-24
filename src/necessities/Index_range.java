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
public class Index_range {
    Vector ind_ranges;
    
    public Index_range(){
        ind_ranges = new Vector();
    }
    
    public void add (Integer_const i_const){
        ind_ranges.add(0, i_const);
    }
    
}
