import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args){
        JFrame fr = new JFrame("Pong");
        gameplay pong = new gameplay();
        paddle1 controller1 = new paddle1();
        paddle2 controller2 = new paddle2();
        JLayeredPane first = new JLayeredPane();

        first.setBackground(Color.black);

        Point t = new Point(15, 0);
        first.setPosition(controller1, 1);
        first.setLocation(t);
        first.setSize(15, 1000);
        fr.setBackground(Color.white);
        fr.setBounds(0, 0, 1500, 1000);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayeredPane(first);
        //fr.add(pong);
        //fr.add(controller1);
        //fr.add(controller2);
    }
}
