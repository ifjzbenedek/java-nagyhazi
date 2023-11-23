package Base;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainFrame extends JFrame implements ActionListener {
    GamePanel gp;
    JMenuItem newGame;
    JMenuItem loadGame;

    public MainFrame()
    {
        super("##Snake Battles##");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(800,860);


        gp = new GamePanel();
        this.add(gp);

        this.setJMenuBar(Menu());
    }

    public JMenuBar Menu()
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Játék");
        newGame = new JMenuItem("Új játék indítása", KeyEvent.VK_K);
        loadGame = new JMenuItem("Játék betöltése", KeyEvent.VK_L);

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
            gp.newGame();

        }
        else
        {
            System.out.println("loadGame");
            gp.loadGame();
        }
    }
}
