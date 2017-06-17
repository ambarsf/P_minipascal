/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo_Intermedio;

/**
 *
 * @author ambarsuarez
 */
public class Cuadruplo {
    //public enum Operaciones{ASSIGN,SUMA,RESTA,MULTI,DIV,IF_EQ,IF_GEQ,IF_LEQ,IF_GT,IF_LT,IF_NET,GOTO};
    String operacion;
    String argumento1;
    String argumento2;
    String resultado;

    public Cuadruplo(String operacion,String argumento1, String argumento2, String resultado) {
        this.operacion = operacion;
        this.argumento1 = argumento1;
        this.argumento2 = argumento2;
        this.resultado = resultado;
    }

    public Cuadruplo(String operacion, String argumento1, String resultado) {
        this.operacion = operacion;
        this.argumento1 = argumento1;
        this.resultado = resultado;
    }

    public Cuadruplo(String operacion, String resultado) {
        this.operacion = operacion;
        this.resultado = resultado;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getArgumento1() {
        return argumento1;
    }

    public void setArgumento1(String argumento1) {
        this.argumento1 = argumento1;
    }

    public String getArgumento2() {
        return argumento2;
    }

    public void setArgumento2(String argumento2) {
        this.argumento2 = argumento2;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }   

    @Override
    public String toString() {
        String form = "%-15s %-15s %-15s %-15s";
        return String.format(form, operacion, argumento1, argumento2, resultado);
    }
    
    
    
    
    
}
