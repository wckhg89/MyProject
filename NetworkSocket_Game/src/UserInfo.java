import java.io.*;
import java.util.Calendar;

public class UserInfo {

	static String ID = null;
	static String PW = null;
	static String name = null;
	static String nID = null;
	static String nPW = null;
	static String nName = null;
	static String[][] user = new String[100][6];
	String[] temp = new String[6];
	int year, mon, day, hour, min;
	static int check;
	static int length;
	static String date;
	static String returnValue = "failed";
	static String returnInfo[] = new String[6];

	public UserInfo(String tmp1, String tmp2) {
		// ����Ʈ����1 �Ҹ������� ��¥ ����
		ID = tmp1;
		PW = tmp2;
		Calendar now = Calendar.getInstance();
		year = now.get(Calendar.YEAR);
		mon = now.get(Calendar.MONTH) + 1;
		day = now.get(Calendar.DAY_OF_MONTH);
		hour = now.get(Calendar.HOUR_OF_DAY);
		min = now.get(Calendar.MINUTE);
		date = year + "/" + mon + "/" + day + "/" + hour + "/" + min;
		returnValue = "failed";
	}

	public UserInfo(String tmp1, String tmp2, String tmp3) {
		// ����Ʈ����2 �Ҹ������� ��¥ ����
		nID = tmp1;
		nPW = tmp2;
		nName = tmp3;

		Calendar now = Calendar.getInstance();
		year = now.get(Calendar.YEAR);
		mon = now.get(Calendar.MONTH) + 1;
		day = now.get(Calendar.DAY_OF_MONTH);
		hour = now.get(Calendar.HOUR_OF_DAY);
		min = now.get(Calendar.MINUTE);
		date = year + "/" + mon + "/" + day + "/" + hour + "/" + min;
		returnValue = "failed";
	}

	public UserInfo(String tmp) {
		// ����Ʈ���� 3
		name = tmp;
	}

