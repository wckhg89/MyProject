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

	// ä������ �������

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
						// Ŭ���̾�Ʈ���� �α��� ��ư�� �����ٸ�

						UserInfo user = new UserInfo(temp[1], temp[2]);
						// ���������� �����ϴ� Ŭ���� (Client���� �޾ƿ� ID�� PW�� �Ѱ��ش�.)

						name = user.matchUser();
						/*
						 * ��ġ�ϴ� ���̵� ��й�ȣ�� �ش� ���̵��� �����̸��� ���Ϲް� �׷��� �ʴٸ� failed�޽�����
						 * ���Ϲ޴´�.
						 */

						if (name.equalsIgnoreCase("failed")) {
							out.println("loginFail");
							// �����ϴ� ���̵� �ƴҰ�� �����޽����� Ŭ���̾�Ʈ�� �����ش�.
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
									// �̹� �������� �������� Ŭ���̾�Ʈ���� �˷��ش�.
								}
							}
						}
					} else if (temp[0].equalsIgnoreCase("new")) {
						// Ŭ���̾�Ʈ���� ȸ�������� �ߴٸ�

						UserInfo user = new UserInfo(temp[1], temp[2], temp[3]);
						// ���������� �����ϴ� Ŭ������ �ű� �������̵� ��й�ȣ �̸��� �����ش�.

						int chkID = user.equalID();
						/*
						 * �̹� ��ϵ� ���̵����� �ƴ��� Ȯ���Ѵ�. ���� ��ϵ� ���̵� �ƴ϶�� 1�� �������ְ� �׷���
						 * �ʴٸ� 0�� �����Ѵ�.
						 */

						if (chkID == 1) {
							out.println("SUCCESS_NEWMEMBER");
							// ȸ�������� ���������� Ŭ���̾�Ʈ���� �˷��ش�.
						} else {
							out.println("NEWIDFAIL");
							// �̹� ��ϵ� ���̵�(ȸ������ ����)��� Ŭ���̾�Ʈ���� �˷��ش�.
						}

					}
				}

				out.println("NAMEACCEPTED");
				writers.add(out);

				for (PrintWriter writer : writers)
					writer.println("Entrance ");
				/*
				 * �������� 'client'�鿡�� "Entrance "�� �����ݴϴ�. (Ŭ���̾�Ʈ�� Entrance �޽����� �ް�
				 * ����Ʈ�� ���� �ٽ� ä���غ� �Ѵ�.)
				 */
				for (PrintWriter writer : writers) {
					Iterator<String> iterator = names.iterator();
					while (iterator.hasNext()) {
						String list_name = iterator.next();
						if (!chatUser.contains(list_name)) {
							/*
							 * 1:1ä������ ������ ������ ���ο� ������ ���ö�ä������ ������ ��ġ���� �ʴ´ٸ�
							 */
							writer.println("SetList " +"LIST " + list_name);
							/*
							 * �������� 'client'�鿡�� "SetList "�� �����ݴϴ�. ����� ����Ʈ�� �ٽ�
							 * �������� ä���(��, 1:1ä������ ����ڴ� ����Ʈ�� ä���� �ʴ´�.)
							 */
						} else if (chatUser.contains(list_name))
							writer.println("SetList " +"GAME " + list_name);
					}
				}

				int check = 0;

				while (true) {
					if (check == 0) {
						for (PrintWriter writer : writers) {
							writer.println("ENTER " + name + " ���� �����ϼ̽��ϴ�.");
							// ��� Ŭ���̾�Ʈ���� ���� ����ڸ� �˷��ش�.
						}
						check++;
					}

					String input = in.readLine();
					String temp[] = input.split(" ");// Ŭ���̾�Ʈ�� ���� �� �޽����� �ɰ���
					/*
					 * temp[1] = ������ ���ϴ� �����, temp[2] = ������ �õ��ϴ� ����� temp[3] =
					 * ������ �õ��ϴ� ����� IP�ּ�, temp[4] = ������ �õ��ϴ� ����� port#
					 */
					if (temp[0].equalsIgnoreCase("login")) {
						continue;
					} else if (temp[0].equalsIgnoreCase("USERINFO")) {
						/*
						 * Ŭ���̾�Ʈ�� ���������� ��ȸ�Ͽ��ٸ�, �ش� ������ Ŭ���̾�Ʈ���� �����ش�.
						 */
						String info[] = new String[6];
						UserInfo userInfomation = new UserInfo(temp[1]);
						info = userInfomation.returnSelectInfo();
						/*
						 * �������� Ŭ������ Ž���Ͽ� ��ġ�ϴ� ������ ������ �������ش�.
						 */
						out.println("INFO " + info[0] + " " + info[1] + " "
								+ info[2] + " " + info[3] + " " + info[4] + " "
								+ info[5]);
						// ���Ϲ��� ������ ũ���̾�Ʈ���� �����ش�.
					} else if (temp[0].equalsIgnoreCase("��ȭ����")) {
						for (PrintWriter writer : writers)
							// ��� Ŭ���̾�Ʈ�� 1:1��ȭ ���� �޽����� ������.
							writer.println("Connection " + temp[1] + " "
									+ temp[2] + " " + temp[3] + " " + temp[4]);
					} else if (temp[0].equalsIgnoreCase("��ȭ����")) {
						chatUser.add(temp[1]);
						chatUser.add(temp[2]);
						// 1:1 ä������ ���� �迭�� ����

						for (PrintWriter writer : writers)
							// ��� Ŭ���̾�Ʈ�� �޽����� ������.
							writer.println("START " + temp[1] + " �԰� "
									+ temp[2] + " ���� 1:1 ��ȭ�� �����Ͽ����ϴ�.");

					} else if (temp[0].equalsIgnoreCase("��ȭ����")) {
						chatUser.remove(temp[1]);
						chatUser.remove(temp[2]);
						// 1:1ä���� ���� ������ �迭���� ����
						// ���⼭ �ι��Ѹ���
						for (PrintWriter writer : writers)
							writer.println("Entrance ");
						// ��ȭ���ᰡ �ι��Ǵϱ� ��� �ʱ�ȭ�� ���ش�.
						for (PrintWriter writer : writers)
							// ��� Ŭ���̾�Ʈ�� 1:1��ȭ ���� �޽����� ������.
							writer.println("END " + temp[1] + " �԰� " + temp[2]
									+ " ���� 1:1 ��ȭ�� �����Ͽ����ϴ�.");
						for (PrintWriter writer : writers) {
							Iterator<String> iterator = names.iterator();
							while (iterator.hasNext()) {
								String list_name = iterator.next();
								if (!chatUser.contains(list_name)) {
									// ���� ���� ä������ ������ ��ġ���� �ʴ´ٸ�
									writer.println("SetList " +"LIST " +list_name);
									// �������� 'client'�鿡�� "SetList "�� �����ݴϴ�.
								}
								else
									writer.println("SetList " +"GAME " +list_name);
							}
						}

					} else if (temp[0].equalsIgnoreCase("WIN")) {
						/*
						 * ������ ����Ǹ� �¸��ڿ��� �¼��� ���������ش�.
						 */
						UserInfo WIN = new UserInfo(temp[1]);
						WIN.serachWin();
					} else if (temp[0].equalsIgnoreCase("LOSE")) {
						/*
						 * ������ ����Ǹ� �й��ڿ��� �м��� ���������ش�.
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
						writer.println("EXIT " + name + " ���� �����Ͽ����ϴ�.");
					}
					/*
					 * ������ �α׾ƿ��ϸ� ���Ŭ���̾�Ʈ���� �޽����� �־� ������ �˸��� ����Ʈ���� �ش� ������ �����.
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