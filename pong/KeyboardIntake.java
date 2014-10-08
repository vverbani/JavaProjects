/*
* practicing getting input from keyboard
*/
package GUI;
/*
* first import handles the keyboard listener
* second import handles the jframe and pnael
*/
import java.awt.event.*;
import javax.swing.*;

public class KeyboardIntake extends JPanel
{

	public KeyboardIntake()
	{
			KeyListener listening = new KeyListener() 
			{
				@Override
				public void keyTyped(KeyEvent e)
				{

				}
				@Override
				public void keyPressed(KeyEvent e)
				{
					System.out.println("keypressed= " + KeyEvent.getKeyText(e.getKeyCode()));
				}
				@Override
				public void keyReleased(KeyEvent e)
				{
				System.out.println("keyReleased=" + KeyEvent.getKeyText(e.getKeyCode()));
				}

			};
			addKeyListener(listening);
			setFocusable(true);

	}
	public static void main(String[] args)
	{
			JFrame frame = new JFrame("Tennis?");
			KeyboardIntake keyboard = new KeyboardIntake();
			frame.add(keyboard);
			frame.setSize(200,200);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}