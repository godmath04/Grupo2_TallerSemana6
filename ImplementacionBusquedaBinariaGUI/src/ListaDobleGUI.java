import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaDobleGUI {
    private JTextField textElemento;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton ordenarBurbujaButton;
    private JButton busquedaLinealButton;
    private JButton busquedaBinariaButton;
    private JButton busquedaInterpoladaButton;
    private JButton mostrarButton;
    private JTextArea textArea;
    private JPanel pGeneral;
    private JLabel Elemento;

    ListaDoble lis = new ListaDoble();

    public ListaDobleGUI() {

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inp = textElemento.getText();
                try {
                    int valor = Integer.parseInt(inp);
                    lis.agregar(valor, textArea);
                    textElemento.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un numero valido");
                }
            }

        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inp = textElemento.getText();
                try {
                    int valor = Integer.parseInt(inp);
                    lis.eliminar(valor, textArea);
                    textElemento.setText("");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ordenarBurbujaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lis.ordenarBurbuja(textArea);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        busquedaLinealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buscar = textElemento.getText();
                try {
                    int valor = Integer.parseInt(buscar);
                    int pos = lis.buscarLineal(valor, textArea);

                    if (pos == -1) {
                        JOptionPane.showMessageDialog(null, "Elemento no encontrado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento: " + valor + " encontrado en posicion: " + (pos + 1));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                }
            }
        });
        busquedaBinariaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buscar = textElemento.getText();
                try {
                    int valor = Integer.parseInt(buscar);
                    int pos = lis.buscarBinaria(valor, textArea);

                    if (pos == -1) {
                        JOptionPane.showMessageDialog(null, "Elemento no encontrado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elementos ordenados.\n" + "Elemento: " + valor + " encontrado en posicion: " + (pos + 1));
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                }
            }
        });
        busquedaInterpoladaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Proximamente ... (:");
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    lis.mostrarLista(textArea);
                } catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ListaDobleGUI");
        frame.setContentPane(new ListaDobleGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
