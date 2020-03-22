import javax.swing.*;

public class main {
    public static void main(String[] args){
        JFrame fr = new JFrame("Pong");
        gameplay pong = new gameplay();
        fr.setBounds(0, 0, 1500, 1000);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.add(pong);
    }
}
