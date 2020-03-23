import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class paddle1 extends JPanel implements ActionListener, KeyListener {
    private boolean play = false;
    private int pos = 500;
    private Timer timer;
    private int delay = 8;

    public paddle1(){
        setBounds(15, pos, 15, 150);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setBackground(Color.white);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){
        setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        timer.start();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_W){
            moveup();
        }else if(keyEvent.getKeyCode() == KeyEvent.VK_S){
            movedown();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public void moveup(){
        if(pos<=10){
            pos = 0;
        }else if(pos == 0){
            movedown();
        }else{
            pos-=10;
        }
    }

    public void movedown(){
        if(pos>=990){
            pos = 1000;
        }else if(pos == 1000){
            movedown();
        }else{
            pos+=10;
        }
    }
}
