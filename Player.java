public class Player {

	private int position;
	private String name = new String();

	Player (String userName) {

		name = userName;
		position = 0;
		return;

	}

	public String getName(){

		return name;

	}

	public void move (int squares) {
		position = position + squares;
		if (position < 0) {
			position = position + Monopoly.NUM_SQUARES;
		} else if (position >= Monopoly.NUM_SQUARES) {
			position = position % Monopoly.NUM_SQUARES;
		}
		return;
	}

	public int getPosition () {
		return position;
	}

}
