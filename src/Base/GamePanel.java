package Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {

    final Timer timer;

    boolean isRunning = false;
    private Game game;

    public GamePanel()
    {
        setFocusable(true);

        initGamePanel();
        timer = new Timer(20,this);
        timer.start();
    }

    public void newGame()
    {
        game = new Game();
        isRunning = true;
    }

    public void loadGame()
    {

        try {
            FileInputStream f = new FileInputStream("mentes.txt");
            ObjectInputStream in = new ObjectInputStream(f);
            game = (Game)in.readObject();
            isRunning = true;

        }catch (IOException ex){}catch(ClassNotFoundException ex){}
    }

    private void initGamePanel()
    {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                onKeyPressed(e.getKeyCode());
            }
        });
    }

    private void onKeyPressed(int keyCode)
    {
        game.turnKeyPressesIntoInfos(keyCode);
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
        if(isRunning) {
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


            for (int i = 0; i < game.getItems().size(); i++) {
                if (game.getItems().get(i).getName().equals("apple")) {
                    g.setColor(Color.RED);
                    DrawCoordinate(game.getItems().get(i).getCoordinates(), g);
                } else if (game.getItems().get(i).getName().equals("lemon")) {
                    g.setColor(Color.YELLOW);
                    DrawCoordinate(game.getItems().get(i).getCoordinates(), g);
                } else if (game.getItems().get(i).getName().equals("blueberry")) {
                    g.setColor(Color.BLUE);
                    DrawCoordinate(game.getItems().get(i).getCoordinates(), g);
                } else if (game.getItems().get(i).getName().equals("orange")) {
                    g.setColor(Color.ORANGE);
                    DrawCoordinate(game.getItems().get(i).getCoordinates(), g);
                } else if (game.getItems().get(i).getName().equals("kiwi")) {
                    g.setColor(Color.GREEN);
                    DrawCoordinate(game.getItems().get(i).getCoordinates(), g);
                } else if (game.getItems().get(i).getName().equals("raspberry")) {
                    g.setColor(Color.PINK);
                    DrawCoordinate(game.getItems().get(i).getCoordinates(), g);
                }
            }
        }
    }

    private void saveGame()
    {
        try{
            FileOutputStream f = new FileOutputStream("mentes.txt");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(game);
            out.close();
        }catch( IOException ex){}
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(isRunning)
        {
            game.Step();
            saveGame();
            repaint();
        }
    }

}
