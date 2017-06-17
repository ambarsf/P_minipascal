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
public class Caller {
    String id;
    Caller_params callers;

    public Caller(String id, Caller_params callers) {
        this.id = id;
        this.callers = callers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Caller_params getCallers() {
        return callers;
    }

    public void setCallers(Caller_params callers) {
        this.callers = callers;
    }

    @Override
    public String toString() {
        return ""+id;
    }
    
    
    
}
