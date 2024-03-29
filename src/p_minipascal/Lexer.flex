package p_minipascal;
import java_cup.*;
import java_cup.runtime.*;

%%

%unicode 
%class Lexer
%cup
%line
%column
%ignorecase

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
AllButR_Key = [^}]
AllButR_Quotation = [^']
comment = "{"{AllButR_Key}*"}"
number= {digit}+
constchar = "'"[a-zA-Z]"'"
conststr = "'"{AllButR_Quotation}*"'"

%%
<YYINITIAL>{
	"integer"  		{ return symbol (sym.INTEGER); }
	"string"  		{ return symbol (sym.STRING); }
	"boolean"  		{ return symbol (sym.BOOLEAN); }
	"char"  		{ return symbol (sym.CHAR); }
	"var"	 		{ return symbol (sym.VAR); }
	"array"	 		{ return symbol (sym.ARRAY); }

	"true"  		{ return symbol (sym.TRUE); }
	"false"  		{ return symbol (sym.FALSE); }


	"if"  			{ return symbol (sym.IF); }
	"else"			{ return symbol (sym.ELSE); }
	"program" 		{ return symbol (sym.PROGRAM); }
	"while"  		{ return symbol (sym.WHILE); }
	"do"  			{ return symbol (sym.DO); }
	"for"  			{ return symbol (sym.FOR); }
	"to"  			{ return symbol (sym.TO); }
	"repeat"  		{ return symbol (sym.REPEAT); }
        "until"  		{ return symbol (sym.UNTIL); }
	"then"  		{ return symbol (sym.THEN); }
	"begin" 		{ return symbol (sym.BEGIN); }
	"end" 			{ return symbol (sym.END); }
        "of"                    { return symbol (sym.OF); }
        "function"             { return symbol (sym.FUNCTION); }

	"write"  		{ return symbol (sym.WRITE); }
	"read"  		{ return symbol (sym.READ); }

	{comment}		{}

	";"			{ return symbol (sym.SEMICOLON); }
        ":"                     { return symbol (sym.COLON); }
	","			{ return symbol (sym.COMMA); } 
        "."                     { return symbol (sym.DOT); }

   	"+"                     { return new Symbol(sym.PLUS, yyline+1, yycolumn+1); }
   	"-"                     { return new Symbol(sym.MINUS, yyline+1, yycolumn+1); }
    	"*"                     { return new Symbol(sym.TIMES, yyline+1, yycolumn+1);}
    	"/"                     { return new Symbol(sym.DIVIDE, yyline+1, yycolumn+1);}

	"("                     { return new Symbol(sym.LPAREN, yyline+1, yycolumn+1); }
    	")"                     { return symbol(sym.RPAREN); }
    	"\["                    { return symbol(sym.LCOR); }
   	"\]"                    { return symbol(sym.RCOR); }


    	">="                    { return symbol(sym.GREATEREQ); }
    	"<="                    { return symbol(sym.LESSEQ);    }
    	">"                     { return symbol(sym.GREATER);   }
    	"<"                     { return symbol(sym.LESS);      }
    	"<>"                    { return symbol(sym.NEQ);       }
    	"="                     { return symbol(sym.EQU);       }

	"and"			{ return symbol (sym.AND); }
	"or"			{ return symbol (sym.OR); }
	"not"			{ return symbol (sym.NOT); }

	":="			{ return new Symbol(sym.ASSIGN, yyline+1, yycolumn+1); }



	{number}  		{ return symbol (sym.NUMBER, new Integer(Integer.parseInt(yytext()))); }
        {id}  			{ return symbol (sym.ID, yytext()); }
	{constchar}  		{ return symbol (sym.CONSTCHAR, yytext()); }
	{conststr} 		{ return symbol (sym.CONSTSTR, yytext()); }
        {WhiteSpace}            { /* just skip what was found, do nothing */ }  
	.			{ System.err.println("Illegal character <" + yytext() + "> at line: " + (yyline + 1) + " column: " + (yycolumn + 1));  }
}
