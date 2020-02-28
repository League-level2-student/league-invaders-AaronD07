import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	int score = 0;

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;

	}

	public void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	public void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	public void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			
			if (LeagueInvaders.HEIGHT < aliens.get(i).y) {
				aliens.get(i).isActive = false;
			}
			
		}
		for(int i = 0; i<projectiles.size(); i++) {
			projectiles.get(i).update();
		
			
		}
		rocket.update();
		
		checkCollision();
purgeObjects();
	}

	public void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}

		for (int t = 0; t < projectiles.size(); t++) {
			projectiles.get(t).draw(g);
		}
	}

	public void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		
		}
		for (int t = 0; t < projectiles.size(); t++) {
			if (projectiles.get(t).isActive == false) {
				projectiles.remove(t);
			}
		
		}
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
	public void checkCollision() {
		for(int i=0; i<aliens.size(); i++) {
			if (rocket.collisionBox.intersects(aliens.get(i).collisionBox)) {
				rocket.isActive=false;
			}
		
			for(int o=0; o<projectiles.size(); o++) {
				if (aliens.get(i).collisionBox.intersects(projectiles.get(o).collisionBox)) {
					aliens.get(i).isActive=false;
					score =score+1;
				}
			}
		}
				
			}
	public int getScore() {
		return score;
	}
		
	}
	

