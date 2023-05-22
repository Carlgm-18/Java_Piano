package components_package;

import javax.swing.*;
import java.awt.*;



/**
 * @author Carlos Gálvez Mena
 *
 * Representa el conjunto de notas durante el proceso de adivinar
 */
public class PanelNotasAdivinar extends JPanel {
    private JButton[] botonesNotas = new JButton[110];
    private Notas[] notas;
    private PanelNotasCrear panelNotasCrear;
    private int contadorNotas = 0;
    private int len;

    /**
     *
     * @param panelNotasCrear Panel de las notas creadas
     */
    public PanelNotasAdivinar(PanelNotasCrear panelNotasCrear){
        this.panelNotasCrear = panelNotasCrear;
        this.notas = panelNotasCrear.getMelodia();
        this.len = panelNotasCrear.getNumNotas();
        setLayout(new GridLayout(10, 11, 10, 10));
        setBackground(Color.BLACK);
        colocarNotas();
        setVisible(true);
    }

    /**
     * Distribuye los elementos que representan las notas de manera uniforma
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
     * Comprueba que la nota adivinada sea correcta, además de tratar la condición para ganar
     * @param nota Valor de la nota a adivinar
     */
    public void adivinarNota(Notas nota){
        if(!(nota.name()).equals(notas[contadorNotas].name())){
            new ReproductorSonidos("error");
        }else {
            botonesNotas[contadorNotas].setBackground(notas[contadorNotas].getColor());
            new ReproductorSonidos(notas[contadorNotas++].name().toLowerCase());

            if (contadorNotas == len) {
                new ReproductorSonidos("campeones");
                JOptionPane.showMessageDialog(null, "¡HAS GANADO!");
                PanelContenidos.innerSplit.setLeftComponent(new PanelActividades());
                PanelContenidos.innerSplit.setDividerLocation(100);
            }
        }
    }
}
