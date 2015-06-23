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
	// 메인서버의 IP주소
	String IP;
	// 현재실행중인 클라이언트의 IP주소
	String port;
	// 현재실행중인 사용자와 다른 사용자와의 1:1채팅을 위한 port#
	String myName;
	// 현재 사용자
	String selectUser;
	// 유저 list에서 선택한 유저의 이름
	String info[] = new String[6];
	// 유저의 정보를 담기위한 배열
	String name = null;
	String[] userIDPW;
	// 로그인할때 이렵한 아이디와 비밀번호
	String newUID;
	// 회원가입시 새로운 아이디
	String newUPW;
	// 회원가입시 새로운 비밀번호
	String newUNAME;
	// 회원가입시 새로운 유저이름
	BufferedReader in;
	// 메인서버와 통신을 하기 위한 인풋스트림
	static PrintWriter out;
	// 메인선버와 통신을 하기 위한 아웃풋 스트림
	private static HashSet<String> online = new HashSet<String>();
	// 게임중 유저를 저장하고 있는 배열입니다.
	String temp = null;
	// 에러체크를 위한 변수
	int chk;
	// 에러체크를 위한변수

	JFrame frame = new JFrame();
	// 로비창
	JPanel panelTitle_LB = new JPanel();
	JLabel labelTitle_LB = new JLabel();
	JLabel labelTitle2_LB = new JLabel();
	JLabel labelTitle3_LB = new JLabel();
	// 타이틀 꾸미기
	JTextArea messageArea = new JTextArea(8, 40);
	// 메시지나오는창
	JTextField textField = new JTextField(40);
	// 메시지입력창
	JTabbedPane chatGame = new JTabbedPane();
	// 로비유저 , 게임중 유저
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	JList<String> listOfuser = new JList<String>(listModel);
	// 로비유저목록창
	DefaultListModel<String> listModelGame = new DefaultListModel<String>();
	JList<String> listOfGameUser = new JList<String>(listModelGame);
	// 게임중유저목록창
	JPanel panel_button = new JPanel();
	public static JButton connection = new JButton();
	// 1:1채팅버튼
	JButton userInfo = new JButton();
	// "유저정보"버튼

	/*
	 * 로비창
	 */

	JFrame frame2 = new JFrame("로그인");
	// 로그인 프레임
	JPanel panelTitle = new JPanel();
	JLabel labelTitle = new JLabel();
	JLabel labelTitle2 = new JLabel();
	JLabel labelTitle3 = new JLabel();
	// 타이틀 로그인
	JPanel panelID = new JPanel();
	// 아이디패널
	JLabel labelID = new JLabel("아이디     ");
	JTextField ID = new JTextField(10);
	JPanel panelPW = new JPanel();
	// 아이디
	JLabel labelPW = new JLabel("비밀번호");
	JPasswordField PW = new JPasswordField(10);
	// 비밀번호

	JPanel panelButton2 = new JPanel();
	// 회원가입버튼, 로그인버튼을 붙이기위한 패널
	JButton newMember = new JButton();
	// "회원가입"버튼
	JButton login = new JButton();
	// "로그인"버튼

	/*
	 * 로그인 창
	 */

	JFrame frame3;
	// 회원가입 프레임
	JPanel panelTitle_SU = new JPanel();
	JLabel labelTitle_SU = new JLabel();
	JLabel labelTitle2_SU = new JLabel();
	JLabel labelTitle3_SU = new JLabel();
	// 타이틀 회원가입
	JPanel panelNewID = new JPanel();
	JLabel labelNewID = new JLabel("등록아이디     ");
	JTextField NewID = new JTextField(10);
	// 등록아이디

	JPanel panelNewPW = new JPanel();
	JLabel labelNewPW = new JLabel("등록비밀번호");
	JPasswordField NewPW = new JPasswordField(10);
	// 등록 비밀번호

	JPanel panelNewName = new JPanel();
	JLabel labelNewName = new JLabel("등록이름       ");
	JTextField NewName = new JTextField(10);
	// 등록 이름

	JPanel panelButton3 = new JPanel();
	JButton access = new JButton();// "등록"
	// 등록버튼

	/*
	 * 회원가입 창
	 */

	public JFrame frame_log = new JFrame("로그인실패");
	// 로그인 실패 메시지
	public JFrame frame4_log = new JFrame("회원가입성공");
	// 회원가입 성공 메시지
	public JFrame frame5_log = new JFrame("회원가입오류");
	// 회원가입 오류 메시지

	JFrame frame4;
	// 유저정보 프레임
	JPanel panelTitle_UI = new JPanel();
	JLabel labelTitle_UI = new JLabel();
	JLabel labelTitle2_UI = new JLabel();
	JLabel labelTitle3_UI = new JLabel();
	// 타이틀 꾸미기
	JPanel PanelUserRANK;
	JLabel labelUserRANK;
	JLabel UserRANK;
	// 유저계급
	JPanel panelUserID;
	JLabel labelUserID;
	JTextField UserID;
	// 유저 아이디
	JPanel panelUserName;
	JLabel labelUserName;
	JTextField UserName;
	// 유저이름
	JPanel panelUserWin;
	JLabel labelUserWin;
	JTextField UserWin;
	// 유저 승리횟수
	JPanel panelUserLose;
	JLabel labelUserLose;
	JTextField UserLose;
	// 유저 패배횟수
	JPanel panelUserDate;
	JLabel labelUserDate;
	JTextField UserDate;
	// 유저 최근 로그인 일자
	JPanel panel_exit_UI;
	JButton exit_UI;

	// 닫기 버튼

	/*
	 * 유저정보 창
	 */
	public static class Sound {
		// 소리 클래스
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
		// 드리블하는 마리오
		panelTitle_LB.add(TitleMario);
		panelTitle_LB.add(labelTitle3_LB);
		// 말풍선과 드리블마리오 붙이고

		panel_button.add(connection);
		panel_button.add(userInfo);
		// 버튼패널에 1:1버튼과 유저정보버튼 을 붙인다.

		Box chat = Box.createVerticalBox();
		messageArea.setEditable(false);
		chat.add(new JScrollPane(messageArea));
		chat.add(textField);
		// 박스레이아웃을 이용해서 수직으로 메시지나오는창과 입력창을 붙인다.
		Box listLobby = Box.createVerticalBox();
		listLobby.setPreferredSize(new Dimension(210, 130));
		listLobby.add(new JScrollPane(listOfuser));
		// 박스에 리스트를 붙여줍니다.
		Box listGame = Box.createVerticalBox();
		listGame.add(new JScrollPane(listOfGameUser));
		listGame.setPreferredSize(new Dimension(210, 130));
		// 박스에 게임중리스트를 붙여줍니다.
		listLobby.setBackground(bg);
		listGame.setBackground(bg);
		listOfuser.setPreferredSize(new Dimension(200, 120));
		listOfGameUser.setPreferredSize(new Dimension(200, 120));

		chatGame.addTab("로비", listLobby);
		chatGame.addTab("게임중", listGame);
		// 탭아이콘에 로비박스와과 게임중박스를 붙인다.

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
		// 박스레이아웃을 이용해서 수평으로 모든것을 합친다.
		/* 두개로 나눠서 안붙이니까 꺠져서 이렇게 할수 밖에없엇어요 ㅠㅠ조원님들 */

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
		// 프래임에 박스를 붙인다.
		frame.pack();
		frame.setResizable(false);

		// 프레임크기를 자동으로 조절한다.

		/*
		 * 로비화면 완성
		 */

		textField.addActionListener(new ActionListener() {
			// 채팅입력시 액션
			public void actionPerformed(ActionEvent e) {
				buttonSound("button.wav");
				out.println(textField.getText());
				textField.setText("");
			}
		});

		connection.addActionListener(new ActionListener() {
			// 1:1채팅시 액션
			public void actionPerformed(ActionEvent e) {
				buttonSound("button.wav");

				Random random = new Random();

				selectUser = (String) listOfuser.getSelectedValue();
				// list에서 선택된 이름을 저장한다.
				if (selectUser.equals(myName)) {
					// 현재 유저와 동일하면 오류 메시지를 출력한다.
					messageArea.append("본인과는 1:1채팅을 할 수 없습니다.\n");
				} else {
					InetAddress address = null;
					try {
						address = InetAddress.getLocalHost();
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					}
					IP = address.getHostAddress();
					// IP주소를 저장한다.
					port = Integer.toString(random.nextInt(1000));
					// 랜덤하게 포트번호를 받는다.

					out.println("대화연결 " + selectUser + " " + myName + " " + IP
							+ " " + port);
					// 접속을 당하는 사용자, 접속을 시도하는 사용자, 접속을 시도하는 사용자의 IP,
					// 접속을 시도하는 사용자의 새로운 port#를 'server'에 보내준다.
				}
			}
		});

		userInfo.addActionListener(new ActionListener() {
			// 유저정보 확인시 액션
			public void actionPerformed(ActionEvent e) {
				buttonSound("button.wav");
				String user = (String) listOfuser.getSelectedValue();
				// 선택된 유저의 정보를
				out.println("USERINFO " + user);
				// 메인서버에 유저정보 알려줄것을 요청한다.
			}
		});
	}

	public static void ExitSignal(String tmpName1, String tmpName2) {
		// 1:1채팅창이 종료되었을때 신호를 받아오는 메소드
		out.println("대화종료 " + tmpName1 + " " + tmpName2);
		// 메인서버에 1:1 채팅이 종료되었음을 알려준다.
	}

	public static void WinnerSignal(String Winner) {
		// 게임종료시 승리자를 받는 메소드
		out.println("WIN " + Winner);
		// 메인서버에 게임의 승리자를 알려줍니다.
	}

	public static void LoserSignal(String loser) {
		// 게임종료시 패배자를 받는 메소드
		out.println("LOSE " + loser);
		// 메인서버에 게임의 패배자를 알려줍니다.
	}

	public void buttonSound(String FileName) {
		// 버튼 효과음을 넣기위한 메소드
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
		// 타이틀
		panelID.add(labelID);
		panelID.add(ID);
		// 패널ID에 라벨과 버튼을 붙인다.
		panelPW.add(labelPW);
		panelPW.add(PW);
		// 패널PW에 라벨과 버튼을 붙인다.
		panelButton2.add(newMember);
		panelButton2.add(login);
		// 패널버튼2에 회원가입버튼과 로그인버튼을 붙인다.
		Box IDPW = Box.createVerticalBox();
		IDPW.add(panelTitle);
		IDPW.add(panelID);
		IDPW.add(panelPW);
		IDPW.add(panelButton2);
		// 박스레이아웃을 이용해서 수직으로 다 붙인다.

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
		// 프레임 중앙에 붙인다
		frame2.pack();
		// 프레임크기 자동조절
		frame2.setVisible(true);
		// 메소드 호출되면 보이게한다.
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 종료버튼 활성화

		/*
		 * 로그인창 완성
		 */

		newMember.addActionListener(new ActionListener() {
			// 회원가입 버튼글릭시 액션
			public void actionPerformed(ActionEvent e) {
				buttonSound("button.wav");
				newMember();
				// 회원가입 메소드를 호출한다.
			}
		});

		login.addActionListener(new ActionListener() {
			// 로그인 버튼 클릭시 액션
			public void actionPerformed(ActionEvent e) {
				buttonSound("button.wav");
				temp = null;
				userIDPW = null;
				temp = ID.getText() + " " + PW.getText();
				userIDPW = temp.split(" ");
				out.println("login " + userIDPW[0] + " " + userIDPW[1]);
				// 메인서버에 입력한 아이디 패스워드를 보내준다.
			}
		});

	}

	public void newMember() {
		frame3 = new JFrame("회원가입");

		frame3.addWindowListener(new WindowAdapter() {
			// 회원가입 종료버튼의 역할
			public void windowClosing(WindowEvent e) {
				frame3.dispose();
			}
		});

		panelTitle_SU = new JPanel();
		labelTitle_SU = new JLabel();
		labelTitle2_SU = new JLabel();
		labelTitle3_SU = new JLabel();
		// 타이틀
		panelNewID = new JPanel();
		labelNewID = new JLabel("등록아이디     ");
		NewID = new JTextField(10);
		// 등록아이디
		panelNewPW = new JPanel();
		labelNewPW = new JLabel("등록비밀번호");
		NewPW = new JPasswordField(10);
		// 등록 비밀번호
		panelNewName = new JPanel();
		labelNewName = new JLabel("등록이름       ");
		NewName = new JTextField(10);
		// 등록 이름
		panelButton3 = new JPanel();
		access = new JButton();// "등록"
		// 등록버튼
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
		// 패널ID에 라벨과 버튼을 붙인다.

		panelNewPW.add(labelNewPW);
		panelNewPW.add(NewPW);
		// 패널PW에 라벨과 버튼을 붙인다.

		panelNewName.add(labelNewName);
		panelNewName.add(NewName);

		panelButton3.add(access);

		// 패널버튼2에 회원가입버튼과 로그인버튼을 붙인다.

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
		// 프레임 중앙에 붙인다.
		frame3.pack();
		// 프레임크기 자동조절
		frame3.setVisible(true);
		frame3.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		/*
		 * 로그인창 꾸미기 완성
		 */

		access.addActionListener(new ActionListener() {
			// 회원가입 버튼글릭시 액션
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
					// 아무것도 입력하지 않았을 경우 에러메시지를 출력한다.
					JOptionPane.showMessageDialog(frame5_log,
							"공백란이 있는지 다시한번 확인해주세요.");
				} else {
					out.println("new " + newUID + " " + newUPW + " " + newUNAME);
					// 메인서버에 새로운 아이디 비밀번호 이름을 보내준다.
				}
			}
		});
	}

	private void UserInfomation(String[] tmp) {

		frame4 = new JFrame("유저정보");
		PanelUserRANK = new JPanel();
		labelUserRANK = new JLabel("유저계급      ");
		UserRANK = new JLabel();

		panelUserID = new JPanel();
		labelUserID = new JLabel("유저아이디   ");
		UserID = new JTextField(10);
		// 유저 아이디
		panelUserName = new JPanel();
		labelUserName = new JLabel("유저이름      ");
		UserName = new JTextField(10);
		// 유저이름
		panelUserWin = new JPanel();
		labelUserWin = new JLabel("유저승리횟수");
		UserWin = new JTextField(10);
		// 유저 승리횟수
		panelUserLose = new JPanel();
		labelUserLose = new JLabel("유저패배횟수");
		UserLose = new JTextField(10);
		// 유저 패배횟수
		panelUserDate = new JPanel();
		labelUserDate = new JLabel("최근로그인   ");
		UserDate = new JTextField(10);
		// 최근 로그인일자
		panel_exit_UI = new JPanel();
		exit_UI = new JButton();// "닫기"

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
		// 계급 정보
		if (Integer.parseInt(tmp[3]) >= 0 && Integer.parseInt(tmp[3]) <= 3)
			UserRANK.setIcon(low);
		// 0~3 짚신
		else if (Integer.parseInt(tmp[3]) >= 4
				&& Integer.parseInt(tmp[3]) <= 10)
			UserRANK.setIcon(mid);
		// 4~10 운동화
		else if (Integer.parseInt(tmp[3]) >= 11
				&& Integer.parseInt(tmp[3]) <= 30)
			UserRANK.setIcon(high);
		// 11~30 축구화
		else if (Integer.parseInt(tmp[3]) >= 31)
			UserRANK.setIcon(max);
		// 31이상 황금축구화

		panelUserID.add(labelUserID);
		panelUserID.add(UserID);
		UserID.setText(tmp[0]);
		UserID.setEditable(false);
		// 유저아이디 정보

		panelUserName.add(labelUserName);
		panelUserName.add(UserName);
		UserName.setText(tmp[2]);
		UserName.setEditable(false);
		// 유저 이름 정보

		panelUserWin.add(labelUserWin);
		panelUserWin.add(UserWin);
		UserWin.setText(tmp[3]);
		UserWin.setEditable(false);
		// 유저 승수 정보

		panelUserLose.add(labelUserLose);
		panelUserLose.add(UserLose);
		UserLose.setText(tmp[4]);
		UserLose.setEditable(false);
		// 유저 패배수 정보

		panelUserDate.add(labelUserDate);
		panelUserDate.add(UserDate);
		UserDate.setText(tmp[5]);
		UserDate.setEditable(false);
		// 최근 로그인 날짜 정보

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
		// 프레임 중앙에 붙인다.
		frame4.pack();
		// 프레임크기 자동조절
		frame4.setVisible(true);
		// 프레임 보이게

		/*
		 * 우저정보창 꾸미기 완성
		 */

		exit_UI.addActionListener(new ActionListener() {
			// 유저정보 확인시 액션
			public void actionPerformed(ActionEvent e) {
				buttonSound("button.wav");
				frame4.dispose();
				// 프레임 닫는다.

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
			// 서버로 부터 정보를 받아오기위한 input stream 을 열어줍니다.
			out = new PrintWriter(socket.getOutputStream(), true);
			// 서버로 정보를 보내기 위한 output stream 을 열어줍니다.

			int checkforone = 0;
			while (true) {
				String line = in.readLine();
				String temp[] = line.split(" ");

				// 'line'을 " "기준으로 나누어준다.
				// temp[1] = 접속을 당하는 사용자
				// temp[2] = 접속을 시도하는 사용자
				// temp[3] = 접속을 시도하는 사용자의 port#
				// temp[4] = 접속을 시도하는 사용자의 IP

				if (line.startsWith("SUBMITNAME")) {
					if (checkforone == 0) {
						login();
						// 로그인 메소드를 실행합니다.
						frame.setVisible(false);
						checkforone = 1;
					}
				} else if (line.startsWith("loginFail")) {
					Component frame = null;
					/*
					 * 만일 가입되어있지 않은 회원이거나 비밀번호가 틀리다면, 에러메시지를 출력합니다.
					 */
					JOptionPane.showMessageDialog(frame,
							"아이디 혹은 비밀번호가 일치하지 않습니다.");
				} else if (line.startsWith("equalID")) {
					/*
					 * 만일 현재 접속중인 아ㄷ이디라면, 에러메시지를 출력합니다.
					 */
					Component frame = null;
					JOptionPane.showMessageDialog(frame,
							"현재 접속중인 유저입니다. 다시 로그인해주세요.");
				} else if (line.startsWith("NEWNAME")) {
					// 로그인 성공
					myName = line.substring(8);
					frame.setTitle(myName + "님 마리오사커에 오신것을 환영합니다!");
				} else if (line.startsWith("SUCCESS_NEWMEMBER")) {
					// 회원가입 성공
					Component frame4 = null;
					JOptionPane.showMessageDialog(frame4, "회원가입을 축하합니다.");
					frame3.setVisible(false);
					// 성공 메시지 띄울것
				} else if (line.startsWith("NEWIDFAIL")) {
					/*
					 * 회원가입시 이미 존재하는 아이디라면, 에러메시지를 출력합니다.
					 */
					Component frame5 = null;
					JOptionPane.showMessageDialog(frame5,
							"이미 등록된 아이디 입니다. 다른 아이디로 가입해주세요.");
				} else if (line.startsWith("NAMEACCEPTED")) {
					Sound.stop();
					frame.setVisible(true);
					frame2.setVisible(false);
					textField.setEditable(true);
				} else if (line.startsWith("Entrance")) {
					/*
					 * 새로운 유저가 들어왔다면 리스트를 비워줍니다.
					 */
					listModel.clear();
					listModelGame.clear();
				} else if (line.startsWith("INFO")) {
					/*
					 * 메인서버에게 유저정보를 받아옵니다.
					 */
					for (int i = 0; i < 6; i++) {
						info[i] = temp[i + 1];
					}
					UserInfomation(info);
				} else if (line.startsWith("SetList")) {
					/*
					 * 새로운 유저가 들어왓다면, 로비리스트를 다시 채워줍니다. 새로운 유저가 들어왓다면, 게임중리스트를 다시
					 * 채워줍니다.
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
					 * 새로운 유저가 들어왔다는것을 메시지창에 출력합니다.
					 */
					messageArea.append(line.substring(6) + "\n");
				} else if (line.startsWith("removeList")) {
					/*
					 * 유저가 로그아웃했다면, 리스트에서 지워줍니다.
					 */
					Thread.sleep(30);
					listModel.removeElement(line.substring(11));
					listOfuser.repaint();
					listOfGameUser.repaint();
				} else if (line.startsWith("EXIT")) {
					/*
					 * 유저가 로그아웃했다면, 메시지창에 나갔음을 알려줍니다.
					 */
					messageArea.append(line.substring(5) + "\n");
				} else if (line.startsWith("MESSAGE")) {
					/*
					 * 채팅 메시지를 입력했다면, 메시지창에 띄워줍니다.
					 */
					messageArea.append(line.substring(8) + "\n");
				} else if (line.startsWith("Connection")) {
					if (myName.equals(temp[1])) {
						// 접속을 당하는 사용자라면
						Client_Client c = new Client_Client(temp[1], temp[2],
								temp[3], Integer.parseInt(temp[4]));
						// 당하는 사용자, 시도하는 사용자, IP주소, port#
						c.start();
						// 1:1채팅 클라이언트 쪽 쓰레드를 시작한다.
						connection.setEnabled(false);
						// 해당 아이디는 1:1채팅 버튼을 비활성화 해준다.
					} else if (myName.equals(temp[2]) && IP.equals(temp[3])) {
						// 접속을 시도하는 사용자이고 IP주소가 그 사용자와 일치한다면
						out.println("대화시작 " + myName + " " + selectUser);
						// 메인서버에 1:1대화를 시작하였다고 알려준다.
						Client_Server s = new Client_Server(temp[2], temp[1],
								Integer.parseInt(temp[4]));
						// 시도하는 사용자, 당하는 사용자, port#
						s.start();
						// 1:1채팅 서버쪽 쓰레드를 시작한다.
						connection.setEnabled(false);
						// 해당 아이디는 1:1채팅 버튼을 비활성화 해준다.
					}
				} else if (line.startsWith("START")) {
					/*
					 * 1:1대화를 시작했다면, 리스트에서 해당 사용자를 없애주고, 1:1 대화를 시작했음을 메시지창에
					 * 아려줍니다.
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
					// 게임중 유저추가
					listModel.removeElement(temp[1]);
					listModel.removeElement(temp[3]);
					// 로비유저 삭제
				} else if (line.startsWith("END")) {
					/*
					 * 1:1대화가 종료되면 메시지로 해당 사실을 알려줍니다.
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
		// 메인서버의 아이피 주소를 받는 메소드
		return JOptionPane.showInputDialog(frame,
				"Enter IP Address of the Server:", "Welcome to the Chatter",
				JOptionPane.QUESTION_MESSAGE);
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.run();
	}
}