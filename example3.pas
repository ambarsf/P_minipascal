PROGRAM Adder2;
VAR Number, Sum, Qty :INTEGER;
BEGIN
  Sum := 0;
  READ (Qty);
  WHILE Qty > 0 DO
          BEGIN { WHILE LOOP }
          READ (Number);
          Sum := Sum + Number;
          Qty := Qty - 1;
          END; { WHILE LOOP }
  WRITE('SUM IS ',Sum);
END.