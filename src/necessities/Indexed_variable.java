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
public class Indexed_variable {
    Array_variable ar_var;
    Expression exp;

    public Indexed_variable(Array_variable ar_var, Expression exp) {
        this.ar_var = ar_var;
        this.exp = exp;
    }

    public Array_variable getAr_var() {
        return ar_var;
    }

    public Expression getExp() {
        return exp;
    }

    @Override
    public String toString() {
        return ""+ar_var ;
    }
    
    

    
    
    
}
