package com.aslux.tdwtf.byoc.knockingmeofftheperch;

import java.util.LinkedList;
import java.util.List;

public class PerchStrategy
{
    public static void main( String[] args )
    {
        int count = 0;
        int successCount = 0;

        PerchStrategy perchStrategy = new PerchStrategy();
        for ( int i = 0; i < 100000; ++i )
        {
            ++count;
            long finalBankroll = perchStrategy.simulate( 10, 1, 20 );
            if ( finalBankroll > 0 )
            {
//                System.out.println( finalBankroll );
                ++successCount;
            }
        }

        System.out.println( "Success: " + successCount + " out of " + count + " attempts (" +
            ( ( (double) successCount / count ) * 100 ) + "%)." );
    }

    public long simulate( long startingBankroll, int numberOfTables, long desiredEndingBankroll )
    {
        long bankroll = startingBankroll;

        long currentBet = 10;

        List<RouletteTable> rouletteTables = createRouletteTables( numberOfTables );

        do
        {
            spinRouletteWheels( rouletteTables );
            RouletteTable rouletteTable = getRouletteTableWithFourInARow( rouletteTables );
            if ( rouletteTable != null )
            {
                Color betOnColor = rouletteTable.getRecentHistory().get( 0 ).getColor();
                Color nextSpinColor = rouletteTable.spinWheel().getColor();
                if ( nextSpinColor.equals( betOnColor ) )
                {
                    bankroll += currentBet;
                    currentBet += 1.50;
                }
                else
                {
                    bankroll -= currentBet;
                }

                if ( bankroll < currentBet )
                {
                    currentBet = bankroll;
                }
            }
        }
        while ( bankroll > 0 && bankroll < desiredEndingBankroll );

        return bankroll;
    }

    private RouletteTable getRouletteTableWithFourInARow( List<RouletteTable> rouletteTables )
    {
        for ( RouletteTable rouletteTable : rouletteTables )
        {
            List<RouletteSlot> recentHistory = rouletteTable.getRecentHistory();
            if ( recentHistory.size() == 4 &&
                recentHistory.get( 0 ).getColor().equals( recentHistory.get( 1 ).getColor() ) &&
                recentHistory.get( 0 ).getColor().equals( recentHistory.get( 2 ).getColor() ) &&
                recentHistory.get( 0 ).getColor().equals( recentHistory.get( 3 ).getColor() ) )
            {
                return rouletteTable;
            }
        }
        return null;
    }

    private void spinRouletteWheels( List<RouletteTable> rouletteTables )
    {
        for ( RouletteTable rouletteTable : rouletteTables )
        {
            rouletteTable.spinWheel();
        }
    }

    private List<RouletteTable> createRouletteTables( int numberOfTables )
    {
        List<RouletteTable> rouletteTables = new LinkedList<RouletteTable>();
        for ( int i = 0; i < numberOfTables; ++i )
        {
            rouletteTables.add( new RouletteTable() );
        }
        return rouletteTables;
    }


}