	public void serachWin() throws IOException {
		/*
		 * �̱� ������ �������� ã�� �޼ҵ�
		 */
		BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
		String line;

		int i = 0;
		while ((line = reader.readLine()) != null) // ������ ���� null �� �ɶ����� �о
		{
			temp = line.split(" ");

			for (int j = 0; j < 6; j++) {
				user[i][j] = temp[j];
			}
			i++;
			length = i;
		}

		for (i = 0; i < length; i++) {// � ������ �̱� �������� Ž��
			if (name.equalsIgnoreCase(user[i][2])) {
				try {
					writeFileWin(i);// ã�Ҵٸ�, �ش������� �¼��� ���������ݴϴ�.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		reader.close();
	}

	public static void writeFileWin(int check) throws Exception {
		/*
		 * ���ӿ� �̱����� �¼��� �÷��ִ� �޼ҵ��Դϴ�. ó������ txt���Ͽ� �ٽý��ִµ�, �̶� �̱������� ���ο��� �¼��� �ϳ�
		 * �÷��� ����մϴ�.
		 */
		PrintWriter writer = new PrintWriter(new FileWriter("user.txt"));
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < 6; j++) {
				if (j == 3 && check == i) {
					writer.print(Integer.parseInt(user[i][j]) + 1 + " ");
				} else {
					writer.print(user[i][j] + " ");
				}
			}
			writer.println();
		}
		writer.close();
	}

	public void serachLose() throws IOException {
		/*
		 * ���� ������ �������� ã�� �޼ҵ��Դϴ�.
		 */
		BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
		String line;

		int i = 0;
		while ((line = reader.readLine()) != null) // ������ ���� null �� �ɶ����� �о
		{
			temp = line.split(" ");

			for (int j = 0; j < 6; j++) {
				user[i][j] = temp[j];
			}
			i++;
			length = i;
		}

		for (i = 0; i < length; i++) {// � ������ ���� �������� Ž��
			if (name.equalsIgnoreCase(user[i][2])) {

				try {
					writeFileLose(i);// ã�Ҵٸ�, �ش������� �м��� ���������ݴϴ�.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		reader.close();
	}

	public static void writeFileLose(int check) throws Exception {
		/*
		 * ���ӿ� �̱����� �¼��� �÷��ִ� �޼ҵ��Դϴ�. ó������ txt���Ͽ� �ٽý��ִµ�, �̶� �̱������� ���ο��� �¼��� �ϳ�
		 * �÷��� ����մϴ�.
		 */
		PrintWriter writer = new PrintWriter(new FileWriter("user.txt"));
		for (int i = 0; i < length; i++) {

			for (int j = 0; j < 6; j++) {
				if (j == 4 && check == i) {
					writer.print(Integer.parseInt(user[i][j]) + 1 + " ");
				} else {
					writer.print(user[i][j] + " ");
				}
			}
			writer.println();
		}
		writer.close();
	}

	public String[] returnSelectInfo() throws IOException {
		/*
		 * ���������� �޾ƿ��� �ؽ�Ʈ���Ͽ��� �޾ƿ��� �޼ҵ��Դϴ�.
		 */

		BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
		String line;

		int i = 0;
		while ((line = reader.readLine()) != null) // ������ ���� null �� �ɶ����� �о
		{
			temp = line.split(" ");

			if (name.equalsIgnoreCase(temp[2])) {
				returnInfo = temp;
			}

			i++;
			length = i;
		}
		reader.close();

		return returnInfo;
	}

	public int equalID() throws IOException {
		// ȸ�����Խ� ���� ���ԵǾ� �ִ� ���̵� �ִ��� �˻��Ѵ�.

		BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
		String line;
		int returnValue = 0;
		int chk = 0;

		int i = 0;

		while ((line = reader.readLine()) != null) // ������ ���� null �� �ɶ����� �о
		{
			temp = line.split(" ");

			for (int j = 0; j < 6; j++) {
				user[i][j] = temp[j];
			}

			if (nID.equalsIgnoreCase(temp[0])) {

				chk = 1;
			}

			i++;
			length = i;
		}

		reader.close();
		try {
			if (chk == 0) {
				returnValue = writeNewUser();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	public String matchUser() throws IOException {
		// �α��ν� ���̵� Ž���Ѵ�.

		BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
		String line;

		int i = 0;
		while ((line = reader.readLine()) != null) // ������ ���� null �� �ɶ����� �о
		{
			temp = line.split(" ");

			for (int j = 0; j < 6; j++) {
				user[i][j] = temp[j];
			}
			i++;
			length = i;
		}

		for (i = 0; i < length; i++) {// �α��� ������ ��������Ʈ�� �����ϴ��� Ž��
			if (ID.equalsIgnoreCase(user[i][0])) {
				if (PW.equalsIgnoreCase(user[i][1])) {
					try {
						writeFile(i);// �ִٸ� ��¥������ ���� ���� �ٽý��ش�.
					} catch (Exception e) {
						e.printStackTrace();
					}
					returnValue = user[i][2];// ���Ұ����� �����̸��� �ش�.
				}
			}
		}
		reader.close();

		return returnValue;
	}

	public static void writeFile(int check) throws Exception {
		/*
		 * �α��ο� ����������, �ش������� �α��� �ð��� �ֽ�ȭ�Ͽ� �ؽ�Ʈ���Ͽ� ������ݴϴ�.
		 */
		PrintWriter writer = new PrintWriter(new FileWriter("user.txt"));
		for (int i = 0; i < length; i++) {

			for (int j = 0; j < 6; j++) {
				if (j == 5 && check == i) {
					writer.print(date);
				} else {
					writer.print(user[i][j] + " ");
				}
			}
			writer.println();
		}
		writer.close();
	}

	public static int writeNewUser() throws Exception {
		/*
		 * ���ο� ������ ����� �ش� �ؽ�Ʈ ���Ͽ� �߰����ִ� �޼ҵ��Դϴ�.
		 */
		PrintWriter writer = new PrintWriter(new FileWriter("user.txt"));
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < 6; j++) {
				writer.print(user[i][j] + " ");
			}
			writer.println();
		}
		writer.print(nID + " " + nPW + " " + nName + " " + "0" + " " + "0"
				+ " " + date);
		writer.println();
		writer.close();
		return 1;
	}
}
