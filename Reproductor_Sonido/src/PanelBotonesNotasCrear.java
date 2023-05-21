import javax.swing.*;
import java.awt.*;

public class PanelBotonesNotasCrear extends JPanel {
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
            botones[i] = new JButton(names[i].name());
            botones[i].setFocusPainted(false);
            botones[i].setBackground(names[i].getColor());
            botones[i].setForeground(Color.BLACK);
            botones[i].setFont(new Font("Calibri", 1, 18));
        }

        botones[7] = new JButton("FIN");
        botones[7].setFocusPainted(false);
        botones[7].setBackground(Color.BLACK);
        botones[7].setForeground(Color.WHITE);
        botones[7].setFont(new Font("Calibri", 1, 18));

        for(JButton b : botones){
            add(b);
        }
    }


}
