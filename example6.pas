program exProcedure;
var
   a, b, c: integer;
   e, f : String;

   function findMin(j: integer, g: integer):integer;
     var x, y, l,  min:String;
     begin
        min := 'Hola';
        write(' Enter three numbers: ');
        write(' Minimum: ', min);
     end;

begin
<<<<<<< HEAD
   a:= f;       {tira error si se le asigna f por ejemplo, pero hay un null pointer exception}
   b:= 15 + a;   {si 15 se cambia por e tira un null pointer exception}
   c:= a + 10;    {si b se cambia por e que es un integer, no tira error}
   e:= 'Ambar' + 'l'; {si hol se cambia por solo l hay un null pointer exception}
   f:= 'Ambar' + a; {No funciona si le asigno 'Ambar+a'}
=======
   a:= 10;       {tira error si se le asigna f por ejemplo, pero hay un null pointer exception}
   b:= a + a;   {si 15 se cambia por e tira un null pointer exception}
   c:= 13 + 10;    {si b se cambia por e que es un integer, no tira error}
   e:= 'Ambar' + 'hola'; {si hol se cambia por solo l hay un null pointer exception}
   f:= 'Ambar' + e; {No funciona si le asigno 'Ambar+a'}
>>>>>>> d09d46782160c368834a33cde3b6a481275d7629
end
.
