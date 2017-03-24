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
public class Simple_stament {
    
    Assign_stament a_st;
    Procedure_stament pr_st;
    Read_stament r_st;
    Write_stament w_st;

    public Simple_stament(Assign_stament a_st) {
        this.a_st = a_st;
    }

    public Simple_stament(Procedure_stament pr_st) {
        this.pr_st = pr_st;
    }

    public Simple_stament(Read_stament r_st) {
        this.r_st = r_st;
    }

    public Simple_stament(Write_stament w_st) {
        this.w_st = w_st;
    }
    
    
    
}
