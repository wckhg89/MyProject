import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import sun.audio.*;

public class Client extends Thread {

	String mainServerIP;
	// ���μ����� IP�ּ�
	String IP;
	// ����������� Ŭ���̾�Ʈ�� IP�ּ�
	String port;
	// ����������� ����ڿ� �ٸ� ����ڿ��� 1:1ä���� ���� port#
	String myName;
	// ���� �����
	String selectUser;
	// ���� list���� ������ ������ �̸�
	String info[] = new String[6];
	// ������ ������ ������� �迭
	String name = null;
	String[] userIDPW;
	// �α����Ҷ� �̷��� ���̵�� ��й�ȣ
	String newUID;
	// ȸ�����Խ� ���ο� ���̵�
	String newUPW;
	// ȸ�����Խ� ���ο� ��й�ȣ
	String newUNAME;
	// ȸ�����Խ� ���ο� �����̸�
	BufferedReader in;
	// ���μ����� ����� �ϱ� ���� ��ǲ��Ʈ��
	static PrintWriter out;
	// ���μ����� ����� �ϱ� ���� �ƿ�ǲ ��Ʈ��
	private static HashSet<String> online = new HashSet<String>();
	// ������ ������ �����ϰ� �ִ� �迭�Դϴ�.
	String temp = null;
	// ����üũ�� ���� ����
	int chk;
	// ����üũ�� ���Ѻ���

	JFrame frame = new JFrame();
	// �κ�â
	JPanel panelTitle_LB = new JPanel();
	JLabel labelTitle_LB = new JLabel();
	JLabel labelTitle2_LB = new JLabel();
	JLabel labelTitle3_LB = new JLabel();
	// Ÿ��Ʋ �ٹ̱�
	JTextArea messageArea = new JTextArea(8, 40);
	// �޽���������â
	JTextField textField = new JTextField(40);
	// �޽����Է�â
	JTabbedPane chatGame = new JTabbedPane();
	// �κ����� , ������ ����
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	JList<String> listOfuser = new JList<String>(listModel);
	// �κ��������â
	DefaultListModel<String> listModelGame = new DefaultListModel<String>();
	JList<String> listOfGameUser = new JList<String>(listModelGame);
	// �������������â
	JPanel panel_button = new JPanel();
	public static JButton connection = new JButton();
	// 1:1ä�ù�ư
	JButton userInfo = new JButton();
	// "��������"��ư

	/*
	 * �κ�â
	 */

	JFrame frame2 = new JFrame("�α���");
	// �α��� ������
	JPanel panelTitle = new JPanel();
	JLabel labelTitle = new JLabel();
	JLabel labelTitle2 = new JLabel();
	JLabel labelTitle3 = new JLabel();
	// Ÿ��Ʋ �α���
	JPanel panelID = new JPanel();
	// ���̵��г�
	JLabel labelID = new JLabel("���̵�     ");
	JTextField ID = new JTextField(10);
	JPanel panelPW = new JPanel();
	// ���̵�
	JLabel labelPW = new JLabel("��й�ȣ");
	JPasswordField PW = new JPasswordField(10);
	// ��й�ȣ

	JPanel panelButton2 = new JPanel();
	// ȸ�����Թ�ư, �α��ι�ư�� ���̱����� �г�
	JButton newMember = new JButton();
	// "ȸ������"��ư
	JButton login = new JButton();
	// "�α���"��ư

	/*
	 * �α��� â
	 */

	JFrame frame3;
	// ȸ������ ������
	JPanel panelTitle_SU = new JPanel();
	JLabel labelTitle_SU = new JLabel();
	JLabel labelTitle2_SU = new JLabel();
	JLabel labelTitle3_SU = new JLabel();
	// Ÿ��Ʋ ȸ������
	JPanel panelNewID = new JPanel();
	JLabel labelNewID = new JLabel("��Ͼ��̵�     ");
	JTextField NewID = new JTextField(10);
	// ��Ͼ��̵�

	JPanel panelNewPW = new JPanel();
	JLabel labelNewPW = new JLabel("��Ϻ�й�ȣ");
	JPasswordField NewPW = new JPasswordField(10);
	// ��� ��й�ȣ

	JPanel panelNewName = new JPanel();
	JLabel labelNewName = new JLabel("����̸�       ");
	JTextField NewName = new JTextField(10);
	// ��� �̸�

