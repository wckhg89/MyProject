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



public class Mario_client extends JFrame implements Runnable {

	static BufferedReader in;
	// 1:1채팅시 사용되는 'inputStream'
	static PrintWriter out;
	// 1:1채팅시 사용되는 'outputStream'
	static String IP;
	// 자신의 컴퓨터 IP주소
	static int port;
	// 1:1 채팅 전용 소켓
	static String name;
	static String defPos = "0";
	static boolean client_on = false;
	static boolean server_on = false;

	private Thread t;
	int count = 0;
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 420;
	public static final int HEIGHT = 650;
	private moveImage mv;
	private moveKeeper mk;
	private drawScore ds;

	ImageIcon leftB;
	ImageIcon centerB;
	ImageIcon rightB;
	ImageIcon leftB_on;
	ImageIcon centerB_on;
	ImageIcon rightB_on;

	static JButton left;
	static JButton center;
	static JButton right;

	JPanel goal;
	JPanel button;
	JPanel kick;
	JPanel crowds;
	// 골키퍼,버튼, 키커, 관중
	JPanel one;
	JPanel two;
	// 골키퍼,버튼, 키커, 관중 붙일 패널
	Container contentPane;
	// 모두를 붙일 컨테이너

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
	
	public Mario_client(String tmpIP, int tmpPort, String tmpName) {
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		IP = tmpIP;
		port = tmpPort;
		name = tmpName;

		leftB = new ImageIcon("leftB_c.png");
		centerB = new ImageIcon("centerB_c.png");
		rightB = new ImageIcon("rightB_c.png");
		leftB_on = new ImageIcon("leftB_c_on.png");
		centerB_on = new ImageIcon("centerB_c_on.png");
		rightB_on = new ImageIcon("rightB_c_on.png");

		left = new JButton();
		center = new JButton();
		right = new JButton();

		JPanel button = new JPanel();

		// 골키퍼,버튼, 키커, 관중
		JPanel one = new JPanel(new GridLayout(2, 1));
		JPanel two = new JPanel(new GridLayout(3, 1));
		// 골키퍼,버튼, 키커, 관중 붙일 패널
		Container contentPane = getContentPane();

		setSize(WIDTH, HEIGHT);
		addWindowListener(new WindowDestroyer(this));
		setTitle(name + "님 승리하세요!");
		contentPane.setLayout(new BorderLayout());

		// // = new JPanel();

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
		// adding a goal post.
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

		one.add(goal);
		one.add(button);
		// this area the ball is going to fly.

		// area.setPreferredSize(new Dimension(500,300));

		// this is a panel that hold the button
		// 여기서 크기 지정해주는게 .누르고 setbounds로 하면 크기가 지정됨.

		button.setPreferredSize(new Dimension(400, 50));

		// this is a panel where mario is standing.
		// adding kicker.
		final Image kicker = (Toolkit.getDefaultToolkit())
				.getImage("kickMario.gif");
		kick = new JPanel() {
			public void paintComponent(Graphics g) {
				g.clearRect(0, 0, 400, 50);
				g.drawImage(kicker, 170, 0, this);
			}
		};
		kick.setPreferredSize(new Dimension(400, 50));

		// this is a button to kick a ball

		left.setIcon(leftB);
		center.setIcon(centerB);
		right.setIcon(rightB);
		left.setRolloverIcon(leftB_on);
		center.setRolloverIcon(centerB_on);
		right.setRolloverIcon(rightB_on);

		left.setBackground(Color.white);
		center.setBackground(Color.white);
		right.setBackground(Color.white);
		left.setBorder(null);
		right.setBorder(null);
		center.setBorder(null);
		left.setVisible(false);
		right.setVisible(false);
		center.setVisible(false);

		// this is a part that wil layoyt each panels.
		crowds.setBackground(Color.WHITE);
		goal.setBackground(Color.white);
		kick.setBackground(Color.white);
		button.setBackground(Color.white);

		button.add(left);
		button.add(center);
		button.add(right);
		contentPane.setBackground(Color.WHITE);

		// adding a actionListener to each buttons.
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

		two.add(kick);
		two.add(crowds);
		two.add(score);

		contentPane.add(one, BorderLayout.NORTH);
		contentPane.add(two, BorderLayout.SOUTH);

		left.addActionListener(new ActionListener() {
			// 왼쪽버튼 클릭시 액션
			public void actionPerformed(ActionEvent e) {
				defPos = "1";
				out.println("defence " + "1");
				blocked = 1;
			}
		});
		center.addActionListener(new ActionListener() {
			// 가운데버튼 클릭시 액션
			public void actionPerformed(ActionEvent e) {
				defPos = "2";
				out.println("defence " + "2");
				blocked = 2;
			}
		});
		right.addActionListener(new ActionListener() {
			// 오른쪽버튼 클릭시 액션
			public void actionPerformed(ActionEvent e) {
				defPos = "3";
				out.println("defence " + "3");
				blocked = 3;
			}
		});
	}

	public void showScore(int keeper, int kicker) {
		turn++;
		if (keeper == kicker) {
			ds.getTurn(turn, 1, tempx);
			new Thread(ds).start();
		} else {
			ds.getTurn(turn, 0, tempx);
			new Thread(ds).start();
		}
		tempx += 80;
	}

