
public class Board {

	// Board data from http://monopoly.wikia.com/wiki/Monopoly
	// Note, a property is a site, utility or station

	public static final int NUM_SQUARES = 40;

	private Square[] squares = new Square[NUM_SQUARES];  // colour codes were also added to the squares area

	Board () {
		squares[0] = new Square("Go");
		squares[1] = new Property("Old Kent Rd", "brown", 50, 60, new int[] {2,10,30,90,160,250});
		squares[2] = new Square("Comminity Chest");
		squares[3] = new Property("Whitechapel Rd", "brown", 50, 60, new int[] {4,20,60,180,320,450});
		squares[4]  = new Square("Income Tax");
		squares[5] = new Property("King's Cross Station", "station", 0, 200, new int[] {25,50,100,200,200,200});
		squares[6] = new Property("The Angel Islington", "light blue", 50, 100, new int[] {6,30,90,270,400,550});
		squares[7] = new Square("Chance");
		squares[8] = new Property("Euston Rd", "light blue", 50, 100, new int[] {6,30,90,270,400,550});
		squares[9] = new Property("Pentonville Rd", "light blue", 50, 120, new int[] {8,40,100,300,450,600});
		squares[10] = new Square("Jail");
		squares[11] = new Property("Pall Mall", "pink", 100, 140, new int[] {10,50,150,450,625,750});
		squares[12] = new Property("Electric Co", "utility", 0, 150, new int[] {1,1,0,0,0,0});
		squares[13] = new Property("Whitehall", "pink", 100, 140, new int[] {10,50,150,450,625,750});
		squares[14] = new Property("Northumberland Ave", "pink", 100, 160, new int[] {12,60,180,500,700,900});
		squares[15] = new Property("Marylebone Station", "station", 0, 200, new int[] {25,50,100,200,200,200});
		squares[16] = new Property("Bow St", "orange", 100, 180, new int[] {14,70,200,550,750,950});
		squares[17] = new Square("Community Chest");
		squares[18] = new Property("Marlborough St", "orange", 100, 180, new int[] {14,70,200,550,750,950});
		squares[19] = new Property("Vine St", "orange", 100, 200, new int[] {16,80,220,600,800,1000});
		squares[20] = new Square("Free Parking");
		squares[21] = new Property("Strand", "red", 150, 220, new int[] {18,90,250,700,875,1050});
		squares[22] = new Square("Chance");
		squares[23] = new Property("Fleet St", "red", 150, 220, new int[] {18,90,250,700,875,1050});
		squares[24]  = new Property("Trafalgar Sq", "red", 150, 240, new int[] {20,100,300,750,925,1100});
		squares[25] = new Property("Fenchurch St Station", "station", 0, 200, new int[] {25,50,100,200,200,200});
		squares[26] = new Property("Leicester Sq", "yellow", 150, 260, new int[] {22,110,330,800,975,1150});
		squares[27] = new Property("Coventry St", "yellow", 150, 260, new int[] {22,110,330,800,975,1150});
		squares[28] = new Property("Water Works", "utility",0, 150, new int[] {1,1,0,0,0,0});
		squares[29] = new Property("Piccadilly", "yellow", 150, 280, new int[] {22,120,360,850,1025,1200});
		squares[30] = new Square("Go To Jail");
		squares[31] = new Property("Regent St", "green", 200, 300, new int[] {26,130,390,900,1100,1275});
		squares[32] = new Property("Oxford St", "green", 200, 300, new int[] {26,130,390,900,1100,1275});
		squares[33] = new Square("Community Chest");
		squares[34] = new Property("Bond St", "green", 200, 320, new int[] {28,150,450,1000,1200,1400});
		squares[35] = new Property("Liverpool St Station","station",0, 200, new int[] {25,50,100,200,200,200});
		squares[36] = new Square("Chance");
		squares[37] = new Property("Park Lane", "dark blue", 200, 350, new int[] {35,175,500,1100,1300,1500});
		squares[38] = new Square("Super Tax");
		squares[39] = new Property("Mayfair", "dark blue", 200, 400, new int[] {50,200,600,1400,1700,2000});
		return;
	}

	public Square getSquare (int index) {
		return squares[index];
	}

	public Property getProperty (int index) {
		return (Property) squares[index];
	}

	public boolean isProperty (int index) {
		return squares[index] instanceof Property;
	}
	

	public Property getProperty (String shortName) 
	{
		Property property = null;
		for (Square s : squares) {
			if (s instanceof Property) {
				Property p = (Property) s;
				if (p.equals(shortName)) {
					property = p;
				}
			}
		}
		return property;
		}
	
	boolean isProperty (String shortName) {
			boolean found = false;
			for (Square s :squares) {
				if (s instanceof Property) {
					Property p = (Property) s;
					if (p.equals(shortName)) {	
						found = true;
					}
				}
			}
			return found;
	}
}