	JPanel panelButton3 = new JPanel();
	JButton access = new JButton();// "���"
	// ��Ϲ�ư

	/*
	 * ȸ������ â
	 */

	public JFrame frame_log = new JFrame("�α��ν���");
	// �α��� ���� �޽���
	public JFrame frame4_log = new JFrame("ȸ�����Լ���");
	// ȸ������ ���� �޽���
	public JFrame frame5_log = new JFrame("ȸ�����Կ���");
	// ȸ������ ���� �޽���

	JFrame frame4;
	// �������� ������
	JPanel panelTitle_UI = new JPanel();
	JLabel labelTitle_UI = new JLabel();
	JLabel labelTitle2_UI = new JLabel();
	JLabel labelTitle3_UI = new JLabel();
	// Ÿ��Ʋ �ٹ̱�
	JPanel PanelUserRANK;
	JLabel labelUserRANK;
	JLabel UserRANK;
	// �������
	JPanel panelUserID;
	JLabel labelUserID;
	JTextField UserID;
	// ���� ���̵�
	JPanel panelUserName;
	JLabel labelUserName;
	JTextField UserName;
	// �����̸�
	JPanel panelUserWin;
	JLabel labelUserWin;
	JTextField UserWin;
	// ���� �¸�Ƚ��
	JPanel panelUserLose;
	JLabel labelUserLose;
	JTextField UserLose;
	// ���� �й�Ƚ��
	JPanel panelUserDate;
	JLabel labelUserDate;
	JTextField UserDate;
	// ���� �ֱ� �α��� ����
	JPanel panel_exit_UI;
	JButton exit_UI;

	// �ݱ� ��ư

	/*
	 * �������� â
	 */
	public static class Sound {
		// �Ҹ� Ŭ����
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

