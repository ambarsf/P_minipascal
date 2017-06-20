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
            } else if (Cuadruplo_actual.getOperacion().contains("ASSIGN")) {
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
        /*String operation = "";
        if (actualQuadruple.operator.equals("+")) {
            operation = "add";
        } else if (actualQuadruple.operator.equals("-")) {
            operation = "sub";
        } else if (actualQuadruple.operator.equals("*")) {
            operation = "mul";
        } else if (actualQuadruple.operator.equals("/")) {
            operation = "div";
        }

        String primerOperando = "";
        String segundoOperando = "";
        String variableLocation = "";
        boolean isVariable = false;
        String destinyR = "";
        int availableIndex = getAvailableTemporal();
         destinyR = "$t" + availableIndex;
        if (actualQuadruple.destiny.index != 0) {
            
            temporalMap.set(availableIndex, "t" + actualQuadruple.destiny.index);
        } else if (!actualQuadruple.destiny.name.equals("")) {
            isVariable = true;
            //Se tiene que buscar la variable si es global,parametro o local
            int offsetOpDestino;
            for (int i = symbolTable.size() - 1; i >= 0; i--) {
                if ((symbolTable.get(i).scope.equals(actualScope) || symbolTable.get(i).scope.contains("G")) && !symbolTable.get(i).getType().contains("->") && !symbolTable.get(i).getType().contains("record")) {
                    if(symbolTable.get(i).scope.contains("G")){
                        code += "   lw "+ destinyR + ",_"+actualQuadruple.destiny.name+"\n";
                        variableLocation = "_"+actualQuadruple.destiny.name;
                        break;
                    }else if(symbolTable.get(i).isParameter()){
                        int paramNumber = getParamNumber(actualQuadruple.destiny.name);
                        code += "   move "+destinyR+",$s"+paramNumber+"\n";
                        variableLocation = "$s"+paramNumber;
                        break;
                    }else{
                        offsetOpDestino = symbolTable.get(i).offset;
                        if(symbolTable.get(i).getType().equals("integer")){
                            offsetOpDestino += 4;
                        }else if(symbolTable.get(i).getType().equals("boolean")){
                            offsetOpDestino += 1;
                        }else{
                           String tipo = buscarId(symbolTable.get(i).getType(),"1").getType();
                           offsetOpDestino += getTypeSize(tipo);
                        }
                        offsetOpDestino += 8;
                        offsetOpDestino += pilaCantidadParametros.peek()*4;
                        code += "   lw " +destinyR +",-"+offsetOpDestino+"($fp)\n";
                        variableLocation = "-"+offsetOpDestino+"($fp)";
                        break;
                    }
                }
            }
            temporalMap.set(availableIndex, variableLocation);
        }

        String operandoIzq = "";
        if (!actualQuadruple.operand1.v.equals("")) {
            operandoIzq = actualQuadruple.operand1.v;
            primerOperando = operandoIzq;
            if(operandoIzq.equals("RET")){//si el operando es RET
                int availableIndexIzq = getAvailableTemporal();
                String destinyOperandoIzq = "$t" + availableIndexIzq;
                temporalMap.set(availableIndexIzq, "$v0");
                code += "   move " + destinyOperandoIzq + ",$v0\n"; 
                primerOperando = destinyOperandoIzq;
            }            
        } else if (!actualQuadruple.operand1.name.equals("")) {
            operandoIzq = actualQuadruple.operand1.name;
        } else {
            operandoIzq = "t" + actualQuadruple.operand1.index;
        }
        String operandoDer = "";
        if (!actualQuadruple.operand2.v.equals("")) {
            operandoDer = actualQuadruple.operand2.v;
            segundoOperando = operandoDer;
            if(operandoDer.equals("RET")){//si el operando es RET
                int availableIndexDer = getAvailableTemporal();
                String destinyOperandoDer = "$t" + availableIndexDer;
                temporalMap.set(availableIndexDer, "$v0");
                code += "   move " + destinyOperandoDer + ",$v0\n"; 
                segundoOperando = destinyOperandoDer;
            }
        } else if (!actualQuadruple.operand2.name.equals("")) {
            operandoDer = actualQuadruple.operand2.name;
        } else {
            operandoDer = "t" + actualQuadruple.operand2.index;
        }
        int indiceOpIzq = -1;
        int indiceOpDer = -1;
        for (int i = 0; i < temporalMap.size(); i++) {
            if (temporalMap.get(i).equals(operandoIzq)) {
                indiceOpIzq = i;
            }
            if (temporalMap.get(i).equals(operandoDer)) {
                indiceOpDer = i;
            }
        }

        int availableIndexIzq = -1;
        if (primerOperando.equals("")) {
            if (indiceOpIzq != -1) {
                primerOperando = "$t" + indiceOpIzq;
                temporalMap.set(indiceOpIzq, "");
            } else {
                int offset = 0;
                boolean esVariable = false;
                boolean global = false;
                boolean esParametro = false;
                //variables locales
                for (int i = symbolTable.size() - 1; i >= 0; i--) {
                    if ((symbolTable.get(i).scope.equals(actualScope) || symbolTable.get(i).scope.contains("G")) && !symbolTable.get(i).getType().contains("->") && !symbolTable.get(i).getType().contains("record")) {
                        offset = symbolTable.get(i).offset;
                        if(symbolTable.get(i).getType().equals("integer")){
                        offset += 4;
                    }else if(symbolTable.get(i).getType().equals("boolean")){
                        offset += 1;
                    }else{
                       String tipo = buscarId(symbolTable.get(i).getType(),"1").getType();
                       offset += getTypeSize(tipo);
                    }
                        if (symbolTable.get(i).getId().equals(operandoIzq)) {
                            if(symbolTable.get(i).isParameter())
                                esParametro = true;
                            esVariable = true;
                            if (symbolTable.get(i).scope.contains("G")) {
                                global = true;
                            }
                            break;
                        }
                    }
                }
                //$s0 - $s7
                offset += pilaCantidadParametros.peek()*4;
                offset += 8;//$fp y $ra
                if (esVariable) {
                    //primerOperando = "-"+offset+"($fp)";
                    availableIndexIzq = getAvailableTemporal();
                    String destinyOperandoIzq = "$t" + availableIndexIzq;
                    temporalMap.set(availableIndexIzq, operandoIzq);
                    if(esParametro){
                        int paramNumber = getParamNumber(operandoIzq);
                        code += "   move "+destinyOperandoIzq+",$s"+paramNumber+"\n";
                    }else if (global) {
                        code += "   lw " + destinyOperandoIzq + ",_" + operandoIzq + "\n";
                    } else {
                        code += "   lw " + destinyOperandoIzq + ",-" + offset + "($fp)\n";
                    }

                    primerOperando = destinyOperandoIzq;
                    //temporalMap.set(availableIndexIzq,"");
                }
                
            }
        }
        int availableIndexDer = -1;
        if (segundoOperando.equals("")) {
            if (indiceOpDer != -1) {
                segundoOperando = "$t" + indiceOpDer;
                temporalMap.set(indiceOpDer, "");
            } else {
                int offset = 0;
                boolean esVariable = false;
                boolean global = false;
                boolean esParametro = false;
                //variables locales
                for (int i = symbolTable.size() - 1; i >= 0; i--) {
                    if ((symbolTable.get(i).scope.equals(actualScope) || symbolTable.get(i).scope.contains("G")) && !symbolTable.get(i).getType().contains("->") && !symbolTable.get(i).getType().contains("record")) {
                        offset = symbolTable.get(i).offset;
                        if(symbolTable.get(i).getType().equals("integer")){
                        offset += 4;
                    }else if(symbolTable.get(i).getType().equals("boolean")){
                        offset += 1;
                    }else{
                       String tipo = buscarId(symbolTable.get(i).getType(),"1").getType();
                       offset += getTypeSize(tipo);
                    }
                        if (symbolTable.get(i).getId().equals(operandoDer)) {
                            if(symbolTable.get(i).isParameter())
                                esParametro = true;
                            esVariable = true;
                            if (symbolTable.get(i).scope.contains("G")) {
                                global = true;
                            }
                            break;
                        }
                    }
                }
                //$s0 - $s7
                offset += pilaCantidadParametros.peek()*4;
                offset += 8;//$fp y $ra
                if (esVariable) {
                    //primerOperando = "-"+offset+"($fp)";
                    availableIndexDer = getAvailableTemporal();
                    String destinyOperandoDer = "$t" + availableIndexDer;
                    temporalMap.set(availableIndexDer, operandoDer);
                    if(esParametro){
                        int paramNumber = getParamNumber(operandoDer);
                        code += "   move "+destinyOperandoDer+",$s"+paramNumber+"\n";
                    }else if (global) {
                        code += "   lw " + destinyOperandoDer + ",_" + operandoDer + "\n";
                    } else {
                        code += "   lw " + destinyOperandoDer + ",-" + offset + "($fp)\n";
                    }

                    segundoOperando = destinyOperandoDer;
                    //temporalMap.set(availableIndexDer,"");
                }
            }
        }
        code += "   " + operation + " " + destinyR + "," + primerOperando + "," + segundoOperando + "\n";
        if (availableIndexIzq != -1) {
            temporalMap.set(availableIndexIzq, "");
        }
        if (availableIndexDer != -1) {
            temporalMap.set(availableIndexDer, "");
        }
        if( isVariable) {
            code += "   sw "+destinyR+","+variableLocation+"\n";
            temporalMap.set(availableIndex, "");
        }
        /*int offset = 0;
                    boolean esVariable = false;
                    //$s0 - $s7

                    //variables locales
                    for (int i = symbolTable.size()-1; i >=0; i--) {
                        if (symbolTable.get(i).scope.equals(actualScope) && !symbolTable.get(i).getType().contains("->") && !symbolTable.get(i).getType().contains("record")) {
                            offset = symbolTable.get(i).offset;
                            offset += symbolTable.get(i).getType().equals("integer") ? 4 : 1;
                            if(symbolTable.get(i).getId().equals(actualQuadruple.destiny.name)){
                                esVariable = true;
                                break;
                            }
                        }
                    }
                    offset+= 8;//$fp y $ra
            if(esVariable)
                code += "   sw "+destinyR+",-"+offset+"($fp)\n";*/
        //temporalMap.set(availableIndex,"");
        /*System.out.println("Izquierda: "+indiceOpIzq);
            System.out.println("Derecha: "+indiceOpDer);
            System.out.println("Destino: "+destinyR);*/
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
