package pong;
	
import java.applet.*;

import java.awt.event.*;

import java.awt.*;

import javax.swing.Timer;

public class MainPong extends Applet implements MouseMotionListener, ActionListener

{

     Ball ball;

     PaddleLeft pLeft;

     PaddleRight pRight;

     Font newFont = new Font("sansserif", Font.BOLD, 20);

     Graphics bufferGraphics;

     Image offscreen;

     final int WIDTH = 500, HEIGHT = 300;

     long currentTime;

     public void init() 

     {

          setSize(500, 300);

          ball = new Ball();

          pLeft = new PaddleLeft();

          pRight = new PaddleRight(ball.getY() - 35);

          addMouseMotionListener(this);

          setBackground(Color.green);

          offscreen = createImage(WIDTH,HEIGHT);

          bufferGraphics = offscreen.getGraphics();

     }

     public void start(){

         currentTime = System.currentTimeMillis();

         Timer time = new Timer(15, this);    

         time.start();

         while(pRight.getScore() < 10){

         }

         time.stop();

         currentTime = System.currentTimeMillis() - currentTime;

         repaint();

     }

     public void stop(){

     }

      public void paint(Graphics g) 

     {

          bufferGraphics.clearRect(0,0,WIDTH,HEIGHT);

          bufferGraphics.setColor(Color.blue);

          bufferGraphics.fillRect(pLeft.XPOS,pLeft.getPos(),10,70);

          bufferGraphics.fillRect(pRight.XPOS, pRight.getPos(),10,70);

          bufferGraphics.setColor(Color.white);

          bufferGraphics.setFont(newFont);

          bufferGraphics.drawString("Futile", 150, 15);

          bufferGraphics.drawString(""+ pRight.getScore(),300,15);

          bufferGraphics.fillRect(240,0,20,300);

          if(pRight.getScore() == 10){

              bufferGraphics.drawString("You Lasted: " + (currentTime/ 1000) + "sec.", 40, 150);

          }

          bufferGraphics.setColor(Color.red);

          bufferGraphics.fillRect(ball.getX(),ball.getY(),10,10);

          g.drawImage(offscreen,0,0,this);


          Toolkit.getDefaultToolkit().sync();

     }

     public void update(Graphics g)

     {

          paint(g);

     }

     public void mouseMoved(MouseEvent evt) 

     {

          pLeft.setPos(evt.getY()- 35);

     }

     public void mouseDragged(MouseEvent evt) 

     {

     }

     public void checkCollision(){


        if(ball.getY() == 0 || ball.getY() == 290){

            ball.dy = (ball.dy * -1);

        }

        if((ball.getX() == 40) && hitPaddle()){

            ball.dx = (ball.dx * -1);

        }

        if(ball.getX() == 460){

            ball.dx = (ball.dx * -1);

        }


        //if the ball is missed by the human paddle and reaches the

        //left-hand edge of the applet window, then reset the ball

        //and increment the score

        if(ball.getX() == 0){

            pRight.setScore(pRight.getScore() + 1);

            ball.reset();

        }

     }

      

     public boolean hitPaddle(){

         boolean didHit = false;

         //this just checks if the ball is lined up between the top and

         //bottom right-hand corners of the human paddle

         if((pLeft.getPos() - 10) <= ball.getY() && (pLeft.getPos() + 70) > ball.getY()){

             //sets didHit to true

             didHit = true;

         }

      return didHit;

     }

 

    @Override

    //every 15 milliseconds, the Timer time triggers the

    //actionPerformed method

    public void actionPerformed(ActionEvent arg0) {

         //moves the ball

         ball.move();

         //lines the computer paddle up with the ball
         int bally = ball.getY();
        
         pRight.setPos(bally - 35);

         //checks the ball for a collision

         checkCollision();

         //repaints the applet

         repaint();

    }

 

 }
