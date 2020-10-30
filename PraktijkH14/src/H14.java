import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.net.URL;

public class H14 extends Applet {
    TextField tekstvak;
    Button knop;
    Label label;
    int stenen = 23;
    boolean spel = true;
    private URL recources;
    private AudioClip geluid;


    public void init() {
        recources = H14.class.getResource("../resources/");
        geluid = getAudioClip(recources, "applaus.wav");

        tekstvak = new TextField();
        tekstvak.addActionListener(new Listener());

        knop = new Button("Enter");
        knop.setBackground(Color.green);
        knop.addActionListener(new Listener());


        label = new Label("Voer getallen 1,2 of 3 in");
        label.setBackground(Color.cyan);

        add(label);
        add(tekstvak);
        add(knop);

    }


    public void paint(Graphics g) {
        setBackground(Color.cyan);

        if (!spel && stenen > 0) {
            if (stenen % 4 == 2) {
                stenen -= 1;
            } else if (stenen % 4 == 3) {
                stenen -= 2;
            } else if (stenen % 4 == 0) {
                stenen -= 3;
            } else {
                double random = Math.random();
                int getal = (int) (random * 3 + 1);
                stenen -= getal;
            }
            spel = true;
        }
        if (stenen <= 0 && spel) {
            g.drawString("je hebt gewonnen", 70, 40);
            remove(label);
            remove(knop);
            remove(tekstvak);
            stenen = 0;
            geluid.play();
        } else if (stenen <= 0 && !spel) {
            g.drawString("je hebt verloren", 70, 40);
            remove(label);
            remove(knop);
            remove(tekstvak);
            stenen = 0;}

            int teller;
            int y = 80;
            int x = 20;
            for (teller = 0; teller < stenen; teller++) {
                g.fillOval(x, y, 10, 10);
                x += 20;
                if (teller == 4 || teller == 9 || teller == 14 || teller == 19) {
                    y += 20;
                    x = 20;
                }
            }
            if (stenen > 0) {
                g.drawString("Er zijn nog: " + stenen + " stenen", 10, 50);
            }
        }
        class Listener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String output = tekstvak.getText();
                int getal = Integer.parseInt(output);
                if (getal <= 3 && getal > 0) {
                    stenen -= getal;
                    spel = false;
                }
                tekstvak.setText("");
                repaint();
            }
        }
    }

