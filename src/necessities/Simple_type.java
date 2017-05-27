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
public class Simple_type {
    Type_ident T_id;
    
    public Simple_type(Type_ident t_i){
        T_id = t_i;
    }
        public Type_ident getT_id() {
        return T_id;
    }

    public void setT_id(Type_ident T_id) {
        this.T_id = T_id;
    }
}
