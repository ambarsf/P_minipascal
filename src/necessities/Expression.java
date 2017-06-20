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
public class Expression {
    Simple_expression s_exp1;
    Simple_expression s_exp2;
    String sign="";

    public Expression(Simple_expression s_exp1) {
        this.s_exp1 = s_exp1;
    }

    public Expression(Simple_expression s_exp1,  Simple_expression s_exp2) {
        this.s_exp1 = s_exp1;
        this.s_exp2 = s_exp2;
    }
    
    public Expression (Simple_expression s_exp1, String sign, Simple_expression s_exp2){
        this.s_exp1 = s_exp1;
        this.sign = sign;
        this.s_exp2 = s_exp2;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
    
    public Simple_expression getS_exp1() {
        return s_exp1;
    }

    public Simple_expression getS_exp2() {
        return s_exp2;
    }

    @Override
    public String toString() {
        return ""+s_exp1 ;
    }
    
    
    
    
    
    
}
