import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
public class GamePanel extends JPanel{ 
	Font titleFont;
	 final int MENU = 0;
	    final int GAME = 1;
	    final int END = 2;
	    int currentState = MENU;
	    public GamePanel() {
	    	  titleFont = new Font("Arial", Font.PLAIN, 48);
	    }
		@Override
		public void paintComponent(Graphics g){
			if(currentState == MENU){
			    drawMenuState(g);
			}else if(currentState == GAME){
			    drawGameState(g);
			}else if(currentState == END){
			    drawEndState(g);
			}
		}
		void updateMenuState() { 
			
		}
		 void updateGameState() { 
			 
		 }
		 void updateEndState()  { 
			 
		 }
		 void drawMenuState(Graphics g) {  
			 g.setColor(Color.BLUE);
			 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			 g.setFont(titleFont);
			 g.setColor(Color.YELLOW);
			 g.drawString("League Invaders", 50, 100);
			 
			 g.setFont(titleFont);
			 g.setColor(Color.YELLOW);
			 g.drawString("Press ENTER to Start", 50, 400);
			 
			 g.setFont(titleFont);
			 g.setColor(Color.YELLOW);
			 g.drawString("Press START for instructions", 50, 600);
		 }
		 void drawGameState(Graphics g) {
			 g.setColor(Color.BLACK);
			 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 }
		 void drawEndState(Graphics g)  { 
			 g.setColor(Color.RED);
			 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 }
		
	
}


