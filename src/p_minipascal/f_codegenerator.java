/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_minipascal;

import Codigo_Intermedio.Cuadruplo;
import Codigo_Intermedio.Cuadruplos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import p_minipascal.SymbolTable;

/**
 *
 * @author ambarsuarez
 */
public class f_codegenerator {
   //esta es la lista de mensajes _msg(num);
   ArrayList<String> messages = new ArrayList();
   ArrayList<String> temporal = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", "", "", ""));
   ArrayList<String> argumentos = new ArrayList<>(Arrays.asList("", "", "", "")); 
   ArrayList<String> temporales = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", ""));
   String actualScope = "main";
   String code = "";
   //para tratar de manejar la pila
   Stack<Integer> stack_cant_params = new Stack<Integer>();
   Stack<ArrayList<String>> stack_temps_alive = new Stack<ArrayList<String>>();

    public f_codegenerator(ArrayList<String> messages) {
        this.messages = messages;
    }
    
    public void generateCode() {
        generateHeader();
        code += ".text\n.globl main\n\nmain:\n";
        generateQuadrupleCode();

    }
    
    public void generateHeader() {
        code += ".data\n";
        for (int i = 0; i < messages.size(); i++) {
            code += "_msg" + (i) + ":      .asciiz " + messages.get(i) + "\n";
        }
        for (Simbolo s : SymbolTable.getTablaSimbolos().values()){
            if(s.getAmbito().matches("main")){
              code += "_" + s.getNombre() + ":      .word " + 0 + "\n";  
            }
        }
    }
    
    public void generateQuadrupleCode() {
        Cuadruplo Cuadruplo_actual;
        code += "move $fp,$sp\n";
        stack_temps_alive.add(new ArrayList<String>());
        generateStartFunctionCode();
        for (int i = 0; i < Cuadruplos.getCuadruplos().size(); i++) {
            Cuadruplo_actual = Cuadruplos.getCuadruplos().get(i);
            if (Cuadruplo_actual.getOperacion().contains("IF")) {
                generateIfCode(Cuadruplo_actual);
            } else if (Cuadruplo_actual.getOperacion().contains("GOTO")) {
                code += "   b _" + Cuadruplo_actual.getResultado() + "\n";
            } else if (Cuadruplo_actual.getOperacion().contains("ASSIGN")) {
                generateAssignmentCode(Cuadruplo_actual);
            } else if (Cuadruplo_actual.getOperacion().contains("ETIQ")) {
                generateEtiqCode(Cuadruplo_actual);
            } else if (Cuadruplo_actual.getOperacion().contains("WRITE")) {
                generatePrintCode(Cuadruplo_actual);
            } else if (Cuadruplo_actual.getOperacion().contains("READ")) {
                generateReadCode(Cuadruplo_actual);
            } else if (Cuadruplo_actual.getOperacion().equals("+") || Cuadruplo_actual.getOperacion().equals("-") || Cuadruplo_actual.getOperacion().equals("*") || Cuadruplo_actual.getOperacion().equals("/")
                        || Cuadruplo_actual.getOperacion().equals("<")|| Cuadruplo_actual.getOperacion().equals("<=")|| Cuadruplo_actual.getOperacion().equals("=")|| Cuadruplo_actual.getOperacion().equals(">=")
                        || Cuadruplo_actual.getOperacion().equals(">=")) {
                generateArithmeticCode(Cuadruplo_actual);
            } else if (Cuadruplo_actual.getOperacion().contains("CALL")) {
                generateCallCode(Cuadruplo_actual);
            } 
        }

    }

    private void generateIfCode(Cuadruplo actualQuadruple) {    
    }
    
    private void generateArithmeticCode(Cuadruplo Cuadruplo_actual) {
        //si la suma son dos immediate add solo acepta un immediate en la segunda pos.
        //if (Cuadruplo_actual.getArgumento1().matches(code)){
            
        //}else{
            //si no son dos immediate.
            
        //}
        String operation = "";
        if (Cuadruplo_actual.getOperacion().equals("+")) {
            operation = "add";
        } else if (Cuadruplo_actual.getOperacion().equals("-")) {
            operation = "sub";
        } else if (Cuadruplo_actual.getOperacion().equals("*")) {
            operation = "mul";
        } else if (Cuadruplo_actual.getOperacion().equals("/")) {
            operation = "div";
        } else if (Cuadruplo_actual.getOperacion().equals("<")) {
            operation = "blt";
        } else if (Cuadruplo_actual.getOperacion().equals("<=")) {
            operation = "ble";
        } else if (Cuadruplo_actual.getOperacion().equals("=")) {
            operation = "beq";
        } else if (Cuadruplo_actual.getOperacion().equals(">=")) {
            operation = "bge";
        }else if (Cuadruplo_actual.getOperacion().equals(">")) {
            operation = "bgt";
        }
        code += operation+"     _"+Cuadruplo_actual.getArgumento1()+", _"+Cuadruplo_actual.getArgumento2()+", $"+Cuadruplo_actual.getResultado()+"\n";
        /*String primerOperando = "";
        String segundoOperando = "";
        String variableLocation = "";
        boolean isVariable = false;
        String destinyR = "";
        
        int availableIndex = getAvailableTemporal();
         destinyR = "$t" + availableIndex;
         */
         
        
    }

