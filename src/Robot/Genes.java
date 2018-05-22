package Robot;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.DoubleGene; //La funcion DoubleGene usa tres parametros: configuracion(que se asigna a traves de una llamada), limite inferior, limite superior;

public class Genes{

	private Configuration conf = new DefaultConfiguration();
	private Gene[] jengibre = new Gene[4];
	private Chromosome cromogibre;

	public void distanceToBeClose(double lowerBound, double upperBound) throws InvalidConfigurationException{
		jengibre[0] = new DoubleGene(conf, lowerBound, upperBound); //double the default close distance
	}
	
	public void changeSpeedProbability(double lowerBound, double upperBound) throws InvalidConfigurationException{
		jengibre[1] = new DoubleGene(conf, lowerBound, upperBound); //10% chance
	}
	
	public void rangeOfSpeeds(double lowerBound, double upperBound) throws InvalidConfigurationException {
		jengibre[2] = new DoubleGene(conf, lowerBound, upperBound); //triple the default
	}
	
	public void minimumSpeed(double lowerBound, double upperBound) throws InvalidConfigurationException {
		jengibre[3] = new DoubleGene(conf, lowerBound, upperBound);//minimum range of speed, still using default
	}

	public void crearCromosoma() {
		try {

			cromogibre = new Chromosome(conf, jengibre);

		}catch(InvalidConfigurationException e) {

			e.getStackTrace();
		}
	}
	
	public double getJengibreDistance() {
		
		return (Gene) jengibre[0].getAllele();
	}
	
	public double getJengibreSpeedProbability() {

		return (Gene) jengibre[1].getAllele();
	}

	public int getJengibreSpeedRange() {

		return (Gene) jengibre[2].getAllele();
	}

	public double getJengibreLento() {

		return (Gene) jengibre[3].getAllele();
	}
	
	public Chromosome getCromogibre() {
		return this.cromogibre;
	}
	
	
}