	public Client() {

		Color bg = new Color(255, 255, 255);
		Color bg2 = new Color(128, 0, 128);
		ImageIcon img = new ImageIcon("c.gif");
		ImageIcon img2 = new ImageIcon("ball.gif");
		ImageIcon img3 = new ImageIcon("title_lobby.png");
		ImageIcon img4 = new ImageIcon("chatB.png");
		ImageIcon img5 = new ImageIcon("infoB.png");
		ImageIcon img6 = new ImageIcon("chatB_on.png");
		ImageIcon img7 = new ImageIcon("infoB_on.png");
		ImageIcon img8 = new ImageIcon("chatB_dis.png");

		Box TitleMario = Box.createVerticalBox();
		TitleMario.add(labelTitle_LB);
		TitleMario.add(labelTitle2_LB);
		// �帮���ϴ� ������
		panelTitle_LB.add(TitleMario);
		panelTitle_LB.add(labelTitle3_LB);
		// ��ǳ���� �帮������ ���̰�

		panel_button.add(connection);
		panel_button.add(userInfo);
		// ��ư�гο� 1:1��ư�� ����������ư �� ���δ�.

		Box chat = Box.createVerticalBox();
		messageArea.setEditable(false);
		chat.add(new JScrollPane(messageArea));
		chat.add(textField);
		// �ڽ����̾ƿ��� �̿��ؼ� �������� �޽���������â�� �Է�â�� ���δ�.
		Box listLobby = Box.createVerticalBox();
		listLobby.setPreferredSize(new Dimension(210, 130));
		listLobby.add(new JScrollPane(listOfuser));
		// �ڽ��� ����Ʈ�� �ٿ��ݴϴ�.
		Box listGame = Box.createVerticalBox();
		listGame.add(new JScrollPane(listOfGameUser));
		listGame.setPreferredSize(new Dimension(210, 130));
		// �ڽ��� �����߸���Ʈ�� �ٿ��ݴϴ�.
		listLobby.setBackground(bg);
		listGame.setBackground(bg);
		listOfuser.setPreferredSize(new Dimension(200, 120));
		listOfGameUser.setPreferredSize(new Dimension(200, 120));

		chatGame.addTab("�κ�", listLobby);
		chatGame.addTab("������", listGame);
		// �Ǿ����ܿ� �κ�ڽ��Ͱ� �����߹ڽ��� ���δ�.

		Box title_chat_list = Box.createHorizontalBox();
		title_chat_list.setBackground(bg);
		title_chat_list.add(chat);
		title_chat_list.add(chatGame);

		Box allComponet = Box.createVerticalBox();

		allComponet.add(panelTitle_LB);
		allComponet.add(title_chat_list);

		Box allComponet2 = Box.createVerticalBox();
		allComponet2.add(allComponet);
		allComponet2.add(panel_button);
		// �ڽ����̾ƿ��� �̿��ؼ� �������� ������ ��ģ��.
		/* �ΰ��� ������ �Ⱥ��̴ϱ� ������ �̷��� �Ҽ� �ۿ�������� �Ф������Ե� */

		labelTitle_LB.setIcon(img);
		labelTitle_LB.setBackground(bg);
		labelTitle2_LB.setIcon(img2);
		labelTitle2_LB.setBackground(bg);
		labelTitle3_LB.setIcon(img3);
		labelTitle3_LB.setBackground(bg);
		connection.setBackground(bg);
		connection.setBorder(null);
		connection.setIcon(img4);
		connection.setRolloverIcon(img6);
		connection.setDisabledIcon(img8);
		userInfo.setBackground(bg);
		userInfo.setBorder(null);
		userInfo.setIcon(img5);
		userInfo.setRolloverIcon(img7);
		panelTitle_LB.setBackground(bg);
		panel_button.setBackground(bg);
		frame.setBackground(bg);
		frame.add(allComponet2, BorderLayout.CENTER);
		// �����ӿ� �ڽ��� ���δ�.
		frame.pack();
		frame.setResizable(false);

		// ������ũ�⸦ �ڵ����� �����Ѵ�.

		/*
		 * �κ�ȭ�� �ϼ�
		 */

		textField.addActionListener(new ActionListener() {
			// ä���Է½� �׼�
			public void actionPerformed(ActionEvent e) {
				buttonSound("button.wav");
				out.println(textField.getText());
				textField.setText("");
			}
		});

		connection.addActionListener(new ActionListener() {
			// 1:1ä�ý� �׼�
			public void actionPerformed(ActionEvent e) {
				buttonSound("button.wav");

				Random random = new Random();

				selectUser = (String) listOfuser.getSelectedValue();
				// list���� ���õ� �̸��� �����Ѵ�.
				if (selectUser.equals(myName)) {
					// ���� ������ �����ϸ� ���� �޽����� ����Ѵ�.
					messageArea.append("���ΰ��� 1:1ä���� �� �� �����ϴ�.\n");
				} else {
					InetAddress address = null;
					try {
						address = InetAddress.getLocalHost();
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					}
					IP = address.getHostAddress();
					// IP�ּҸ� �����Ѵ�.
					port = Integer.toString(random.nextInt(1000));
					// �����ϰ� ��Ʈ��ȣ�� �޴´�.

					out.println("��ȭ���� " + selectUser + " " + myName + " " + IP
							+ " " + port);
					// ������ ���ϴ� �����, ������ �õ��ϴ� �����, ������ �õ��ϴ� ������� IP,
					// ������ �õ��ϴ� ������� ���ο� port#�� 'server'�� �����ش�.
				}
			}
		});

		userInfo.addActionListener(new ActionListener() {
			// �������� Ȯ�ν� �׼�
			public void actionPerformed(ActionEvent e) {
				buttonSound("button.wav");
				String user = (String) listOfuser.getSelectedValue();
				// ���õ� ������ ������
				out.println("USERINFO " + user);
				// ���μ����� �������� �˷��ٰ��� ��û�Ѵ�.
			}
		});
	}

	public static void ExitSignal(String tmpName1, String tmpName2) {
		// 1:1ä��â�� ����Ǿ����� ��ȣ�� �޾ƿ��� �޼ҵ�
		out.println("��ȭ���� " + tmpName1 + " " + tmpName2);
		// ���μ����� 1:1 ä���� ����Ǿ����� �˷��ش�.
	}

	public static void WinnerSignal(String Winner) {
		// ��������� �¸��ڸ� �޴� �޼ҵ�
		out.println("WIN " + Winner);
		// ���μ����� ������ �¸��ڸ� �˷��ݴϴ�.
	}

	public static void LoserSignal(String loser) {
		// ��������� �й��ڸ� �޴� �޼ҵ�
		out.println("LOSE " + loser);
		// ���μ����� ������ �й��ڸ� �˷��ݴϴ�.
	}

