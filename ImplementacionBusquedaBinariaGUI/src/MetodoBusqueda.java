import javax.swing.*;

public interface MetodoBusqueda {

    //Metodos------------------------------------------
    public int buscarLineal(int dato, JTextArea textArea);

    public int buscarInterpolada(int dato, JTextArea textArea);

    public int buscarBinaria(int dato, JTextArea textArea);

}
