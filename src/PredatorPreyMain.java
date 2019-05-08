public class PredatorPreyMain {

    public static void main (String[] args)
    {
        Population prey = new Population(200, 0.8, 0.6, "Rabbit.");
        Population predator = new Population(60, 0.1, 0.09, "reddit.com/r/teenagers", "Can't breed cos none of us have gfs, reduce fast cos we're depressed and suicidal. We can kill rabbits though");
        PredatorPreyModelEquation equation = new PredatorPreyModelEquation(prey, predator);

        System.out.println(equation.getPred());
        System.out.println(equation.getPrey());
    }
}
