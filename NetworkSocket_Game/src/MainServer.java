import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class MainServer {

	private static final int PORT = 9001;

	private static HashSet<String> names = new HashSet<String>();

	private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();

	private static ArrayList<String> chatUser = new ArrayList<String>();

	// 채팅중인 유저목록

	public static void main(String[] args) throws Exception {
		System.out.println("The chat server is running.");
		ServerSocket listener = new ServerSocket(PORT);
		try {
			while (true) {
				new Handler(listener.accept()).start();
			}
		} finally {
			listener.close();
		}
	}

	private static class Handler extends Thread {
		private String name;
		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;

		public Handler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);

				while (true) {
					String tmp = "";
					out.println("SUBMITNAME");
					tmp = in.readLine();

					String temp[] = tmp.split(" ");

					if (temp[0].equalsIgnoreCase("login")) {
						// 클라이언트에서 로그인 버튼을 눌렀다면

						UserInfo user = new UserInfo(temp[1], temp[2]);
						// 유저정보를 관리하는 클래스 (Client에게 받아온 ID와 PW를 넘겨준다.)

						name = user.matchUser();
						/*
						 * 일치하는 아이디 비밀번호면 해당 아이디의 유저이름을 리턴받고 그렇지 않다면 failed메시지를
						 * 리턴받는다.
						 */

						if (name.equalsIgnoreCase("failed")) {
							out.println("loginFail");
							// 존재하는 아이디가 아닐경우 오류메시지를 클라이언트에 보내준다.
						} else if (name == null) {
							return;
						} else {
							synchronized (names) {
								if (!names.contains(name)) {
									out.println("NEWNAME " + name);
									names.add(name);
									break;
								} else {
									out.println("equalID");
									// 이미 접속중인 유저임을 클라이언트에게 알려준다.
								}
							}
						}
					} else if (temp[0].equalsIgnoreCase("new")) {
						// 클라이언트에서 회원가입을 했다면

						UserInfo user = new UserInfo(temp[1], temp[2], temp[3]);
						// 유저정보를 관리하는 클래스에 신규 유저아이디 비밀번호 이름을 보내준다.

						int chkID = user.equalID();
						/*
						 * 이미 등록된 아이디인지 아닌지 확인한다. 만일 등록된 아이디가 아니라면 1을 리턴해주고 그렇지
						 * 않다면 0을 리턴한다.
						 */

						if (chkID == 1) {
							out.println("SUCCESS_NEWMEMBER");
							// 회원가입이 성공했음을 클라이언트에게 알려준다.
						} else {
							out.println("NEWIDFAIL");
							// 이미 등록된 아이디(회원가입 실패)라고 클라이언트에게 알려준다.
						}

					}
				}

				out.println("NAMEACCEPTED");
				writers.add(out);

				for (PrintWriter writer : writers)
					writer.println("Entrance ");
				/*
				 * 접속중인 'client'들에게 "Entrance "을 보내줍니다. (클라이언트는 Entrance 메시지를 받고
				 * 리스트를 비우고 다시 채울준비를 한다.)
				 */
				for (PrintWriter writer : writers) {
					Iterator<String> iterator = names.iterator();
					while (iterator.hasNext()) {
						String list_name = iterator.next();
						if (!chatUser.contains(list_name)) {
							/*
							 * 1:1채팅중인 유저가 있을때 새로운 유저가 들어올때채팅중인 유저와 일치하지 않는다면
							 */
							writer.println("SetList " +"LIST " + list_name);
							/*
							 * 접속중인 'client'들에게 "SetList "을 보내줍니다. 비워진 리스트에 다시
							 * 유저들을 채운다(단, 1:1채팅중인 사용자는 리스트에 채우지 않는다.)
							 */
						} else if (chatUser.contains(list_name))
							writer.println("SetList " +"GAME " + list_name);
					}
				}

				int check = 0;

				while (true) {
					if (check == 0) {
						for (PrintWriter writer : writers) {
							writer.println("ENTER " + name + " 님이 입장하셨습니다.");
							// 모든 클라이언트에게 들어온 사용자를 알려준다.
						}
						check++;
					}

					String input = in.readLine();
					String temp[] = input.split(" ");// 클라이언트로 부터 온 메시지를 쪼갠다
					/*
					 * temp[1] = 접속을 당하는 사용자, temp[2] = 접속을 시도하는 사용자 temp[3] =
					 * 접속을 시도하는 사용자 IP주소, temp[4] = 접속을 시도하는 사용자 port#
					 */
					if (temp[0].equalsIgnoreCase("login")) {
						continue;
					} else if (temp[0].equalsIgnoreCase("USERINFO")) {
						/*
						 * 클라이언트가 유저정보를 조회하였다면, 해당 정보를 클라이언트에게 보내준다.
						 */
						String info[] = new String[6];
						UserInfo userInfomation = new UserInfo(temp[1]);
						info = userInfomation.returnSelectInfo();
						/*
						 * 유저인포 클래스를 탐색하여 일치하는 유저의 정보를 리턴해준다.
						 */
						out.println("INFO " + info[0] + " " + info[1] + " "
								+ info[2] + " " + info[3] + " " + info[4] + " "
								+ info[5]);
						// 리턴받은 정보를 크라이언트에게 보내준다.
					} else if (temp[0].equalsIgnoreCase("대화연결")) {
						for (PrintWriter writer : writers)
							// 모든 클라이언트에 1:1대화 연결 메시지를 보낸다.
							writer.println("Connection " + temp[1] + " "
									+ temp[2] + " " + temp[3] + " " + temp[4]);
					} else if (temp[0].equalsIgnoreCase("대화시작")) {
						chatUser.add(temp[1]);
						chatUser.add(temp[2]);
						// 1:1 채팅중인 유저 배열에 저장

						for (PrintWriter writer : writers)
							// 모든 클라이언트에 메시지를 보낸다.
							writer.println("START " + temp[1] + " 님과 "
									+ temp[2] + " 님이 1:1 대화를 시작하였습니다.");

					} else if (temp[0].equalsIgnoreCase("대화종료")) {
						chatUser.remove(temp[1]);
						chatUser.remove(temp[2]);
						// 1:1채팅이 끝난 유저는 배열에서 삭제
						// 여기서 두번뿌린다
						for (PrintWriter writer : writers)
							writer.println("Entrance ");
						// 대화종료가 두번되니까 계속 초기화를 해준다.
						for (PrintWriter writer : writers)
							// 모든 클라이언트에 1:1대화 종료 메시지를 보낸다.
							writer.println("END " + temp[1] + " 님과 " + temp[2]
									+ " 님이 1:1 대화를 종료하였습니다.");
						for (PrintWriter writer : writers) {
							Iterator<String> iterator = names.iterator();
							while (iterator.hasNext()) {
								String list_name = iterator.next();
								if (!chatUser.contains(list_name)) {
									// 만일 현재 채팅중인 유저와 일치하지 않는다면
									writer.println("SetList " +"LIST " +list_name);
									// 접속중인 'client'들에게 "SetList "을 보내줍니다.
								}
								else
									writer.println("SetList " +"GAME " +list_name);
							}
						}

					} else if (temp[0].equalsIgnoreCase("WIN")) {
						/*
						 * 게임이 종료되면 승리자에게 승수를 증가시켜준다.
						 */
						UserInfo WIN = new UserInfo(temp[1]);
						WIN.serachWin();
					} else if (temp[0].equalsIgnoreCase("LOSE")) {
						/*
						 * 게임이 종료되면 패배자에게 패수를 증가시켜준다.
						 */
						UserInfo LOSE = new UserInfo(temp[1]);
						LOSE.serachLose();
					} else {
						for (PrintWriter writer : writers) {
							writer.println("MESSAGE " + name + " : " + input);
						}
					}
				}

			} catch (IOException e) {
				System.out.println(e);
			} finally {
				if (!name.equalsIgnoreCase("failed")) {
					for (PrintWriter writer : writers) {
						writer.println("removeList " + name);
					}
					for (PrintWriter writer : writers) {
						writer.println("EXIT " + name + " 님이 퇴장하였습니다.");
					}
					/*
					 * 유저가 로그아웃하면 모든클라이언트에게 메시지를 주어 퇴장을 알리고 리스트에서 해당 유저를 지운다.
					 */
				}
				if (name != null) {
					names.remove(name);
				}
				if (out != null) {
					writers.remove(out);
				}
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
	}

}