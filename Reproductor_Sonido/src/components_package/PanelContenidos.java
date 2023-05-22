package components_package;

import javax.swing.*;
import java.awt.*;



/**
 * @author Carlos Gálvez Mena
 *
 * Representa el contentPane del JFrame
 */
public class PanelContenidos extends JPanel {

    public static JSplitPane innerSplit;
    public static JSplitPane generalSplit;
    public PanelContenidos(){
        setLayout(new BorderLayout());
        init();
        setVisible(true);
    }

    /**
     * Inicializa todos los componentes necesarios
     */
    private void init(){
        innerSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new PanelActividades(), new PanelBotones());
        innerSplit.setEnabled(false);
        innerSplit.setDividerLocation(90);
        generalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new PanelDibujo(), innerSplit);
        generalSplit.setEnabled(false);
        add(generalSplit);
    }
}
