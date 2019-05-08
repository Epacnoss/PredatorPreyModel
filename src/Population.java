import java.util.StringJoiner;

public class Population {

    int popSize;
    private double growthCoEfficient;
    private double reductionCoEfficient;
    private String species; //eg. Tiger, Sheep, Poop.
    private String notes;

    public Population(int popSize, double growthCoEfficient, double reductionCoEfficient, String species) {
        this.popSize = popSize;
        this.growthCoEfficient = growthCoEfficient;
        this.reductionCoEfficient = reductionCoEfficient;
        this.species = species;
    }

    public Population(int popSize, double growthCoEfficient, double reductionCoEfficient, String species, String extra) {
        this.popSize = popSize;
        this.growthCoEfficient = growthCoEfficient;
        this.reductionCoEfficient = reductionCoEfficient;
        this.species = species;
        notes = extra;
    }

    @Override
    public String toString() {
        if(notes == null)
        {
            return new StringJoiner(", ", Population.class.getSimpleName() + "[", "]")
                    .add("popSize=" + popSize)
                    .add("growthCoEfficient=" + growthCoEfficient)
                    .add("reductionCoEfficient=" + reductionCoEfficient)
                    .add("species='" + species + "'")
                    .toString();
        }else
        {
            return new StringJoiner(", ", Population.class.getSimpleName() + "[", "]")
                    .add("popSize=" + popSize)
                    .add("growthCoEfficient=" + growthCoEfficient)
                    .add("reductionCoEfficient=" + reductionCoEfficient)
                    .add("species='" + species + "'")
                    .add("Exra Stuff... ='" + notes + "'")
                    .toString();
        }
    }

    public double getGrowthCoEfficient() {
        return growthCoEfficient;
    }

    public void setGrowthCoEfficient(double growthCoEfficient) throws NegativeNumEsception
    {
        if(growthCoEfficient < 0)
        {
            this.growthCoEfficient = 0;
            throw new NegativeNumEsception();
        }


        this.growthCoEfficient = growthCoEfficient;
    }

    public double getReductionCoEfficient() {
        return reductionCoEfficient;
    }

    public void setReductionCoEfficient(double reductionCoEfficient) throws NegativeNumEsception
    {
        if(reductionCoEfficient < 0)
        {
            this.reductionCoEfficient = 0;
            throw new NegativeNumEsception();
        }

        this.reductionCoEfficient = reductionCoEfficient;
    }

    public int getPopSize() {
        return popSize;
    }

    public void setPopSize(int popSize) {
        this.popSize = popSize;
    }

    public String getSpecies() {
        return species;
    }
}