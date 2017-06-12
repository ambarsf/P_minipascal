program exProcedure;
var
   a, b, c: integer;
   e, f : String;

   function findMin(j: integer, g: integer):integer;
     var x, y, l,  min:String;
         m, n :integer;
     begin
        m := 10 + 20;
        g:=5;
        j := 5 + g + m;
        min := 'Hola';
        write(' Enter three numbers: ');
        write(' Minimum: ', min);
     end;
begin
   a  :=5;
   b := 5+a+a ; { esto tira un null pointer exception }
   e:= 'Ambar' + 'hola';
   f:= 'Ambar';
end
.
