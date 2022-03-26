package Lab10Progra2;

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Hilo extends Thread {

    Random r = new Random();
    private JProgressBar barra1;
    private JProgressBar barra2;
    private Planeta planetita1;
    private Planeta planetita2;
    private Cientifico Luis;

    public Hilo(JProgressBar barra1, JProgressBar barra2, Planeta planetita1, Planeta planetita2, Cientifico Luis) {
        this.barra1 = barra1;
        this.barra2 = barra2;
        this.planetita1 = planetita1;
        this.planetita2 = planetita2;
        this.Luis = Luis;
    }

    @Override
    public void run() {
        boolean active = true;
        while (active) {
            barra1.setValue(barra1.getValue() + 1);
            if (barra1.getValue() == barra1.getMaximum()) {
                JOptionPane.showMessageDialog(null, "Finalizacion de la imulacuiob");
                barra1.setValue(0);
                active = false;

                int X = (planetita1.getCordenadaX() + planetita2.getCordenadaX()) / 2;
                int Y = (planetita1.getCordenaday() + planetita2.getCordenaday()) / 2;
                int peso = (planetita1.getPeso() + planetita2.getPeso()) / 2;
                int tamanio = (planetita1.getTamaño() + planetita2.getCordenadaX()) / 2;

                int probabilidad = r.nextInt(100) + 1;

                if (planetita1 instanceof Terrestre) {
                    if (probabilidad <= 25) {
                        String nombreNewPlanet = JOptionPane.showInputDialog(null, "Ingrese le nombre ");
                        Planeta newPlanet = new Terrestre(tamanio, peso, nombreNewPlanet, X, Y);
                        Luis.getPlanetasdescubiertos().add(newPlanet);
                    }
                } else if (planetita2 instanceof Gaseoso) {
                    if (probabilidad <= 20) {
                        String nombreNewPlanet = JOptionPane.showInputDialog(null, "Ingresde el nombre ");
                        Planeta nuevoPlanet = new Gaseoso(tamanio, peso, nombreNewPlanet, X,Y);
                        Luis.getPlanetasdescubiertos().add(nuevoPlanet);
                    }
                }
            }
            try {
                Thread.sleep(5);

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }

}
