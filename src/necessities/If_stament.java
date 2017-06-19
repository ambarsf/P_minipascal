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
    Staments st1;
    Staments st2;

    public If_stament(Expression exp, Staments st) {
        this.exp = exp;
        this.st1 = st;
    }

    public If_stament(Expression exp, Staments st1, Staments st2) {
        this.exp = exp;
        this.st1 = st1;
        this.st2 = st2;
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }

    public Staments getSt1() {
        return st1;
    }

    public void setSt1(Staments st1) {
        this.st1 = st1;
    }

    public Staments getSt2() {
        return st2;
    }

    public void setSt2(Staments st2) {
        this.st2 = st2;
    }
    
    
    
    
    
    
    
    
}
