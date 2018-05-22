import numpy as np
import matplotlib as mpl
import matplotlib.pyplot as plt
import seaborn as sns
np.random.seed(sum(map(ord, "aesthetics")))


def genesFromFile(filename):
    


def sinplot(flip=1):
    genes = genesFromFile()
    for i in range(1, 7):
        plt.plot(x, np.sin(x + i * .5) * (7 - i) * flip)
    plt.savefig("data.png")

if __name__ == '__main__':
    sns.set()
    sinplot()