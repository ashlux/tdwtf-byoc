package com.ashlux.kata.stringcalculator;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class StringCalculator
{
    private static final String DEFAULT_DELIMITER = ",\n";

    public int add( String commaSeperatedNumbers )
    {
        String[] numbers = getNumbers( commaSeperatedNumbers );
        return add( numbers );
    }

    private String[] getNumbers( String commaSeperatedNumbers )
    {
        String delimiters = getDelimiters( commaSeperatedNumbers );
        return StringUtils.split( StringUtils.remove( commaSeperatedNumbers, "//" + delimiters + "\n" ), delimiters );
    }

    private String getDelimiters( String commaSeperatedNumbers )
    {
        String delimiters = DEFAULT_DELIMITER;
        if ( hasDelimiterSpecified( commaSeperatedNumbers ) )
        {
            delimiters = StringUtils.substringBetween( commaSeperatedNumbers, "//", "\n" );
        }
        return delimiters;
    }

    private boolean hasDelimiterSpecified( String commaSeperatedNumbers )
    {
        return StringUtils.startsWith( commaSeperatedNumbers, "//" );
    }

    private int add( String[] numbers )
    {
        int total = 0;
        for ( String number : numbers )
        {
            total += convertStringToInt( number );
        }
        return total;
    }

    private int convertStringToInt( String string )
    {
        if ( "".equals( string ) )
        {
            return 0;
        }
        return Integer.parseInt( string );
    }
}
