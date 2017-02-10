import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


// By Cian Kelly, 15386256 10/02/2017

class boardGames extends JFrame{
	
	   int b = 165; // sets orginal co-ordinates for pieces 
	   int b1 = 180;
	   int b2 = 195;
	   int a1 = 950;
	   int i = 0;
	   
	  public void paint(Graphics g){  // places coloured pieces on the board with their co-ordinates
	        super.paint(g);
	       
	        super.paintComponents(g);
	        boolean show = true;
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
	          
	        for(int i = 0; i <40; i++)
				{
	        	  
				   String input = JOptionPane.showInputDialog(null, "Please enter one to move the pieces around the board. 0 to exit");
				   double moves =  Double.parseDouble(input); // question box which allows pieces to be moved 
				  
				   
				   if(moves == 1 && a1 >= 150 && b != 965) // moves along left hand side of board
				   {				   
					   a1 = a1 - 80;
					   super.repaint();  
					   System.out.println(a1);
					  
				   }
				 
		
				   if(moves == 1 && a1 < 150 && b != 965) //moves along top of board
				   {
					   b = b + 80;
					   b1 = b1 + 80;
					   b2 = b2 + 80;
					   System.out.println(b);
					   System.out.println(b1);
					   System.out.println(b2);
					   super.repaint();
				   }
				   if(moves == 1 && b == 965 && a1 < 930) //moves along left hand side of board
				   {
					   a1 = a1 +78;
					   super.repaint();
					   System.out.println(a1);
				   }
				   if(moves == 1 && a1 == 928 && b == 965 || b == 887 || b == 809 || b == 731 || b == 653 || b == 575 || b == 497 || b == 419 || b == 341 || b == 263)
				   {
					   b = b - 78;
					   b1 = b1 - 78;  //moves along bottom of the board
					   b2 = b2 - 78;
					   a1 = 950;
					   super.repaint();
				   }
				   else if(moves == 0) //exit board if 0 is entered in pane
				   {
					   System.exit(0);
				   }
			  }  
	          
			
	        }

	 
	public static void main(String[] a) throws IOException{
		    	 
				   
		       String path = "C:\\Users\\Cian\\Desktop\\alpha3.jpg"; // path the iamge of boards 
		       File file = new File(path);
		       BufferedImage image = ImageIO.read(file);
		       JLabel board = new JLabel(new ImageIcon(image));
		       boardGames gameBoard = new boardGames();	    
		       gameBoard.getContentPane().add(board); // sets board title, size and attatches image 
		       gameBoard.setSize(1200, 1200);
		       gameBoard.setVisible(true);
		       gameBoard.setTitle("meanGirls #cringe");
		       gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       
	}
	
}

		     
	

