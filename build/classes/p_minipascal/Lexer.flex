package p_minipascal;
import java_cup.*;
import java_cup.runtime.*;

%%

%unicode 
%class Lexer
%cup
%line
%column

%{
	private Symbol symbol (int type){
		return new Symbol(type, yyline, yycolumn);
	}
	private Symbol symbol (int type, Object value){
		return new Symbol(type,yyline,yycolumn,value);
	}
%}

%eofval{ 
    return symbol(sym.EOF);
%eofval}





letter = [a-zA-Z_]
digit = [0-9]
LineTerminator = \r|\n|\r\n

WhiteSpace     = {LineTerminator} | [ \t\f]  
id = {letter}+{letter}*{digit}*
//AllButR_Key = [^}]
//AllButR_Quotation = [^']
//comment = "{"{AllButR_Key}*"}"
//program = (P|p)(R|r)(O|o)(G|g)(R|r)(A|a)(M|m)
//begin = (B|b)(E|e)(G|g)(I|i)(N|n)
//end = (E|e)(N|n)(D|d)
//write = (W|w)(R|r)(I|i)(T|t)(E|e)
//writeln = (W|w)(R|r)(I|i)(T|t)(E|e)(L|l)(N|n)
//read = (R|r)(E|e)(A|a)(D|d)
//while = (W|w)(H|h)(I|i)(L|l)(E|e)
//procedure = (P|p)(R|r)(O|o)(C|c)(E|e)(D|d)(U|u)(R|r)(E|e)
//do = (D|d)(O|o)
//for = (F|f)(O|o)(R|r)
//to = (T|t)(O|o)
//of = (O|o)(F|f)
//repeat = (R|r)(E|e)(P|p)(E|e)(A|a)(T|t)
//if = (I|i)(F|f)
//else = (E|e)(L\l)(S\s)(E\e)
//then = (T|t)(H|h)(E|e)(N|n)
//true = (T|t)(R|r)(U|u)(E|e)
//false = (F|f)(A|a)(L|l)(S|s)(E|e)
//var = (V|v)(A|a)(R|r)
//and = (A|a)(N|n)(D|d)
//or = (O|o)(R|r)
//not = (N|n)(O|o)(T|t)
//array = (A|a)(R|r)(R|r)(A|a)(Y|y)
//number= {digit}+
integer = (i|I)(n|N)(t|T)(e|E)(g|G)(e|E)(r|R)
char = (c|C)(h|H)(a|A)(r|R) 
string = (s|S)(t|T)(r|R)(i|I)(n|N)(g|G)
boolean = (b|B)(o|O)(o|O)(l|L)(e|E)(a|A)(n|N)
//constchar = "'"[a-zA-Z]"'"
//conststr = "'"{AllButR_Quotation}*"'"

%%
<YYINITIAL>{
	{integer}  		{ return symbol (sym.INTEGER); }
	{string}  		{ return symbol (sym.STRING); }
	{boolean}  		{ return symbol (sym.BOOLEAN); }
	{char}  		{ return symbol (sym.CHAR); }
//	{var}	 		{ return symbol (sym.VAR); }
//	{array}	 		{ return symbol (sym.ARRAY); }

//	{true}  		{ return symbol (sym.TRUE); }
//	{false}  		{ return symbol (sym.FALSE); }


//	{if}  			{ return symbol (sym.IF); }
//	{else}			{ return symbol (sym.ELSE); }
//	{program} 		{ return symbol (sym.PROGRAM); }
//	{while}  		{ return symbol (sym.WHILE); }
//	{do}  			{ return symbol (sym.DO); }
//	{for}  			{ return symbol (sym.FOR); }
//	{to}  			{ return symbol (sym.TO); }
//	{repeat}  		{ return symbol (sym.REPEAT); }
//	{then}  		{ return symbol (sym.THEN); }
//	{begin} 		{ return symbol (sym.BEGIN); }
//	{end} 			{ return symbol (sym.END); }
//      {of}                    { return symbol (sym.OF); }

//	{write}  		{ return symbol (sym.WRITE); }
//	{writeln}  		{ return symbol (sym.WRITELN); }
//	{read}  		{ return symbol (sym.READ); }

//	{comment}		{ return symbol (sym.COMMENT); }

	";"			{ return symbol (sym.SEMICOLON); }
        ":"                     { return symbol (sym.COLON); }
	","			{ return symbol (sym.COMMA); } 
//      "."                     { return symbol (sym.DOT); }

//   	"+"                     { return symbol(sym.PLUS); }
//   	"-"                     { return symbol(sym.MINUS);       }
//    	"*"                     { return symbol(sym.TIMES);       }
//    	"/"                     { return symbol(sym.DIVIDE);       }

//	"("                     { return symbol(sym.LPAREN);      }
//    	")"                     { return symbol(sym.RPAREN);      }
 //   	"\["                    { return symbol(sym.LCOR);    }
 //  	"\]"                    { return symbol(sym.RCOR);     }


//    	">="                    { return symbol(sym.GREATEREQ); }
//    	"<="                    { return symbol(sym.LESSEQ);    }
//    	">"                     { return symbol(sym.GREATER);   }
//    	"<"                     { return symbol(sym.LESS);      }
//    	"<>"                    { return symbol(sym.NEQ);       }
//    	"="                     { return symbol(sym.EQU);       }

//	{and}			{ return symbol (sym.AND); }
//	{or}			{ return symbol (sym.OR); }
//	{not}			{ return symbol (sym.NOT); }

//	":="			{ return symbol(sym.ASSIGN); }



//	{number}  		{ return symbol (sym.NUMBER, new Integer(Integer.parseInt(yytext()))); }
//	{constchar}  		{ return symbol (sym.CONSTCHAR, yytext()); }
//	{conststr} 		{ return symbol (sym.CONSTSTR, yytext()); }
	{id}  			{ return symbol (sym.ID, yytext()); }
        {WhiteSpace}            { /* just skip what was found, do nothing */ }  
	.			{ System.err.println("Illegal character <" + yytext() + "> at line: " + (yyline + 1) + " column: " + (yycolumn + 1));  }
}
