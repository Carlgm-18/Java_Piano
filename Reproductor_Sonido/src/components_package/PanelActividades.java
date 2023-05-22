package components_package;

import javax.swing.*;
import java.awt.*;



/**
 * @author Carlos Gálvez Mena
 *
 * Contiene un {@link JLabel} que representa el texto situado en la parte intermedia de la interfaz
 */
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
