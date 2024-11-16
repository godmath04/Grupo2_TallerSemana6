import javax.swing.*;

public interface Lista {

    //Metodos------------------------------------------
    public void mostrarLista(JTextArea textArea);

    public void actualizarLista(JTextArea textArea);

    public void agregar(int dato, JTextArea textArea);

    public boolean eliminar(int dato, JTextArea textArea);
}
