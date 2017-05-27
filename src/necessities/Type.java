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
public class Type {    Simple_type sim_t;
    Array_type arr_t;
    boolean simple;    
    public Type(Simple_type si_t){
        sim_t = si_t;
        simple = true;
    }
    
    public Type(Array_type ar_t){
        arr_t = ar_t;
        simple = false;
    }

    public Simple_type getSim_t() {
        return sim_t;
    }

    public void setSim_t(Simple_type sim_t) {
        this.sim_t = sim_t;
    }

    public Array_type getArr_t() {
        return arr_t;
    }

    public void setArr_t(Array_type arr_t) {
        this.arr_t = arr_t;
    }

    public boolean isSimple() {
        return simple;
    }

    public void setSimple(boolean simple) {
        this.simple = simple;
    }
    
}
