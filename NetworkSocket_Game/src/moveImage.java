import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class moveImage extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int time = 20;
	private final int fre = 100;
	
	private int cx ;
	private int cy;
	private int ex;
	private int ey;
	String direction = "";

	public void direction(String a)
	{
		direction = a;
	}
	public void setStartCoordinate(int x, int y ){
		cx = x;
		cy = y;
	}
	public void setEndCoordinate(int x, int y)
	{
		ex = x;
		ey = y;
	}
	public void paint(Graphics g)
	{
		Image img1 = (Toolkit.getDefaultToolkit()).getImage("¹è°æ.png");
		Image img2 = (Toolkit.getDefaultToolkit()).getImage("ball.gif");
		g.drawImage(img1, 10, 0, this);
		g.drawImage(img2, cx, cy, this);
	}
	public void run()
	{
		try
		{
			Thread.sleep(1000);
			if( direction.equals("center"))
			{
				while(cy >= ey)
				{
					//cx -= mx;
					cy -= 10;
					repaint();
					Thread.sleep(10);
				}
				cx = 180;
				cy = 330;
				//this will sleep and stop the ball for a moment.
				Thread.sleep(10000);
				repaint();

				//if you erase this statement, than you should press the button one more time to 
				//let the ball move to the starting point.
			}
			else if(direction.equals("left"))

			{
				while(cy >= ey)
				{
					cx -= 5;
					cy -= 15;
					repaint();
					Thread.sleep(time);
				}
				cx = 180;
				cy = 330;
				Thread.sleep(10000);
				repaint();
			}
			else if(direction.equals("right"))
			{
				while(cy >= ey)
				{
					cx += 5;
					cy -= 15;
					repaint();
					Thread.sleep(time);
				}
				cx = 180;
				cy = 330;
				Thread.sleep(10000);
				repaint();
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
