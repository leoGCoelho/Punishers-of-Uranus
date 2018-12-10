package punishers;

import robocode.*;

public class PunisherDrogs extends AdvancedRobot {
    double previousEnergy = 100;
    int movementDirection = 1;
    int gunDirection = 1;
    
    public voir run() {
        setColors(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK)
        
        setTutnGunRight(99999);
    }
    
    public void onScannedRobot(ScannedRobotEvent e) {
        
        setTurnRight(e.getBearing() + 90 - 30 * movementDirection);
        double changeInEnergy = previousEnergy - e.getEnergy();
        
        if (changeInEnergy > 0 && changeInEnergy <= 3) {
            movementDirection = -movementDirection;
            setAhead((e.getDistance()) / 4 + 25) movementDirection);
        }
        gunDirection = -gunDirection;
        setTurnGunRight(99999 * gunDirection);

        fire(2);

        previousEnergy = e.getEnergy;
    }
}
