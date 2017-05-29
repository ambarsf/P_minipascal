Program entero;
Var
		i : integer;
		linf, lsup, j : integer;
		cadena : string;
		caracter : char;
		num : integer;
		n: array[1..10] of integer;

{ESTE ES UN COMENTARIO AMBUCHIS}

Begin 
	for i := 1 to 10 do
		writeln(i);
	for i := 1 to 10 do
		writeln('1');

	writeln ('Introduzca el limite inferior y limite superior');
	readln (linf, lsup);
	
	for i := linf-3 to lsup*2 do
		writeln (i);
	caracter := 'a';
	num := 100;
	cadena := 'Ambar likes beans';
	writeln(caracter);
	writeln(cadena);
	for i := 1 to 10 do
        n[ i ] := i + 100;   (* set element at location i to i + 100 *)
    	(* output each array element's value *)
   
   	for j:= 1 to 10 do
        writeln('Element[', j, '] = ', n[j] );



end.
