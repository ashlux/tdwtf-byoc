package com.aslux.tdwtf.byoc.knockingmeofftheperch;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class RouletteWheel
{
    private final List<RouletteSlot> rouletteWheel = new LinkedList<RouletteSlot>();

    public RouletteWheel()
    {
        rouletteWheel.add( new RouletteSlot( Color.GREEN, "0" ) );
        rouletteWheel.add( new RouletteSlot( Color.GREEN, "00" ) );

        for ( int i = 1; i <= 36; ++i )
        {
            // even = red, odd = black
            if ( i % 2 == 0 )
            {
                rouletteWheel.add( new RouletteSlot( Color.RED, String.valueOf( i ) ) );
            }
            else
            {
                rouletteWheel.add( new RouletteSlot( Color.BLACK, String.valueOf( i ) ) );
            }
        }
    }

    public RouletteSlot spinWheel()
    {
        int chosenIndex = new Random().nextInt( rouletteWheel.size() );
        return rouletteWheel.get( chosenIndex );
    }
}
