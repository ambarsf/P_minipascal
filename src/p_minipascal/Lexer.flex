package p_minipascal;
import java_cup.*;
import java_cup.runtime.*;

%%

%unicode 
%class Lexer
%cup
%line
%ignorecase
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
	"then"  		{ return symbol (sym.THEN); }
	"begin" 		{ return symbol (sym.BEGIN); }
	"end" 			{ return symbol (sym.END); }
        "of"                    { return symbol (sym.OF); }
        "procedure"             { return symbol (sym.PROCEDURE); }

	"write"  		{ return symbol (sym.WRITE); }
	"read"  		{ return symbol (sym.READ); }

	{comment}		{}

	";"			{ return symbol (sym.SEMICOLON); }
        ":"                     { return symbol (sym.COLON); }
	","			{ return symbol (sym.COMMA); } 
        "."                     { return symbol (sym.DOT); }

   	"+"                     { return symbol(sym.PLUS); }
   	"-"                     { return symbol(sym.MINUS); }
    	"*"                     { return symbol(sym.TIMES);}
    	"/"                     { return symbol(sym.DIVIDE);}

	"("                     { return symbol(sym.LPAREN); }
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

	":="			{ return symbol(sym.ASSIGN); }



	{number}  		{ return symbol (sym.NUMBER, new Integer(Integer.parseInt(yytext()))); }
	{constchar}  		{ return symbol (sym.CONSTCHAR, yytext()); }
	{conststr} 		{ return symbol (sym.CONSTSTR, yytext()); }
	{id}  			{ return symbol (sym.ID, yytext()); }
        {WhiteSpace}            { /* just skip what was found, do nothing */ }  
	.			{ System.err.println("Illegal character <" + yytext() + "> at line: " + (yyline + 1) + " column: " + (yycolumn + 1));  }
}
