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
public class Procedure_d {
    String id;
    Type tipo;
    Parameters parametros;

    public Procedure_d(String id, Type tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Procedure_d(String id, Type tipo, Parameters parametros) {
        this.id = id;
        this.tipo = tipo;
        this.parametros = parametros;
    }
    
    
    
}
