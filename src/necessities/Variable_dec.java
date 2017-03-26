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
    String identifier;
    
    public Variable_dec(){
        identifiers=new Vector();
    }
    
    public void add(String id){
        identifiers.add(id);
    }

    public Variable_dec(Vector identifiers, Type type) {
        this.identifiers = identifiers;
        this.type = type;
    }
    
    public Variable_dec(String identifier, Type type) {
        this.identifier = identifier;
        this.type = type;
    }
    
    
    
}
