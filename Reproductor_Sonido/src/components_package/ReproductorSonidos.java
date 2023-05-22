package components_package;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;



/**
 * @author Carlos Gálvez Mena
 *
 * Clase que permite reproducir un archivo de sonido pasando su nombre como parámetro
 */

public class ReproductorSonidos {
    /**
     *
     * @param note Nombre del archivo a reproducir
     */
    public ReproductorSonidos(String note) {
        Clip clip;
        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("sonidos/" + note + ".wav")
                    .getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }catch (UnsupportedAudioFileException | LineUnavailableException | IOException error) {
            System.err.println("ERROR: PROBLEMAS CON LA REPRODUCCIÓN DEL SONIDO");
        }
    }
}