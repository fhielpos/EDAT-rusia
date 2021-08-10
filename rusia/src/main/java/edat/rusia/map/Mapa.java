package edat.rusia.map;

import edat.rusia.lista.Lista;

public class Mapa {
    private Lista ciudades;

    public Mapa(int cantCiudades) {
        ciudades = new Lista();
    }

    public boolean agregarCiudad(Nodo nuevaCiudad) {
        this.ciudades.insertar(nuevaCiudad, this.ciudades.longitud()+1);

        return true;
    }

    public boolean agregarAdyacente(String ciudadOrigen, String ciudadDestino, int distancia) {
        // Si hay ciudades cargadas:
        if (!this.ciudades.esVacia()) {
            // Buscar los dos nodos
            Nodo nodoOrigen = buscarCiudad(ciudadOrigen);
            Nodo nodoDestino = buscarCiudad(ciudadDestino);

            // Hacer que los nodos sean vecinos y agregar la distancia
            if (nodoOrigen != null && nodoDestino != null) {
                nodoOrigen.agregarAdyacente(nodoDestino, distancia);
                return true;
            } else {
                // Alguno de los nodos es nulo, error
                System.out.println("Error, una de las ciudades no está en el mapa");
            }
        }

        return false;
    }

    private Nodo buscarCiudad(String unaCiudad) {
        // Buscar el nodo correspondiente para una ciudad

        int iterador = 1;
        int cantCiudades = this.ciudades.longitud();
        Nodo ciudad = null;

        while (iterador <= cantCiudades && ciudad == null) {
            // Si la etiqueta del nodo coincide con la ciudad buscada
            if (((Nodo) this.ciudades.recuperar(iterador)).getEtiqueta().toLowerCase().equals(unaCiudad.toLowerCase())) {
                ciudad = (Nodo) this.ciudades.recuperar(iterador);
            } else {
                iterador++;
            }
        }
        return ciudad;
    }

    public void imprimirDistancias() {
        // Imprime todas las distancias para cada uno de las ciudades 
        // Se espera que imprima valores duplicados ya que cada ciudad tiene su propia lista
        int cantCiudades = this.ciudades.longitud();
        if (!this.ciudades.esVacia()) {
            for (int i = 0; i <= cantCiudades; i++) {
                ((Nodo) this.ciudades.recuperar(i)).imprimirDistancias();
            }
        }
    }

    public void imprimirCiudades() {
        int cantCiudades = this.ciudades.longitud();
        if (!this.ciudades.esVacia()) {
            for (int i = 1; i <= cantCiudades; i++) {
                ((Nodo) this.ciudades.recuperar(i)).getVecinos();
            }
        }
    }
}
