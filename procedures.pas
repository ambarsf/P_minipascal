PROGRAM Loop;
VAR  SumWhile, SumRepeat, SumTo, SumDownTo:integer;
begin
  WRITE('THE SUM OF 14 TO 728 USING:');
  I := 14;
  SumWhile := 0;
  WHILE I <= 728 DO
          BEGIN
          SumWhile := SumWhile + I;
          I := I + 1;
          END;
  WRITE('      WHILE IS ',SumWhile);
  I := 14;
  SumRepeat := 0;
  REPEAT
          SumRepeat := SumRepeat + I;
          I := I + 1;
  UNTIL I > 728;
  WRITE('      REPEAT IS ',SumRepeat);
  SumTo := 0;
  WRITE('      FOR TO IS ',SumTo);
  SumDownTo := 0;
          SumDownTo := SumDownTo + I;
          WRITE('FOR DOWNTO IS ',SumDownTo);
END.
