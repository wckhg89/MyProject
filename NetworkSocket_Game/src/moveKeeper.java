import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class moveKeeper extends Canvas implements Runnable{


	private static final long serialVersionUID = 1L;
	private final int time = 20;

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
		Image img = null;
		Image goalPost = (Toolkit.getDefaultToolkit()).getImage("°ñ´ë.PNG");

		if(direction.equals("right"))
		{
			img = (Toolkit.getDefaultToolkit()).getImage("keeprerR.gif");
		}
		
		else if(direction.equals("left"))
		{
			img = (Toolkit.getDefaultToolkit()).getImage("keeperL.gif");
		}
		else if(direction.equals("center"))
		{
			img = (Toolkit.getDefaultToolkit()).getImage("b.gif");

		}
		else if( direction.equals("reset"))
		{
			img = (Toolkit.getDefaultToolkit()).getImage("b.gif");
		}
		else
		{
			img = (Toolkit.getDefaultToolkit()).getImage("b.gif");
		}
		
		g.drawImage(goalPost, 40, 0, this);
		g.drawImage(img, cx, cy, this);
	}
	public void run()
	{
		try
		{
			if( direction.equals("center"))
			{
				Thread.sleep(1000);
				while(cx >= ex)
				{
					cx -= 5;
					repaint();
					Thread.sleep(time);
					
				}
			}

			else if(direction.equals("left"))

			{
				Thread.sleep(1000);
				while(cx >= ex)
				{
					cx -= 5;
					repaint();
					Thread.sleep(time);
				
				}
				cx = 170;
				direction = "reset";
				Thread.sleep(10000);
				repaint();
			}
			else if(direction.equals("right"))
			{
				Thread.sleep(1000);
				while(cx <= ex)
				{
					cx += 5;
					repaint();
					Thread.sleep(time);
					
				}
				cx = 170;
				direction = "reset";
				Thread.sleep(10000);
				repaint();

			}

		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
