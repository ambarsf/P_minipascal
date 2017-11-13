PROGRAM Adder2;
VAR Number, Sum, Qty:INTEGER;
BEGIN
  READ (Qty);
    WHILE Qty > 0 DO
            READ (Number);
            Sum := 0;
            Sum := Sum + Sum;
            Qty := Sum - 1;

    WRITE('SUM IS ',Sum);
  END.
