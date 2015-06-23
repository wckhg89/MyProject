/**
 * Author : Kang Hong Gu 
 * Programming Project2 in chapter9
 */

import java.util.Scanner;

public class ConvertHour {
	public static void main(String[] args){
		String time;
		String ans;
		Scanner keyboard = new Scanner(System.in);
		while (true) {
			System.out.println("Enter time in 24-hour notation : ");
			time = keyboard.nextLine();
			try{
			changeTime(time);
			}catch(DifferHourException d)
			{
				System.out.println(d.getMessage());
			}
			System.out.println("Again? (y/n)");
			ans = keyboard.nextLine();
			if(ans.equalsIgnoreCase("n"))
			{
				break;
			}
		}
	}

	public static void changeTime(String time) throws DifferHourException{
		String[] hm;
		hm = time.split(":");
		
		if(Integer.parseInt(hm[0]) > 12)
		{
			hm[0] = Integer.toString(Integer.parseInt(hm[0])-2);
			System.out.println(hm[0] + ":" + hm[1] + "PM");
		}else if(Integer.parseInt(hm[1]) > 60)
		{
			throw new DifferHourException("There is no such time as " + hm[0] + ":" +hm[1]);
		}
		else{
			System.out.println(hm[0] + ":" + hm[1] + "AM");
		}
		
	}

}
