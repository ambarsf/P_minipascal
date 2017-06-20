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
   String actualScope = "1";
   String code = "";
   Stack<Integer> pilaCantidadParametros = new Stack<Integer>();
   Stack<ArrayList<String>> pilaTemporalesVivos = new Stack<ArrayList<String>>();

    public f_codegenerator(ArrayList<String> messages) {
        this.messages = messages;
    }
    
    public void generateCode() {
        generateDataHeader();
        code += ".text\n.globl main\nmain:\n";
        //generateQuadrupleCode();

    }
    
    public void generateDataHeader() {
        code += ".data\n";
        //Aqui se colocan la declaracion de mensajes
        for (int i = 0; i < messages.size(); i++) {
            code += "_msg" + (i + 1) + ":      .asciiz " + messages.get(i) + "\n";
        }
        for (Simbolo s : SymbolTable.getTablaSimbolos().values()){
            if(s.getAmbito().matches("main")){
              code += "_" + s.getNombre() + ":      .word " + 0 + "\n";  
            }
        }
        // Aqui se colocan las declaraciones de variables globales
        //nueva linea
        code += "_newLine:      .asciiz \"\\n\"\n";
    }
    
    public void generateQuadrupleCode() {
        Cuadruplo Cuadruplo_actual;
        // Al inicio se agrega la parte del main
        code += "   move $fp,$sp\n";
        pilaTemporalesVivos.add(new ArrayList<String>());
        generateStartFunctionCode();
        for (int i = 0; i < Cuadruplos.getCuadruplos().size(); i++) {

            Cuadruplo_actual = Cuadruplos.getCuadruplos().get(i);
            if (Cuadruplo_actual.getOperacion().contains("IF")) {
                generateIfCode(Cuadruplo_actual);
            } else if (Cuadruplo_actual.getOperacion().contains("GOTO")) {
                code += "   b _" + Cuadruplo_actual.getResultado() + "\n";
            } else if (Cuadruplo_actual.getOperacion().contains("=")) {
                generateAssignmentCode(Cuadruplo_actual);
            } else if (Cuadruplo_actual.getOperacion().contains("ETIQ")) {
                generateTagCode(Cuadruplo_actual);
            } else if (Cuadruplo_actual.getOperacion().contains("PRINT")) {
                generatePrintCode(Cuadruplo_actual);
            } else if (Cuadruplo_actual.getOperacion().equals("+") || Cuadruplo_actual.getOperacion().equals("-") || Cuadruplo_actual.getOperacion().equals("*") || Cuadruplo_actual.getOperacion().equals("/")) {
                generateArithmeticCode(Cuadruplo_actual);
            } else if (Cuadruplo_actual.getOperacion().contains("CALL")) {
                generateCallCode(Cuadruplo_actual);
            } /*else if (actualQuadruple.operator.equals("=[]")){
                generateAssignRecordCode(actualQuadruple);
            } else if (actualQuadruple.operator.equals("[]=")){
                generateAssignToRecordCode(actualQuadruple);
            }*/
        }

    }

    private void generateIfCode(Cuadruplo actualQuadruple) {
       
    }

    private void generateAssignmentCode(Cuadruplo Cuadruplo_actual) {
    }

    private void generateTagCode(Cuadruplo Cuadruplo_actual) {
    }

    private void generatePrintCode(Cuadruplo Cuadruplo_actual) {
    }

    private void generateArithmeticCode(Cuadruplo Cuadruplo_actual) {
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
