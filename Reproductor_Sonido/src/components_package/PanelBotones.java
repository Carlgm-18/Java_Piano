package components_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;



/**
 * @author Carlos Gálvez Mena
 *
 * Contiene los botones principales que permitirán acceder a las diferentes interfaces de la aplicación
 */
public class PanelBotones extends JPanel {
    private final String[] names = {"CREAR", "REPRODUCIR", "ADIVINAR", "SALIR"};
    private JButton[] botones = new JButton[names.length];
    private PanelNotasCrear notasCrear;

    public PanelBotones(){
        setLayout(new GridLayout(1, 4));
        colocarBotones();
        setVisible(true);
    }

    /**
     * Coloca los botones de forma ordenada
     */
    private void colocarBotones(){
        for(int i = 0; i<names.length; i++){
            JButton but = new JButton(names[i]);
            but.setFocusPainted(false);
            but.setBackground(Color.BLACK);
            but.setForeground(Color.WHITE);
            but.setFont(new Font("Calibri", 1, 18));
            botones[i] = but;
            add(but);
        }

        botones[0].addActionListener(crearListener());
        botones[1].addActionListener(reproducirListener());
        botones[2].addActionListener(adivinarListener());
        botones[3].addActionListener(salirListener());
    }

    /**
     * Accede a la sección que permite crear una melodía
     * @return Acción que cambia la interfaz
     */
    private ActionListener crearListener(){
        return e -> {
            notasCrear = new PanelNotasCrear();
            PanelContenidos.innerSplit.setLeftComponent(new PanelBotonesNotasCrear(notasCrear));
            PanelContenidos.innerSplit.setDividerLocation(100);
            PanelContenidos.generalSplit.setLeftComponent(notasCrear);
            PanelContenidos.generalSplit.setDividerLocation(550);
        };
    }
    /**
     * Accede a la sección que permite reproducir la melodía creada
     * @return Acción que cambia la interfaz
     */
    private ActionListener reproducirListener(){
        return e -> {
            if(notasCrear==null){
                JOptionPane.showMessageDialog(null, "POR FAVOR\nPRIMERO CREA UNA MELODIA");
            }else{
                PanelNotasReproducir panelReproducir = new PanelNotasReproducir(notasCrear);

                PanelContenidos.innerSplit.setLeftComponent(new PanelBotonesNotasReproducir(panelReproducir));
                PanelContenidos.innerSplit.setDividerLocation(100);
                PanelContenidos.generalSplit.setLeftComponent(panelReproducir);
                PanelContenidos.generalSplit.setDividerLocation(550);
            }

        };
    }
    /**
     * LLeva a la sección que permite adivinar la melodía creada
     * @return Acción que cambia la interfaz
     */
    private ActionListener adivinarListener(){
        return e -> {
            if (notasCrear==null){
                JOptionPane.showMessageDialog(null, "POR FAVOR\nPRIMERO CREA UNA MELODIA");
            }else{
                PanelNotasAdivinar panelAdivinar = new PanelNotasAdivinar(notasCrear);

                PanelContenidos.innerSplit.setLeftComponent(new PanelBotonesNotasAdivinar(panelAdivinar));
                PanelContenidos.innerSplit.setDividerLocation(100);
                PanelContenidos.generalSplit.setLeftComponent(panelAdivinar);
                PanelContenidos.generalSplit.setDividerLocation(550);
            }
        };
    }
    /**
     * Cierra la aplicación
     * @return Acción que cierra la aplicación
     */
    private ActionListener salirListener(){
        return e -> {
            System.exit(0);
        };
    }
}
