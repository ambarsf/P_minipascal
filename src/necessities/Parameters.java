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
Vector <Parameter>parametros = new Vector();
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

    public Vector<Parameter> getParametros() {
        return parametros;
    }

    public void setParametros(Vector parametros) {
        this.parametros = parametros;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }
    
    public void showParams(){
        for (int i = 0; i < parametros.size(); i++) {
            System.out.println(parametros.get(i));
        }
    }




    
}
