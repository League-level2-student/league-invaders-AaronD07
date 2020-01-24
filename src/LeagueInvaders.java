import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel gamepanel;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800; 
	
public static void main(String[] args) {
LeagueInvaders invaders = new LeagueInvaders();
invaders.setup();


}
public LeagueInvaders() {
	frame =new JFrame();
	gamepanel=new GamePanel();
}
public void setup() {
	frame.add(gamepanel);
	frame.setVisible(true);
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}
