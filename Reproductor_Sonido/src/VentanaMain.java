import javax.swing.*;

public class VentanaMain extends JFrame {
    public VentanaMain(){
        this.setSize(800,800);
        this.setTitle("TALLER 2 - PROGRAMACIÓN II - CURSO 2022-2023");
        this.setContentPane(new PanelContenidos());
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
