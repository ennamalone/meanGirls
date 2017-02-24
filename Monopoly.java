import java.util.ArrayList;
import java.util.Random;

public class Monopoly {


	public static final int NUM_SQUARES = 40;
	public static final int MAX_NUM_PLAYERS = 6;
	public static final int rent = 50;
	public static final int price = 450;


	private ArrayList<Player> players = new ArrayList<Player>();
	private UI ui = new UI(players);
	int playerIndex = -1;
	property properties = new property();
	String temp = new String();
	String command;
	private Boolean cond;
	

	Player player = new Player(command);
	int p = 0, z = 0, j = 0;
	
	void turn(){
		for(Player element : players){
			cond = true;
			playerTurns(element);
			

		}
		turn();
	}


	Monopoly () {

		for (int p=0; p < MAX_NUM_PLAYERS; p++) {

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
				ui.displayString(players.get(p).getName() + " is player " + (p+1) + "."); // not working properly
				ui.displayString("balance:" + players.get(p).getBalance());
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

	public void playerTurns(Player e){
		
		
	while(cond)
	{
		ui.displayString("\n" +  e.getName());
		 
		
		switch (ui.getCommand().toLowerCase())
		{
			case "roll":
				DiceRoll();
				ui.displayString(properties.prop[e.getPosition()]);
				ui.displayString("price:" + properties.proprice[e.getPosition()]);
				if(e.getPosition() == 0 || e.getPosition() == 1 || e.getPosition() == 2 || e.getPosition() == 3)
				{
					e.passGO();
				}
				
				break;
				
			case "balance":
				String numberAsString = Integer.toString(e.getBalance());
				ui.displayString(numberAsString);	// prints out 1500 in response to balance entered
				break;
				
			case "pay rent":
				String numberAsString1 = Integer.toString((e.getBalance() - properties.proprice[e.getPosition()]));
				ui.displayString(numberAsString1);
				break;
				
			case "buy":
				int i = 0;
				String numberAsString2 = Integer.toString(e.buyProperty());
				ui.displayString(numberAsString2);
				/*while(i < properties.player1.length)
				{
					properties.player1[i] = properties.prop[e.getPosition()];
					i++;
				}
			
				while(j != properties.player1.length)
				{
					ui.displayString("Propeties owned are:" + "\n" + properties.player1[j]);
					j++;
				} */
				break;
	
			case "help":
				String validCommands = ">Accepted commands are: BALANCE, BUY, PAY RENT, HELP, PROPERTY, ROLL";
				ui.displayString(validCommands);
				break;
				
			case "done":
				p = p + 1;
				if(p == players.size())
				{
					p = 0;	
				}
				players.get(p).move(+1);
			//	ui.display(Player.);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException a) {
					System.out.println("Sleep exeception.");
				}
				cond = false;
				break;
				
			default:
				String errorMessage = "ERROR: Invalid command\nAccepted commands are: BALANCE, BUY, PAY RENT, HELP, PROPERTY, ROLL";
				ui.displayString(errorMessage);
				
			
		}
}		
		return;


	}



	public static void main (String args[]) {
		Monopoly game = new Monopoly();
		return;
	}
}