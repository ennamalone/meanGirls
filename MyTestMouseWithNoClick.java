
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
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
          g.drawOval(200,1000,10,10);
          g.drawOval(212,1000,10,10);
          g.drawOval(224,1000,10,10);
          g.setColor(Color.RED);
          g.fillOval(200,1000,10,10);
          g.setColor(Color.GREEN);
          g.fillOval(212,1000,10,10);
          g.setColor(Color.BLUE);
          g.fillOval(224,1000,10,10);
        }
   }

// the methods required by the MouseListener interface.
// Look up the MouseEvent class to see what the input to
// these methods is.  The getX and getY methods return to
// us the location of the mouseClick that generated the event.

   //public void mouseClicked(MouseEvent e)
   //{
     //show = false;    
  // }

   //public void mouseEntered(MouseEvent e){
   //}

   //public void mouseExited(MouseEvent e){
   //}

  // public void mousePressed(MouseEvent e)
  // {
    	 // int xLocation = e.getX();
	     // int yLocation = e.getY();
	    //  show = true;
	    //  circleXcenter = xLocation-circleRadius;
	  //    circleYcenter = yLocation-circleRadius;
	//      repaint();
  // }

  // public void mouseReleased(MouseEvent e){
  // }
   
 //  public void mouseMoved(MouseEvent e)
   //{
	 //  	  int xLocation = e.getX();
	   //   int yLocation = e.getY();
	     // show = true;
	     // circleXcenter = xLocation-circleRadius;
	      //circleYcenter = yLocation-circleRadius;
	      //repaint();
	   
  // }
   
   public void mouseDragged(MouseEvent e)
   {
	   
   }

@Override
public void mouseMoved(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

}



//  This class actually creates one of those MouseJFrame objects
// and sets its initial size and makes it visible (all using
// methods that the MouseJFrame class inherits from JFrame+-9

public class MyTestMouseWithNoClick{

    public static void main(String[] a){
       MouseJFrameq  myMouseJFrame2 = new MouseJFrameq ();
       myMouseJFrame2.setSize(1200, 1200);
       myMouseJFrame2.setVisible(true);
       myMouseJFrame2.setTitle("meanGirls");
    }

}
