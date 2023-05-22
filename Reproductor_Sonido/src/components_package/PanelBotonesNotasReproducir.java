package components_package;

import javax.swing.*;
import java.awt.*;



/**
 * @author Carlos Gálvez Mena
 *
 * Representa el botón que permite reproducir la siguinte nota
 */
public class PanelBotonesNotasReproducir extends JPanel {
    private PanelNotasReproducir panelReproducir;

    /**
     *
     * @param panelReproducir Panel que contiene las notas que debe reproducir
     */
    public PanelBotonesNotasReproducir(PanelNotasReproducir panelReproducir){
        this.panelReproducir = panelReproducir;
        initComponents();
        setLayout(new GridLayout(1, 1));
        setVisible(true);
    }

    /**
     * Coloca los componentes requeridos
     */
    private void initComponents(){
        JButton botonReproducir = new JButton(">");
        botonReproducir.setFont(new Font("Arial", 1, 20));
        botonReproducir.addActionListener(e -> playNextNote());
        add(botonReproducir);
    }

    /**
     * Llama al método playNota() de la clase {@link PanelNotasReproducir}
     */
    private void playNextNote(){
        panelReproducir.playNota();
    }
}
