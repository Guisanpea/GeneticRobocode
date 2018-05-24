package Robot;

import org.jgap.*;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.DoubleGene;

public class LaunchBattle {

	private static final int MAX_EVOLUTIONS = 150;

	public static void main(String[] args) throws InvalidConfigurationException {
        
        Configuration config = new DefaultConfiguration();
    	
    	FitnessFunction myFunc = new MyFitnessFunction();
    	config.setFitnessFunction(myFunc);
    	
    	Genes myGenes = new Genes();
    	myGenes.crearGenotipo();
    	
    	myGenes.distanceToBeClose(0, 905);
    	myGenes.changeSpeedProbability(0, 1);
    	myGenes.rangeOfSpeeds(0, 8);
    	myGenes.minimumSpeed(0, 8);
    	
	}
	
}
