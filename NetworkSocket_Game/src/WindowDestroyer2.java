import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sun.audio.*;

public class WindowDestroyer2 extends WindowAdapter {

	Mario_server tm;

	public static class Sound {
		private static Clip clip;

		public static synchronized void play(final String fileName) {
			// Note: use .wav files

			new Thread(new Runnable() {
				public void run() {
					try {
						clip = AudioSystem.getClip();
						AudioInputStream inputStream = AudioSystem
								.getAudioInputStream(new File(fileName));
						clip.open(inputStream);
						clip.start();

					} catch (Exception e) {
						System.out.println("play sound error: "
								+ e.getMessage() + " for " + fileName);
					}
				}
			}).start();
		}

		public static void stop() throws InterruptedException {
			clip.stop();
		}

	}

	public WindowDestroyer2(Mario_server tmpMario) {
		tm = tmpMario;
	}

	public void windowClosing(WindowEvent e) {
		final JFrame giveUp = new JFrame("���");
		JLabel giveUp_img = new JLabel();
		JPanel allButton = new JPanel();
		JButton button = new JButton();
		JButton button2 = new JButton();
		ImageIcon GU = new ImageIcon("flag.gif");
		ImageIcon ok = new ImageIcon("ok.jpg");
		ImageIcon ok_on = new ImageIcon("ok_on.jpg");
		ImageIcon cancle = new ImageIcon("cancle.jpg");
		ImageIcon cancle_on = new ImageIcon("cancle_on.jpg");
		Color bg = new Color(255, 255, 255);

		giveUp.setBackground(bg);
		giveUp_img.setIcon(GU);
		allButton.setBackground(bg);
		allButton.add(button);
		allButton.add(button2);

		button.setBackground(bg);
		button.setBorder(null);
		button.setIcon(ok);
		button.setRolloverIcon(ok_on);

		button2.setBackground(bg);
		button2.setBorder(null);
		button2.setIcon(cancle);
		button2.setRolloverIcon(cancle_on);

		giveUp.add(giveUp_img, BorderLayout.NORTH);
		giveUp.add(allButton, BorderLayout.SOUTH);

		giveUp.pack();
		giveUp.setVisible(true);

		button.addActionListener(new ActionListener() {
			/* ok��ư Ŭ���� ������� �¸� â�� ����.
			 * �׷��� �Ǹ� �ݴ�� �ڽ��ʿ��� �й�â�� �߸鼭 ���� �޽����� ��뿡�� ������
			 * ����� ����
			 */
			public void actionPerformed(ActionEvent e) {
				Sound.play("button.wav");
				tm.giveUpLose();
				giveUp.setVisible(false);
				// �й� �޼ҵ带 ȣ���մϴ�.
			}
		});
		button2.addActionListener(new ActionListener() {
			// ��ҹ�ư
			public void actionPerformed(ActionEvent e) {
				Sound.play("button.wav");
				giveUp.setVisible(false);
			}
		});

	}
}
