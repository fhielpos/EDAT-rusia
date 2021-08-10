package edat.rusia.lista;

public class NodoLista {
    private Object elemento;
    private NodoLista enlace;

    public NodoLista(Object unElemento, NodoLista unEnlace){
        this.elemento = unElemento;
        this.enlace = unEnlace;
    }

    public void setElemento(Object unElemento){
        this.elemento = unElemento;
    }

    public void setEnlace(Object unElemento){
        this.elemento = unElemento;
    }

    public Object getElemento(){
        return this.elemento;
    }

    public NodoLista getEnlace(){
        return this.enlace;
    }

    
}
