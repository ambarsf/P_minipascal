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
public class Type_ident {
    String ident;
    
    public Type_ident(String id){
        ident = id;
    }

    public Type_ident() {
    }
    
        public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return ident ;
    }
    
    
    
}
