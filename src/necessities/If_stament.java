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
public class If_stament {
    
    Expression exp;
    Stament st1;
    Stament st2;

    public If_stament(Expression exp, Stament st) {
        this.exp = exp;
        this.st1 = st;
    }

    public If_stament(Expression exp, Stament st1, Stament st2) {
        this.exp = exp;
        this.st1 = st1;
        this.st2 = st2;
    }
    
    
    
    
    
    
    
}
