
/*
* Getting familiar with a game GUI
*/
package GUI;
/*
* importing Jframe
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

public class Game extends JPanel
{
	
	Ball ball = new Ball(this);
	Racket racket = new Racket(this);

	public Game()
	{
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e ){

			}
			@Override
			public void keyReleased(KeyEvent e)
			{
				racket.keyReleased(e);
			}
			@Override
			public void keyPressed(KeyEvent e)
			{
				racket.keyPressed(e);

			}
		});
		setFocusable(true);
	}
	private void move()
	{
		ball.move();
		racket.move();
	}

	@Override
	public void paint(Graphics g)
	{

		/*
		* the super.paint(g) clears the screen 
		*/
		super.paint(g);
		/*
		* increment the score on the screen
		*/
		
		//g.setColor(Color.RED);
		g.drawString("Score:" + ball.getScore(), ball.getWidth() - 50, 10);
		
		Graphics2D graphics = (Graphics2D) g;
		/*
		* renderingHint makes the border of the figures smoother
		*/
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
									RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(graphics);
		racket.paint(graphics);
	
	}
	/*
	*main method for testing the Jframe
	*/
	public void gameOver()
	{
		JOptionPane.showMessageDialog(this,"Game Over", "Game Over",
										JOptionPane.YES_NO_OPTION);
	}
	public static void main(String[] args) throws InterruptedException
	{
		/*
		* create new frame with specific sizes
		* make it visible
		* if x is pressed, close program
		*/
		JFrame jframe = new JFrame("First Game");
		Game game = new Game();
		jframe.add(game);
		jframe.setSize(500,500);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		while(true)
		{
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}


}