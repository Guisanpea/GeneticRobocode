package Robot;

mport java.io.PrintWriter;

import org.jgap.Chromosome;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.DoubleGene;

import java.io.PrintWriter;

public class Genes{



		final int EVOLVING_LAPSES = 10;

		org.jgap.Configuration conf = new DefaultConfiguration();
		//Insertar configuraciones fitness function
		Gene[] jengibre = new Gene[4];
		jengibre[0] = new DoubleGene(conf,0.0,300.0);
		jengibre[1] = new DoubleGene(conf,0.0,1.0);
		jengibre[2] = new DoubleGene(conf,0.0,30.0);
		jengibre[3] = new DoubleGene(conf,0.0,30.0);
		Chromosome chromojibre = new Chromosome(conf, jengibre);

		conf

		Genotype population = Genotype.randomInitialGenotype(conf);

		IChromosome bestChromojibre;
		//La puntuacion, recogedla
		PrintWriter pwChromojibre = new PrintWriter("chromosome.txt");
		for(int i = 0; i < EVOLVING_LAPSES; i++){
			System.out.println("Generation number " + i);

			population.evolve();
			bestChromojibre = population.getFittestChromosome();

			//puntuacion -> bestChromojibre.getFitnessValue(); algo asi para obtener los datos de la funcion fitness
			System.out.println("Points: " + //puntuacion);
			pwChromojibre.println(//puntuacion.toString());

			System.out.println("Close distance: " + bestChromojibre.getGene(0));
			pwChromojibre.println(bestChromojibre.getGene(0).toString());

			System.out.println("Change of speed probability: " + bestChromojibre.getGene(1));
			pwChromojibre.println(bestChromojibre.getGene(1).toString());

			System.out.println("Speeds range: " + bestChromojibre.getGene(2));
			pwChromojibre.println(bestChromojibre.getGene(2).toString());

			System.out.println("Minimum speed: " +bestChromojibre.getGene(3));
			pwChromojibre.println(bestChromojibre.getGene(3).toString());

			System.out.println("-----------------------");
		}

		pwChromogibre.close();
	}

//La clase seria algo asi









	/**
	protected Configuration conf = new DefaultConfiguration();
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

	public void crearGenotipo() throws FileNotFoundException {
		try {

			cromogibre = new Chromosome(conf, jengibre);
			conf.setPreservFittestIndividual(true);
			conf.setSampleChromosome(cromogibre);
			conf.setPopulationSize(POP_SIZE); //One single robot

			Genotype popRobot = Genotype.randomInitialGenotype(conf);
			PrintWriter printData = new PrintWriter(new File("genes.txt"));

			for(int i=0; i<EVOLVING_LAPSE; i++) {
				printData.println(popRobot.getPopulation().getGenome(true));
				System.out.println(i + ";");
				System.out.println(popRobot.toString());
				popRobot.evolve();
				System.out.println(popRobot.getFittestChromosome().toString());
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

		return (Integer) jengibre[2].getAllele();
	}

	public double getJengibreLento() {

		return (Double) jengibre[3].getAllele();
	}

	public Chromosome getCromogibre() {
		return this.cromogibre;
	}


}
**/