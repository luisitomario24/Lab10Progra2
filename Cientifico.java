package Lab10Progra2;

import java.io.Serializable;
import java.util.ArrayList;

public class Cientifico implements Serializable {

    public String nombreCientifico;
    private ArrayList<Planeta> planetasdescubiertos = new ArrayList();

    public Cientifico(String nombre) {
        this.nombreCientifico = nombre;
    }

    public String getNombre() {
        return nombreCientifico;
    }

    public void setNombre(String nombre) {
        this.nombreCientifico = nombre;
    }

    public ArrayList<Planeta> getPlanetasdescubiertos() {
        return planetasdescubiertos;
    }

    public void setPlanetasdescubiertos(ArrayList<Planeta> planetasdescubiertos) {
        this.planetasdescubiertos = planetasdescubiertos;
    }

    @Override
    public String toString() {
        return  nombreCientifico ;
    }
    
    
    

   
}
