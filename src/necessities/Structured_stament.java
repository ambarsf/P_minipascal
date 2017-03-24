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
public class Structured_stament {
    
   Compound_stament c_st;
   If_stament if_st;
   While_stament while_st;

    public Structured_stament(Compound_stament c_st) {
        this.c_st = c_st;
    }

    public Structured_stament(If_stament if_st) {
        this.if_st = if_st;
    }

    public Structured_stament(While_stament while_st) {
        this.while_st = while_st;
    }
   
   
    
}
