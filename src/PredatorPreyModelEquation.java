public class PredatorPreyModelEquation {

    private Population prey;
    private Population predator;

    public PredatorPreyModelEquation(Population prey, Population predator) {
        this.prey = prey;
        this.predator = predator;
    }


    public String getPrey ()
    {
        return prey.toString() + " IS THE PREDATOR";
    }

    public String getPred ()
    {
        return predator.toString() + " IS THE PREY";
    }


}
