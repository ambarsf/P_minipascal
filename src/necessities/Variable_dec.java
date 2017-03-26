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
public class Variable_dec {
    Vector identifiers;
    Type type;
    
    public Variable_dec(){
        identifiers=new Vector();
    }
    
    public Variable_dec(Type taip){
        type = taip;
    }
    
    public void add(String id){
        identifiers.add(id);
    }

    public Variable_dec(Vector identifiers, Type type) {
        this.identifiers = identifiers;
        this.type = type;
    }
    
    
    
}
