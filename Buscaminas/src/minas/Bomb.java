package minas;

class Bomb 
{
    private Matrix bombMap;
    private int totalBombs;
	
    Bomb (int totalBombs)
    {
        this.totalBombs = totalBombs;
        fixBombsCount();
    }
	
    void start()
    {
        bombMap = new Matrix(Box.ZERO);
        for (int j = 0; j < totalBombs; j++)
            placeBomb ();
    }
    private void fixBombsCount() 
    {
    	int maxBombs=Ranges.getSize().x *Ranges.getSize().y /2;
    	if(totalBombs>maxBombs)
    		totalBombs=maxBombs;
    }
	private void placeBomb() 
	{
		while (true)
        {
            Coord coord = Ranges.getRandomCoord();
            if (Box.BOMB == bombMap.get(coord))
                continue;
            bombMap.set(new Coord(coord.x, coord.y), Box.BOMB);
            incNumbersAroundBomb(coord);
            break;
        }
	}
	Box get (Coord coord)
    {
        return bombMap.get(coord);
    }
	
	private void incNumbersAroundBomb (Coord coord)
    {
        for (Coord around : Ranges.getCoordsArround(coord))
            if (Box.BOMB != bombMap.get(around))
                bombMap.set(around, bombMap.get(around).getNextNumberBox());
    }

	int getTotalBombs() {
		return totalBombs;
	}

}
