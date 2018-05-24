package Robot;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.DoubleGene;

public class LaunchBattle {

	private static final int MAX_EVOLUTIONS = 150;

	public static void main(String[] args) throws InvalidConfigurationException {
        
        Configuration config = new DefaultConfiguration();
    	
    	FitnessFunction myFunc = new MyFitnessFunction();
    	config.setFitnessFunction(myFunc);
    	
    	Genes myGenes = new Genes();
    	myGenes.crearCromosoma();
    	
    	myGenes.distanceToBeClose(0, 905);
    	myGenes.changeSpeedProbability(0, 1);
    	myGenes.rangeOfSpeeds(0, 8);
    	myGenes.minimumSpeed(0, 8);
    	
    	config.setSampleChromosome(myGenes.cromogibre);
    	
    	config.setPopulationSize(12);
    	
    	Genotype Population=Genotype.randomInitialGenotype(config);
    	
    	for (int i = 0; i < MAX_EVOLUTIONS; i++) {
    		System.out.println(i + ";");
    		System.out.println(Population.toString());
    		Population.evolve();
    		System.out.println(Population.getFittestChromosome().toString());
    	}
    	
	}
	
}
