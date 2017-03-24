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
public class Stament {
    Simple_stament s_st;
    Structured_stament  c_st;

    public Stament(Simple_stament s_st) {
        this.s_st = s_st;
    }

    public Stament(Structured_stament c_st) {
        this.c_st = c_st;
    }
    
    
    
}
