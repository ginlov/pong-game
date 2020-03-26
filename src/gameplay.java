import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

public class gameplay extends JPanel implements KeyListener, ActionListener {

    private Timer t = new Timer(5, this);
    private int pos1 = 500;
    private int pos2 = 500;
    private int padh = 150;
    private int padw = 15;
    private int speed = 5;

    private int ballsize = 20;
    private int ballx, bally;
    private int score1;
    private int score2;

    private int dirx = 2;
    private int diry = 2;

    private int stage1 = -1;
    private int stage2 = -1;

    private int padding = 15;

    private String one, two;

    private int segmentlength;
    private int width, height;

    public gameplay(){

        //setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        //t.setInitialDelay(100);
        score1 = 0;
        score2 = 0;
        t.start();
    }

    int test = 1;
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        if(test == 1) {
            width = (int)getWidth();
            height = (int)getHeight();
            test = 0;
            ballx = (int)width/2;
            bally = (int)height/2;
            segmentlength = (int) (height/9);
        }

        if(score1<10 && score2<10) {


            try {
                g2D.fillOval(ballx, bally, ballsize, ballsize);
            } catch (Exception e) {
            } finally {

                Rectangle pad1 = new Rectangle(padding, pos1, padw, padh);
                Rectangle pad2 = new Rectangle(width-padding - padw, pos2, padw, padh);

                g2D.setColor(Color.black);
                g2D.fill(pad1);
                g2D.fill(pad2);

                //Ellipse2D ball = new Ellipse2D.Double(ballx, bally, rad, rad);


                one = "Score 1: " + score1;
                two = "Score 2: " + score2;

                g2D.drawString(one, 650, 15);
                g2D.drawString(two, 800, 15);

                int t = 0;
                while (t + segmentlength <= height) {
                    g2D.fillRect(width/2, t, 3, segmentlength);
                    t += 2 * segmentlength;
                }
                
                g.dispose();
            }
        }
        else if(score1 == 10){
            g2D.drawString("Player1 Win!!", 700, 500);
        }
        else if(score2 == 10){
            g2D.drawString("Player2 Win!!", 700, 500);
        }
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // ball side walls
        if(bally<0 || bally + ballsize>=height){
            diry = -diry;
        }

        // left/right walls
        if(ballx<0){
            dirx = -dirx;
            score2++;
        }

        if(ballx + ballsize >= width){
            dirx = -dirx;
            score1++;
        }

        //left pad, the first pad
        if(ballx<= padding+padw && dirx<0){
            if(bally<=pos1+padh && bally+ballsize>=pos1){
                dirx = -dirx;
            }
        }

        // right pad, the second pad
        if(ballx>=width-ballsize-padding-padw && dirx>0){
            if(bally<pos2+padh && bally+ballsize>=pos2){
                dirx = -dirx;
            }
        }
        ballx += dirx;
        bally += diry;

        //press key
        if(stage1 == 0){
            pos1 += (pos1<=height-speed-padh)?speed:0;
        }else if(stage1 == 1){
            pos1 -= (pos1>=speed)?speed:0;
        }

        if(stage2 == 0){
            pos2 += (pos2<=height-speed-padh)?speed:0;
        }else if(stage2 == 1){
            pos2 -= (pos2>=speed)?speed:0;
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_S){
            stage1 = 0;
        }
        else if(keyEvent.getKeyCode() == KeyEvent.VK_W){
            stage1 = 1;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN){
            stage2 = 0;
        }else if(keyEvent.getKeyCode() == KeyEvent.VK_UP){
            stage2 = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_S){
            stage1 = -1;
        }
        else if(keyEvent.getKeyCode() == KeyEvent.VK_W){
            stage1 = -1;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN){
            stage2 = -1;
        }else if(keyEvent.getKeyCode() == KeyEvent.VK_UP){
            stage2 = -1;
        }
    }
}
