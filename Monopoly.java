import java.util.ArrayList;
import java.util.Random;

public class Monopoly {


	public static final int NUM_SQUARES = 40;
	public static final int MAX_NUM_PLAYERS = 6;
	public static final int rent = 16;
	


	private ArrayList<Player> players = new ArrayList<Player>();
	private UI ui = new UI(players);
	int playerIndex;
	String temp = new String();
	String command;
	private Boolean condition;
	

	Player player = new Player(command);
	int p = 0, z = 0, i = 0, k = 0;
	int rolls = 0;
	
	
	void turn(){
		for(Player element : players){ // allows each arraylist element to be accessed independently
			condition = true; // sets boolean
			playerTurns(element);// calls playerTurns function
			

		}
		turn();
	}


	Monopoly () {

		for (int p=0; p < MAX_NUM_PLAYERS; p++) { // gets players names and assigns a balance to each

			ui.displayString("Please enter the player name for player " + (p+1) + ", or to finish enter done.");
			temp = ui.getCommand();

			if(temp.toLowerCase().equals("done")){

				ui.displayString(temp);
				whoFirst();
				turn();
				break;

			}
			else
			{

				players.add(new Player(temp));
				ui.displayString(players.get(p).getName() + " is player " + (p+1) + "."); // players name is displayed
				ui.displayString("balance:" + players.get(p).getBalance()); // players balance is displayed
				playerIndex++;

			}

		}
		
		ui.display();
		return;
	}

		
	public void whoFirst() { // function to decide who goes first based on highest dice roll

		int diceA, diceB;
		int[] resArr = new int[6];
		Random diceRoll = new Random();

		for(int a = 0; a <= players.size(); a++)
		{

			diceA = 1 + diceRoll.nextInt(6); // dice roll random between 1-6
			diceB = 1 + diceRoll.nextInt(6); // dice roll random between 1-6
			resArr[a] = diceA + diceB;

		}

	}

	private void DiceRoll () {

		if(rolls<1)
		{
			Random diceRoll = new Random();
			int dice1;
			int dice2;
			int diceTotal;


			dice1 = 1 + diceRoll.nextInt(6); // dice roll random between 1-6
			dice2 = 1 + diceRoll.nextInt(6); // dice roll random between 1-6

			ui.displayString("Your rolled dice are " + dice1 + " and " + dice2 + ".");

			diceTotal = dice1 + dice2;
			rolls++;

			if(dice1 == dice2)
			{

				rolls--;
				DiceRoll();

			} // counts the number of dice roll so user can only have one rolls if doubled is not rolled

			for (int i = 0; i<diceTotal;  i++) {
				
					players.get(p).move(+1);
					ui.display();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						System.out.println("Sleep exeception.");
					}
				}
			

		}
		else if(rolls>=1) // case if player has already rolled this turn 
		{

			ui.displayString("You cannot roll until your next turn.");
			return;

		}

		return;
	}

	public void playerTurns(Player e){ // 
		
		
	while(condition) // the boolean conditions is true will execute player turns and ensuing switch statments
	{
		ui.displayString("\n" +  e.getName());
		 
		
		switch (ui.getCommand().toLowerCase())
		{
			case "roll": // rolls random dice to move players gamepiece
				DiceRoll();
				ui.displayString(player.prop[e.getPosition()]); // displays the name of property landed on by calling getPosition from player class 
				ui.displayString("price:" + player.proprice[e.getPosition()]); // displays said properties price
				if(e.getPosition() == 0 || e.getPosition() == 1 || e.getPosition() == 2 || e.getPosition() == 3)
				{
					e.passGO(); // adds 200 to the players bank account as they pass go 
				} 
				break;
				
			case "balance": // displays current players balance
				String numberAsString = Integer.toString(e.getBalance()); // calls getBalance function from players class
				ui.displayString(numberAsString);	// calls balance function form player class
				break;
				
			case "pay rent":
				String numberAsString1 = Integer.toString(e.payRent()); // calls pay Rent function from player class
				ui.displayString(numberAsString1);
				break;
				
			case "buy":
				 
				String numberAsString2 = Integer.toString(e.buyProperty()); // calls buyProperty function player class
				ui.displayString(numberAsString2);
				player.player1[i] = player.prop[e.getPosition()]; // adds name of property to each players personal array
				i++;
				k++;
				break; 
	
			case "help": // if player requires help remembering commands 
				String validCommands = ">Accepted commands are: BALANCE, BUY, PAY RENT, HELP, PROPERTY, ROLL";
				ui.displayString(validCommands);
				break;
				
			case "property": // gives players list of properties that are owned 
				int j = 0;
				ui.displayString("Properties owned are:" + "\n");
				while(j != k)
				{
					ui.displayString(player.player1[j]); // calls player1 array form player class
					j++;
				}
				break;
				
			case "done": // iterates the players
				p = p + 1;
				if(p == players.size()) // allows player to end turn so next player can begin their turn
				{
					p = 0;	
				}
				players.get(p).move(+1);
				try {
					Thread.sleep(500);
				} catch (InterruptedException a) {
					System.out.println("Sleep exeception.");
				}
				rolls = 0;
				condition = false; // breaks boolean statement so switch statements can start again
				break;
				
			default: // case if a command is entered that is not recognised
				String errorMessage = "ERROR: Invalid command\nAccepted commands are: BALANCE, BUY, PAY RENT, HELP, PROPERTY, ROLL";
				ui.displayString(errorMessage);
				
			
		}
}		
		return;


	}



	public static void main (String args[]) {
		Monopoly game = new Monopoly(); // launches the game
		return;
	}
}