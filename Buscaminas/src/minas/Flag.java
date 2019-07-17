package minas;

public class Flag {

		private Matrix flagMap;
		private int countOfClosedBoxes;
		void start() 
		{
			flagMap=new Matrix(Box.CLOSED);
			countOfClosedBoxes = Ranges.getSize().x*Ranges.getSize().y;
		}
		Box get(Coord coord) 
		{
			return flagMap.get(coord);
		}
		public void setOpenedToBox(Coord coord) {
			flagMap.set(coord, Box.OPENED);
			countOfClosedBoxes--;
		}
		
		public void setFlagedBox(Coord coord) {
			flagMap.set(coord, Box.FLAGED);			
		}
		public void setCloseedBox(Coord coord) {
			flagMap.set(coord, Box.CLOSED);			
		}
		public void toggFlagedBox(Coord coord) 
		{
			switch(flagMap.get(coord))
			{
				case FLAGED :setCloseedBox(coord);
				case CLOSED :setFlagedBox(coord);
				
			}
			
		}
	     int getCountClosedBoxes() {
			return countOfClosedBoxes;
		}
		void setBombedToBox(Coord coord) {
			flagMap.set(coord, Box.BOMBED);
			
		}
		public void setOpenedToClosedBombBox(Coord coord) 
		{
			if(flagMap.get(coord)==Box.CLOSED)
				flagMap.set(coord,Box.OPENED);
			
		}
		public void setNobombToFlagedSafeBox(Coord coord) 
		{
			if(flagMap.get(coord)==Box.FLAGED)
				flagMap.set(coord,Box.NOBOMB);			
		}
		int getCountOfFlagedBoxesAround (Coord coord)
	    {
			int count = 00;
			for(Coord around : Ranges.getCoordsArround(coord))
				if(flagMap.get(around)== Box.FLAGED)
					count++;
	        return count;
	    }

}
