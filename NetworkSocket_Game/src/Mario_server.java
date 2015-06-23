import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mario_server extends JFrame implements Runnable {
	static BufferedReader in;
	static PrintWriter out;
	int count = 0;
	static int port;
	static String name;
	static String shootPos = "0";
	static boolean client_on = false;
	static boolean server_on = false;

	private Thread t;
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 420;
	public static final int HEIGHT = 650;
	private moveImage mv;
	private moveKeeper mk;
	private drawScore ds;

	JPanel button;
	static JButton left;
	static JButton center;
	static JButton right;
	JPanel crowds;
	JPanel goal;
	JPanel kick;
	JPanel one;
	JPanel two;
	Container contentPane;

	int tempx = 10;
	int turn = 0;

	int kicked;
	int blocked;

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

	public Mario_server(int tmpPort, String tmpName) {
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		ImageIcon leftB = new ImageIcon("leftB.png");
		ImageIcon centerB = new ImageIcon("centerB.png");
		ImageIcon rightB = new ImageIcon("rightB.png");
		ImageIcon leftB_on = new ImageIcon("leftB_on.png");
		ImageIcon centerB_on = new ImageIcon("centerB_on.png");
		ImageIcon rightB_on = new ImageIcon("rightB_on.png");

		button = new JPanel();
		left = new JButton();
		center = new JButton();
		right = new JButton();

		one = new JPanel(new GridLayout(2, 1));
		two = new JPanel(new GridLayout(3, 1));
		contentPane = getContentPane();

		port = tmpPort;
		name = tmpName;
		setSize(WIDTH, HEIGHT);
		addWindowListener(new WindowDestroyer2(this));
		setTitle(name + "님 승리하세요!");

		contentPane.setLayout(new BorderLayout());

		final Image c1 = (Toolkit.getDefaultToolkit()).getImage("m1_g.gif");
		final Image c2 = (Toolkit.getDefaultToolkit()).getImage("m2_g.gif");
		final Image c3 = (Toolkit.getDefaultToolkit()).getImage("m3_g.gif");
		// 버섯이미지
		crowds = new JPanel() {
			public void paintComponent(Graphics g) {
				g.clearRect(0, 0, 400, 50);
				g.drawImage(c1, 0, 0, this);
				g.drawImage(c2, 25, 0, this);
				g.drawImage(c3, 50, 0, this);
				g.drawImage(c1, 75, 0, this);
				g.drawImage(c2, 100, 0, this);
				g.drawImage(c3, 125, 0, this);
				g.drawImage(c1, 150, 0, this);
				g.drawImage(c2, 175, 0, this);
				g.drawImage(c3, 200, 0, this);
				g.drawImage(c1, 225, 0, this);
				g.drawImage(c2, 250, 0, this);
				g.drawImage(c3, 275, 0, this);
				g.drawImage(c1, 300, 0, this);
				g.drawImage(c2, 325, 0, this);
				g.drawImage(c3, 350, 0, this);
				g.drawImage(c1, 375, 0, this);
				g.drawImage(c3, 0, 25, this);
				g.drawImage(c2, 25, 25, this);
				g.drawImage(c1, 50, 25, this);
				g.drawImage(c3, 75, 25, this);
				g.drawImage(c2, 100, 25, this);
				g.drawImage(c1, 125, 25, this);
				g.drawImage(c3, 150, 25, this);
				g.drawImage(c2, 175, 25, this);
				g.drawImage(c1, 200, 25, this);
				g.drawImage(c3, 225, 25, this);
				g.drawImage(c2, 250, 25, this);
				g.drawImage(c1, 275, 25, this);
				g.drawImage(c3, 300, 25, this);
				g.drawImage(c2, 325, 25, this);
				g.drawImage(c1, 350, 25, this);
				g.drawImage(c3, 375, 25, this);

			}
		};
		crowds.setPreferredSize(new Dimension(400, 50));
		final Image goalPost = (Toolkit.getDefaultToolkit()).getImage("골대.PNG");
		// 골대 이미지
		final Image keeper = (Toolkit.getDefaultToolkit()).getImage("b.gif");
		// 골키퍼 이미지

		goal = new JPanel(new BorderLayout()) {
			public void paintComponent(Graphics g) {
				g.clearRect(0, 0, 400, 50);
				g.drawImage(goalPost, 40, 0, this);
			}
		};

		mk = new moveKeeper();
		mk.setStartCoordinate(170, 0);

		goal.add(mk);
		goal.setPreferredSize(new Dimension(400, 50));
		// in panel one there is a crowd and a goal post.

		one.add(crowds);
		one.add(goal);
		// this area the ball is going to fly.

		// area.setPreferredSize(new Dimension(500,300));

		// this is a panel that hold the button
		// 여기서 크기 지정해주는게 .누르고 setbounds로 하면 크기가 지정됨.

		button.setPreferredSize(new Dimension(400, 50));

		// this is a panel where mario is standing.
		// adding kicker.
		final Image kicker = (Toolkit.getDefaultToolkit())
				.getImage("kickMario.gif");
		// JLayeredPane jp2 = new JLayeredPane();
		kick = new JPanel() {
			public void paintComponent(Graphics g) {
				g.clearRect(0, 0, 400, 50);
				g.drawImage(kicker, 170, 0, this);
			}
		};
		kick.setPreferredSize(new Dimension(400, 50));

		left.setBackground(Color.white);
		center.setBackground(Color.white);
		right.setBackground(Color.white);
		left.setBorder(null);
		right.setBorder(null);
		center.setBorder(null);

		left.setIcon(leftB);
		center.setIcon(centerB);
		right.setIcon(rightB);
		left.setRolloverIcon(leftB_on);
		center.setRolloverIcon(centerB_on);
		right.setRolloverIcon(rightB_on);

		// this is a part that wil layoyt each panels.
		crowds.setBackground(Color.WHITE);
		goal.setBackground(Color.white);

		kick.setBackground(Color.white);

		button.setBackground(Color.white);

		button.add(left);
		button.add(center);
		button.add(right);
		contentPane.setBackground(Color.WHITE);

		two.add(button);
		two.add(kick);

		mv = new moveImage();
		mv.setStartCoordinate(180, 330);
		mv.setEndCoordinate(180, 5);
		contentPane.add(mv);

		final Image scoreBoard = (Toolkit.getDefaultToolkit())
				.getImage("점수판.jpg");
		JPanel score;
		score = new JPanel(new BorderLayout()) {
			public void paintComponent(Graphics g) {
				g.clearRect(0, 0, 400, 50);
				g.drawImage(scoreBoard, 40, 0, this);
			}
		};
		ds = new drawScore();
		score.add(ds);
		score.setBackground(Color.WHITE);
		score.setPreferredSize(new Dimension(400, 50));

		two.add(score);
		contentPane.add(one, BorderLayout.NORTH);
		contentPane.add(two, BorderLayout.SOUTH);

		left.addActionListener(new ActionListener() {
			// 왼쪽버튼 클릭시 액션
			public void actionPerformed(ActionEvent e) {

				shootPos = "1";
				out.println(shootPos);
				kicked = 1;
				left.setVisible(false);
				right.setVisible(false);
				center.setVisible(false);
			}
		});
		center.addActionListener(new ActionListener() {
			// 가운데버튼 클릭시 액션
			public void actionPerformed(ActionEvent e) {
				shootPos = "2";
				out.println(shootPos);
				kicked = 2;
				left.setVisible(false);
				right.setVisible(false);
				center.setVisible(false);
			}
		});
		right.addActionListener(new ActionListener() {
			// 오른쪽버튼 클릭시 액션
			public void actionPerformed(ActionEvent e) {
				shootPos = "3";
				out.println(shootPos);
				kicked = 3;
				left.setVisible(false);
				right.setVisible(false);
				center.setVisible(false);
			}
		});

	}

	public void showScore(int keeper, int kicker) {
		turn++;
		if (keeper == kicker) {
			ds.getTurn(turn, 0, tempx);
			new Thread(ds).start();

		} else {
			ds.getTurn(turn, 1, tempx);
			new Thread(ds).start();
		}
		tempx += 80;
	}

	static public void win() {
		/*
		 * 게임에 승리했을때, 나타나는 팝업창 메소드
		 */
		JFrame goalPopup = new JFrame("승리");
		JLabel goalImg = new JLabel();

		ImageIcon img = new ImageIcon("win.gif");
		Color bg = new Color(255, 255, 255);

		goalImg.setIcon(img);
		goalImg.setBackground(bg);

		goalPopup.add(goalImg, BorderLayout.NORTH);

		goalPopup.setBounds(400, 400, 0, 0);
		goalPopup.setVisible(true);
		goalPopup.pack();

		left.setVisible(false);
		right.setVisible(false);
		center.setVisible(false);
		Sound.play("win.wav");
		out.println("shoot " + "LOSE");
		try {

			TimeUnit.SECONDS.sleep(7);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		goalPopup.setVisible(false);
		Client.WinnerSignal(name);

	}

	public void lose() {
		/*
		 * 게임에 패배했을때, 나타나는 팝업창 메소드
		 */
		JFrame goalPopup = new JFrame("패배");
		JLabel goalImg = new JLabel();
		ImageIcon img = new ImageIcon("lose.gif");
		Color bg = new Color(255, 255, 255);

		goalImg.setIcon(img);
		goalImg.setBackground(bg);

		goalPopup.add(goalImg, BorderLayout.NORTH);

		goalPopup.setBounds(450, 150, 0, 0);
		goalPopup.setVisible(true);
		goalPopup.pack();

		left.setVisible(false);
		right.setVisible(false);
		center.setVisible(false);
		Sound.play("lose.wav");
		try {

			TimeUnit.SECONDS.sleep(7);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		goalPopup.setVisible(false);
		Client.LoserSignal(name);

		out.println("shoot " + "EXIT");
	}

	public void giveUpLose() {
		/*
		 * 기권하였을때
		 */
		out.println("shoot " + "WIN");
	}

	public void goal() {
		/*
		 * 골인에 성공했을때, 나타나는 팝업 메소드
		 */
		JFrame goalPopup = new JFrame("골인");
		JLabel goalImg = new JLabel();

		ImageIcon img = new ImageIcon("goal.gif");
		Color bg = new Color(255, 255, 255);

		goalImg.setIcon(img);
		goalImg.setBackground(bg);

		goalPopup.add(goalImg);
		goalPopup.setBounds(450, 150, 0, 0);
		goalPopup.setVisible(true);
		goalPopup.pack();
		left.setVisible(false);
		right.setVisible(false);
		center.setVisible(false);
		Sound.play("goalin.wav");
		try {

			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		goalPopup.setVisible(false);
		left.setVisible(true);
		right.setVisible(true);
		center.setVisible(true);
	}

	public void noGoal() {
		/*
		 * 골인에 실패했을때, 나타나는 팝업 메소드
		 */
		JFrame goalPopup = new JFrame("노골");
		JLabel goalImg = new JLabel();

		ImageIcon img = new ImageIcon("nogoal.gif");
		Color bg = new Color(255, 255, 255);

		goalImg.setIcon(img);
		goalImg.setBackground(bg);

		goalPopup.add(goalImg);
		goalPopup.setBounds(450, 150, 0, 0);
		goalPopup.setVisible(true);
		goalPopup.pack();
		left.setVisible(false);
		right.setVisible(false);
		center.setVisible(false);
		Sound.play("nogoalin.wav");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		goalPopup.setVisible(false);
		left.setVisible(true);
		right.setVisible(true);
		center.setVisible(true);
	}

	//이 부분은 골키퍼의 움직음을 받아 키퍼를 움직이게 하는 메소드입니다. 
	public void moveKeeper(int keepermove, int ballmove) {
		if (keepermove == 1) {
			mk.direction("left");
			mk.setEndCoordinate(50, 0);
			new Thread(mk).start();
			try {
				new Thread(mk).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (keepermove == 2) {
			mk.direction("center");
			mk.setEndCoordinate(170, 0);
			new Thread(mk).start();
			try {
				new Thread(mk).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			mk.direction("right");
			mk.setEndCoordinate(300, 0);
			new Thread(mk).start();
			try {
				new Thread(mk).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void moveBall(int keeperMove, int ballMove) {
		if (ballMove == 1) {
			mv.direction("left");
			new Thread(mv).start();
			try {
				new Thread(mv).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (ballMove == 2) {
			mv.direction("center");
			new Thread(mv).start();
			try {
				new Thread(mv).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			mv.direction("right");
			new Thread(mv).start();
			try {
				new Thread(mv).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void run() {
		try {
			ServerSocket welcomeSocket = new ServerSocket(port);
			// 채팅을 위한 'server'소켓을 연다.

			Socket connectionSocket = welcomeSocket.accept();
			// 연결소켓을 만들어 대화상대의 연결을 기다린다.
			in = new BufferedReader(new InputStreamReader(
					connectionSocket.getInputStream()));
			out = new PrintWriter(connectionSocket.getOutputStream(), true);
			// 스트림을 열어준다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Game Server start..\n ");
		System.out.println(port);
		try {
			while (true) {
				String line = in.readLine();

				left.setVisible(true);
				right.setVisible(true);
				center.setVisible(true);

				if (line.startsWith("defence")) {
					if (line.substring(8).equals(shootPos)) {
						/*
						 * 만일 슛한 포지션이 골키퍼가 막은 포지션과 일치하면
						 * 노골로 처리합니다.
						 */
						blocked = Integer.parseInt(line.substring(8));
						moveKeeper(blocked, kicked);
						moveBall(blocked, kicked);
						out.println("shoot " + shootPos);
						try {
							TimeUnit.SECONDS.sleep(2);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						noGoal();
						showScore(Integer.parseInt(shootPos),
								Integer.parseInt(line.substring(8)));
						shootPos = "0";
					} else if (line.substring(8).equals("EXIT")) {
						/*
						 * 게임 종료시 클라이언트(로비창)에게 종료 신호를 준후에,
						 * 게임 상대에게도 종료 메시지를 보내줍니다.
						 */
						shootPos = "0";
						count = 0;
						if (this.server_on == true) {
							Client_Server.ExitGameSignal();
						}
						if (this.client_on == true) {
							Client_Client.ExitGameSignal();
						}
						this.server_on = false;
						this.client_on = false;
						out.println("shoot " + "EXIT");
						this.dispose();
						return;
					} else if (line.substring(8).equals("LOSE")) {
						/*
						 * 게임에 패배했을때
						 */
						lose();
					} else if (line.substring(8).equals("WIN")) {
						/*
						 * 게임에 승리했을때
						 */
						win();
					} else {
						/*
						 * 골인에 성공했을때,
						 */
						blocked = Integer.parseInt(line.substring(8));
						moveKeeper(blocked, kicked);
						moveBall(blocked, kicked);
						out.println("shoot " + shootPos);
						try {

							TimeUnit.SECONDS.sleep(2);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						goal();
						showScore(Integer.parseInt(shootPos),
								Integer.parseInt(line.substring(8)));
						count++;
						if (count == 3) {
							//세번 골인에 성공하면 승리합니다.
							win();
						}
						shootPos = "0";
					}
				}

			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/*public static void main(String[] args) {
		Mario_server m = new Mario_server(100, "b");
		m.setVisible(true);
		m.run();
	}*/

}
