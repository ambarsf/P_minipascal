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
public class Parameter {
    String Id;
    int number;
    Type tipo;

    public Parameter(String Id, Type tipo) {
        this.Id = Id;
        this.tipo = tipo;
    }

    public Parameter(String Id, int number) {
        this.Id = Id;
        this.number = number;
    }
    
    
    
}