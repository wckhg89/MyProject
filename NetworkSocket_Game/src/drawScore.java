import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class drawScore extends Canvas implements Runnable{


	private static final long serialVersionUID = 1L;
	private final int time = 20;

	int cnt;
	int valid;
	int location;
	
	public void getTurn(int a, int v, int b){
		cnt = a;
		valid  = v;
		location = b;
	}
	
	
	public void update(Graphics g)
	{
		Image img = (Toolkit.getDefaultToolkit()).getImage("goal.jpg");
		Image img2 =(Toolkit.getDefaultToolkit()).getImage("nullscore.jpg");
		Image img3 = (Toolkit.getDefaultToolkit()).getImage("nogoal.jpg");
		if( cnt == 0)
		{
			
			g.drawImage(img2, 0, 0, this);
		}	
		else{
			if( valid == 1)
			{
			
				g.drawImage(img, location, 0, this);
			}
			else
			{
			
				g.drawImage(img3,location,0,this);
			}
		}
		
	}
	
	public void run()
	{
		try
		{
			
			repaint();
			Thread.sleep(time);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
