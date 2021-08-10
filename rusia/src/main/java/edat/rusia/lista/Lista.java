package edat.rusia.lista;

public class Lista {
    private NodoLista cabecera;

    public Lista() {
        this.cabecera = null;
    }

    public boolean insertar(Object unElemento, int posicion) {
        boolean exito = true;

        if (posicion < 1 || posicion > this.longitud() + 1) {
            // Regla 1 < pos < longitud() + 1
            exito = false;
        } else {
            if (posicion == 1) {
                // Crear nodo y enlazar a la cabecera
                this.cabecera = new NodoLista(unElemento, this.cabecera);
            } else {
                NodoLista aux = this.cabecera;
                int i = 1;
                while (i < posicion - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                // Crear nodo y enlazar
                NodoLista nuevo = new NodoLista(unElemento, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        return exito;
    }

    public Object recuperar(int posicion) {
        Object elemento = null;
        
        if (posicion > 0 && posicion <= this.longitud()) {
            NodoLista aux = this.cabecera;
            int i = 1;
            // Avanzar hasta posicion
            while (i < posicion) {
                aux = aux.getEnlace();
                i++;
            }

            // Obtener elemento y retornar
            elemento = aux.getElemento();
        }
        return elemento;
    }

    public int localizar(Object unElemento) {
        int posicion = -1;
        if(!esVacia()){
            int i = 1;
            NodoLista aux = this.cabecera;
            int longitud = this.longitud();
            // Avanzar mientras el elemento no sea el buscado
            do{
                if(aux.getElemento() == unElemento){
                    posicion = i;
                } else {
                    aux = aux.getEnlace();
                    i++;
                }
            } while(i <= longitud && posicion == -1); // Si posicion ya no es -1 o si llego al limite, terminar
        }
        return posicion;
    }

    public int longitud() {
        int longitud = 0;
        NodoLista aux;

        if (!esVacia()) {
            // Si no es vacia, analizar la longitud

            aux = this.cabecera;
            longitud++;

            // Mientras el enlace no sea nulo, avanzar
            while (aux.getEnlace() != null) {
                aux = aux.getEnlace();
                longitud++;
            }
        }

        return longitud;
    }

    public boolean esVacia() {
        return (this.cabecera == null);
    }

    public void vaciar(){
        this.cabecera = null;
    }

}
