package Robot;

import robocode.*;
import robocode.Robot;
import robocode.util.Utils;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import org.jgap.InvalidConfigurationException;

public class GeneticSuperTracker extends AdvancedRobot implements GeneticRobot {

    Genes currentGenes;
    int moveDirection=1;
    Random velocityRandom;

    @Override
    public void run() {
        try {
            currentGenes = getCurrentGenes("genes.txt");

            velocityRandom = new Random();
            setAdjustRadarForRobotTurn(true);//keep the radar still while we turn
            setBodyColor(new Color(128, 128, 50));
            setGunColor(new Color(50, 50, 20));
            setRadarColor(new Color(200, 200, 70));
            setScanColor(Color.white);
            setBulletColor(Color.blue);
            setAdjustGunForRobotTurn(true); // Keep the gun still when we turn
            turnRadarRightRadians(Double.POSITIVE_INFINITY);//keep turning radar right
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        double absBearing = e.getBearingRadians() + getHeadingRadians();//enemies absolute bearing
        double latVel = e.getVelocity() * Math.sin(e.getHeadingRadians() - absBearing);//enemies later velocity
        setTurnRadarLeftRadians(getRadarTurnRemainingRadians());//lock on the radar

        changeSpeedRandomly();

        if (e.getDistance() > currentGenes.getJengibreDistance()) {//if distance is greater than 150
            distanceFire(e, absBearing, latVel);
        } else {//if we are close enough...
            closeFire(e, absBearing, latVel);
        }
    }

    private void changeSpeedRandomly() {
        if (Math.random() < currentGenes.getJengibreSpeedProbability()) {
            changeSpeed();
        }
    }

    private void changeSpeed() {
        int randomInRange = velocityRandom.nextInt(currentGenes.getJengibreSpeedRange());
        double speedPartition = Rules.MAX_VELOCITY / currentGenes.getJengibreSpeedRange();

        double nextSpeed = randomInRange * speedPartition + currentGenes.getJengibreLento();
        setMaxVelocity(nextSpeed);//randomly change speed
    }

    private void closeFire(ScannedRobotEvent e, double absBearing, double latVel) {
        double gunAngleToNormalize = absBearing - getGunHeadingRadians() + latVel / 15;
        double gunTurnAngle = Utils.normalRelativeAngle(gunAngleToNormalize);//amount to turn our gun, lead just a little bit
        setTurnGunRightRadians(gunTurnAngle);//turn our gun
        setTurnLeft(-90 - e.getBearing()); //turn perpendicular to the enemy
        setAhead((e.getDistance() - 140) * moveDirection);//move forward
        setFire(3);//fire
    }

    private void distanceFire(ScannedRobotEvent e, double absBearing, double latVel) {
        double gunAngleToNormalize = absBearing - getGunHeadingRadians() + latVel / 22;
        double gunTurnAngle = Utils.normalRelativeAngle(gunAngleToNormalize);//amount to turn our gun, lead just a little bit

        double turnAngleToNormalize = absBearing - getHeadingRadians() + latVel / getVelocity();
        double turnRightAngle = Utils.normalRelativeAngle(turnAngleToNormalize);

        setTurnGunRightRadians(gunTurnAngle); //turn our gun
        setTurnRightRadians(turnRightAngle);//drive towards the enemies predicted future location
        setAhead((e.getDistance() - 140) * moveDirection);//move forward
        setFire(3);//fire
    }


    public void onHitWall(HitWallEvent e){
		moveDirection=-moveDirection;//reverse direction upon hitting a wall
	}

	/**
	 * onWin:  Do a victory dance
	 */
	public void onWin(WinEvent e) {
		for (int i = 0; i < 50; i++) {
			turnRight(30);
			turnLeft(30);
		}
	}

    @Override
	public Genes getCurrentGenes(String filename) throws InvalidConfigurationException, FileNotFoundException {

		Genes genio = new Genes();
		Scanner sc = new Scanner(new File(filename));

		Scanner sc2 = new Scanner(sc.nextLine());
		genio.distanceToBeClose(sc2.nextDouble(), sc2.nextDouble());

		sc2.close();
		sc2 = new Scanner(sc.nextLine());
		genio.changeSpeedProbability(sc2.nextDouble(), sc2.nextDouble());

		sc2.close();
		sc2 = new Scanner(sc.nextLine());
		genio.rangeOfSpeeds(sc2.nextInt(), sc2.nextInt());

		sc2.close();
		sc2 = new Scanner(sc.nextLine());
		genio.minimumSpeed(sc2.nextDouble(), sc2.nextDouble());

		genio.crearGenotipo();

		sc2.close();
		sc.close();

		return genio;

	}
}
