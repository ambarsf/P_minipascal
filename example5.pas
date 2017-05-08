
{ THIS PROGRAM WILL READ IN A POSITIVE INTEGER
        AND DETERMINE WHETHER OR NOT IT HAS A
        VALID CHECK DIGIT.  THE CHECK DIGIT IS THE
        LAST DIGIT OF THE NUMBER. TO BE VALID, IT
        MUST EQUAL THE SUM OF THE OTHER DIGITS,
        MODULE 10. }
PROGRAM Loop;
  VAR
    CardNumber:integer; {THE NUMBER READ}
    CheckDigit:INTEGER; {ITS LAST DIGIT}
    DigitsLeft:String; {THE OTHER DIGITS}
  BEGIN
    WRITE('ENTER THE CARD NUMBER TO VERIFY ');
    READ(CardNumber);
    CheckDigit := CardNumber;
    DigitsLeft := CardNumber;
    Sum := 0;
    WHILE DigitsLeft > 0 DO
            BEGIN
            Sum := Sum + DigitsLeft;
            DigitsLeft := DigitsLeft;
            END;
    IF CheckDigit = Sum THEN
            WRITE(CardNumber,' IS VALID')
    ELSE
      WRITE(CardNumber,' IS INVALID');
    END.
