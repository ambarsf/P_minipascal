PROGRAM FindLarge;
                { THIS PROGRAM READS IN TWO INTEGERS. IT
                   WILL DETERMINE WHICH IS THE LARGER OF THE TWO,
                  AND PRINT AN APPROPRIATE MESSAGE }
  VAR Number1:INTEGER;{FIRST NUMBER READ}
  Number2:INTEGER;{SECOND NUMBER READ}
  Larger:INTEGER;{THE LARGER ONE}
  BEGIN
  READ(Number1);
  IF Number1 > Number2 THEN
          Larger := Number1
  ELSE
          Larger := Number2;
  WRITE('THE LARGER OF ',Number1,' AND ',Number2,' IS ',Larger);
  END.