    private void generateAssignmentCode(Cuadruplo Cuadruplo_actual) {
        if (Cuadruplo_actual.getArgumento1().contains("'")){
            
        }else if (Cuadruplo_actual.getArgumento1().matches("^([1-9]|[1-9][0-9]|[1-9][0-9][0-9])$")){
            code += "\n";
            Temporal tmp = new Temporal();
            code += "   li _"+tmp+", "+Cuadruplo_actual.getArgumento1()+"\n";
            code += "   sw $"+tmp+", _"+Cuadruplo_actual.getResultado()+"\n";          
            code += "\n";
        }else{
            Temporal tmp = new Temporal();
            code += "\n";
            code += "   lw $"+tmp+", _"+Cuadruplo_actual.getArgumento1()+"\n";
            code += "   sw $"+tmp+", _"+Cuadruplo_actual.getResultado()+"\n";
            code += "\n";
           
        }
    }

    private void generateEtiqCode(Cuadruplo Cuadruplo_actual) {
            code += "_" + Cuadruplo_actual.getArgumento1() + ":\n";
    }

    private void generatePrintCode(Cuadruplo Cuadruplo_actual) {
        int encontrado=-1;
        for (int i = 0; i < messages.size(); i++) {
            if (Cuadruplo_actual.getArgumento1().matches(messages.get(i))){
                encontrado=i;
            }
        }
        
        if (encontrado==-1){
            code += "\n";
            code+="   li $v0, 1\n";
            code+="   lw $a0,_"+Cuadruplo_actual.getArgumento1()+"\n";
            code+="   syscall\n";
            code+= " \n";
                    
            
        }else{
            code+= " \n";
            code+="   li $v0, 4\n";
            code+="   la $a0,_msg"+encontrado+"\n";
            code+="   syscall\n";
            code+= " \n";
        }
        
    }
    
    public void generateReadCode(Cuadruplo Cuadruplo_actual){
        code += "\n";
        code += "   li $v0, 5\n";
        code += "   syscall\n";
        code += "   sw $v0, _"+Cuadruplo_actual.getArgumento1()+"\n";
        code += "\n";
    }
    public void generateFinalFunctionCode() {
        code += "   move $sp, $fp\n";
        code += "   lw $fp,-4($sp)\n";
        code += "   lw $ra,-8($sp)\n";
        int posicion = 12;
        int cantidadParams = stack_cant_params.pop();
        for(int i = 0; i<cantidadParams; i++){
            code += "   lw $s"+i+",-"+posicion+"($sp)\n";
            posicion += 4;
        }
        ArrayList<String> temporalesVivos = stack_temps_alive.pop();
        int posicionTemporal = 0;
        for(int i = temporalesVivos.size()-1; i>=0;i--){
            code += "   lw "+temporalesVivos.get(i)+","+posicionTemporal+"($sp)\n";
        }
        code += "   jr $ra\n";
    }

    private void generateCallCode(Cuadruplo Cuadruplo_actual) {
        ArrayList<String> temporalesVivos = new ArrayList<String>();
        int sumaTemporales = 0;
        for(int i = 0; i<temporal.size(); i++){
            if(!temporal.get(i).equals("")){
                temporalesVivos.add("$t"+i);                
            }
        }
        for(int i = 0; i< temporalesVivos.size();i++){
            sumaTemporales += 4;
            code += "   sw "+temporalesVivos.get(i)+",-"+sumaTemporales+"($sp)\n";
            
        }
        code += "   sub $sp,$sp,"+(sumaTemporales)+"\n";
        stack_temps_alive.push(temporalesVivos);
        String [] name_func = Cuadruplo_actual.getArgumento1().split(",");
        code += "   jal _" + name_func[0] + "\n";
        for(int i = 0; i<argumentos.size(); i++){
            argumentos.set(i,"");
        }
    }

    private void generateStartFunctionCode() {
        
    }
    
    public int getAvailableTemporal() {
        int index;
        for (index = 0; index < temporal.size(); index++) {
            if (temporal.get(index).equals("")) {
                break;
            }
        }
        return index;
    }

    public int getAvailableArgument() {
        int index;
        for (index = 0; index < argumentos.size(); index++) {
            if (argumentos.get(index).equals("")) {
                break;
            }
        }
        return index;
    }

    public int getAvailableTemporales() {
        int index;
        for (index = 0; index < temporales.size(); index++) {
            if (temporales.get(index).equals("")) {
                break;
            }
        }
        return index;
    }

    public String getFinalCode() {
        return code;
    }

    public void printCode() {
        System.out.println(code);
    }
   
   
    
    
}