	public void buttonSound(String FileName) {
		// ��ư ȿ������ �ֱ����� �޼ҵ�
		try {
			File file = new File(FileName);
			FileInputStream fs = new FileInputStream(file);
			AudioStream as = new AudioStream(fs);
			AudioPlayer.player.start(as);
		} catch (Exception ex) {
			System.out.println("sound exception");
		}
	}

	public void login() {

		Sound.play("back.wav");
		Color bg = new Color(255, 255, 255);
		ImageIcon img = new ImageIcon("a.gif");
		ImageIcon img2 = new ImageIcon("ball.gif");
		ImageIcon img3 = new ImageIcon("title.png");
		ImageIcon img4 = new ImageIcon("loginB.png");
		ImageIcon img5 = new ImageIcon("signB.png");
		ImageIcon img6 = new ImageIcon("loginB_on.png");
		ImageIcon img7 = new ImageIcon("signB_on.png");

		Box TitleMario = Box.createVerticalBox();
		TitleMario.add(labelTitle);
		TitleMario.add(labelTitle2);

		panelTitle.add(TitleMario);
		panelTitle.add(labelTitle3);
		// Ÿ��Ʋ
		panelID.add(labelID);
		panelID.add(ID);
		// �г�ID�� �󺧰� ��ư�� ���δ�.
		panelPW.add(labelPW);
		panelPW.add(PW);
		// �г�PW�� �󺧰� ��ư�� ���δ�.
		panelButton2.add(newMember);
		panelButton2.add(login);
		// �гι�ư2�� ȸ�����Թ�ư�� �α��ι�ư�� ���δ�.
		Box IDPW = Box.createVerticalBox();
		IDPW.add(panelTitle);
		IDPW.add(panelID);
		IDPW.add(panelPW);
		IDPW.add(panelButton2);
		// �ڽ����̾ƿ��� �̿��ؼ� �������� �� ���δ�.

		labelTitle.setIcon(img);
		labelTitle.setBackground(bg);
		labelTitle2.setIcon(img2);
		labelTitle2.setBackground(bg);
		labelTitle3.setIcon(img3);
		labelTitle3.setBackground(bg);
		newMember.setBackground(bg);
		newMember.setBorder(null);
		newMember.setIcon(img5);
		newMember.setRolloverIcon(img7);
		login.setBackground(bg);
		login.setBorder(null);
		login.setIcon(img4);
		login.setRolloverIcon(img6);
		panelTitle.setBackground(bg);
		panelID.setBackground(bg);
		panelPW.setBackground(bg);
		panelButton2.setBackground(bg);

		frame2.add(IDPW, BorderLayout.CENTER);
		// ������ �߾ӿ� ���δ�
		frame2.pack();
		// ������ũ�� �ڵ�����
		frame2.setVisible(true);
		// �޼ҵ� ȣ��Ǹ� ���̰��Ѵ�.
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �����ư Ȱ��ȭ

		/*
		 * �α���â �ϼ�
		 */

		newMember.addActionListener(new ActionListener() {
			// ȸ������ ��ư�۸��� �׼�
			public void actionPerformed(ActionEvent e) {
				buttonSound("button.wav");
				newMember();
				// ȸ������ �޼ҵ带 ȣ���Ѵ�.
			}
		});

		login.addActionListener(new ActionListener() {
			// �α��� ��ư Ŭ���� �׼�
			public void actionPerformed(ActionEvent e) {
				buttonSound("button.wav");
				temp = null;
				userIDPW = null;
				temp = ID.getText() + " " + PW.getText();
				userIDPW = temp.split(" ");
				out.println("login " + userIDPW[0] + " " + userIDPW[1]);
				// ���μ����� �Է��� ���̵� �н����带 �����ش�.
			}
		});

	}

