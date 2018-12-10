package punisher;
import robocode.*;
import java.util.Random;


import java.awt.*;

public class PunisherRandom extends AdvancedRobot
{
	
	double velocity, velocity2;
	int randomizer;
	boolean stop;

	public void run() {
		
		stop = false;
		velocity = 15;
		velocity2 = 5;
		randomizer = 0;

		// Set colors
		setBodyColor(new Color(0, 0, 0));
		setGunColor(new Color(0, 0, 255));
		setRadarColor(new Color(0, 0, 0));
		setBulletColor(new Color(0, 0, 255));
		setScanColor(new Color(0, 0, 0));



		
		while(true) {
			switch (randomizer){
				case 0:
						setAhead(velocity);
						setTurnRight(velocity);
						setTurnGunRight(velocity2);
						if(stop)
							break;
						execute();
						break;
				case 1:
						setAhead(velocity);
						setTurnLeft(velocity);
						setTurnGunLeft(velocity2);
						if(stop)
							break;
						execute();
						break;
				case 2:
						setAhead(velocity);
						setTurnGunRight(velocity2);
						if(stop)
							break;
						execute();
						break;
				default:
						randomizer = 0;
						stop = false;
						break;
			}
		}
	}

	c void onScannedRobot(ScannedRobotEvent e) {
		if(!(e.getName().contains("Punisher")))
			fire(100);
		stop = true;
		randomizer = 3;
	}

	
	public void onHitByBullet(HitByBulletEvent e) {
		switch (randomizer){
			case 0:
				randomizer = 1;
				break;
			case 1:
				randomizer = 2;
				break;
			default:
				randomizer = 0;
				break;
		}
	}

	public void onHitWall(HitWallEvent e) {
		back(50);
		switch (randomizer){
			case 0:
				randomizer = 1;
				break;
			case 1:
				randomizer = 2;
				break;
			default:
				randomizer = 0;
				break;
		}
	}

	public void onHitRobot(HitRobotEvent e) {
		if(!(e.getName().contains("Punisher")))
			fire(1000);
	}
}