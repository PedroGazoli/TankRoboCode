package gebra;
import robocode.*;
import robocode.util.*;

public class Gebra extends AdvancedRobot {
	private int turnCounter;
	
	public void run() {
	
		setBodyColor(Color.orange);
		setGunColor(Color.orange);
		setRadarColor(Color.red);
		setBulletColor(Color.gray);
		setScanColor(Color.gray);
		
		turnCounter = 0;
		setGunRotationRate(15);
		
		while (true) {
			if (turnCounter % 64 == 0) {
				setTurnRate(0);
				setVelocityRate(4);
			}
			if (turnCounter % 64 == 32) {
				setVelocityRate(-6);
			}
			turnCounter++;
			execute();
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
	}

	public void onHitByBullet(HitByBulletEvent e) {
		setTurnRate(5);
	}
	
	public void onHitWall(HitWallEvent e) {
		setVelocityRate(-1 * getVelocityRate());
	}
}
