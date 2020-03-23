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

    private int ballx = 740, bally = 490;
    private int score1 = 0;
    private int score2 = 0;

    private int dirx = 2;
    private int diry = 2;

    private int stage1 = -1;
    private int stage2 = -1;

    private String one, two;

    private int segmentlength = 75;

    public gameplay(){
        //setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        //t.setInitialDelay(100);
        t.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        try {
            g2D.fillOval(ballx, bally, 20, 20);
        } catch(Exception e){}
        finally {

            Rectangle pad1 = new Rectangle(10, pos1, padw, padh);
            Rectangle pad2 = new Rectangle(1470, pos2, padw, padh);

            g2D.setColor(Color.black);
            g2D.fill(pad1);
            g2D.fill(pad2);

            //Ellipse2D ball = new Ellipse2D.Double(ballx, bally, rad, rad);


            one = "Score 1: " + score1;
            two = "Score 2: " + score2;

            g2D.drawString(one, 650, 15);
            g2D.drawString(two, 800, 15);

            int t = 0;
            while(t+segmentlength<=1000){
                g2D.fillRect(750, t, 3, segmentlength);
                t+=2*segmentlength;
            }

            g.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // ball side walls
        if(bally<0 || bally + 20>1000){
            diry = -diry;
        }

        // left/right walls
        if(ballx<0){
            dirx = -dirx;
            score2++;
        }

        if(ballx + 20>1500){
            dirx = -dirx;
            score1++;
        }

        //left pad, the first pad
        if(ballx<= 25 && dirx<0){
            if(bally+10<=pos1+padh && bally+10>=pos1){
                dirx = -dirx;
            }
        }

        // right pad, the second pad
        if(ballx>=1470 && dirx>0){
            if(bally+10<pos2+padh && bally+10>=pos2){
                dirx = -dirx;
            }
        }
        ballx += dirx;
        bally += diry;

        //press key
        if(stage1 == 0){
            pos1 += (pos1<=840)?10:0;
        }else if(stage1 == 1){
            pos1 -= (pos1>=10)?10:0;
        }

        if(stage2 == 0){
            pos2 += (pos2<=840)?10:0;
        }else if(stage2 == 1){
            pos2 -= (pos2>=10)?10:0;
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
