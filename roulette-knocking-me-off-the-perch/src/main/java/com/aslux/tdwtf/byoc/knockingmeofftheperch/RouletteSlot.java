package com.aslux.tdwtf.byoc.knockingmeofftheperch;

public class RouletteSlot
{
    private final Color color;
    private final String number;

    public RouletteSlot( Color color, String number )
    {
        this.color = color;
        this.number = number;
    }

    public Color getColor()
    {
        return color;
    }

    public String getNumber()
    {
        return number;
    }

    @Override
    public String toString()
    {
        return "RouletteSlot{" + "color=" + color + ", number='" + number + '\'' + '}';
    }
}
