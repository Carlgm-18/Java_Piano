package components_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * @author Carlos Gálvez Mena
 *
 * Representa el piano con el que se va a generar la melodía
 */
public class PanelBotonesNotasCrear extends JPanel implements ActionListener {
    private Notas[] names = Notas.values();
    private JButton[] botones = new JButton[names.length+1];
    private PanelNotasCrear pianoCrear;

    /**
     *
     * @param painoCrear Objeto de tipo {@link PanelNotasCrear}
     */
    public PanelBotonesNotasCrear(PanelNotasCrear painoCrear){
        this.pianoCrear = painoCrear;
        setLayout(new GridLayout(1, 8));
        colocarBotones();
        setVisible(true);
    }

    /**
     * Distribuye los botones que componen el piano
     */
    private void colocarBotones(){
        for(int i = 0; i<names.length; i++){
            JButton button = new JButton(names[i].name());
            button.setFocusPainted(false);
            button.setBackground(names[i].getColor());
            button.setForeground(Color.BLACK);
            button.setFont(new Font("Calibri", 1, 18));
            button.addActionListener(this);
            botones[i] = button;
        }

        botones[7] = new JButton("FIN");
        botones[7].setFocusPainted(false);
        botones[7].setBackground(Color.BLACK);
        botones[7].setForeground(Color.WHITE);
        botones[7].setFont(new Font("Calibri", 1, 18));
        botones[7].addActionListener(e -> changeToInicio());

        for(JButton b : botones){
            add(b);
        }
    }

    /**
     * Trata los eventos generados por las diferentes teclas del piano
     * @param e Evento a tratar
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        pianoCrear.addNota(Notas.valueOf(e.getActionCommand()));
    }

    /**
     * Método que permite volver a la pantalla principal
     */
    private void changeToInicio(){
        PanelContenidos.innerSplit.setLeftComponent(new PanelActividades());
        PanelContenidos.innerSplit.setDividerLocation(90);
        PanelContenidos.generalSplit.setLeftComponent(new PanelDibujo());
    }
}
