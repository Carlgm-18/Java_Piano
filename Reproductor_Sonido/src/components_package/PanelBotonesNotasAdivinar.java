package components_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * @author Carlos Gálvez Mena
 *
 * Panel que representa el paino en el proceso de adivinar
 */
public class PanelBotonesNotasAdivinar extends JPanel implements ActionListener {
    private Notas[] names = Notas.values();
    private JButton[] botones = new JButton[names.length+1];
    private PanelNotasAdivinar pianoAdivinar;

    /**
     *
     * @param painoAdivinar Objeto de tipo {@link PanelNotasAdivinar}
     */
    public PanelBotonesNotasAdivinar(PanelNotasAdivinar painoAdivinar){
        this.pianoAdivinar = painoAdivinar;
        setLayout(new GridLayout(1, 8));
        colocarBotones();
        setVisible(true);
    }

    /**
     * Distribuye los botones que conforman el teclado
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

    @Override
    public void actionPerformed(ActionEvent e) {
        pianoAdivinar.adivinarNota(Notas.valueOf(e.getActionCommand()));
    }

    private void changeToInicio(){
        PanelContenidos.innerSplit.setLeftComponent(new PanelActividades());
        PanelContenidos.innerSplit.setDividerLocation(90);
        PanelContenidos.generalSplit.setLeftComponent(new PanelDibujo());
    }
}
