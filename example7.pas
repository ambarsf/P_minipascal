program exProcedure;
var
   a, b, c: integer;
   e, f : String;

   function findMin(j: integer, g: integer):integer;
     var x, y, l,  min:String;
         m, n :integer;
     begin
        m := 10;
        min := 'Hola';
	findMin := m;
        write(' Enter three numbers: ');
        write(' Minimum: ', min);
     end;
    function Ambuchis(h: integer, i: String):String;
	var o, p, q: String;
	begin
		o:= 'Trece';
		p:= 'Catorce';
		q:= 'Ambar likes beans';
		Ambuchis:= q;
	end;
begin
   a:= 10 + r;
   e:= 'Ambar' + 'hola'; {si hol se cambia por solo l hay un null pointer exception}
   f:= 'Ambar'; {No funciona si le asigno 'Ambar+a'}
   a:= 10;       {tira error si se le asigna f por ejemplo, pero hay un null pointer exception}
   m := 11;
end.