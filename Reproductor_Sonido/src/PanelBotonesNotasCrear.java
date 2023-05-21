import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBotonesNotasCrear extends JPanel implements ActionListener {
    private Notas[] names = Notas.values();
    private JButton[] botones = new JButton[names.length+1];
    private PanelNotasCrear pianoCrear;
    public PanelBotonesNotasCrear(PanelNotasCrear painoCrear){
        this.pianoCrear = painoCrear;
        setLayout(new GridLayout(1, 8));
        colocarBotones();
        setVisible(true);
    }

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
        pianoCrear.addNota(Notas.valueOf(e.getActionCommand()));
    }

    private void changeToInicio(){
        PanelContenidos.innerSplit.setLeftComponent(new PanelActividades());
        PanelContenidos.innerSplit.setDividerLocation(90);
        PanelContenidos.generalSplit.setLeftComponent(new PanelDibujo());
    }
}
