import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class gameplay extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int score = 0;
    private int delay = 8;

    private Timer timer;

    private int player1Y = 500;
    private int player2Y = 500;

    private int ballposX = 350;
    private int ballposY = 120;
    private int balldirX = -1;
    private int balldirY = -2;

    private int segmentlength = 50;

    //control the paddles
    private int pa1 = -1;
    private int pa2 = -1;

    paddle1 player1 = new paddle1();
    paddle2 player2 = new paddle2();

    public gameplay(){

        setLocation(0,0);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){
        //backGround
        g.setColor(Color.black);
        g.fillRect(0,0,1500,1000);

        //player1
        g.setColor(Color.white);
        //g.fillRect(15, player1Y, 15, 150);

        //player2
        //g.fillRect(1470, player2Y, 15, 150);

        //ball
        g.fillOval(ballposX, ballposY, 15, 15);

        int temp = 0;
        while(temp+segmentlength<=1000){
            g.fillRect(749, temp, 2, segmentlength);
            temp += 2*segmentlength;
        }

        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        timer.start();
        repaint();
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {}
    @Override
    public void keyReleased(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        //if(keyEvent.getKeyCode() == KeyEvent.VK_UP){
        //    pa1 = 0;
        //    move1up();
        //}
        //else if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN)
        //{
        //    pa1 = 1;
         //   move1down();
        //}
        //if(keyEvent.getKeyCode() == KeyEvent.VK_W){
        //    move2up();
        //}
        //else if(keyEvent.getKeyCode() == KeyEvent.VK_S){
        //    move2down();
        //}
    }

    // control the paddles
    public void move1up(){
        if(player1Y<=10) move1down();
        else{
            player1Y-=10;
            //move1up();
        }
    }

    public void move1down(){

    }

    public void move2up(){
        if(player2Y<=10) move2down();
        else {
            player2Y -= 10;
            //move2up();
        }
    }

    public void move2down(){ }


}
