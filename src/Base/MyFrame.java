package Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MyFrame extends JFrame implements ActionListener {

    final Timer t;
    Game game = new Game();
    public MyFrame()
    {
        super("2 player Base.Snake");
        this.setSize(800,800);
        this.setResizable(true);
        this.setFocusable(true);
        t = new Timer(200,this);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                game.turnKeyPressesIntoInfos(e.getKeyCode());
            }
        });
        t.start();
    }

    private void DrawCoordinateArray(ArrayList<Coordinate> ac, Graphics g)
    {
        for(int i = 0; i < ac.size(); i++)
        {
            g.fillRect(ac.get(i).GetPosX()*40, ac.get(i).GetPosY()*40, 40,40);
        }
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        ArrayList<Coordinate> sTemp = game.getPlayer(0).getSnake().getCoordinates();
        g.setColor(Color.GREEN);
        DrawCoordinateArray(sTemp, g);

        g.setColor(Color.BLUE);
        sTemp = game.getPlayer(1).getSnake().getCoordinates();
        DrawCoordinateArray(sTemp, g);

        g.setColor(Color.DARK_GRAY);
        sTemp = game.getWalls();
        DrawCoordinateArray(sTemp, g);

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        game.Step();
        repaint();
    }
}