	public void moveKeeper(int keepermove, int ballmove) {
		if( keepermove == 1 )
		{
			mk.direction("left");
			mk.setEndCoordinate(50, 0);
			new Thread(mk).start();
			try {
				new Thread(mk).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else if(keepermove == 2)
		{
			mk.direction("center");
			mk.setEndCoordinate(170, 0);
			new Thread(mk).start();
			try {
				new Thread(mk).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else
		{
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
	//이 부분은 공을 움직이기 위한 메소드입니다.
	public void moveBall(int keeperMove, int ballMove)
	{
		if( ballMove == 1 )
		{
			mv.direction("left");
			new Thread(mv).start();
			try {
				new Thread(mv).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else if(ballMove == 2)
		{
			mv.direction("center");
			new Thread(mv).start();
			try {
				new Thread(mv).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else
		{
			mv.direction("right");
			new Thread(mv).start();
			try {
				new Thread(mv).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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

		goalPopup.setBounds(450, 150, 0,0);
		goalPopup.setVisible(true);
		goalPopup.pack();

		left.setVisible(false);
		right.setVisible(false);
		center.setVisible(false);
		Sound.play("win.wav");
		out.println("defence " + "LOSE");
		try {

			TimeUnit.SECONDS.sleep(7);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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

		goalPopup.setBounds(450, 150, 0,0);
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

		out.println("defence " + "EXIT");
	}

	public void giveUpLose() {
		/*
		 * 기권하였을때 
		 */
		out.println("defence " + "WIN");
	}

	public void block() {
		/*
		 * 방어에 성공했을때, 나타나는 팝업 메소드
		 */
		JFrame goalPopup = new JFrame("막음");
		JLabel goalImg = new JLabel();

		ImageIcon img = new ImageIcon("block.gif");
		Color bg = new Color(255, 255, 255);

		goalImg.setIcon(img);
		goalImg.setBackground(bg);

		goalPopup.add(goalImg);

		goalPopup.setBounds(450, 150, 0,0);
		goalPopup.setVisible(true);
		goalPopup.pack();
		left.setVisible(false);
		right.setVisible(false);
		center.setVisible(false);

		Sound.play("goalin.wav");
		try {

			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		goalPopup.setVisible(false);

	}

	public void noBlock() {
		/*
		 * 방어에 실패했을때, 나타나는 팝업 메소드
		 */
		JFrame goalPopup = new JFrame("못막음");
		JLabel goalImg = new JLabel();

		ImageIcon img = new ImageIcon("noblock.gif");
		Color bg = new Color(255, 255, 255);

		goalImg.setIcon(img);
		goalImg.setBackground(bg);

		goalPopup.add(goalImg);

		goalPopup.setBounds(450, 150, 0,0);
		goalPopup.setVisible(true);
		goalPopup.pack();
		left.setVisible(false);
		right.setVisible(false);
		center.setVisible(false);
		Sound.play("nogoalin.wav");
		try {

			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		goalPopup.setVisible(false);

	}

	public void run() {

		try {
			Socket clientSocket = new Socket(IP, port);
			// 1:1대화 소켓을 연결합니다.
			in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			// 스트림을 열어준다.

			while (true) {
				String[] temp;
				String line = in.readLine();
				temp = line.split(" ");

				left.setVisible(true);
				right.setVisible(true);
				center.setVisible(true);

				if (line.startsWith("shoot")) {
					
					left.setVisible(false);
					right.setVisible(false);
					center.setVisible(false);

					if (temp[1].equals(defPos)) {
						/*
						 * 만일 슛한 포지션이 골키퍼가 막은 포지션과 일치하면
						 * 방어성공으로 처리합니다.
						 */
						kicked = Integer.parseInt(temp[1]);
						moveKeeper(blocked, kicked);
						moveBall(blocked, kicked);
						try {
							TimeUnit.SECONDS.sleep(2);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						block();
						showScore(Integer.parseInt(defPos),
								Integer.parseInt(temp[1]));
						defPos = "0";
						count++;
						if (count == 3) {
							//세번 막으면 승리합니다.
							win();
						}
					} else if (temp[1].equals("EXIT")) {
						/*
						 * 게임 종료시 클라이언트(로비창)에게 종료 신호를 준후에,
						 * 게임 상대에게도 종료 메시지를 보내줍니다.
						 */
						defPos = "0";
						count = 0;
						if (this.server_on == true) {
							Client_Server.ExitGameSignal();
						}
						if (this.client_on == true) {
							Client_Client.ExitGameSignal();
						}
						this.server_on=false;
						this.client_on=false;
						out.println("defence " + "EXIT");
						this.dispose();
						return;
					} else if (temp[1].equals("LOSE")) {
						/*
						 * 게임에 패배했을때
						 */
						lose();
					} else if (temp[1].equals("WIN")) {
						/*
						 * 게임에 승리했을때
						 */
						win();
					} else {
						/*
						 * 방어에 실패했을때,
						 */
						kicked = Integer.parseInt(temp[1]);
						moveKeeper(blocked, kicked);
						moveBall(blocked, kicked);
						try {

							TimeUnit.SECONDS.sleep(2);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						noBlock();
						showScore(Integer.parseInt(defPos),
								Integer.parseInt(temp[1]));

						defPos = "0";

					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	  //public static void main(String[] args) { Mario_client m = new
	  //Mario_client("127.0.0.1", 100, "a"); m.setVisible(true); m.run(); }
}
