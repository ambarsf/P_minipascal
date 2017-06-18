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
public class Writes {
    Expression ov;
    Vector<Expression> values = new Vector();
    
    public Writes(){
        values = new Vector();
    }
    
    public void add(Expression o_v){
        values.add(0, o_v);
    }

    public Vector getValues() {
        return values;
    }

    public void setValues(Vector values) {
        this.values = values;
    }
    
    public Writes(Expression o_v) {
        this.ov = o_v;
        values.add(o_v);        
    }
    
    
    
    
    
    
}
