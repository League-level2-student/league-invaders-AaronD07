import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
Rocketship rocket;
ArrayList <Projectile> projectile = new ArrayList <Projectile>();
ArrayList <Alien> aliens = new ArrayList <Alien>();
Random random = new Random();
public ObjectManager(Rocketship rocket) {
	this.rocket=rocket;
	
}
public void addProjectile(Projectile projectile) {
}
public void addAlien() {
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}

public void update() {
	for(int i=0; i<aliens.size(); i++) {
		aliens.get(i).update();
		}
	LeagueInvaders.HEIGHT=20;
}

}
