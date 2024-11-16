import javax.swing.*;

public class ListaDoble implements Lista, MetodoBusqueda, MetodoOrdenar {
    //Atributos------------------------------------------
    public NodoDoble ini;
    public NodoDoble fin;
    public int tam;

    //Constructor------------------------------------------
    public ListaDoble() {
    }

    //Metodos de interfaz Lista------------------------------------------
    @Override
    public void mostrarLista(JTextArea textArea) {
        if (ini == null) {
            textArea.setText("Lista vacia");
            return;
        }
        StringBuilder listaStr = new StringBuilder("Lista en orden: \n");
        NodoDoble actual = ini;
        while (actual != null) {
            listaStr.append(actual.dato);
            actual = actual.sig;
        }
        listaStr.append("\n");
        listaStr.append("Lista en orden inverso: \n");
        actual = fin;
        while (actual != null) {
            listaStr.append(actual.dato);
            actual = actual.ant;
        }
        textArea.setText(listaStr.toString());
    }

    @Override
    public void actualizarLista(JTextArea textArea) {
        mostrarLista(textArea);
    }

    @Override
    public void agregar(int dato, JTextArea textArea) {
        NodoDoble nuevo = new NodoDoble(dato);

        if (ini == null) {
            ini = fin = nuevo;
        } else {
            fin.sig = nuevo;
            nuevo.ant = fin;
            fin = nuevo;
        }
        tam++;
        actualizarLista(textArea);
    }

    @Override
    public boolean eliminar(int dato, JTextArea textArea) {
        if (ini == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia");
            return false;
        }

        NodoDoble actual = ini;

        while (actual != null && actual.dato != dato) {
            actual = actual.sig;
        }

        if (actual == null) { //elemento no sea encontrado
            JOptionPane.showMessageDialog(null, "Elemento no encontrado");
            return false;
        }

        if (actual == ini) {
            ini = ini.sig;
            if (ini != null) {
                ini.ant = null;
            } else if (actual == fin) {
                fin = fin.ant;
                if (fin != null) {
                    fin.sig = null;
                }
            } else {
                actual.ant.sig = actual.sig;
                actual.sig.ant = actual.ant;
            }
            tam--;
            actualizarLista(textArea);
        }
        return true;
    }

    //Metodos de interfaz MetodoBusqueda------------------------------------------
    @Override
    public int buscarLineal(int dato, JTextArea textArea) {
        NodoDoble actual = ini;
        int pos = 0;
        while (actual != null) {
            if (actual.dato == dato) {
                ;
                return pos;
            }

            actual = actual.sig;
            pos++;
        }
        return -1;
    }

    @Override
    public int buscarInterpolada(int dato, JTextArea textArea) {
        /*
        Dejo este espacio para añadir el metodo en un futuro -> Proyecto escalable
         */
        return 0;
    }

    @Override
    public int buscarBinaria(int dato, JTextArea textArea) {
        ordenarBurbuja(textArea);//Para busqueda binaria debe estar ordenada
        int inicio = 0;
        int fin = tam - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int pos = 0;
            NodoDoble actual = ini;
            while (pos < medio) {
                actual = actual.sig;
                pos++;
            }
            if (actual.dato == dato) {
                return pos;
            } else if (actual.dato < dato) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    //Metodos de interfaz MetodoOrdenar------------------------------------------
    @Override
    public void ordenarBurbuja(JTextArea textArea) {
        if (ini == null || ini.sig == null) {
            return;
        }
        boolean burb;

        do {
            burb = false;
            NodoDoble actual = ini;

            while (actual.sig != null) {
                if (actual.dato > actual.sig.dato) {
                    int aux = actual.dato;
                    actual.dato = actual.sig.dato;
                    actual.sig.dato = aux;
                    burb = true;
                }
                actual = actual.sig;
            }
        } while (burb);
        actualizarLista(textArea);
    }
}
