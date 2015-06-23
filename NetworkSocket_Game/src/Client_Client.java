import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.*;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Client_Client extends Thread {
	

	
	static BufferedReader in;
	// 1:1채팅시 사용되는 'inputStream'
	static PrintWriter out;
	// 1:1채팅시 사용되는 'outputStream'
	static String name_Me;
	// 현재 사용자의 이름을 나타내는 변수
	static String name_Other;
	// 현재 대화상대의 이름을 나타내는 변수
	static String IP;
	// 자신의 컴퓨터 IP주소
	static int port;
	// 1:1 채팅 전용 소켓
	static String gameIP;
	static int gamePort;

	
	JPanel panelTitle_chat;
	JLabel labelTitle;
	JLabel labelTitle2;
	JLabel labelTitle3;
	JLabel labelTitle4;
	//꾸미기
	
	JPanel panel_text;
	// 채팅입력 'textField'을 붙이기위한 'panel'
	JPanel panel_msgArea;
	// 채팅메시지를 보여주는 'messageArea'를 붙이기위한 'panel'
	JPanel panel_button;
	// 파일전송시 사용되는 '파일선택', '파일전송', '수신수락' 버튼을 을 붙이기위한 'panel'
	JFrame frame;
	// 채팅창 전체의 'frame'
	JTextField textField;
	// 채팅입력 'textField'
	static JTextArea messageArea;
	
	private static JButton request;
	private static JButton permit;
	private static JButton help;
	
	// 파일전송시 사용되는 '파일선택', '파일전송', '수신수락' 버튼
	
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

	

	public Client_Client(String tmp, String tmp2, String tmp3, int tmp4) {
		// 본인이름, 대화상대이름 , IP주소, 1:1채팅시 사용할 'port#'
		name_Me = tmp;
		name_Other = tmp2;
		IP = tmp3;
		port = tmp4;
		
		panelTitle_chat = new JPanel();
		labelTitle = new JLabel();
		labelTitle2 = new JLabel();
		labelTitle3 = new JLabel();
		labelTitle4 = new JLabel();
		panel_button = new JPanel();
		panel_msgArea = new JPanel();
		panel_text = new JPanel();
		textField = new JTextField(40);
		messageArea = new JTextArea(8, 40);
		request = new JButton();
		permit = new JButton();
		help = new JButton();
		
		frame = new JFrame();
		
		frame.setTitle(name_Me + "님은 "+name_Other +"님과 1:1채팅중입니다.");
		
		Color bg = new Color(255,255,255);
		ImageIcon img = new ImageIcon("m1.gif");
		ImageIcon img2 = new ImageIcon("m2.gif");
		ImageIcon img3 = new ImageIcon("m3.gif");
		ImageIcon img4 = new ImageIcon("title_chat.png");
		ImageIcon img5 = new ImageIcon("requestB.png");
		ImageIcon img6 = new ImageIcon("requestB_on.png");
		ImageIcon img7 = new ImageIcon("permitB.png");
		ImageIcon img8 = new ImageIcon("permitB_on.png");
		ImageIcon img9 = new ImageIcon("permitB_dis.png");
		ImageIcon img10 = new ImageIcon("requestB_dis.png");
		ImageIcon helpB = new ImageIcon("helpB.png");
		ImageIcon helpBon = new ImageIcon("helpB_on.png");
		
		Box TitleMario = Box.createHorizontalBox();
		TitleMario.add(labelTitle);
		TitleMario.add(labelTitle2);
		TitleMario.add(labelTitle3);
		//버섯 3마리 붙이기
		panelTitle_chat.add(TitleMario);
		panelTitle_chat.add(labelTitle4);
		//버섯이랑 마리오 붙이기
		
		textField.setEditable(true);
		messageArea.setEditable(false);

		

		panel_msgArea.add(new JScrollPane(messageArea));
		panel_text.add(textField);
		
		panel_button.add(request);
		panel_button.add(permit);
		panel_button.add(help);
		
		Box allComponent = Box.createVerticalBox();
		allComponent.add(panelTitle_chat);
		allComponent.add(panel_msgArea);
		allComponent.add(panel_text);
		allComponent.add(panel_button);
		
		labelTitle.setIcon(img);
		labelTitle.setBackground(bg);
		labelTitle2.setIcon(img2);
		labelTitle2.setBackground(bg);
		labelTitle3.setIcon(img3);
		labelTitle3.setBackground(bg);
		labelTitle4.setIcon(img4);
		labelTitle4.setBackground(bg);
		panelTitle_chat.setBackground(bg);
		panel_msgArea.setBackground(bg);
		panel_text.setBackground(bg);
		panel_button.setBackground(bg);
		request.setIcon(img5);
		request.setRolloverIcon(img6);
		request.setDisabledIcon(img10);
		request.setBackground(bg);
		request.setBorder(null);
		permit.setIcon(img7);
		permit.setRolloverIcon(img8);
		permit.setDisabledIcon(img9);
		permit.setBackground(bg);
		permit.setBorder(null);
		help.setIcon(helpB);
		help.setRolloverIcon(helpBon);
		help.setBorder(null);
		
		permit.setEnabled(false);

		frame.add(allComponent, BorderLayout.CENTER);
		frame.pack();
		// 채팅창을 구성합니다.

		frame.setVisible(true);
		// 채팅창을 보이게합니다.

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Client.ExitSignal(name_Me, name_Other);
				out.println("EXIT");
			}
		});
		
		textField.addActionListener(new ActionListener() {
			// 채팅메시지 입력 후 'enter'를 입력하였을때, 나타나는 'action'
			public void actionPerformed(ActionEvent e) {
				Sound.play("button.wav");
				String tmp = textField.getText();
				// 임시 변수 'tmp'에 입력한 메시지를 저장해둔다.
				out.println(tmp);
				// 대화 상대에게 'tmp'를 보내준다.
				messageArea.append(name_Me + " : " + tmp + "\n");
				// 자신의 채팅창에 입력한 메시지를 띄운다.
				textField.setText("");
				// 입력창을 초기화해준다.
			}
		});
		
		request.addActionListener(new ActionListener() {
			// 게임 요청 버튼 액션
			public void actionPerformed(ActionEvent ey) {
				Sound.play("button.wav");
				messageArea.append("상대방에게 게임을 요청하였습니다. 상대방의 수락을 기다립니다.\n");
				request.setEnabled(false);
				out.println("request");
			}
		});

		permit.addActionListener(new ActionListener() {
			/* 
			 * 게임 수락 버튼 액션
			 * 게임 서버를 열어줍니다.
			 */
			public void actionPerformed(ActionEvent ex) {
				Sound.play("button.wav");
				permit.setEnabled(false);
				Random random = new Random();
				
				InetAddress address = null;
				try {
					address = InetAddress.getLocalHost();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				}
				gameIP = address.getHostAddress();
				gamePort = random.nextInt(1000);
				out.println("permitted "+gameIP +" " + gamePort);
				Mario_server m_s =new Mario_server(gamePort,name_Me);
				m_s.client_on=true;
				new Thread(m_s).start();
				m_s.setVisible(true);


			}
		});
		help.addActionListener(new ActionListener() {
			/*
			 * 도움말 버튼을 누르게되면,
			 * 게임에 대한 설명을 보여줍니다.
			 */
			public void actionPerformed(ActionEvent ey) {
				Sound.play("button.wav");
				help();
			}
		});

	}
	//만약 사용자가 도움말 버튼을 누를 경우 도움말을 보여주기 위한 메소드 입니다. 
	private void help()
	{
		
		new Help().setVisible(true);
	}
	public static void ExitGameSignal()
	{
		request.setEnabled(true);
		permit.setEnabled(false);
		messageArea.append("게임이 종료되었습니다.\n");
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
				String line = in.readLine();
				String[] temp = line.split(" ");
				if (temp[0].equals("request")) {
					// 만일 상대방인 게임 요청을 했다면
					messageArea.append("상대방이 게임을 요청하였습니다. 수락을 원하시면 'PERMIT'버튼을 눌러주세요\n");
					permit.setEnabled(true);
					request.setEnabled(false);
				} else if (temp[0].equals("permit")) {
					request.setEnabled(false);	
				}else if(temp[0].equals("permitted"))
				{
					/*
					 * 게임요청이 수락되었다면
					 * 게임 클라이언트를 실행합니다.
					 */
					Mario_client m_c =new Mario_client(temp[1],Integer.parseInt(temp[2]),name_Me);
					m_c.client_on=true;
					new Thread(m_c).start();
					m_c.setVisible(true);;
				}
				else if (temp[0].equals("EXIT")) {
					/*
					 * 1:1대화가 종료되면 상대방에게도 종료되었음을 알려줍니다.
					 */
					request.setEnabled(true);
					permit.setEnabled(true);
					Client.connection.setEnabled(true);
					
					out.println("EXIT");
					frame.dispose();
					return;
				} else {
					messageArea.append(name_Other + " : " + line + "\n");
					// 상대방이 보낸 메시지를 대화창에 띄운다.
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}