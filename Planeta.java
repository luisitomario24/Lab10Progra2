
package Lab10Progra2;

import java.io.Serializable;


public class Planeta implements Serializable{
    int tamaño;
    int peso;
    String nombre;
    int cordenadaX;
    int cordenaday;
    public Planeta(){
        
    }
    public Planeta(int tamaño, int peso, String nombre, int cordenadaX, int cordenaday) {
        this.tamaño = tamaño;
        this.peso = peso;
        this.nombre = nombre;
        this.cordenadaX = cordenadaX;
        this.cordenaday = cordenaday;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

        public int getCordenadaX() {
        return cordenadaX;
    }

    public void setCordenadaX(int cordenadaX) {
        this.cordenadaX = cordenadaX;
    }

    public int getCordenaday() {
        return cordenaday;
    }

    public void setCordenaday(int cordenaday) {
        this.cordenaday = cordenaday;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
