import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelBotones extends JPanel {
    private String[] names = {"CREAR", "REPRODUCIR", "ADIVINAR", "SALIR"};
    private JButton[] botones = new JButton[names.length];
    public PanelBotones(){
        setLayout(new GridLayout(1, 4));
        colocarBotones();
        setVisible(true);
    }
    private void colocarBotones(){
        for(int i = 0; i<names.length; i++){
            botones[i] = new JButton(names[i]);
            botones[i].setFocusPainted(false);
            botones[i].setBackground(Color.BLACK);
            botones[i].setForeground(Color.WHITE);
            botones[i].setFont(new Font("Calibri", 1, 18));
        }
        for(JButton b : botones){
            add(b);
        }
    }

    private ActionListener crearListener(){
        return e -> {

        };
    }

    private ActionListener reproducirListener(){
        return e -> {

        };
    }

    private ActionListener adivinarListener(){
        return e -> {

        };
    }

    private ActionListener salirListener(){
        return e -> {
            System.exit(0);
        };
    }
}
