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
public class Term {
    Factor fact;
    Term term;
    

    public Term(Factor fact) {
        this.fact = fact;
    }

    public Term getTerm() {
        return term;
    }

    public Factor getFact() {
        return fact;
    }

    @Override
    public String toString() {
        return ""+fact ;
    }
    
    

    
    
    
    
    
}
