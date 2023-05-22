package components_package;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



/**
 * @author Carlos Gálvez Mena
 *
 * Representa la imagen de la UIB colocada en la pantalla inicial
 */
public class PanelDibujo extends JPanel {
    private BufferedImage uibImage;
    public PanelDibujo(){

        try {
            uibImage = ImageIO.read(new File("img/UIB.jpg"));
        } catch(IOException ioEx) {
            throw new RuntimeException(ioEx);
        }

        JLabel uib = new JLabel(new ImageIcon(uibImage.getScaledInstance(800,550, Image.SCALE_DEFAULT)));
        add(uib);
        setVisible(true);
    }
}