	public void newMember() {
		frame3 = new JFrame("ȸ������");

		frame3.addWindowListener(new WindowAdapter() {
			// ȸ������ �����ư�� ����
			public void windowClosing(WindowEvent e) {
				frame3.dispose();
			}
		});

		panelTitle_SU = new JPanel();
		labelTitle_SU = new JLabel();
		labelTitle2_SU = new JLabel();
		labelTitle3_SU = new JLabel();
		// Ÿ��Ʋ
		panelNewID = new JPanel();
		labelNewID = new JLabel("��Ͼ��̵�     ");
		NewID = new JTextField(10);
		// ��Ͼ��̵�
		panelNewPW = new JPanel();
		labelNewPW = new JLabel("��Ϻ�й�ȣ");
		NewPW = new JPasswordField(10);
		// ��� ��й�ȣ
		panelNewName = new JPanel();
		labelNewName = new JLabel("����̸�       ");
		NewName = new JTextField(10);
		// ��� �̸�
		panelButton3 = new JPanel();
		access = new JButton();// "���"
		// ��Ϲ�ư
		Color bg = new Color(255, 255, 255);
		ImageIcon img = new ImageIcon("b.gif");
		ImageIcon img2 = new ImageIcon("ball.gif");
		ImageIcon img3 = new ImageIcon("title_signup.png");
		ImageIcon img4 = new ImageIcon("confrimB.png");
		ImageIcon img5 = new ImageIcon("confrimB_on.png");

		Box TitleMario2 = Box.createVerticalBox();
		TitleMario2.add(labelTitle_SU);
		TitleMario2.add(labelTitle2_SU);

		panelTitle_SU.add(TitleMario2);
		panelTitle_SU.add(labelTitle3_SU);

		panelNewID.add(labelNewID);
		panelNewID.add(NewID);
		// �г�ID�� �󺧰� ��ư�� ���δ�.

		panelNewPW.add(labelNewPW);
		panelNewPW.add(NewPW);
		// �г�PW�� �󺧰� ��ư�� ���δ�.

		panelNewName.add(labelNewName);
		panelNewName.add(NewName);

		panelButton3.add(access);

		// �гι�ư2�� ȸ�����Թ�ư�� �α��ι�ư�� ���δ�.

		Box NewIDPW = Box.createVerticalBox();
		NewIDPW.add(panelTitle_SU);
		NewIDPW.add(panelNewID);
		NewIDPW.add(panelNewPW);
		NewIDPW.add(panelNewName);
		NewIDPW.add(panelButton3);

		labelTitle_SU.setIcon(img);
		labelTitle_SU.setBackground(bg);
		labelTitle2_SU.setIcon(img2);
		labelTitle2_SU.setBackground(bg);
		labelTitle3_SU.setIcon(img3);
		labelTitle3_SU.setBackground(bg);
		access.setBackground(bg);
		access.setBorder(null);
		access.setIcon(img4);
		access.setRolloverIcon(img5);
		panelTitle_SU.setBackground(bg);
		panelNewID.setBackground(bg);
		panelNewPW.setBackground(bg);
		panelNewName.setBackground(bg);
		panelButton3.setBackground(bg);

		frame3.add(NewIDPW, BorderLayout.CENTER);
		// ������ �߾ӿ� ���δ�.
		frame3.pack();
		// ������ũ�� �ڵ�����
		frame3.setVisible(true);
		frame3.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		/*
		 * �α���â �ٹ̱� �ϼ�
		 */

		access.addActionListener(new ActionListener() {
			// ȸ������ ��ư�۸��� �׼�
			public void actionPerformed(ActionEvent e) {
				buttonSound("button.wav");
				newUID = NewID.getText();
				newUPW = NewPW.getText();
				newUNAME = NewName.getText();

				NewID.setText("");
				NewPW.setText("");
				NewName.setText("");

				if (newUID.equalsIgnoreCase("") || newUPW.equalsIgnoreCase("")
						|| newUNAME.equalsIgnoreCase("")) {
					// �ƹ��͵� �Է����� �ʾ��� ��� �����޽����� ����Ѵ�.
					JOptionPane.showMessageDialog(frame5_log,
							"������� �ִ��� �ٽ��ѹ� Ȯ�����ּ���.");
				} else {
					out.println("new " + newUID + " " + newUPW + " " + newUNAME);
					// ���μ����� ���ο� ���̵� ��й�ȣ �̸��� �����ش�.
				}
			}
		});
	}

