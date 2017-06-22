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
   ArrayList<String> messages = new ArrayList();
   ArrayList<String> temporalMap = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", "", "", ""));
   ArrayList<String> argumentsMap = new ArrayList<>(Arrays.asList("", "", "", ""));
   ArrayList<String> temporalSMap = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", ""));
   String actualScope = "main";
   String code = "";
   Stack<Integer> pilaCantidadParametros = new Stack<Integer>();
   Stack<ArrayList<String>> pilaTemporalesVivos = new Stack<ArrayList<String>>();

    public f_codegenerator(ArrayList<String> messages) {
        this.messages = messages;
    }
    
    public void generateCode() {
        generateDataHeader();
        code += ".text\n.globl main\nmain:\n";
        generateQuadrupleCode();

    }
    
    public void generateDataHeader() {
        code += ".data\n";
        for (int i = 0; i < messages.size(); i++) {
            code += "_msg" + (i + 1) + ":      .asciiz " + messages.get(i) + "\n";
        }
        for (Simbolo s : SymbolTable.getTablaSimbolos().values()){
            if(s.getAmbito().matches("main")){
              code += "_" + s.getNombre() + ":      .word " + 0 + "\n";  
            }
        }
    }
    
    public void generateQuadrupleCode() {
        Cuadruplo Cuadruplo_actual;
        code += "   move $fp,$sp\n";
        pilaTemporalesVivos.add(new ArrayList<String>());
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
                generateTagCode(Cuadruplo_actual);
            } else if (Cuadruplo_actual.getOperacion().contains("WRITE")) {
                generatePrintCode(Cuadruplo_actual);
            } else if (Cuadruplo_actual.getOperacion().equals("+") || Cuadruplo_actual.getOperacion().equals("-") || Cuadruplo_actual.getOperacion().equals("*") || Cuadruplo_actual.getOperacion().equals("/")) {
                generateArithmeticCode(Cuadruplo_actual);
            } else if (Cuadruplo_actual.getOperacion().contains("CALL")) {
                generateCallCode(Cuadruplo_actual);
            } 
        }

    }

    private void generateIfCode(Cuadruplo actualQuadruple) {    
    }
    
    private void generateArithmeticCode(Cuadruplo Cuadruplo_actual) {
    }

    private void generateAssignmentCode(Cuadruplo Cuadruplo_actual) {
    }

    private void generateTagCode(Cuadruplo Cuadruplo_actual) {
    }

    private void generatePrintCode(Cuadruplo Cuadruplo_actual) {
        int encontrado=-1;
        for (int i = 0; i < messages.size(); i++) {
            if (Cuadruplo_actual.getArgumento1().matches(messages.get(i))){
                encontrado=i;
            }
        }
        
        if (encontrado==-1){
            
        }else{
            code+="   li $v0, 4\n";
            code+="   la $a0,_msg"+encontrado+"\n";
            code+="   syscall\n";
        }
        
    }
    public void generateFinalFunctionCode() {
        code += "   move $sp, $fp\n";
        code += "   lw $fp,-4($sp)\n";
        code += "   lw $ra,-8($sp)\n";
        int posicion = 12;
        int cantidadParams = pilaCantidadParametros.pop();
        for(int i = 0; i<cantidadParams; i++){
            code += "   lw $s"+i+",-"+posicion+"($sp)\n";
            posicion += 4;
        }
        ArrayList<String> temporalesVivos = pilaTemporalesVivos.pop();
        int posicionTemporal = 0;
        for(int i = temporalesVivos.size()-1; i>=0;i--){
            code += "   lw "+temporalesVivos.get(i)+","+posicionTemporal+"($sp)\n";
        }
        code += "   jr $ra\n";
    }

    private void generateCallCode(Cuadruplo Cuadruplo_actual) {
    }

    private void generateStartFunctionCode() {
        
    }
    
    public int getAvailableTemporal() {
        int index;
        for (index = 0; index < temporalMap.size(); index++) {
            if (temporalMap.get(index).equals("")) {
                break;
            }
        }
        return index;
    }

    public int getAvailableArgument() {
        int index;
        for (index = 0; index < argumentsMap.size(); index++) {
            if (argumentsMap.get(index).equals("")) {
                break;
            }
        }
        return index;
    }

    public int getAvailableTemporalS() {
        int index;
        for (index = 0; index < temporalSMap.size(); index++) {
            if (temporalSMap.get(index).equals("")) {
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
