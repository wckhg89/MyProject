/**
 * Program to BasketballGame 
 * Author : Kang Hong Gu 
 * Programming Project9 in chapter5
 * Last Changed : April. 10. 2014
 */

public class BasketballGame {
	private String team1_Name;
	private String team2_Name;
	private int team1_Score;
	private int team2_Score;
	private boolean game_End = false;

	//Setter name
	public void setName(String t1, String t2) {
		this.team1_Name = t1;
		this.team2_Name = t2;
	}

	//Setter score 1
	public void setScorePoint1(String team) {
		if (team.equalsIgnoreCase(this.team1_Name)) {
			this.team1_Score += 1;
		} else if (team.equalsIgnoreCase(this.team2_Name)) {
			this.team2_Score += 1;
		}
	}
	//Setter score 2
	public void setScorePoint2(String team) {
		if (team.equalsIgnoreCase(this.team1_Name)) {
			this.team1_Score += 2;
		} else if (team.equalsIgnoreCase(this.team2_Name)) {
			this.team2_Score += 2;
		}
	}

	//Setter score 3
	public void setScorePoint3(String team) {
		if (team.equalsIgnoreCase(this.team1_Name)) {
			this.team1_Score += 3;
		} else if (team.equalsIgnoreCase(this.team2_Name)) {
			this.team2_Score += 3;
		}
	}

	//Setter game state to end
	public void setGameStateToEnd() {
		this.game_End = true;
	}

	//Getter get game state
	public boolean getEnd() {
		return this.game_End;
	}

	//Getter get Score
	public int getScore(String team) {
		if (team.equalsIgnoreCase(team1_Name)) {
			return this.team1_Score;
		} else {
			return this.team2_Score;
		}
	}

	//Getter win team now
	public String getWinTeam() {
		if (this.team1_Score > this.team2_Score) {
			return this.team1_Name;
		} else if (this.team1_Score < this.team2_Score) {
			return this.team2_Name;
		} else
			return "draw";
	}
}
