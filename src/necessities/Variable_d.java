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
public class Variable_d {
    Vector variables = new Vector();
    String id;
    Type tipo;

    public Variable_d() {
        this.variables = new Vector();
    }
    
    

public void add(String id){
    variables.add(0, id);
}

    public Variable_d(String id, Type tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Vector getVariables() {
        return variables;
    }

    public void setVariables(Vector variables) {
        this.variables = variables;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }
}
