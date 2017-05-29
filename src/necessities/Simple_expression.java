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
public class Simple_expression {
    Term term;
    Simple_expression s_e;

    public Simple_expression(Term term) {
        this.term = term;
    }

    public Term getTerm() {
        return term;
    }

    @Override
    public String toString() {
        return ""+term;
    }
    
    
    
    
}
