import javax.swing.*;

public class Sim {

    private Population predators;
    private Population prey;

    public Sim(Population predators, Population prey) {
        this.predators = predators;
        this.prey = prey;
    }

    public void run (int steps, JTextField output, JTextField predSize, JTextField preySize, JTextField predBox, JTextField preyBox)
    {
        for (int i = 0; i < steps; i++)
        {
            if (prey.getPopSize() <= 0) {
                String dead = "PREY NOW EXTINCT! ON STEP " + (i + 1);
//                gui.setOuput(dead, prey.toString());
                output.setText(null);
                output.setText(dead + "\n" + prey.toString());
                break;
            }
            if (predators.getPopSize() <= 0) {
                String dead = "PREDATORS NOW EXTINCT! ON STEP " + (i + 1);
//                gui.setOuput(dead, predators.toString());
                output.setText(null);
                output.setText(dead + "\n" + predators.toString());
                break;
            }

            int preyChange = ((int) calcPreyChange());
            int predChange = ((int) calcPredChange());

            predators.addToPop(predChange);
            prey.addToPop(preyChange);

            String preyTxt = pp(prey.getSpecies()) + " population: " + prey.getPopSize() + ", changed by: " + preyChange + ".";
            String predTxt = pp(predators.getSpecies()) + " population: " + predators.getPopSize() + ", changed by: " + predChange + ".";
            String endTxt = "--------------------------------------- END OF STEP " + (i + 1)+ " ---------------------------------------";

//            gui.setOuput(preyTxt, predTxt, endTxt);
//            gui.setPredSize(predators.getPopSize());
//            gui.setPreySize(prey.getPopSize());

            output.setText(null);
            predSize.setText(null);
            preySize.setText(null);
            predBox.setText(null);
            preyBox.setText(null);
            output.setText(endTxt);
            predBox.setText(predTxt);
            preyBox.setText(preyTxt);
            predSize.setText(predators.getPopSize() + "");
            preySize.setText(prey.getPopSize() + "");

        }


        System.out.println(predators.getPopSize() + " is the " + pp(predators.getSpecies()) + " Population Size");
        System.out.println(prey.getPopSize() + " is the " + pp(prey.getSpecies()) + " Population Size");

    }

    private double calcPreyChange ()
    {
        double preyMult = prey.getGrowthCoEfficient() -
                (prey.getReductionCoEfficient() * predators.getPopSize());
        double newSize = Math.round(prey.getPopSize() * preyMult);
        return newSize;
    }

    private double calcPredChange ()
    {
        double predMult = (predators.getGrowthCoEfficient() * predators.getPopSize()) -
                predators.getReductionCoEfficient();
        double newSize = Math.round(predators.getPopSize() * predMult);
        return newSize;
    }

    private String pp (String str) // Pretty Printer
    {
        char[] chs = str.toCharArray();
        String strFinal = "";
        for (int i = 0; i < chs.length; i++) {
            String s = chs[i] + "";
            if(i == 0)
                s = s.toUpperCase();
            else
                s = s.toLowerCase();
            strFinal += s;
        }

        return strFinal;
    }

    public void setPred (Population p)
    {
        predators = p;
    }
    public void setPrey (Population p)
    {
        prey = p;
    }
}
