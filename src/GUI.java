import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JFrame frame;
    private JTextField preySize, preyIncrease, preyDecrease, preyName, preyNotes, preyTitle;
    private JTextField predSize, predIncrease, predDecrease, predName, predNotes, predTitle;
    private JTextField ouputGeneral, preyOutput, predOutput;
    private JButton go;
    private JPanel panel, bottomPanel;
    private Dimension buttonOutputSize;

    public GUI (int w, int h, Sim s)
    {
        //region Init

        frame = new JFrame("Predator Prey Model - Lokta-Volterra Equations");
        frame.setPreferredSize(new Dimension(w, h));
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        go = new JButton("Go!!");

        ouputGeneral = new JTextField("OUTPUT");
        ouputGeneral.setEditable(false);
        preyOutput = new JTextField("OUTPUT");
        preyOutput.setEditable(false);
        predOutput = new JTextField("OUTPUT");
        predOutput.setEditable(false);

        preyTitle = new JTextField("PREY DATA");
        preyTitle.setEditable(false);
        preySize = new JTextField("2000");
        preySize.setToolTipText("Prey Inital Size");
        preyIncrease = new JTextField("0.125");
        preyIncrease.setToolTipText("Prey increase coefficient");
        preyDecrease = new JTextField("0.0001");
        preyDecrease.setToolTipText("Prey decrease coefficient");
        preyName = new JTextField("Rabbit");
        preyName.setToolTipText("Name");
        preyNotes = new JTextField("Likes Grass and dandileons, la la la la la.");
        preyNotes.setToolTipText("Notes");

        predTitle = new JTextField("PREDATOR DATA");
        predTitle.setEditable(false);
        predSize = new JTextField("100");
        predSize.setToolTipText("Predator Inital Size");
        predIncrease = new JTextField("0.125");
        predIncrease.setToolTipText("Predator increase coefficient");
        predDecrease = new JTextField("0.0001");
        predDecrease.setToolTipText("Predator decrease coefficient");
        predName = new JTextField("Lion");
        predName.setToolTipText("Name");
        predNotes = new JTextField("RA RA RA. I am de king of de jungle.");
        predNotes.setToolTipText("Notes");
        //endregion

        //region add / JFrame BP
        panel.add(preyTitle);
        panel.add(predTitle);
        panel.add(preySize);
        panel.add(predSize);
        panel.add(preyIncrease);
        panel.add(predIncrease);
        panel.add(preyDecrease);
        panel.add(predDecrease);
        panel.add(preyName);
        panel.add(predName);
        panel.add(preyNotes);
        panel.add(predNotes);

        bottomPanel.add(preyOutput, BorderLayout.NORTH);
        bottomPanel.add(predOutput, BorderLayout.CENTER);
        bottomPanel.add(ouputGeneral, BorderLayout.SOUTH);

        frame.add(go, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //endregion

        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.setPred(getPred());
                s.setPrey(getPrey());

                s.run(1, ouputGeneral, predSize, preySize, predOutput, preyOutput);
            }
        });
    }

    public int tryInt (String s)
    {
        try {
            int i = Integer.parseInt(s);
            return i;
        } catch (NumberFormatException e) {
            return 1;
        }
    }
    public double tryDouble (String s)
    {
        try {
            double d = Double.parseDouble(s);
            return d;
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    public Population getPrey ()
    {
        Population prey = new Population(tryInt(preySize.getText()), tryDouble(preyIncrease.getText()), tryDouble(preyDecrease.getText()), preyName.getText(), preyNotes.getText());
        return prey;
    }
    public Population getPred ()
    {
        Population pred = new Population(tryInt(predSize.getText()), tryDouble(predIncrease.getText()), tryDouble(predDecrease.getText()), predName.getText(), predNotes.getText());
        return pred;
    }


}
