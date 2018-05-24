package Robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.jgap.InvalidConfigurationException;

import robocode.Robot;

public interface GeneticRobot {
	void run();

	Genes getCurrentGenes(String filename) throws InvalidConfigurationException, FileNotFoundException;

