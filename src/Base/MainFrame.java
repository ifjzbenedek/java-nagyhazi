package Base;

import javax.swing.*;

public class MainFrame extends JFrame {
    GamePanel gp = new GamePanel();
    public MainFrame()
    {
        super("##Snake Battles##");
        this.setSize(800,800);
        this.add(gp);
    }
}
