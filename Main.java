// Cian Kelly 15386256
// Brian Finlay 15381151
// Énna Malone 


public class Main {

	public static void main (String args[]) {	
		Monopoly monopoly = new Monopoly();		
		monopoly.inputNames();
		monopoly.giveStartMoney();
		monopoly.decideStarter();
		do {
			monopoly.processTurn();
			if (!monopoly.isGameOver()) {
				monopoly.nextPlayer();
			}
		} while (!monopoly.isGameOver());
		monopoly.decideWinner();
		monopoly.displayGameOver();
		return;
	}
	
}
