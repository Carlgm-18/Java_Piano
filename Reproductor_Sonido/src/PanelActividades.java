import javax.swing.*;
import java.awt.*;

public class PanelActividades extends JPanel {
    public PanelActividades(){
        JLabel texto = new JLabel("TALLER 2 - PROGRAMACIÓN II - CURSO 2022-2023");
        texto.setOpaque(true);
        texto.setBackground(Color.BLACK);
        texto.setForeground(Color.WHITE);
        texto.setHorizontalAlignment(0);
        texto.setFont(new Font("Arial", 1, 20));
        this.setLayout(new BorderLayout());
        add(texto);
        setVisible(true);
    }
}
