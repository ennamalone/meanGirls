import java.util.ArrayList;
import java.util.Random;

public class Monopoly {


	public static final int NUM_SQUARES = 40;
	public static final int MAX_NUM_PLAYERS = 6;

	private ArrayList<Player> players = new ArrayList<Player>();
	private UI ui = new UI(players);
	int playerIndex = -1;
	String temp = new String();

	Monopoly () {

		for (int p=0; p < MAX_NUM_PLAYERS; p++) {

			ui.displayString("Please enter the player name for player " + (p+1) + ", or to finish enter done.");

			temp = ui.getCommand();

			if(temp.toLowerCase().equals("done")){

				ui.displayString(temp);
				break;

			}
			else
			{

				players.add(new Player(temp));
				ui.displayString(players.get(p).getName() + " is player " + (p+1) + ".");
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

		if((ui.getCommand().toLowerCase().equals("roll"))&&(rolls<1))
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

			}

			for (int p=0; p<playerIndex; p++) {
				for (int i=0; i<diceTotal; i++) {
					players.get(p).move(+1);
					ui.display();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						System.out.println("Sleep exeception.");
					}
				}
			}

		}
		else if((ui.getCommand().toLowerCase().equals("roll"))&&(rolls>1))
		{

			ui.displayString("You cannot roll until your next turn.");


		}


		return;
	}

	public void playerTurns(int i){

		if(i == (players.size()-1)){

			i = 0;

		}


		return playerTurns(i++);

	}



	public static void main (String args[]) {
		Monopoly game = new Monopoly();
		return;
	}
}
