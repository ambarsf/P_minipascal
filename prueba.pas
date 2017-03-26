PROGRAM Whldo;
        { THIS PROGRAM SHOWS THE WHILE-DO LOOP }
        VAR Counter:INTEGER;
                Sum:INTEGER;
  BEGIN
END.
Counter := 1;
Sum := 0;
WHILE Counter <= 15 DO
        BEGIN { WHILE LOOP }
        Sum := Sum + Counter;
        Counter := Counter + 1
        End;
WRITE('SUM =',Sum)
