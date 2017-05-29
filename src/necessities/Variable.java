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
public class Variable {
    Entire_variable ent_v;
    Indexed_variable  ind_v;
    boolean entire = true;

    public Variable(Entire_variable ent_v) {
        this.ent_v = ent_v;
        entire =true;
    }

    public Variable(Indexed_variable ind_v) {
        this.ind_v = ind_v;
        entire = false;
    }
    
    
    public Entire_variable getEnt_v() {
        return ent_v;
    }

    public void setEnt_v(Entire_variable ent_v) {
        this.ent_v = ent_v;
    }

    public Indexed_variable getInd_v() {
        return ind_v;
    }

    public void setInd_v(Indexed_variable ind_v) {
        this.ind_v = ind_v;
    }

    @Override
    public String toString() {
        if (entire=true){
            return ""+ent_v;
        }else{
            return ""+ind_v;
        }
    }
    
    
    
}
