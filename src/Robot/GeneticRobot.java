package Robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import robocode.Robot;

public interface GeneticRobot {
	void run();

	Genes getCurrentGenes(String filename);

<<<<<<< Updated upstream
    Genes getCurrentGenes(String filename);
=======
	static void printGenes(String filename, Genes genes) throws FileNotFoundException {
		PrintWriter printGenes = new PrintWriter(new File(filename));
		printGenes.println(genes.getJengibreDistance());
		printGenes.println(genes.getJengibreSpeedProbability());
		printGenes.println( genes.getJengibreSpeedRange());
		printGenes.println(genes.getJengibreLento());

	}

	Genes applyFitnessFunction(double lifeLeft, int victories, double timeSpent);
>>>>>>> Stashed changes
}
