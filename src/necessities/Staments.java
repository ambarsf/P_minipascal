/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package necessities;

import Codigo_Intermedio.Etiqueta;
import java.util.Vector;

/**
 *
 * @author ambarsuarez
 */
public class Staments {
    Vector <Stament> values = new Vector();
    Stament stament;
    Etiqueta etiq;
    
    public Staments(){
        values = new Vector();
    }
    
    public void add(Stament st){
        values.add(0, st);
    }
    
    public Staments(Stament stament){
        this.stament= stament;
        values.add(0,stament);
    }
    
    public Staments(Stament stament,Etiqueta etiq){
        this.stament= stament;
        this.etiq = etiq;
        values.add(0,stament);
    }

    public Etiqueta getEtiq() {
        return etiq;
    }

    public void setEtiq(Etiqueta etiq) {
        this.etiq = etiq;
    }
    
    
    
}
