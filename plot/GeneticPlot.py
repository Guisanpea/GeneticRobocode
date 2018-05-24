import csv

import numpy as np
import matplotlib as mpl
import matplotlib.pyplot as plt
import seaborn as sns
np.random.seed(sum(map(ord, "aesthetics")))

speeds = []
distances = []
ranges = []
probabilities = []
fitnesses = []
i = 0


def genesFromFile(filename):
    i = 0
    reader = csv.reader(filename)
    for row in reader:
        speeds.append(int(row["speed"]))
        ranges.append(int(row["range"]))
        distances.append(int(row["distance"]))
        probabilities.append(int(row["probability"]))
        fitnesses.append(int(row["fitness"]))
        i += 1

    return i


def printPlot(i):
    axis = list(range(i))

    plt.subplot(211)
    plt.plot(axis, fitnesses)

    plt.subplot(212)
    plt.plot(distances)
    plt.plot(speeds)
    plt.plot(ranges)
    plt.plot(probabilities)


if __name__ == '__main__':
    sns.set()
    i = genesFromFile("nombre")
    printPlot(i)