/**
 * Copyright (c) 2001-2018 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/epl-v10.html
 */
package punishers;


import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.*;

public class PunisherStranded extends Robot {

	boolean flag;
	double moving;
	boolean caution;

	/**
	 * run: Move around the walls
	 */
	public void run() {

		caution = false;
		flag = false;
		moving = Math.max(getBattleFieldWidth(), getBattleFieldHeight());

		// Set colors
		setColors(Color.BLACK, Color.GRAY, Color.RED, Color.WHITE, Color.WHITE); //Cores (corpo, arma, radar, tiro, arco do radar)

		turnRight(getHeading() % 90);
		ahead(moving);

		flag = true;
		turnGunLeft(90);
		turnLeft(90);

		while (true) {
				turnGunRight(90);
				turnGunLeft(90);

				flag = true;
				ahead(moving);
				flag = false;
				caution = false;

				turnLeft(90);
		}
	}

	/**
	 * onHitRobot:  Move away a bit.
	 */
	public void onHitRobot(HitRobotEvent evnt) {

		if (evnt.getBearing() > -90 && evnt.getBearing() <= 90)
        back(100);

    else
        ahead(100);
	}

	/**
	 * onScannedRobot:  Fire!
	 */
	public void onScannedRobot(ScannedRobotEvent evnt) {
		if(!(evnt.getName().contains("Punisher")))
				fire(100);

		if (flag) {
				scan();
				caution = true;
		}
	}
}
