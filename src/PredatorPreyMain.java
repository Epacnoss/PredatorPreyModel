import java.util.ArrayList;

public class PredatorPreyMain {

    public static void main (String[] args)
    {
        //region init
        Population rabbitsPrey = new Population(2000, (7.0 / 8.0), (1.0 / 10000.0), "Rabbit");
//        Population redditorsPrey = new Population(14, 0.000001, 0.9, "reddit.com/r/teenagers", "Can't breed cos none of us have gfs, reduce fast cos we're depressed and suicidal. We can kill rabbits though");
        Population tigerPred = new Population(20, 0.3, (1.0 / 1000.0), "Lion", "Likes eating small rabbits.");
//        Population sPred = new Population(10000, 0.9, 0.1, "S.. Predator", "Oof. Aah. Hi Jim.");


//        Population pred = tigerPred;
//        Population prey = rabbitsPrey;
        //endregion

        //Sim s = new Sim(pred, prey);

        //s.run(10);

        Sim s = new Sim(tigerPred, rabbitsPrey);
        GUI g = new GUI(600, 600, s);
    }
}
