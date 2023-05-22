package components_package;

import javax.swing.*;
import java.awt.*;



/**
 * @author Carlos Gálvez Mena
 *
 * Representa la distribución de las notas a la hora de crear una melodía
 */

public class PanelNotasCrear extends JPanel {
    private JButton[] botonesNotas = new JButton[110];
    private Notas[] notas = new Notas[110];
    private int contadorNotas = 0;
    public PanelNotasCrear(){
        setLayout(new GridLayout(10, 11, 10, 10));
        setBackground(Color.BLACK);
        colocarNotas();
        setVisible(true);
    }

    /**
     * Distribuye las notas de manera uniforme
     */
    private void colocarNotas(){
        for(int i = 0; i <  botonesNotas.length; i++){
            JButton button = new JButton();
            button.setEnabled(false);
            button.setOpaque(true);
            button.setBackground(Color.BLACK);
            button.setBorder(BorderFactory.createEmptyBorder());
            botonesNotas[i] = button;
            add(button);
        }
    }

    /**
     * Método que permite añadir una nota a la melodía según la tecla que se haya seleccionado
     * @param nota Nota que representa la tecla pulsada
     */
    public void addNota(Notas nota){
        if(contadorNotas==110){
            JOptionPane.showMessageDialog(null,"LÍMITE DE NOTAS ALCANZADO\nPORFAVOR PULSA FIN");
            return;
        }
        botonesNotas[contadorNotas].setBackground(nota.getColor());
        notas[contadorNotas++] = nota;
         new ReproductorSonidos(nota.name().toLowerCase());
    }

    /**
     *
     * @return Array de notas que representa la melodía creada
     */
    public Notas[] getMelodia(){
        return notas;
    }

    /**
     *
     * @return Longitud de la melodía
     */
    public int getNumNotas(){
        return contadorNotas;
    }
}
