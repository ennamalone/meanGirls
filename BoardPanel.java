// Énna Malone 15357146
// Cian Kelly 15386256
// Brian Finlay 15381151 

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

class BoardPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 750;    // must be even
	private static final int FRAME_HEIGHT = 700;
	private static final int TOKEN_RADIUS = 8;   // must be even
	private static final Color[] PLAYER_COLORS = {Color.RED,Color.BLUE,Color.YELLOW,Color.GREEN,Color.MAGENTA,Color.WHITE};
	private static final String[] TOKEN_NAME = {"red","blue","yellow","green","magenta","white"};
	private static final float[] PLAYER_OFFSET = {0, 0.01f, 0.02f, 0.03f, 0.04f, 0.05f};
	private static final float[][] CORNER_FROM = { {710, 730}, {5, 700}, {40,5}, {730, 40},};
	private static final float[][] CORNER_TO = {{60, 730}, {5, 70}, {700,5}, {730, 700}};
	
	private ArrayList<Player> players;	
	private BufferedImage boardImage;
	private int[][][] squareCoords = new int [Board.NUM_SQUARES][Monopoly.MAX_NUM_PLAYERS][2];
	
	BoardPanel (ArrayList<Player> players) {
		this.players = players;
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setBackground(Color.WHITE);
		try {
			boardImage = ImageIO.read(new File("src//board.jpg"));
		} catch (IOException ex) {
			System.out.println("Could not find the image file " + ex.toString());
		}
		int sideLength = Board.NUM_SQUARES/4;
 		for (int s=0; s<Board.NUM_SQUARES; s++) {
			for (int p=0; p<Monopoly.MAX_NUM_PLAYERS; p++) {
		        	int side = (int) s / sideLength;
		        	float offset = (float) (s % sideLength) / sideLength + PLAYER_OFFSET[p];
		        	squareCoords[s][p][0] = Math.round(CORNER_FROM[side][0] + offset * (CORNER_TO[side][0] - CORNER_FROM[side][0]));
		        	squareCoords[s][p][1] = Math.round(CORNER_FROM[side][1] + offset * (CORNER_TO[side][1] - CORNER_FROM[side][1]));
			}
		}
		return;
	}
	
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(boardImage, 0, 0, FRAME_WIDTH, FRAME_HEIGHT, this);
        for (int p=0; p<players.size(); p++) {
	        int square = players.get(p).getPosition();
	        g2.setColor(Color.BLACK);
            Ellipse2D.Double outline = new Ellipse2D.Double(squareCoords[square][p][0],squareCoords[square][p][1],2*TOKEN_RADIUS,2*TOKEN_RADIUS);
            g2.fill(outline);
            Ellipse2D.Double ellipse = new Ellipse2D.Double(squareCoords[square][p][0]+1,squareCoords[square][p][1]+1,2*TOKEN_RADIUS-2,2*TOKEN_RADIUS-2);
            g2.setColor(PLAYER_COLORS[p]);
            g2.fill(ellipse);
        }
		return;
    }
    
    public void refresh () {
		revalidate();
		repaint();
		return;
    }
    
    public String getTokenName (int tokenId) {
    	return TOKEN_NAME[tokenId];
    }
    
}