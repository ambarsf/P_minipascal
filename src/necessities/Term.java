/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package necessities;

import Codigo_Intermedio.Temp;

/**
 *
 * @author ambarsuarez
 */
public class Term {
    Factor fact;
    Term term;
    Temp tmp = null;
    
    

    public Term(Factor fact) {
        this.fact = fact;
    }
    
    public Term(Factor fact,Temp tmp) {
        this.fact = fact;
        this.tmp = tmp;
    }

    public Term getTerm() {
        return term;
    }

    public Temp getTemp() {
        return tmp;
    }

    public void setTemp(Temp tmp) {
        this.tmp = tmp;
    }

    public Factor getFact() {
        return fact;
    }

    @Override
    public String toString() {
        return ""+fact ;
    }
    
    

    
    
    
    
    
}
