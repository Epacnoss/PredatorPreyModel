public class Sim {

    private Population predators;
    private Population prey;

    public Sim(Population predators, Population prey) {
        this.predators = predators;
        this.prey = prey;
    }

    public void run (int steps)
    {
        for (int i = 0; i < steps; i++)
        {
            System.out.println("Redditors UNITE!!!");
        }
    }
}
