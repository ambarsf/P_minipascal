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
    boolean verd;
    boolean fals;
    int type=0;
    
    public Factor(Variable var) {
        this.var = var;
        type=1;
    }

    public Factor(Expression exp) {
        this.exp = exp;
    }

    public Factor(Factor fact) {
        this.fact = fact;
    }

    public Factor(String str) {
        this.str = str;
        type=2;
    }

    public Factor(char ch) {
        this.ch = ch;
        type=3;
    }
    
    public Factor(int num){
        this.num=num;
        type=4;
    }

    public Variable getVar() {
        return var;
    }

    public Expression getExp() {
        return exp;
    }

    public Factor getFact() {
        return fact;
    }

    public String getStr() {
        return str;
    }

    public int getNum() {
        return num;
    }

    public char getCh() {
        return ch;
    }

    public boolean isVerd() {
        return verd;
    }

    public boolean isFals() {
        return fals;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        if (type==1){
          return ""+var;  
        }else if (type==2){
            return str;
        }else if(type==3){
            return ""+ch;
        }else {
           return ""+num; 
        }
    }
    
    
    
    
    
    
    
    
    
}
