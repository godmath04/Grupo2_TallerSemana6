public class NodoDoble {
    //Atributos------------------------------------------
    public int dato;
    public NodoDoble ant;
    public NodoDoble sig;

    //Constructor------------------------------------------
    public NodoDoble(int dato) {
        this.dato = dato;
        this.ant = null;
        this.sig = null;
    }
}
