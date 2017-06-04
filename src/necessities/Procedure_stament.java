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
public class Procedure_stament {
    Procedure_iden p_id;
    
    public  Procedure_stament(Procedure_iden pid){
        p_id=pid;
    }

    public Procedure_iden getP_id() {
        return p_id;
    }

    public void setP_id(Procedure_iden p_id) {
        this.p_id = p_id;
    }
    
    
    
}
