/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_minipascal;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;
/**
 *
 * @author isaac
 */

class Nodo
{
    String nombre;//Nombre de la estructura (for, while, if)
    int repeticiones;//No. de Variables asociadas
    Nodo siguiente; //Instancia a una clase nodo              
    
    Nodo (int repeticiones, String nombre, Nodo siguiente)
    {
        this.repeticiones = repeticiones;
        this.nombre = nombre;        
        this.siguiente = siguiente;
    }
}

class Simbolo
{  
    String nombre;
    String tipo;
    Object valor;
    String ambito;
    
    public Simbolo(String nombre, String tipo ,Object valor, String ambito)
    {
        this.nombre = nombre;       
        this.tipo = tipo;
        this.valor = valor;
        this.ambito = ambito;
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }
    
    public String getAmbito(){
        return ambito;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void setAmbito(String ambito){
        this.ambito = ambito;
    }
}

public class SymbolTable {
    static Map<String, Simbolo> tablaSimbolos;
    static Stack<String> lista;
    static ArrayList<Nodo> repeticiones;        
    static String UltimoTipo;
    static String profundidad;
    static String UltimaFuncion;
    
    public static Logger log = Logger.getLogger(SymbolTable.class.getName());            
    
    public SymbolTable()
    {        
        tablaSimbolos = new HashMap<String, Simbolo>();                                   
        lista = new Stack<String>();
        UltimoTipo = "";
        UltimaFuncion="main";
        profundidad = "main";
        
    }
    
    static public String verificarTipo(String nombre){
        Simbolo s = tablaSimbolos.get(nombre);
        return s.tipo;
    }
    
    static public String verificarAmbito(String nombre){
        Simbolo s = tablaSimbolos.get(nombre);
        return s.ambito;
    }
    
    static public Object verificarValor(String nombre){
        Simbolo s = tablaSimbolos.get(nombre);
        //System.out.println("VALOR DE " + nombre + " ES: " + s.valor);
        return s.valor;
    }
    
    static public String eliminar(String nombre)
    {             
        
        //System.out.println("Eliminando variable: " + nombre);
        try
        {
            tablaSimbolos.remove(nombre);
            return nombre;
        }
        catch(Exception e)
        {
            System.out.println("Error al eliminar una variable de la tabla de simbolos");
            return nombre;
        }                
    }
            
    static public Simbolo crear(String nombre, String tipo, String ambito)
    {        
        Simbolo simbolo = buscar(nombre);                            
        if(simbolo == null) // La variable no existe
        {
            simbolo = new Simbolo(nombre, tipo, null, ambito);
            //System.out.println("Agregando a tabla de simbolos con nombre: " + nombre);
            tablaSimbolos.put(nombre, simbolo);
            if(tipo != null)
                UltimoTipo = tipo;
            //System.out.println("ULTIMO TIPO EN CREAR" + UltimoTipo);
            
            
            //imprimir();                
            System.out.println(" ");
            return simbolo;
        }
        else
        {
        //    log.log(Level.SEVERE, "Redefinición de la variable: " + nombre);
            return null; // La variable ya existía                
        }
    }
    
    static public Simbolo agregarTipo(String nombre, String Ambito){
        Simbolo simbolo = buscar(nombre);
        if(simbolo.getTipo() == null){
            simbolo.setTipo(UltimoTipo);
            simbolo.setAmbito(Ambito);
            //System.out.println("ULTIMO TIPO EN AGREGAR TIPO: " + UltimoTipo);
            tablaSimbolos.replace(nombre, simbolo);
            tablaSimbolos.remove(nombre);
            tablaSimbolos.put(nombre, simbolo);
            //System.out.println("AGREGAR TIPO");
            //imprimir();
            return simbolo;
        }
        else {
            //log.log(Level.SEVERE, "Redifinicion de la variable: " + nombre);
            return null;
        }
    }
        
    static public Simbolo insertar(String nombre, Object valor)            
    {
        //System.out.println("\nIngreso a insertar valor a variable.");
        Simbolo simbolo = buscar(nombre);
        if(simbolo != null) //La variable existe
        {
            //Actualizar el valor
            simbolo.valor = valor;
            tablaSimbolos.remove(nombre);//Elimino para actualizar
            tablaSimbolos.put(nombre, simbolo);
            //imprimir();
            return simbolo;
        }
        else
            return null;
    }
    
    static public Simbolo buscar(String nombre)
    {   
       // if ((Simbolo)tablaSimbolos.get(nombre)!=null)
            return (Simbolo)tablaSimbolos.get(nombre);
        //else{
          //  System.out.println("no existe");
            //return new Simbolo(null, null, null, null);
        //}
    }
    
        static public Simbolo buscarConAmbito(String ambito)
    {   
       // if ((Simbolo)tablaSimbolos.get(nombre)!=null)
        Simbolo retval = null;
        for (Simbolo s : tablaSimbolos.values()){
            if(s.getAmbito().equals(ambito))
                retval = s;
        }
        return retval;
        //else{
          //  System.out.println("no existe");
            //return new Simbolo(null, null, null, null);
        //}
    }
    
    static public String buscarTipo(String nombre){
        return tablaSimbolos.get(nombre).getTipo();
    }
    
    static public String buscarAmbito(String nombre){
        return tablaSimbolos.get(nombre).getAmbito();
    }

    public static Map<String, Simbolo> getTablaSimbolos() {
        return tablaSimbolos;
    }

    public static void setTablaSimbolos(Map<String, Simbolo> tablaSimbolos) {
        SymbolTable.tablaSimbolos = tablaSimbolos;
    }
    
    
    
    
    static public void imprimir()
    {
        System.out.println("\nIngresando a imprimir de TablaSimbolos");
        System.out.println("    Valores de la tabla de simbolos:");
        for (Simbolo s : tablaSimbolos.values())
            System.out.println(String.format("      "
                    + "Nombre: %-15s valor: %-15s tipo: %-15s ambito: %-15s",s.nombre, s.valor, s.tipo, s.ambito));        
        System.out.println("Saliendo de imprimir en TablaSimbolos\n ");        
    }
}


