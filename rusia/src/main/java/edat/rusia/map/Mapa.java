package edat.rusia.map;

public class Mapa {
    private Nodo[] ciudades;
    private int ciudadesCargadas;

    public Mapa(int cantCiudades) {
        ciudades = new Nodo[cantCiudades];
        ciudadesCargadas = 0;
    }

    public boolean agregarCiudad(Nodo nuevaCiudad) {
        if (this.ciudadesCargadas != this.ciudades.length) {
            this.ciudades[ciudadesCargadas] = nuevaCiudad;
            this.ciudadesCargadas++;
            return true;
        } else
            return false;
    }

    public boolean agregarAdyacente(String ciudadOrigen, String ciudadDestino, int distancia) {
        // Si hay ciudades cargadas:
        if (this.ciudadesCargadas != 0) {
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

        int iterador = 0;
        Nodo ciudad = null;

        while (iterador < this.ciudadesCargadas && ciudad == null) {
            // Si la etiqueta del nodo coincide con la ciudad buscada
            if (this.ciudades[iterador].getEtiqueta().toLowerCase().equals(unaCiudad.toLowerCase())) {
                ciudad = this.ciudades[iterador];
            } else {
                iterador++;
            }
        }
        return ciudad;
    }

    public void imprimirDistancias() {
        // Imprime todas las distancias para cada uno de las ciudades 
        // Se espera que imprima valores duplicados ya que cada ciudad tiene su propia lista
        if (this.ciudadesCargadas != 0) {
            for (int i = 0; i < ciudadesCargadas; i++) {
                this.ciudades[i].imprimirDistancias();
            }
        }
    }
}
