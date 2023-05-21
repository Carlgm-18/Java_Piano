import javax.swing.*;
import java.awt.*;

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

    public void addNota(Notas nota){
        if(contadorNotas==110){
            JOptionPane.showMessageDialog(null,"LÍMITE DE NOTAS ALCANZADO\nPORFAVOR PULSA FIN");
            return;
        }
        botonesNotas[contadorNotas].setBackground(nota.getColor());
        notas[contadorNotas++] = nota;
         new ReproductorSonidos(nota.name().toLowerCase());
    }
}
