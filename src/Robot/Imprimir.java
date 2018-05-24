package Robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.jgap.InvalidConfigurationException;

public class Imprimir {

	Genes getCurrentGenes(String filename) throws InvalidConfigurationException, FileNotFoundException {

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

