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
public class Assign_stament {
    Variable var;
    Expression esp;

    public Assign_stament(Variable var, Expression esp) {
        this.var = var;
        this.esp = esp;
    }

    public Variable getVar() {
        return var;
    }

    public Expression getEsp() {
        return esp;
    }
    
    
    
    
    
    
    
}
