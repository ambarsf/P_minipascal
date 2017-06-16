/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package necessities;

import java.util.Vector;

/**
 *
 * @author ambarsuarez
 */
public class Caller_params {
    Vector <Factor> callers = new Vector();

    public Caller_params(Variable var) {
        callers.add(new Factor(var));
    }
    
    public Caller_params(Expression exp){
        this.callers.add(new Factor(exp));
    }
    
     public Caller_params(String str) {
        callers.add(new Factor(str));
    }
     
      public Caller_params(int num) {
        callers.add(new Factor(num));
    }
      
    public void add(Factor fact){
        callers.add(0,fact);
    }
      
       public Caller_params(char ch) {
        callers.add(new Factor(ch));
    }
       
    public Caller_params(Caller caller){
        callers.add(new Factor(caller));
    }
    
    public Caller_params(Factor factor){
        callers.add(new Factor(factor));
    }

    public Caller_params(){

    }

    public Vector<Factor> getCallers() {
        return callers;
    }

    public void setCallers(Vector<Factor> callers) {
        this.callers = callers;
    }
    
    
    
    




    
    
    
    
}
