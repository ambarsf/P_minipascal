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
   a:= 10;       {tira error si se le asigna f por ejemplo, pero hay un null pointer exception}
   b:= 15 + a;   {si 15 se cambia por e tira un null pointer exception}
   c:= a + b;    {si b se cambia por e que es un integer, no tira error}
   e:= 'Ambar' + 'hol'; {si hol se cambia por solo l hay un null pointer exception}
   f:= 'Ambar' + a; {No funciona si le asigno 'Ambar+a'}
end
.
