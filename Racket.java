package GUI;

import java.awt.*;
import java.awt.event.*;

public class Racket
{
	int x = 0;
	int xa = 0;

	private static final int Y = 450;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;

	private Game game;

	public Racket(Game game)
	{
		this.game = game;
	}

	public void move()
	{
		if ( x + xa > 0 && x + xa < game.getWidth()-60)
			x = x + xa;
	}
	public void paint(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(x,450,60,10);

	}
	public void keyReleased(KeyEvent e )
	{
		xa = 0;
	}

	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT) 
			xa = -2;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 2;
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x,Y,WIDTH,HEIGHT);
	}
	public int getTopY()
	{
		return this.Y;

	}
}