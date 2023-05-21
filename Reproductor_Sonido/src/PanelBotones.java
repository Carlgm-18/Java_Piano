import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelBotones extends JPanel {
    private final String[] names = {"CREAR", "REPRODUCIR", "ADIVINAR", "SALIR"};
    private JButton[] botones = new JButton[names.length];

    public PanelBotones(){
        setLayout(new GridLayout(1, 4));
        colocarBotones();
        setVisible(true);
    }
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

    private ActionListener crearListener(){
        return e -> {
            PanelNotasCrear notasCrear = new PanelNotasCrear();
            PanelContenidos.innerSplit.setLeftComponent(new PanelBotonesNotasCrear(notasCrear));
            PanelContenidos.innerSplit.setDividerLocation(100);
            PanelContenidos.generalSplit.setLeftComponent(notasCrear);
            PanelContenidos.generalSplit.setDividerLocation(550);
        };
    }

    private ActionListener reproducirListener(){
        return e -> {
            PanelNotasReproducir panelReproducir = new PanelNotasReproducir();

            PanelContenidos.innerSplit.setLeftComponent(new PanelBotonesNotasReproducir(panelReproducir));
            PanelContenidos.generalSplit.setLeftComponent(panelReproducir);
        };
    }

    private ActionListener adivinarListener(){
        return e -> {
            PanelContenidos.innerSplit.setLeftComponent(new PanelBotonesNotasAdivinar());
            PanelContenidos.generalSplit.setLeftComponent(new PanelNotasAdivinar());
        };
    }

    private ActionListener salirListener(){
        return e -> {
            System.exit(0);
        };
    }
}
