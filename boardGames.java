import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

class boardGames extends JFrame{
	
	public static void main(String[] a) throws IOException{
		    	 
				   }
		       String path = "C:\\Users\\Cian\\Desktop\\alpha3.jpg";
		       File file = new File(path);
		       BufferedImage image = ImageIO.read(file);
		       JLabel board = new JLabel(new ImageIcon(image));
		       boardGames gameBoard = new boardGames();
		       gameBoard.getContentPane().add(board);
		       gameBoard.setSize(1200, 1200);
		       gameBoard.setVisible(true);
		       gameBoard.setTitle("meanGirls #cringe");
		       gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       int b = 165;
			   int b1 = 180;
			   int b2 = 195;
			   int a1 = 950; // +/- 80 for each space 
			   boolean show = false;
			   String input;
			   {
				 for(int i = 0; i <40; i++)
				 {
				   input = JOptionPane.showInputDialog(null, "Please enter one to move the pieces around the board, "
				   		+ " press 0 to view the board");
				   double moves =  Double.parseDouble(input);
				   if(moves == 1 && i <= 10)
				   {
					   a1 = a1 - 80;
					   
				   }
				   if(moves == 1 && i >= 10 && i < 19)
				   {
					   b = b + 80;
					   b1 = b1 + 80;
					   b2 = b2 + 80;
					   
				   }
				   if(moves == 1 && i >= 19 && i <= 20)
				   {
					   b = b + 55;
					   b1 = b1 + 55;
					   b2 = b2 + 55;
					   
				   }
				   if(moves == 1 && i >= 20 && i <= 30)
				   {
					   a1 = a1 + 80;     
				   }
				   if(moves == 1 && i >= 30 && i <= 40)
				   {
					   b = b - 80;
					   b1 = b1 - 80;
					   b2 = b2 - 80;
				   }
				   else if(moves == 0)
					 {
						 i = 40;
					 }
				   }
			   }

			  
			       public void paint(Graphics g){
				   boolean show = true;
			        super.paint(g);
			        super.paintComponents(g);
			        if(show){
				      g.drawOval(b,a1,10,10);
			          g.drawOval(b1,a1,10,10);
			          g.drawOval(b2,a1,10,10);
			          g.setColor(Color.RED);
			          g.fillOval(b,a1,10,10);
			          g.setColor(Color.GREEN);
			          g.fillOval(b1,a1,10,10);
			          g.setColor(Color.BLUE);
			          g.fillOval(b2,a1,10,10);
			        }
	

		}

		}
}
