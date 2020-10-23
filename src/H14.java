import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class H14 extends Applet {
    double een = - 1;
    double twee;
    int kleur;
    int getal;
    String soort[] = {"Ruiten", "Harten", "Klaver", "Schoppen"};
    String nummers[] = {"Boer", "Koning", "Vrouw", "Aas", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    Button knop;

    public void init() {
        knop = new Button("Deel");
        knop.addActionListener(new Listener());
        add(knop);



    }

    public void paint(Graphics g) {
        setBackground(Color.cyan);
        g.drawString(""+ soort [kleur - 1]+ " " + nummers[getal - 1], 130,50);

    }
    class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            een = Math.random();
            twee = Math.random();
            kleur = (int) (een * 4 + 1);
            getal = (int) (twee *13 + 1);
            repaint();
        }
    }

}