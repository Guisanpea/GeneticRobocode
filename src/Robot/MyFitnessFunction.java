package Robot;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

import robocode.control.*;
import robocode.control.events.BattleAdaptor;
import robocode.control.events.BattleCompletedEvent;

public class MyFitnessFunction extends FitnessFunction {

	public MyFitnessFunction() {

	}

	protected double evaluate(IChromosome chromo) {

		double fitness = 0;

		PrintWriter pw;

		try {

			String path = "path";
			pw = new PrintWriter(path);
			for (int i = 0; i < chromo.size(); ++i) {
				pw.write(chromo.getGene(i).getAllele().toString() + "");
			}

			fitness = battle(chromo);

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());

		}

		return fitness;

	}

	protected double battle(IChromosome chromo) throws FileNotFoundException {

		RobocodeEngine engine = new RobocodeEngine(new java.io.File("C:/robocode"));

		engine.setVisible(true);

		int NumPixelRows = 64 * 10;
		int NumPixelCols = 64 * 10;
		BattlefieldSpecification battlefield = new BattlefieldSpecification(NumPixelRows, NumPixelCols);

		int numberOfRounds = 5;
		long inactivityTime = 5000;
		double gunCoolingRate = 1.0;
		int sentryBorderSize = 50;
		boolean hideEnemyNames = false;

		RobotSpecification[] modelRobots = engine.getLocalRepository("atl.SuperTracker*,atl.SuperRamFire*");
		RobotSetup[] robotSetups = new RobotSetup[2];
		robotSetups[0] = new RobotSetup(0.0, 0.0, 0.0);
		robotSetups[1] = new RobotSetup(600.0, 500.0, 0.0);

		/* Create and run the battle */
		BattleSpecification battleSpec = new BattleSpecification(battlefield, numberOfRounds, inactivityTime,
				gunCoolingRate, sentryBorderSize, hideEnemyNames, modelRobots,
				robotSetups);
		engine.addBattleListener(new BattleObserver());
		// Run our specified battle and let it run till it is over
		engine.runBattle(battleSpec, true); // waits till the battle finishes
		// Cleanup our RobocodeEngine
		engine.close();

		double finalScore = BattleObserver.score;

		return finalScore;

	}

	static class BattleObserver extends BattleAdaptor {

		public static double score;

		public void onBattleCompleted(BattleCompletedEvent e) {

			score = e.getIndexedResults()[0].getScore();

		}

	}
}
