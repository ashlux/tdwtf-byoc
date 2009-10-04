package com.ashlux.kata.stringcalculator;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StringCalculatorTest
{
    StringCalculator stringCalculator;

    @BeforeMethod
    public void setup()
    {
        stringCalculator = new StringCalculator();
    }

    @Test(description = "Empty string input should return 0.")
    public void add_emptyString()
    {
        assertEquals( stringCalculator.add( "" ), 0 );
    }

    @Test(description = "String 'N' in input should return that number as an integer.")
    public void add_oneNumber()
    {
        assertEquals( stringCalculator.add( "42" ), 42 );
    }

    @Test(description = "String 'N1,N2' in input should return N1 + N2.")
    public void add_twoNumbers()
    {
        assertEquals( stringCalculator.add( "42,42" ), 84 );
    }

    @Test(description = "String 'N1,N2,...Nn' in input should return N1 + N2 + ... + Nn.")
    public void add_unknownAmountOfNumbers()
    {
        assertEquals( stringCalculator.add( "1,2,3" ), 6 );
    }

    @Test(description = "String of numbers can be delimited by new line (\n) and comma (,).")
    public void add_delimitedByNewLineAndComma()
    {
        assertEquals( stringCalculator.add( "1,2\n3" ), 6 );
    }

    @Test(description = "Specify an optional delimiter on the first line. Delimiter line must start with '//'.")
    public void add_delimiter()
    {
        assertEquals( stringCalculator.add( "//*\n1*2*3" ), 6 );
    }

    @Test(description = "Negative number not allowed.")
    public void add_oneNegativeNumber()
    {
    }
}
