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

        this.setSize(800,800);

        gp = new GamePanel();
        this.add(gp);

        this.setJMenuBar(Menu());
    }

    public JMenuBar Menu()
    {
        JMenuBar menuBar = new JMenuBar();
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
            newGame();

        }
        else
        {
            System.out.println("loadGame");
            loadGame();
        }
    }

    private void newGame()
    {
    }



    private void loadGame()
    {
        Game g;
        try {
            FileInputStream f = new FileInputStream("mentes.txt");
            ObjectInputStream in = new ObjectInputStream(f);
            g = (Game)in.readObject();
            in.close();

            gp = new GamePanel();
            this.add(gp);
            gp.setGame(g);

        }catch (IOException ex){}catch(ClassNotFoundException ex){}
    }
}
