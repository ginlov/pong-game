import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args){
        JFrame fr = new JFrame("Pong");
        gameplay  game = new gameplay();

        fr.setSize(1500, 1000);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        fr.add(game);
        fr.setContentPane(game);
    }
}
