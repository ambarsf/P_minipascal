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
public class Parameters {
Vector parametros = new Vector();
String Id;
Type tipo;

    public Parameters(Vector parametros) {
        this.parametros = parametros;
    }

public void add(Parameter par){
    parametros.add(0,par);
}

    public Parameters(String Id, Type tipo) {
        this.Id = Id;
        this.tipo = tipo;
        parametros.add(new Parameter(Id,tipo));
    }




    
}
