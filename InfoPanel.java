import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InfoPanel extends JPanel implements ActionListener // Information panel with the other two panels attached and input writes to the information page
{
	private JFrame layout; // Setting the JFrame for the other components to fit into
	private JPanel board; // Space for board
	private JTextArea infopanel;
	private JTextField input;
	
	public String writeInformation(String diceNumber) // Testing function to getting the dice roll to print in the info panel
	{
		String diceRoll = "You rolled a " + diceNumber + "!\n";
		return diceRoll;
	}
	
	public void prepareGUI() // Setting the entire interface with sizes and positions
	{
		layout = new JFrame("Monoply");
		layout.setSize(1200, 800); // The entire JFrame is 1200 x 800
		
		board = new JPanel();
		board.setSize(800, 800); // Setting the board to 800 x 800
		
		input = new JTextField();
		input.setSize(400, 100);
//		input.setCaretPosition(0);
		input.setCaretColor(Color.GREEN); // Setting the cursor colour to green
		input.setLayout(new FlowLayout());
		input.setForeground(Color.GREEN); // Writing is green
		input.setBackground(Color.BLACK); // Background of the command line is black
		input.addActionListener(this);  // When enter is hit, the actionPerformed class is called
		
		infopanel = new JTextArea();
		infopanel.setSize(400, 800);
		infopanel.setEditable(false); // Cannot write anything directly into the info panel
		infopanel.setLayout(new FlowLayout());
		Font infoFont = new Font("Serif", Font.ITALIC | Font.BOLD, 16);
		infopanel.setFont(infoFont); // The font in the info panel is set as above
		
		board.setBounds(0, 0, 800, 800); // Setting the co-ordinates of the JComponents
		input.setBounds(800, 675, 700, 20);
		infopanel.setBounds(800, 0, 700, 675);
		
		int x = 4;
		String dice = Integer.toString(x); // Testing Dice roll function
		
		infopanel.append(writeInformation(dice)); // Writing the function into the info panel
		
		
		layout.add(board); // Adding all components to the JFrame
		layout.add(input);
		layout.add(infopanel);
		layout.setLayout(null);
		
		layout.setVisible(true);
	}
	
	public InfoPanel()
	{
		prepareGUI();
	}
	
	public void actionPerformed(ActionEvent evt) // Called whenever enter is hit
	{
		String userInput = input.getText(); 
		infopanel.append(userInput + "\n"); // Adds the user text into the info panel
		
		input.selectAll(); // Highlights all of the text so that the user can start typing again without deleting all of the typed text
	}
	
	private void showBoard()
	{
		layout.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		InfoPanel Board = new InfoPanel();
		Board.showBoard();
	}
	
}