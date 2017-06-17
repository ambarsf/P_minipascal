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
public class Simple_expression {
    Term term;
    Simple_expression s_e;
    Temp tmp;

    public Simple_expression(Term term) {
        this.term = term;
    }
    
    public Simple_expression(Term term,Temp tmp) {
        this.term = term;
        this.tmp = tmp;
    }
    
    public Temp getTemp() {
        return tmp;
    }

    public void setTemp(Temp tmp) {
        this.tmp = tmp;
    }

    public Term getTerm() {
        return term;
    }

    @Override
    public String toString() {
        return ""+term;
    }
    
    
    
    
}
