
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;

// As with the previous JFrame classes, this class extends
// JFrame (so that objects from this class will be window frames
// on the screen).  The paint method then contains what we
// want to happen when the created window is painted.
// This class also implements the MouseListener interface
// so that it can respond appropriately when mouse events
// happen; what the class does is, every time the mouse is
// clicked within the JFrame, it paints a circle at the
// location of that mouse click

class MouseJFrameq  extends JFrame implements MouseMotionListener{

   int circleXcenter;
   int circleYcenter;
   int circleRadius = 5;
   boolean show = false;

// the constructor method: uses the addMouseListener method
// (inherited from JFrame) to say that this window is going
// to listen for and respond to its own mouse events.

   public MouseJFrameq(){
       addMouseMotionListener(this);
   }

// Paints a circle (as before)

   public void paint(Graphics g){
	   show = true;
        super.paint(g);
        super.paintComponents(g);
        if(show){
          g.drawOval(160,1000,10,10);
          g.drawOval(175,1000,10,10);
          g.drawOval(190,1000,10,10);
          g.setColor(Color.RED);
          g.fillOval(160,1000,10,10);
          g.setColor(Color.GREEN);
          g.fillOval(175,1000,10,10);
          g.setColor(Color.BLUE);
          g.fillOval(190,1000,10,10);
        }
   }
   
   public void mouseDragged(MouseEvent e)
   {
	   
   }

@Override
public void mouseMoved(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

}

public class MyTestMouseWithNoClick{

    public static void main(String[] a) throws IOException{
       String path = "C:\\Users\\Cian\\Desktop\\alpha3.jpg";
       File file = new File(path);
       BufferedImage image = ImageIO.read(file);
       JLabel board = new JLabel(new ImageIcon(image));
       MouseJFrameq  myMouseJFrame2 = new MouseJFrameq ();
       myMouseJFrame2.getContentPane().add(board);
       myMouseJFrame2.setSize(1200, 1200);
       myMouseJFrame2.setVisible(true);
       myMouseJFrame2.setTitle("meanGirls");
    }

}