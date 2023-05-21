import javax.swing.*;
import java.awt.*;

public class PanelContenidos extends JPanel {

    public static JSplitPane innerSplit;
    public static JSplitPane generalSplit;
    public PanelContenidos(){
        setLayout(new BorderLayout());
        init();
        setVisible(true);
    }
    private void init(){
        innerSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new PanelActividades(), new PanelBotones());
        innerSplit.setEnabled(false);
        innerSplit.setDividerLocation(60);
        generalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new PanelDibujo(), innerSplit);
        generalSplit.setEnabled(false);
        add(generalSplit);
    }
}
