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
public class Type {
    Simple_type sim_t;
    Array_type arr_t;
    
    public Type(Simple_type si_t){
        sim_t = si_t;
    }
    
    public Type(Array_type ar_t){
        arr_t = ar_t;
    }
    
}
