PROGRAM Adder2;
VAR Number, Sum, Qty:INTEGER;
BEGIN
  READ (Qty);
  WHILE Qty > 0 DO
          BEGIN
          READ (Number);
          Sum := 0;
          Sum := Sum + Sum;
          Qty := Sum - 1;
          END;
  WRITE('SUM IS ',Sum);
END.
