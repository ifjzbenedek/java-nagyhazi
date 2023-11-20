package Base;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame implements ActionListener {
    GamePanel gp = new GamePanel();
    JMenuItem newGame;
    JMenuItem loadGame;

    public MainFrame()
    {
        super("##Snake Battles##");

        this.setSize(800,800);

        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;


        this.setJMenuBar(Menu());

        this.add(gp);
    }

    public JMenuBar Menu()
    {
        JMenuBar menuBar = new JMenuBar();
        //menuBar.setSize(300, 100);
        JMenu menu = new JMenu("Játék");
        newGame = new JMenuItem("Új játék indítása: K", KeyEvent.VK_K);
        loadGame = new JMenuItem("Játék betöltése: L", KeyEvent.VK_L);

        newGame.addActionListener(this);
        loadGame.addActionListener(this);

        menuBar.add(menu);
        menu.add(newGame);
        menu.add(loadGame);
        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame)
        {
            System.out.println("newGame");
        }
        else
        {
            System.out.println("loadGame");
        }
    }

    void newGame()
    {

    }

    void saveGame()
    {

    }

    void LloadGame()
    {
        // Game game =

    }
}
