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

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }
    
    
    
}
