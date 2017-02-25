
public class Player { // moves player pieces around the board
	
	private int position;
	private int balance = 1500; // decarles starting balance for each player 
	private String name = new String();
	
	
	

	Player (String userName) {
		position = 0;
		name = userName;
		return;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void move (int squares) // gives gamepieces movement orders
	{
		position = position + squares;
		if (position < 0) 
		{
			position = position + Monopoly.NUM_SQUARES;
		} else if (position >= Monopoly.NUM_SQUARES) 
		{
			position = position % Monopoly.NUM_SQUARES;
		}
		return;
	}
	
	public int getPosition () // get players position on the board from square 0 - 39
	{
		return position;
	}	
	public int getBalance () 
	{
		return balance;
	}
	
	public int buyProperty()
	{
		balance = balance - proprice[getPosition()]; // get position and price of property before taking form players balance
		return balance;
	}
	
	public int payRent() // pay rent
	{
		balance = balance - Monopoly.rent; // rent currently set as standard value
		return balance;
	}
	
	public int passGO() // case if go is passed
	{
		balance = balance + 200;
		return balance;
	}

	
		
		
		
			String[] player1 = new String [40]; // sets array for each player in which names of property purchased is placed
			{
				
			}
			String[] player2 = new String [20];
			{
				
			}
			String[] player3 = new String [20];
			{
				
			}
			String[] player4 = new String [20];
			{
				
			}
			String[] player5 = new String [20];
			{
				
			}
			String [] player6 = new String [20];
			{
				
			}
			
			// need to return others 

			
			String prop[] = new String[40]; // string containing name of all the squares on the board
			{
			prop[0] = "Go square";
			prop[1] = "Old Kent Road";
			prop[2] = "Community Chect";
			prop[3] = "Whitechapel";
			prop[4] = "Income Tax";
			prop[5] = "King's Cross Station";
			prop[6] = "The Angel Islington";
			prop[7] = "Chance";
			prop[8] = "Euston Road";
			prop[9] = "Pentonville Road";
			prop[10] = "Jail(just visiting)";
			prop[11] = "Pall Mall";
			prop[12] = "Electric Company";
			prop[13] = "Whitehall";
			prop[14] = "Northumberland Avenue";
			prop[15] = "Marlylebone Station";
			prop[16] = "Bow Street";
			prop[17] = "Communtiy Chest";
			prop[18] = "Marlborough Street";
			prop[19] = "Vine Street";
			prop[20] = "Free Parking";
			prop[21] = "Strand";
			prop[22] = "Chance";
			prop[23] = "Fleet Street";
			prop[24] = "Trafalgar Square";
			prop[25] = "Fenchurch Street Station";
			prop[26] = "Leicester Square";
			prop[27] = "Coventry Street";
			prop[28] = "Water Works";
			prop[29] = "Piccadily";
			prop[30] = "Go to jail";
			prop[31] = "Regent Street";
			prop[32] = "Oxford Street";
			prop[33] = "Community Chest";
			prop[34] = "Bond Street";
			prop[35] = "Liverpool Street Station";
			prop[36] = "Chance";
			prop[37] = "Park Lane";
			prop[38] = "Super Tax";
			prop[39] = "Mayfair";
			}
		
		
			int proprice[] = new int[40]; // string containing prices of properties on the board
			{
			proprice[0] = 200;
			proprice[1] = 60;
			proprice[2] = 0;
			proprice[3] = 60;
			proprice[4] = 200;
			proprice[5] = 200;
			proprice[6] = 100;
			proprice[7] = 0;
			proprice[8] = 100;
			proprice[9] = 120;
			proprice[10] = 0;
			proprice[11] = 140;
			proprice[12] = 150;
			proprice[13] = 140;
			proprice[14] = 160;
			proprice[15] = 200;
			proprice[16] = 180;
			proprice[17] = 0;
			proprice[18] = 180;
			proprice[19] = 200;
			proprice[20] = 0;
			proprice[21] = 220;
			proprice[22] = 0;
			proprice[23] = 220;
			proprice[24] = 240;
			proprice[25] = 200;
			proprice[26] = 260;
			proprice[27] = 260;
			proprice[28] = 150;
			proprice[29] = 280;
			proprice[30] = 0;
			proprice[31] = 300;
			proprice[32] = 300;
			proprice[33] = 0;
			proprice[34] = 320;
			proprice[35] = 200;
			proprice[36] = 0;
			proprice[37] = 350;
			proprice[38] = 100;
			proprice[39] = 400;
			

			}	
		
		
	}

