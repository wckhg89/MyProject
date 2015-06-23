import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Help extends JFrame{

	public Help()
	{
		Container contentPane = getContentPane();
		JLabel rule = new JLabel();
		ImageIcon img = new ImageIcon("gamerule.png");
		contentPane.setBackground(Color.BLACK);
		rule.setIcon(img);
		contentPane.add(rule);
		setSize(350,400);
	}
}
