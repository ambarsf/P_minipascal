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
public class Array_type {
    Index_range ind_range;
    Simple_type  sim_t;

    public Array_type(Index_range ind_range, Simple_type sim_t) {
        this.ind_range = ind_range;
        this.sim_t = sim_t;
    }

    @Override
    public String toString() {
        return "Array of "+sim_t;
    }
    
    
}
