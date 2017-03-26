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
    Vector variables;
    String id;
    Type tipo;

public void add(String id){
    variables.add(0, id);
}

    public Variable_d(String id, Type tipo) {
        this.id = id;
        this.tipo = tipo;
    }

}