	private void UserInfomation(String[] tmp) {

		frame4 = new JFrame("��������");
		PanelUserRANK = new JPanel();
		labelUserRANK = new JLabel("�������      ");
		UserRANK = new JLabel();

		panelUserID = new JPanel();
		labelUserID = new JLabel("�������̵�   ");
		UserID = new JTextField(10);
		// ���� ���̵�
		panelUserName = new JPanel();
		labelUserName = new JLabel("�����̸�      ");
		UserName = new JTextField(10);
		// �����̸�
		panelUserWin = new JPanel();
		labelUserWin = new JLabel("�����¸�Ƚ��");
		UserWin = new JTextField(10);
		// ���� �¸�Ƚ��
		panelUserLose = new JPanel();
		labelUserLose = new JLabel("�����й�Ƚ��");
		UserLose = new JTextField(10);
		// ���� �й�Ƚ��
		panelUserDate = new JPanel();
		labelUserDate = new JLabel("�ֱٷα���   ");
		UserDate = new JTextField(10);
		// �ֱ� �α�������
		panel_exit_UI = new JPanel();
		exit_UI = new JButton();// "�ݱ�"

		Color bg = new Color(255, 255, 255);
		ImageIcon img = new ImageIcon("d.gif");
		ImageIcon img2 = new ImageIcon("ball.gif");
		ImageIcon img3 = new ImageIcon("title_userinfo.png");
		ImageIcon img4 = new ImageIcon("closeB_UI.png");
		ImageIcon img5 = new ImageIcon("closeB_UI_on.png");

		ImageIcon low = new ImageIcon("low.jpg");
		ImageIcon mid = new ImageIcon("mid.jpg");
		ImageIcon high = new ImageIcon("high.jpg");
		ImageIcon max = new ImageIcon("max.jpg");

		Box TitleMario = Box.createVerticalBox();
		TitleMario.add(labelTitle_UI);
		TitleMario.add(labelTitle2_UI);

		panelTitle_UI.add(TitleMario);
		panelTitle_UI.add(labelTitle3_UI);

		PanelUserRANK.add(labelUserRANK);
		PanelUserRANK.add(UserRANK);
		// ��� ����
		if (Integer.parseInt(tmp[3]) >= 0 && Integer.parseInt(tmp[3]) <= 3)
			UserRANK.setIcon(low);
		// 0~3 ¤��
		else if (Integer.parseInt(tmp[3]) >= 4
				&& Integer.parseInt(tmp[3]) <= 10)
			UserRANK.setIcon(mid);
		// 4~10 �ȭ
		else if (Integer.parseInt(tmp[3]) >= 11
				&& Integer.parseInt(tmp[3]) <= 30)
			UserRANK.setIcon(high);
		// 11~30 �౸ȭ
		else if (Integer.parseInt(tmp[3]) >= 31)
			UserRANK.setIcon(max);
		// 31�̻� Ȳ���౸ȭ

		panelUserID.add(labelUserID);
		panelUserID.add(UserID);
		UserID.setText(tmp[0]);
		UserID.setEditable(false);
		// �������̵� ����

		panelUserName.add(labelUserName);
		panelUserName.add(UserName);
		UserName.setText(tmp[2]);
		UserName.setEditable(false);
		// ���� �̸� ����

		panelUserWin.add(labelUserWin);
		panelUserWin.add(UserWin);
		UserWin.setText(tmp[3]);
		UserWin.setEditable(false);
		// ���� �¼� ����

		panelUserLose.add(labelUserLose);
		panelUserLose.add(UserLose);
		UserLose.setText(tmp[4]);
		UserLose.setEditable(false);
		// ���� �й�� ����

		panelUserDate.add(labelUserDate);
		panelUserDate.add(UserDate);
		UserDate.setText(tmp[5]);
		UserDate.setEditable(false);
		// �ֱ� �α��� ��¥ ����

		panel_exit_UI.add(exit_UI);

		Box UserInfo = Box.createVerticalBox();

		UserInfo.add(panelTitle_UI);
		UserInfo.add(PanelUserRANK);
		UserInfo.add(panelUserID);
		UserInfo.add(panelUserName);
		UserInfo.add(panelUserWin);
		UserInfo.add(panelUserLose);
		UserInfo.add(panelUserDate);
		UserInfo.add(panel_exit_UI);

		labelTitle_UI.setIcon(img);
		labelTitle_UI.setBackground(bg);
		labelTitle2_UI.setIcon(img2);
		labelTitle2_UI.setBackground(bg);
		labelTitle3_UI.setIcon(img3);
		labelTitle3_UI.setBackground(bg);
		exit_UI.setBorder(null);
		exit_UI.setBackground(bg);
		exit_UI.setIcon(img4);
		exit_UI.setRolloverIcon(img5);

		panelTitle_UI.setBackground(bg);
		PanelUserRANK.setBackground(bg);
		panelUserID.setBackground(bg);
		panelUserName.setBackground(bg);
		panelUserWin.setBackground(bg);
		panelUserLose.setBackground(bg);
		panelUserDate.setBackground(bg);
		panel_exit_UI.setBackground(bg);

		frame4.add(UserInfo, BorderLayout.CENTER);
		// ������ �߾ӿ� ���δ�.
		frame4.pack();
		// ������ũ�� �ڵ�����
		frame4.setVisible(true);
		// ������ ���̰�

		/*
		 * ��������â �ٹ̱� �ϼ�
		 */

		exit_UI.addActionListener(new ActionListener() {
			// �������� Ȯ�ν� �׼�
			public void actionPerformed(ActionEvent e) {
				buttonSound("button.wav");
				frame4.dispose();
				// ������ �ݴ´�.

			}
		});
	}

