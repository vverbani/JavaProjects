package GUI;

import java.awt.*;

public class Ball
{
	/*
	* these control the x and y position of the object
	*/
	int x = 0;
	int y = 0;
	/*
	* these control the speed of the object
	*/
	int xa = 1;
	int ya = 1;

	private int score;
	private Game game;
	private static final int DIAMETER = 30;

	public Ball(Game game)
	{

		this.game = game;
		this.score = 0;

	}

	public void move()
	{

		/*
		* xa = 1; 
		* xa = -1; 
		* ya = 1; 
		* ya = -1; 
		*/

		if(x + xa < 0) 
		xa = 1;
		
		if(x + xa > game.getWidth() - 30)
		xa = -1;
		
		if(y + ya < 0) 
		ya = 1;

		if(collision())
			{

			ya = -1;
			y = game.racket.getTopY() - DIAMETER;
			score++;
			
			}

		//crashes the program	
		if(score > 2 && score < 10)
		{
			xa =  xa +1 ;
			ya = ya + 1;
		}

		if(y + ya > game.getHeight() - DIAMETER) 
		game.gameOver();

		// testing to see if it crashes because it goes out of boundsS
		if( game.getHeight() < y && game.getWidth() < x )
			System.out.println("out of bounds bruh");
		x = x + xa;
		y = y + ya;

	}
	public void paint(Graphics2D g)
	{

		g.setColor(Color.RED);
		g.fillOval(x,y,30,30);


	}
	public boolean collision()
	{
		return game.racket.getBounds().intersects(getBounds());

	}
	public Rectangle getBounds()
	{
		return new Rectangle(x,y,DIAMETER,DIAMETER);

	}
	public int getScore()
	{
		return this.score;
	}
	public int getWidth()
	{
		return this.game.getWidth();
	}
}
