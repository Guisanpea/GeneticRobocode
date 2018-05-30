package Robot;

import java.io.FileNotFoundException;

import org.jgap.*;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.DoubleGene;

public class LaunchBattle {

	private static final int MAX_EVOLUTIONS = 150;

	public static void main(String[] args) throws InvalidConfigurationException, FileNotFoundException {
      	FitnessFunction myFunc = new MyFitnessFunction();
       	
    	Genes myGenes = new Genes();
     	myGenes.conf.setFitnessFunction(myFunc);
    	myGenes.distanceToBeClose(0, 905);
    	myGenes.changeSpeedProbability(0, 1);
    	myGenes.rangeOfSpeeds(0, 8);
    	myGenes.minimumSpeed(0, 8);
    	myGenes.crearGenotipo();
    	
	}
	
}
