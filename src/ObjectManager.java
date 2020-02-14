import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectile = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;

	}

	public void addProjectile(Projectile projectile) {
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

	}

	public void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}

		for (int t = 0; t < projectile.size(); t++) {
			projectile.get(t).draw(g);
		}
	}

	public void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		
		}
		for (int t = 0; t < projectile.size(); t++) {
			if (projectile.get(t).isActive == false) {
				projectile.remove(t);
			}
		
		}
	}
}