	public void run() {
		try {

			mainServerIP = getServerAddress();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

			Socket socket = new Socket(mainServerIP, 9001);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			// ������ ���� ������ �޾ƿ������� input stream �� �����ݴϴ�.
			out = new PrintWriter(socket.getOutputStream(), true);
			// ������ ������ ������ ���� output stream �� �����ݴϴ�.

			int checkforone = 0;
			while (true) {
				String line = in.readLine();
				String temp[] = line.split(" ");

				// 'line'�� " "�������� �������ش�.
				// temp[1] = ������ ���ϴ� �����
				// temp[2] = ������ �õ��ϴ� �����
				// temp[3] = ������ �õ��ϴ� ������� port#
				// temp[4] = ������ �õ��ϴ� ������� IP

				if (line.startsWith("SUBMITNAME")) {
					if (checkforone == 0) {
						login();
						// �α��� �޼ҵ带 �����մϴ�.
						frame.setVisible(false);
						checkforone = 1;
					}
				} else if (line.startsWith("loginFail")) {
					Component frame = null;
					/*
					 * ���� ���ԵǾ����� ���� ȸ���̰ų� ��й�ȣ�� Ʋ���ٸ�, �����޽����� ����մϴ�.
					 */
					JOptionPane.showMessageDialog(frame,
							"���̵� Ȥ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				} else if (line.startsWith("equalID")) {
					/*
					 * ���� ���� �������� �Ƥ��̵���, �����޽����� ����մϴ�.
					 */
					Component frame = null;
					JOptionPane.showMessageDialog(frame,
							"���� �������� �����Դϴ�. �ٽ� �α������ּ���.");
				} else if (line.startsWith("NEWNAME")) {
					// �α��� ����
					myName = line.substring(8);
					frame.setTitle(myName + "�� ��������Ŀ�� ���Ű��� ȯ���մϴ�!");
				} else if (line.startsWith("SUCCESS_NEWMEMBER")) {
					// ȸ������ ����
					Component frame4 = null;
					JOptionPane.showMessageDialog(frame4, "ȸ�������� �����մϴ�.");
					frame3.setVisible(false);
					// ���� �޽��� ����
				} else if (line.startsWith("NEWIDFAIL")) {
					/*
					 * ȸ�����Խ� �̹� �����ϴ� ���̵���, �����޽����� ����մϴ�.
					 */
					Component frame5 = null;
					JOptionPane.showMessageDialog(frame5,
							"�̹� ��ϵ� ���̵� �Դϴ�. �ٸ� ���̵�� �������ּ���.");
				} else if (line.startsWith("NAMEACCEPTED")) {
					Sound.stop();
					frame.setVisible(true);
					frame2.setVisible(false);
					textField.setEditable(true);
				} else if (line.startsWith("Entrance")) {
					/*
					 * ���ο� ������ ���Դٸ� ����Ʈ�� ����ݴϴ�.
					 */
					listModel.clear();
					listModelGame.clear();
				} else if (line.startsWith("INFO")) {
					/*
					 * ���μ������� ���������� �޾ƿɴϴ�.
					 */
					for (int i = 0; i < 6; i++) {
						info[i] = temp[i + 1];
					}
					UserInfomation(info);
				} else if (line.startsWith("SetList")) {
					/*
					 * ���ο� ������ ���Ӵٸ�, �κ񸮽�Ʈ�� �ٽ� ä���ݴϴ�. ���ο� ������ ���Ӵٸ�, �����߸���Ʈ�� �ٽ�
					 * ä���ݴϴ�.
					 */
					online.clear();
					Thread.sleep(30);
					if (temp[1].equalsIgnoreCase("LIST")) {
						listModel.addElement(temp[2]);
					} else if (temp[1].equalsIgnoreCase("GAME")) {
						online.add(temp[2]);
					}

					Iterator<String> iterator = online.iterator();
					while (iterator.hasNext()) {
						String list_name = iterator.next();
						//if (!listModelGame.contains(list_name))
							listModelGame.addElement(list_name);
					}

					listOfuser.repaint();
					listOfGameUser.repaint();
					System.out.println("AA" + listModelGame);
				} else if (line.startsWith("ENTER")) {
					/*
					 * ���ο� ������ ���Դٴ°��� �޽���â�� ����մϴ�.
					 */
					messageArea.append(line.substring(6) + "\n");
				} else if (line.startsWith("removeList")) {
					/*
					 * ������ �α׾ƿ��ߴٸ�, ����Ʈ���� �����ݴϴ�.
					 */
					Thread.sleep(30);
					listModel.removeElement(line.substring(11));
					listOfuser.repaint();
					listOfGameUser.repaint();
				} else if (line.startsWith("EXIT")) {
					/*
					 * ������ �α׾ƿ��ߴٸ�, �޽���â�� �������� �˷��ݴϴ�.
					 */
					messageArea.append(line.substring(5) + "\n");
				} else if (line.startsWith("MESSAGE")) {
					/*
					 * ä�� �޽����� �Է��ߴٸ�, �޽���â�� ����ݴϴ�.
					 */
					messageArea.append(line.substring(8) + "\n");
				} else if (line.startsWith("Connection")) {
					if (myName.equals(temp[1])) {
						// ������ ���ϴ� ����ڶ��
						Client_Client c = new Client_Client(temp[1], temp[2],
								temp[3], Integer.parseInt(temp[4]));
						// ���ϴ� �����, �õ��ϴ� �����, IP�ּ�, port#
						c.start();
						// 1:1ä�� Ŭ���̾�Ʈ �� �����带 �����Ѵ�.
						connection.setEnabled(false);
						// �ش� ���̵�� 1:1ä�� ��ư�� ��Ȱ��ȭ ���ش�.
					} else if (myName.equals(temp[2]) && IP.equals(temp[3])) {
						// ������ �õ��ϴ� ������̰� IP�ּҰ� �� ����ڿ� ��ġ�Ѵٸ�
						out.println("��ȭ���� " + myName + " " + selectUser);
						// ���μ����� 1:1��ȭ�� �����Ͽ��ٰ� �˷��ش�.
						Client_Server s = new Client_Server(temp[2], temp[1],
								Integer.parseInt(temp[4]));
						// �õ��ϴ� �����, ���ϴ� �����, port#
						s.start();
						// 1:1ä�� ������ �����带 �����Ѵ�.
						connection.setEnabled(false);
						// �ش� ���̵�� 1:1ä�� ��ư�� ��Ȱ��ȭ ���ش�.
					}
				} else if (line.startsWith("START")) {
					/*
					 * 1:1��ȭ�� �����ߴٸ�, ����Ʈ���� �ش� ����ڸ� �����ְ�, 1:1 ��ȭ�� ���������� �޽���â��
					 * �Ʒ��ݴϴ�.
					 */
					messageArea.append(line.substring(6) + "\n");
					online.add(temp[1]);
					online.add(temp[3]);
					Iterator<String> iterator = online.iterator();
					while (iterator.hasNext()) {
						String list_name = iterator.next();
						listModelGame.addElement(list_name);
					}
					System.out.println(online);
					// ������ �����߰�
					listModel.removeElement(temp[1]);
					listModel.removeElement(temp[3]);
					// �κ����� ����
				} else if (line.startsWith("END")) {
					/*
					 * 1:1��ȭ�� ����Ǹ� �޽����� �ش� ����� �˷��ݴϴ�.
					 */
					online.remove(temp[1]);
					online.remove(temp[3]);

					messageArea.append(line.substring(4) + "\n");
				}
			}
		} catch (IOException e) {
		} catch (NumberFormatException e) {
		} catch (Exception e) {

		}
	}

	private String getServerAddress() {
		// ���μ����� ������ �ּҸ� �޴� �޼ҵ�
		return JOptionPane.showInputDialog(frame,
				"Enter IP Address of the Server:", "Welcome to the Chatter",
				JOptionPane.QUESTION_MESSAGE);
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.run();
	}
}