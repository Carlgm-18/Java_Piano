package components_package;

import javax.swing.*;
import java.awt.*;



/**
 * @author Carlos Gálvez Mena
 *
 * Completa la distribución de las notas a la hora de reproducir la melodía
 */

public class PanelNotasReproducir extends JPanel {
    private JButton[] botonesNotas = new JButton[110];
    private Notas[] notas;
    private PanelNotasCrear panelNotasCrear;
    private int contadorNotas = 0;
    private int len;

    /**
     * {@link PanelNotasCrear}
     * @param panelNotasCrear Panel que representa las notas añadidas a la melodía
     */
    public PanelNotasReproducir(PanelNotasCrear panelNotasCrear){
        this.panelNotasCrear = panelNotasCrear;
        this.notas = panelNotasCrear.getMelodia();
        this.len = panelNotasCrear.getNumNotas();
        setLayout(new GridLayout(10, 11, 10, 10));
        setBackground(Color.BLACK);
        colocarNotas();
        setVisible(true);
    }

    /**
     * Distribuye los elementos que representan las notas
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
     * Método utilizado para reproducir la siguiente nota
     */
    public void playNota(){

        botonesNotas[contadorNotas].setBackground(notas[contadorNotas].getColor());
        new ReproductorSonidos(notas[contadorNotas++].name().toLowerCase());

        if(contadorNotas==len){
            PanelContenidos.innerSplit.setLeftComponent(new PanelActividades());
            PanelContenidos.innerSplit.setDividerLocation(100);
        }
    }
}
