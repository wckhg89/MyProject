import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Program to ReadFile
 * Author : Kang Hong Gu 
 * Programming Project3 in chapter10
 */
public class ModifyText {
	private String fileName_in;
	private String fileName_out;
	private Scanner inputStream = null;
	private PrintWriter outputStream = null;

	/*
	 * constructor
	 */
	public ModifyText(String fileName, String fileName2) {
		this.setFileName(fileName , fileName2);
	}
	/*
	 * set file name
	 */
	public void setFileName(String fileName, String fileName2) {
		this.fileName_in = fileName;
		this.fileName_out = fileName2;
	}

	/*
	 * this function read file and write file
	 */
	public void readAndWrite() {
		try {
			inputStream = new Scanner(new File(fileName_in));
			outputStream = new PrintWriter(new File(fileName_out));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			line = this.deleteEmptySpace(line);
			line = this.toUpperCaseFirstWord(line);
			outputStream.println(line);
		}
		System.out.println("Success modification text.");
		inputStream.close();
		outputStream.close();
	}
	/*
	 * this function delete two more empty space
	 */
	private String deleteEmptySpace(String line) {
		String modifyLine = "";
		String[] word;
		word = line.split(" ");

		for (int i = 0; i < word.length; i++) {
			if (i == 0)// 대문자 바꾸기
			{
				word[i] = word[i].replace(word[i].charAt(0), word[i]
						.toUpperCase().charAt(0));
			}
			if (word[i].equals("")) {
				continue;
			} else {
				if (word[i].contains(".") || word[i].contains("?")
						|| word[i].contains("!")) {
				}
				modifyLine += word[i] + " ";
			}
		}
		return modifyLine;
	}

	/*
	 * this function toupper case first word
	 */
	private String toUpperCaseFirstWord(String line) {
		String modifyLine = "";
		String[] word;
		word = line.split(" ");

		for (int i = 0; i < word.length; i++) {
			if (word[i].contains(".") || word[i].contains("?")
					|| word[i].contains("!")) {
				
				if (i + 1 < word.length) {
					word[i + 1] = word[i+1].replace(word[i + 1].charAt(0),
							word[i + 1].toUpperCase().charAt(0));
				}
			}
			modifyLine += word[i] + " ";
		}
		return modifyLine;
	}

	public static void main(String[] args) {
		String file_in;
		String file_out;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the input filename : ");
		file_in = keyboard.nextLine();
		System.out.println("Enter the output filename : ");
		file_out = keyboard.nextLine();
		

		ModifyText test = new ModifyText(file_in, file_out);
		test.readAndWrite();
	}
}
