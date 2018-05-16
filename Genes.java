package Robot;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.DoubleGene; //La funcion DoubleGene usa tres parametros: configuracion(que se asigna a traves de una llamada), limite inferior, limite superior;

public class Genes{
	
	Configuration conf = new DefaultConfiguration();
	Gene[] jengibre = new Gene[4];
	
    public void distanceToBeClose(Gene[] jengibre) throws InvalidConfigurationException{
    	jengibre[0] = new DoubleGene(conf, 0, 300); //double the default close distance
    	
    	
    }
    public void changeSpeedProbability(Gene[] jengibre) throws InvalidConfigurationException{
    	jengibre[1] = new DoubleGene(conf, 0, 1); //10% chance
    	
    }
    public void rangeOfSpeeds(Gene[] jengibre) throws InvalidConfigurationException {
    	jengibre[2] = new DoubleGene(conf, 0, 36); //triple the default
    	
    }
    public void minimumSpeed(Gene[] jengibre) throws InvalidConfigurationException {
    	jengibre[3] = new DoubleGene(conf, 0, 12);//minimum range of speed, still using default
    	
    }
    
    try {
    	
    Chromosome Cromogibre = new Chromosome(conf, jengibre);
    
    }catch(InvalidConfigurationException e) {
    	
    	e.getStackTrace();
    }
    
}