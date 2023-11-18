package Base;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    final Timer t;
    public MyFrame()
    {
        super("2 player Base.Snake");
        this.setSize(400,400);
        this.setResizable(true);
        t = new Timer(20,this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
