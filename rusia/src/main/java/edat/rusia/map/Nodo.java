package edat.rusia.map;
import edat.rusia.lista.Lista;

public class Nodo {
    private String etiqueta;
    private Lista rutas;
    private Lista adyacentes;

    public Nodo(String unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        this.adyacentes = new Lista();
        this.rutas = new Lista();
    }

    public boolean agregarAdyacente(Nodo nuevoAdyacente, int unaDistancia) {
        // Buscar en la lista si ya existe dicho nodo
        if (this.adyacentes.localizar(nuevoAdyacente) == -1) {

            System.out.println("Agregando nodo: " + nuevoAdyacente.getEtiqueta());

            // Creo la ruta
            Distancia rutaVecino = new Distancia(this.etiqueta, nuevoAdyacente.getEtiqueta(), unaDistancia);

            // Agrego la ruta a la lista de rutas
            this.rutas.insertar(rutaVecino, this.rutas.longitud()+1);

            // Agrego al vecino
            this.adyacentes.insertar(nuevoAdyacente, this.adyacentes.longitud()+1);
        
            // Agrego al nodo actual al vecino
            nuevoAdyacente.agregarAdyacente(this, unaDistancia);

            return true;
        } else {
            // Si el vecino ya existia devuelvo false
            return false;
        }

    }

    private Nodo buscarVecino(String unVecino) {
        // Buscar el nodo correspondiente a un vecino
        int iterador = 1;
        Nodo vecino = null;
        if (!this.adyacentes.esVacia()) {
            int cantVecinos = this.adyacentes.longitud();
            while ((vecino == null) && iterador <= cantVecinos) {
                if (((Nodo) this.adyacentes.recuperar(iterador)).getEtiqueta().toLowerCase().equals(unVecino.toLowerCase()))
                    vecino = (Nodo) this.adyacentes.recuperar(iterador);
                else
                    iterador++;
            }
        }
        return vecino;
    }

    public boolean modificarDistancia(String unDestino, int nuevaDistancia) {
        // Modificar la distancia entre un nodo y un vecino

        Nodo vecino = buscarVecino(unDestino);

        // Buscar si existe el vecino
        if (vecino != null) {

            // Obtener ruta
            Distancia rutaVecino = buscarRuta(unDestino);

            // Si las distancias no son iguales, cambiar
            if (rutaVecino.getDistancia() != nuevaDistancia) {

                // Modificar distancia en el nodo actual
                rutaVecino.setDistancia(nuevaDistancia);

                // Modificar distancia en el nodo vecino
                vecino.modificarDistancia(this.etiqueta, nuevaDistancia);

                return true;
            }
        }
        return false;
    }

    private Distancia buscarRuta(String unDestino) {
        // Buscar la distancia entre el nodo y un vecino

        int iterador = 0;
        Distancia rutaDestino = null;

        if (!this.adyacentes.esVacia()) {
            int cantVecinos = this.adyacentes.longitud();
            while ((rutaDestino == null) && iterador < cantVecinos) {
                // Comparar strings en lowercase
                if (((Distancia) this.rutas.recuperar(iterador)).getDestino().toLowerCase().equals(unDestino.toLowerCase()))
                    rutaDestino = (Distancia) this.rutas.recuperar(iterador);
                else
                    iterador++;
            }
        }

        return rutaDestino;
    }

    public String getEtiqueta() {
        return this.etiqueta;
    }

    public void imprimirDistancias() {
        // Imprime todas las distancias entre los vecinos
        if (!this.adyacentes.esVacia()) {
            int cantVecinos = this.adyacentes.longitud();
            for (int i = 1; i <= cantVecinos; i++) {
                System.out.println(rutas.recuperar(i).toString());
            }
        }
        else
            System.out.println(this.etiqueta + ": Esta ciudad no tiene niguna ruta cargada");
    }

    public void getVecinos(){
        for(int i=1;i<=adyacentes.longitud();i++){
            System.out.println("Vecino para: "+this.etiqueta);
            System.out.println(this.adyacentes.recuperar(i).toString());
        }
        for(int i=1;i<=rutas.longitud();i++){
            //System.out.println(this.rutas.toString());
        }
    }

    public String toString(){
        return this.etiqueta;
    }

}
