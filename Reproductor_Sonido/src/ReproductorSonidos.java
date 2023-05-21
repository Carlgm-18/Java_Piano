import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReproductorSonidos {
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