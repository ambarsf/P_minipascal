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
public class Entire_variable {
    Variable_identifier var_id;

    public Entire_variable(Variable_identifier var_id) {
        this.var_id = var_id;
    }

    public Variable_identifier getVar_id() {
        return var_id;
    }
    
    

    @Override
    public String toString() {
        return ""+var_id;
    }
    
    
    
    
    
}
