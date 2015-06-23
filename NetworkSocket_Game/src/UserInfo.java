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
		// 컨스트럭터1 불릴때마다 날짜 갱신
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
		// 컨스트럭터2 불릴때마다 날짜 갱신
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
		// 컨스트럭터 3
		name = tmp;
	}

	public void serachWin() throws IOException {
		/*
		 * 이긴 유저가 누구인지 찾는 메소드
		 */
		BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
		String line;

		int i = 0;
		while ((line = reader.readLine()) != null) // 라인의 값이 null 이 될때까지 읽어냄
		{
			temp = line.split(" ");

			for (int j = 0; j < 6; j++) {
				user[i][j] = temp[j];
			}
			i++;
			length = i;
		}

		for (i = 0; i < length; i++) {// 어떤 유저가 이긴 유저인지 탐색
			if (name.equalsIgnoreCase(user[i][2])) {
				try {
					writeFileWin(i);// 찾았다면, 해당유저의 승수를 증가시켜줍니다.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		reader.close();
	}

	public static void writeFileWin(int check) throws Exception {
		/*
		 * 게임에 이긴사람의 승수를 올려주는 메소드입니다. 처음부터 txt파일에 다시써주는데, 이때 이긴유저의 라인에만 승수를 하나
		 * 올려서 기록합니다.
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
		 * 패한 유저가 누구인지 찾는 메소드입니다.
		 */
		BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
		String line;

		int i = 0;
		while ((line = reader.readLine()) != null) // 라인의 값이 null 이 될때까지 읽어냄
		{
			temp = line.split(" ");

			for (int j = 0; j < 6; j++) {
				user[i][j] = temp[j];
			}
			i++;
			length = i;
		}

		for (i = 0; i < length; i++) {// 어떤 유저가 패한 유저인지 탐색
			if (name.equalsIgnoreCase(user[i][2])) {

				try {
					writeFileLose(i);// 찾았다면, 해당유저의 패수를 증가시켜줍니다.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		reader.close();
	}

	public static void writeFileLose(int check) throws Exception {
		/*
		 * 게임에 이긴사람의 승수를 올려주는 메소드입니다. 처음부터 txt파일에 다시써주는데, 이때 이긴유저의 라인에만 승수를 하나
		 * 올려서 기록합니다.
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
		 * 유저정보를 받아오는 텍스트파일에서 받아오는 메소드입니다.
		 */

		BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
		String line;

		int i = 0;
		while ((line = reader.readLine()) != null) // 라인의 값이 null 이 될때까지 읽어냄
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
		// 회원가입시 현재 가입되어 있는 아이디가 있는지 검사한다.

		BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
		String line;
		int returnValue = 0;
		int chk = 0;

		int i = 0;

		while ((line = reader.readLine()) != null) // 라인의 값이 null 이 될때까지 읽어냄
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
		// 로그인시 아이디를 탐색한다.

		BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
		String line;

		int i = 0;
		while ((line = reader.readLine()) != null) // 라인의 값이 null 이 될때까지 읽어냄
		{
			temp = line.split(" ");

			for (int j = 0; j < 6; j++) {
				user[i][j] = temp[j];
			}
			i++;
			length = i;
		}

		for (i = 0; i < length; i++) {// 로그인 유저가 유저리스트에 존재하는지 탐색
			if (ID.equalsIgnoreCase(user[i][0])) {
				if (PW.equalsIgnoreCase(user[i][1])) {
					try {
						writeFile(i);// 있다면 날짜갱신을 위해 파일 다시써준다.
					} catch (Exception e) {
						e.printStackTrace();
					}
					returnValue = user[i][2];// 리텀값으로 유저이름을 준다.
				}
			}
		}
		reader.close();

		return returnValue;
	}

	public static void writeFile(int check) throws Exception {
		/*
		 * 로그인에 성공했을시, 해당유저의 로그인 시간을 최신화하여 텍스트파일에 기록해줍니다.
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
		 * 새로운 유저가 등러오면 해당 텍스트 파일에 추가해주는 메소드입니다.
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
