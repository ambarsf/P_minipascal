program repeatUntilLoop;
var
   a: integer;

begin
   a := 10;
   repeat
      write('value of a: ', a);
      a := a + 1;
   until a = 20;
end.