import javax.swing.*;
import java.awt.*;

public class PanelNotasCrear extends JPanel {
    private JButton[] notas = new JButton[110];
    private int index = 0;
    public PanelNotasCrear(){
        setLayout(new GridLayout(10, 11, 10, 10));
        setBackground(Color.BLACK);
        colocarNotas();
        setVisible(true);
    }

    private void colocarNotas(){
        for(int i = 0; i <  notas.length; i++){
            JButton button = new JButton();
            button.setEnabled(false);
            button.setOpaque(true);
            button.setBackground(Color.BLACK);
            button.setBorder(BorderFactory.createEmptyBorder());
            notas[i] = button;
            add(button);
        }
    }

    public void addNota(Notas nota){
        if(index==110){
            JOptionPane.showMessageDialog(null,"LÍMITE DE NOTAS ALCANZADO");
            return;
        }
        notas[index++].setBackground(nota.getColor());

    }
}
