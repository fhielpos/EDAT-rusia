package edat.rusia.map;

public class Distancia{
    private String origen;
    private String destino;
    private int distancia;

    public Distancia(String ciudadOrigen, String ciudadDestino, int longDistancia){
        this.origen = ciudadOrigen;
        this.destino = ciudadDestino;
        this.distancia = longDistancia;
    }

    public int getDistancia(){
        return this.distancia;
    }

    public String getOrigen(){
        return this.origen;
    }

    public String getDestino(){
        return this.destino;
    }

    public String toString(){
        return "La distancia desde " +this.origen +" hasta " +this.destino +" es de: " +this.distancia +" kilometros";
    }

    public void setDistancia(int nuevaDistancia){
        this.distancia = nuevaDistancia;
    }

    public void setOrigen(String nuevoOrigen){
        this.origen = nuevoOrigen;
    }

    public void setDestino(String nuevoDestino){
        this.destino = nuevoDestino;
    }
}