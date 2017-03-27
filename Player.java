 import java.util.ArrayList;

public class Player {

	private String name;
	private int position;
	private int balance;
	private int amount;
	private String token;
	private boolean passedGo;
	private ArrayList<Property> properties = new ArrayList<Property>();

	Player (String name, String token) {
		this.name = name;
		this.token = token;
		position = 0;
		balance = 0;
		passedGo = false;
		return;
	}

	public void move (int squares) {
		position = position + squares;
		if (position >= Board.NUM_SQUARES) {
			position = position - Board.NUM_SQUARES;
			passedGo = true;
		} else {
			passedGo = false;
		}
		if (position < 0) {
			position = position + Board.NUM_SQUARES;
		}
		return;
	}

	public void doTransaction (int amount) {
		balance = balance + amount;
		this.amount = amount;
		return;
	}

	public int getPosition () {
		return position;
	}

	public String getName () {
		return name;
	}

	public int getTransaction () {
		return amount;
	}

	public int getBalance () {
		return balance;
	}

	public boolean passedGo () {
		return passedGo;
	}

	public void boughtProperty (Property property) {
		property.setOwner(this);
		properties.add(property);
		return;
	}

	public Property getLatestProperty () {
		return properties.get(properties.size()-1);
	}

	public ArrayList<Property> getProperties () {
		return properties;
	}

	public String getPropertyName (int i) {
		return properties.get(i).getName();
	}

	public String getPropertyColour(int i){
		return properties.get(i).getColour();
	}

	public int getPropertySize(){
		return properties.size();
	}

	public int getAssets () {
		int assets = balance;
		for (Property property: properties) {
			assets = assets + property.getValue();
		}
		return assets;
	}

	public String toString () {
		return name + " (" + token + ")";
	}
}
