package com.aslux.tdwtf.byoc.knockingmeofftheperch;

import java.util.LinkedList;
import java.util.List;

public class RouletteTable
{
    private RouletteWheel rouletteWheel = new RouletteWheel();

    private List<RouletteSlot> recentHistory = new LinkedList<RouletteSlot>();

    public RouletteSlot spinWheel()
    {
        // hold no more than 4 previous spins
        if ( recentHistory.size() == 4 )
        {
            recentHistory.remove( 0 );
        }

        // spin wheel and add this pick to the recent history board
        RouletteSlot rouletteSlot = rouletteWheel.spinWheel();
        recentHistory.add( rouletteSlot );
        return rouletteSlot;
    }

    public List<RouletteSlot> getRecentHistory()
    {
        return new LinkedList<RouletteSlot>( recentHistory );
    }
}
