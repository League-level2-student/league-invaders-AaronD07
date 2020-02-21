import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Font titleFont;
	Timer frameDraw;
	Timer alienSpawn;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	final int MENU = 0;
	Rocketship ship = new Rocketship(250, 700, 50, 50, 10);
	final int GAME = 1;
	ObjectManager manager = new ObjectManager(ship);
	final int END = 2;
	int currentState = MENU;

	public GamePanel() {
		if (needImage) {
			loadImage("space.png");
		}
		titleFont = new Font("Arial", Font.PLAIN, 48);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
			
			
		} else if (currentState == END) {
			drawEndState(g);
		}
	}



	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 0, 50);

		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to Start", 0, 400);

		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press START for instructions", 0, 600);
	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
			manager.draw(g);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("LEAGUE INVADERS", 0, 50);

		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("You killed " + " enemies", 0, 400);

		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to start", 0, 600);
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();

		} else if (currentState == GAME) {
			
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
	
		}
		System.out.println("action");
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
				if (currentState == GAME) {
					startGame();
					
				}
				if (currentState == END) {
					endGame();
				}
			
			}
		}
		
			
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");
			if (ship.y >= 5) {
				ship.up();
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");

			if (ship.y <= 750) {
				ship.down();
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			if (ship.x >= 5) {
				ship.left();

			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			if (ship.x <= 450) {

				ship.right();

			}

		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			newProjectile();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void startGame() {
		alienSpawn = new Timer(1000, manager);
		alienSpawn.start();
	}

	public void endGame() {
		alienSpawn.stop();
	}
	public void newProjectile() {
		if (currentState == GAME) {
			manager.addProjectile(ship.getProjectile());
			System.out.println();
		}
	}

}
