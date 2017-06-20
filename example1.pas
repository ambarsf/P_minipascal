PROGRAM FindLarge;
                { THIS PROGRAM READS IN TWO INTEGERS. IT
                   WILL DETERMINE WHICH IS THE LARGER OF THE TWO,
                  AND PRINT AN APPROPRIATE MESSAGE }
  VAR Number1: INTEGER ;{FIRST NUMBER READ}
  Number2: INTEGER;{SECOND NUMBER READ}
  Larger:INTEGER; {THE LARGER ONE}
  verd :string;
  BEGIN
  READ  (Number1);
  IF Number1 < Number2 THEN
          BEGIN
          Larger := Number1;
          verd := 'hola';
          END
  ELSE
          BEGIN
	   	
          Larger := Number2;
          END;
  WRITE ('THE LARGER OF ' , Number1,' AND ',Number2,' IS ',Larger );
  END.
