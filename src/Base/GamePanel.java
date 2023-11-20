package Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {

    final Timer t;

    Game game = new Game();

    public GamePanel()
    {
        this.setSize(800,800);
        this.setFocusable(true);
        t = new Timer(20,this);
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
    private void DrawCoordinate(Coordinate ac, Graphics g)
    {
        g.fillRect(ac.GetPosX()*40, ac.GetPosY()*40, 40,40);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        ArrayList<Coordinate> sTemp = game.getPlayer(0).getSnake().getCoordinates();
        g.setColor(Color.GREEN);
        DrawCoordinateArray(sTemp, g);

        g.setColor(Color.BLUE);
        sTemp = game.getPlayer(1).getSnake().getCoordinates();
        DrawCoordinateArray(sTemp, g);

        g.setColor(Color.DARK_GRAY);
        sTemp = game.getWalls();
        DrawCoordinateArray(sTemp, g);


        for(int i = 0; i < game.getItems().size(); i++)
        {
            if(game.getItems().get(i).getName().equals("apple"))
            {
                g.setColor(Color.RED);
                DrawCoordinate(game.getItems().get(i).getCoordinates(),g);
            }
            else if(game.getItems().get(i).getName().equals("lemon"))
            {
                g.setColor(Color.YELLOW);
                DrawCoordinate(game.getItems().get(i).getCoordinates(),g);
            }
            else if(game.getItems().get(i).getName().equals("blueberry"))
            {
                g.setColor(Color.BLUE);
                DrawCoordinate(game.getItems().get(i).getCoordinates(),g);
            }
            else if(game.getItems().get(i).getName().equals("orange"))
            {
                g.setColor(Color.ORANGE);
                DrawCoordinate(game.getItems().get(i).getCoordinates(),g);
            }
            else if(game.getItems().get(i).getName().equals("kiwi"))
            {
                g.setColor(Color.GREEN);
                DrawCoordinate(game.getItems().get(i).getCoordinates(),g);
            }
            else if(game.getItems().get(i).getName().equals("raspberry"))
            {
                g.setColor(Color.PINK);
                DrawCoordinate(game.getItems().get(i).getCoordinates(),g);
            }
        }
    }




    @Override
    public void actionPerformed(ActionEvent e)
    {
        game.Step();
        repaint();
    }
}
