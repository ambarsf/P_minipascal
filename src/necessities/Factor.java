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
    boolean bool;
    int type;
    Caller caller;
    String tipo;

    public Caller getCaller() {
        return caller;
    }
    
    
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
        tipo = "string";
    }

    public Factor(char ch) {
        this.ch = ch;
        type=3;
        tipo = "character";
    }
    
    public Factor(int num){
        this.num=num;
        type=4;
        tipo = "integer";
    }

    public Factor(boolean bool) {
        this.bool = bool;
        type = 6;
    }
    
    public Factor(Caller caller){
        this.caller = caller;
        type =5;
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

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public char getCh() {
        return ch;
    }

    public int getType() {
        return type;
    }
    
    public String getTipo(){
        return tipo;
    }
    @Override
    public String toString() {
        if (type==1){
          return ""+var;  
        }else if (type==2){
            return str;
        }else if(type==3){
            return ""+ch;
        }else if (type ==4){
           return ""+num; 
        }else if (type==5){
            return ""+caller;
        }else{
            return ""+bool;
        }
    }
    
    
    
    
    
    
    
    
    
}
