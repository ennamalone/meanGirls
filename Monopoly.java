import java.util.ArrayList;
import java.util.Random;

public class Monopoly {


	public static final int NUM_SQUARES = 40;
	public static final int MAX_NUM_PLAYERS = 6;
	public static final int rent = 50;
	public static final int price = 450;


	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Integer> players1 = new ArrayList<Integer>();
	private UI ui = new UI(players);
	int playerIndex = -1;
	String temp = new String();
	String command;
	
	Money money = new Money();
	int p = 0, z = 0;


	Monopoly () {

		for (int p=0; p < MAX_NUM_PLAYERS; p++) {

			ui.displayString("Please enter the player name for player " + (p+1) + ", or to finish enter done.");
			players1.add(0, money.getBalance()); // obvious 
			players1.add(1, money.getBalance1());
			players1.add(2, money.getBalance2()); // need to get seperate accounts for each
			players1.add(3, money.getBalance3());
			players1.add(4, money.getBalance4());
			players1.add(5, money.getBalance5());
			
			temp = ui.getCommand();

			if(temp.toLowerCase().equals("done")){

				ui.displayString(temp);
				whoFirst();
				playerTurns();
				break;

			}
			else
			{

				players.add(new Player(temp));
				ui.displayString(players.get(p).getName() + " is player " + (p+1) + "."); // not working properly
				ui.displayString("balance:" + players1.get(p));
				playerIndex++;

			}

		}
		
		ui.display();
		return;
	}

		
	public void whoFirst() {

		int diceA, diceB;
		int[] resArr = new int[6];
		Random diceRoll = new Random();

		for(int a = 0; a <= players.size(); a++)
		{

			diceA = diceRoll.nextInt(6);
			diceB = diceRoll.nextInt(6);
			resArr[a] = diceA + diceB;

		}

	}

	private void DiceRoll () {

		int rolls = 0;

		if(rolls<1)
		{
			Random diceRoll = new Random();
			int dice1;
			int dice2;
			int diceTotal;


			dice1 = diceRoll.nextInt(6);
			dice2 = diceRoll.nextInt(6);

			ui.displayString("Your rolled dice are " + dice1 + " and " + dice2 + ".");

			diceTotal = dice1 + dice2;
			rolls++;

			if(dice1 == dice2)
			{

				rolls--;
				DiceRoll();

			}

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
		else if(rolls>=1)
		{

			ui.displayString("You cannot roll until your next turn.");
			return;

		}

		return;
	}

	public void playerTurns(){
		
		do
		{
			ui.displayString("\n" + "\n" +  players.get(0).getName());
			command = ui.getCommand();
			ui.displayString(command);
			
			if(command.equalsIgnoreCase("roll"))
			{
				DiceRoll();
			}

			if(command.equalsIgnoreCase("balance")) // works no matter what case is used when typing the word
			{
				// calls new class money
				String numberAsString = Integer.toString(money.getBalance());
				ui.displayString(numberAsString);	// prints out 1500 in response to balance entered
			}

			if(command.equalsIgnoreCase("pay rent"))
			{
				// calls new class money
				String numberAsString1 = Integer.toString(money.payRent());
				ui.displayString(numberAsString1);
			}

			if(command.equalsIgnoreCase("buy"))
			{
				// calls new class money
				String numberAsString2 = Integer.toString(money.buyProperty());
				ui.displayString(numberAsString2);
			}

			if(command.equalsIgnoreCase("help"))
			{
				String validCommands = ">>>>> Accepted commands are: BALANCE, BUY, PAY RENT, HELP, PROPERTY, ROLL";
				ui.displayString(validCommands);
			}
			if(command.equalsIgnoreCase("done"))
			{
				p = p + 1;
				if(p == players.size())
				{
					p = 0;	
				}
				players.get(p).move(+1);
				ui.display();
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Sleep exeception.");
				}
			}

			if(!command.equalsIgnoreCase("help") || !command.equalsIgnoreCase("buy") || !command.equalsIgnoreCase("pay rent") || !command.equalsIgnoreCase("balance") || !command.equalsIgnoreCase("roll") || !command.equalsIgnoreCase("property"))
			{
				String errorMessage = "ERROR: Invalid command\nAccepted commands are: BALANCE, BUY, PAY RENT, HELP, PROPERTY, ROLL";
				ui.displayString(errorMessage);
			}
		}
		while (!command.equals("quit"));

		return;


	}



	public static void main (String args[]) {
		Monopoly game = new Monopoly();
		return;
	}
}