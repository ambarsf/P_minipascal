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
public class Factor {
    
    Variable var;
    Expression exp;
    Factor fact;
    String str;
    int num;
    char ch;
    
    public Factor(Variable var) {
        this.var = var;
    }

    public Factor(Expression exp) {
        this.exp = exp;
    }

    public Factor(Factor fact) {
        this.fact = fact;
    }

    public Factor(String str) {
        this.str = str;
    }

    public Factor(char ch) {
        this.ch = ch;
    }
    
    public Factor(int num){
        this.num=num;
    }
    
    
    
    
    
    
    
}
