public class Population {

    int popSize;
    private double growthCoEfficient;
    private double reductionCoEfficient;
    private String species; //eg. Tiger, Sheep, Poop.

    public Population(int popSize, double growthCoEfficient, double reductionCoEfficient, String species) {
        this.popSize = popSize;
        this.growthCoEfficient = growthCoEfficient;
        this.reductionCoEfficient = reductionCoEfficient;
        this.species = species;
    }
}
