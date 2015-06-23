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
	// 1:1ä�ý� ���Ǵ� 'inputStream'
	static PrintWriter out;
	// 1:1ä�ý� ���Ǵ� 'outputStream'
	static String name_Me;
	// ���� ������� �̸��� ��Ÿ���� ����
	static String name_Other;
	// ���� ��ȭ����� �̸��� ��Ÿ���� ����
	static String IP;
	// �ڽ��� ��ǻ�� IP�ּ�
	static int port;
	// 1:1 ä�� ���� ����
	static String gameIP;
	static int gamePort;

	
	JPanel panelTitle_chat;
	JLabel labelTitle;
	JLabel labelTitle2;
	JLabel labelTitle3;
	JLabel labelTitle4;
	//�ٹ̱�
	
	JPanel panel_text;
	// ä���Է� 'textField'�� ���̱����� 'panel'
	JPanel panel_msgArea;
	// ä�ø޽����� �����ִ� 'messageArea'�� ���̱����� 'panel'
	JPanel panel_button;
	// �������۽� ���Ǵ� '���ϼ���', '��������', '���ż���' ��ư�� �� ���̱����� 'panel'
	JFrame frame;
	// ä��â ��ü�� 'frame'
	JTextField textField;
	// ä���Է� 'textField'
	static JTextArea messageArea;
	
	private static JButton request;
	private static JButton permit;
	private static JButton help;
	
	// �������۽� ���Ǵ� '���ϼ���', '��������', '���ż���' ��ư
	
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
		// �����̸�, ��ȭ����̸� , IP�ּ�, 1:1ä�ý� ����� 'port#'
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
		
		frame.setTitle(name_Me + "���� "+name_Other +"�԰� 1:1ä�����Դϴ�.");
		
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
		//���� 3���� ���̱�
		panelTitle_chat.add(TitleMario);
		panelTitle_chat.add(labelTitle4);
		//�����̶� ������ ���̱�
		
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
		// ä��â�� �����մϴ�.

		frame.setVisible(true);
		// ä��â�� ���̰��մϴ�.

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Client.ExitSignal(name_Me, name_Other);
				out.println("EXIT");
			}
		});
		
		textField.addActionListener(new ActionListener() {
			// ä�ø޽��� �Է� �� 'enter'�� �Է��Ͽ�����, ��Ÿ���� 'action'
			public void actionPerformed(ActionEvent e) {
				Sound.play("button.wav");
				String tmp = textField.getText();
				// �ӽ� ���� 'tmp'�� �Է��� �޽����� �����صд�.
				out.println(tmp);
				// ��ȭ ��뿡�� 'tmp'�� �����ش�.
				messageArea.append(name_Me + " : " + tmp + "\n");
				// �ڽ��� ä��â�� �Է��� �޽����� ����.
				textField.setText("");
				// �Է�â�� �ʱ�ȭ���ش�.
			}
		});
		
		request.addActionListener(new ActionListener() {
			// ���� ��û ��ư �׼�
			public void actionPerformed(ActionEvent ey) {
				Sound.play("button.wav");
				messageArea.append("���濡�� ������ ��û�Ͽ����ϴ�. ������ ������ ��ٸ��ϴ�.\n");
				request.setEnabled(false);
				out.println("request");
			}
		});

		permit.addActionListener(new ActionListener() {
			/* 
			 * ���� ���� ��ư �׼�
			 * ���� ������ �����ݴϴ�.
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
			 * ���� ��ư�� �����ԵǸ�,
			 * ���ӿ� ���� ������ �����ݴϴ�.
			 */
			public void actionPerformed(ActionEvent ey) {
				Sound.play("button.wav");
				help();
			}
		});

	}
	//���� ����ڰ� ���� ��ư�� ���� ��� ������ �����ֱ� ���� �޼ҵ� �Դϴ�. 
	private void help()
	{
		
		new Help().setVisible(true);
	}
	public static void ExitGameSignal()
	{
		request.setEnabled(true);
		permit.setEnabled(false);
		messageArea.append("������ ����Ǿ����ϴ�.\n");
	}

	public void run() {

		try {
			Socket clientSocket = new Socket(IP, port);
			// 1:1��ȭ ������ �����մϴ�.
			in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			// ��Ʈ���� �����ش�.

			while (true) {
				String line = in.readLine();
				String[] temp = line.split(" ");
				if (temp[0].equals("request")) {
					// ���� ������ ���� ��û�� �ߴٸ�
					messageArea.append("������ ������ ��û�Ͽ����ϴ�. ������ ���Ͻø� 'PERMIT'��ư�� �����ּ���\n");
					permit.setEnabled(true);
					request.setEnabled(false);
				} else if (temp[0].equals("permit")) {
					request.setEnabled(false);	
				}else if(temp[0].equals("permitted"))
				{
					/*
					 * ���ӿ�û�� �����Ǿ��ٸ�
					 * ���� Ŭ���̾�Ʈ�� �����մϴ�.
					 */
					Mario_client m_c =new Mario_client(temp[1],Integer.parseInt(temp[2]),name_Me);
					m_c.client_on=true;
					new Thread(m_c).start();
					m_c.setVisible(true);;
				}
				else if (temp[0].equals("EXIT")) {
					/*
					 * 1:1��ȭ�� ����Ǹ� ���濡�Ե� ����Ǿ����� �˷��ݴϴ�.
					 */
					request.setEnabled(true);
					permit.setEnabled(true);
					Client.connection.setEnabled(true);
					
					out.println("EXIT");
					frame.dispose();
					return;
				} else {
					messageArea.append(name_Other + " : " + line + "\n");
					// ������ ���� �޽����� ��ȭâ�� ����.
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}