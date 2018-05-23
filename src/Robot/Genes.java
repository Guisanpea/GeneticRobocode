package Robot;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.DoubleGene; //La funcion DoubleGene usa tres parametros: configuracion(que se asigna a traves de una llamada), limite inferior, limite superior;
import org.jgap.impl.IntegerGene;

public class Genes{

	private Configuration conf = new DefaultConfiguration();
	protected Gene[] jengibre = new Gene[4];
	protected Chromosome cromogibre;
	private static final int POP_SIZE = 1;
	private static final int EVOLVING_LAPSE = 120;

	public void distanceToBeClose(double lowerBound, double upperBound) throws InvalidConfigurationException{
		jengibre[0] = new DoubleGene(conf, lowerBound, upperBound); //double the default close distance
	}

	public void changeSpeedProbability(double lowerBound, double upperBound) throws InvalidConfigurationException{
		jengibre[1] = new DoubleGene(conf, lowerBound, upperBound); //10% chance
	}

	public void rangeOfSpeeds(Integer lowerBound, Integer upperBound) throws InvalidConfigurationException {
		jengibre[2] = new IntegerGene(conf, lowerBound, upperBound); //triple the default
	}

	public void minimumSpeed(double lowerBound, double upperBound) throws InvalidConfigurationException {
		jengibre[3] = new DoubleGene(conf, lowerBound, upperBound);//minimum range of speed, still using default
	}

	public void crearGenotipo() {
		try {

			cromogibre = new Chromosome(conf, jengibre);
			conf.setPreservFittestIndividual(true);
			conf.setSampleChromosome(cromogibre);
			conf.setPopulationSize(POP_SIZE); //One single robot

			Genotype popRobot = Genotype.randomInitialGenotype(conf);
			
			for(int i=0; i<EVOLVING_LAPSE; i++) {
				
				popRobot.evolve();
			}

		}catch(InvalidConfigurationException e) {

			e.getStackTrace();
		}
	}

	public double getJengibreDistance() {

		return (Double) jengibre[0].getAllele();
	}

	public double getJengibreSpeedProbability() {

		return (Double) jengibre[1].getAllele();
	}

	public Integer getJengibreSpeedRange() {

		return (Double) jengibre[2].getAllele();
	}

	public double getJengibreLento() {

		return (Double) jengibre[3].getAllele();
	}

	public Chromosome getCromogibre() {
		return this.cromogibre;
	}


}
