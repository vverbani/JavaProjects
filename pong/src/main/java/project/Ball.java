package pong;

public class Ball{

    //variables for the x and y positio
    private int xPos,yPos;

    public int dx = 5, dy = -5;

     
/*
* Sets ball middle of the screen
*/
    public Ball(){

        setPos(250, 140);

    }

     

    public void setPos(int x, int y){
        this.xPos = x;

        this.yPos = y;

    }
     
    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }
    //this is the method used to move the ball
    public void move(){
        //it takes the current x and y position, then adds their current
        //direction of movement to them, giving us a shift in the ball's
        //position in the applet
        setPos(this.getX() + dx, this.getY() + dy);
    }  
    //reset method for when the computer scores
    public void reset(){
        //the same initial setup as before
        setPos(250,140);
        dx = 5;
        dy = -5;
    }
}
