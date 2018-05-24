package Robot;

import robocode.Robot;

public interface GeneticRobot {
    void run();

    Genes getCurrentGenes(String filename);
}
