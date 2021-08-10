package edat.rusia.tests;

import edat.rusia.map.*;

public class testMap{
    public static void main( String[] args ){
        // Declarar ciudades

        Mapa rusia = inicializarNodos();

        rusia.imprimirCiudades();

    }

    private static Mapa inicializarNodos(){
        int nodos = 11;
        // Lista de las 11 ciudades
        String[] ciudades = {"Moscu", "Kazan", "San Petersburgo", "Kaliningrado", "Nizhni Nóvgorod", "Volgogrado", "Ekaterimburgo", "Sochi", "Rostov del Don", "Saransk", "Samara"};
        
        // Tuplas de ciudades Limitrofes
        /*
            Moscu - San Petersburgo
            Moscu - Saransk
            Moscu - Nizhni
            Saransk -Nizhni
            Saransk - Kazan
            Kazan - Samara
            Kazan - Ekaterinburgo
            Samara - Volgograd
            Volgograd - Rostov
            Rostov - Sochi
            San Petersburgo - Kaliningrado
        */

        Mapa rusia = new Mapa(nodos);

        for (int i=0;i<nodos;i++){
            rusia.agregarCiudad(new Nodo(ciudades[i]));
        }
        
        // Fake data, will replace later
        rusia.agregarAdyacente("Moscu", "San Petersburgo", 1500);
        rusia.agregarAdyacente("Moscu", "Saransk", 1500);
        rusia.agregarAdyacente("Moscu", "Nizhni Nóvgorod", 1500);
        rusia.agregarAdyacente("Saransk", "Nizhni Nóvgorod", 170);
        rusia.agregarAdyacente("Kazan", "Saransk", 1500);
        rusia.agregarAdyacente("Kazan", "Ekaterimburgo", 520);
        rusia.agregarAdyacente("Samara", "Volgogrado", 340);
        rusia.agregarAdyacente("Rostov del Don", "Volgogrado", 1500);
        rusia.agregarAdyacente("Rostov del Don", "Sochi", 300);
        rusia.agregarAdyacente("Kaliningrado", "San Petersburgo", 750);

        return rusia;
    }
}