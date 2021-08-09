package edat.rusia.map;

public class Nodo {
    private String etiqueta;
    private int vecinos;
    private Distancia[] rutas;
    private Nodo[] adyacentes;

    public Nodo(String unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        this.adyacentes = new Nodo[100];
        this.vecinos = 0;
        this.rutas = new Distancia[100];
    }

    public boolean agregarAdyacente(Nodo nuevoAdyacente, int unaDistancia) {
        // Busco si existe un vecino ya cargado con ese nombre para evitar recursión
        // infinita
        if (buscarVecino(nuevoAdyacente.getEtiqueta()) == null) {

            // System.out.println("Agregando nodo: " + nuevoAdyacente.getEtiqueta())

            // Creo la ruta
            Distancia rutaVecino = new Distancia(this.etiqueta, nuevoAdyacente.getEtiqueta(), unaDistancia);

            // Agrego la ruta a la lista de rutas
            rutas[this.vecinos] = rutaVecino;

            // Agrego el nuevo nodo a la lista de adyacentes
            this.adyacentes[this.vecinos] = nuevoAdyacente;

            // Aumento la cantidad de vecinos para evitar otra recursión infinita
            this.vecinos++;

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
        int iterador = 0;
        Nodo vecino = null;
        if (this.vecinos != 0) {
            while ((vecino == null) && iterador < this.vecinos) {
                if (this.adyacentes[iterador].getEtiqueta().toLowerCase().equals(unVecino.toLowerCase()))
                    vecino = this.adyacentes[iterador];
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

        if (this.vecinos != 0) {
            while ((rutaDestino == null) && iterador < this.vecinos) {
                // Comparar strings en lowercase
                if (rutas[iterador].getDestino().toLowerCase().equals(unDestino.toLowerCase()))
                    rutaDestino = rutas[iterador];
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
        if (this.vecinos > 0) {
            for (int i = 0; i < this.vecinos; i++) {
                System.out.println(rutas[i].toString());
            }
        }
        else
            System.out.println(this.etiqueta + ": Esta ciudad no tiene niguna ruta cargada");
    }

}
