package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.vo.Eat;
import com.vo.Play;
import com.vo.Play_Rply;
import com.vo.Sleep;


public class TMModel_Content_MB {
	DataSource ds;

	/**
	 * Create db pool
	 */
	public TMModel_Content_MB() {
		try {
			InitialContext context = new InitialContext();

			ds = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean enterLike(String id, int num) {
		boolean isComplete = false;
		Connection con;
		try {
			con = ds.getConnection();

			String sql = "insert into p_like(p_l_m_id,p_l_num, p_l_date) values(?,?,sysdate())";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, id);
			pstat.setInt(2, num);

			pstat.executeUpdate();
			isComplete = true;

			pstat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isComplete;

	}

	public boolean enterReply(String id, int num, String content) {
		boolean isComplete = false;
		Connection con;
		try {
			con = ds.getConnection();

			String sql = "insert into p_reply(p_r_m_id,p_r_num, p_r_content, p_r_date) values(?,?,?,sysdate())";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, id);
			pstat.setInt(2, num);
			pstat.setString(3, content);

			System.out.println(sql);

			pstat.executeUpdate();
			isComplete = true;

			pstat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isComplete;

	}

	public int likeCount(int num) {
		int count = 0;

		try {
			Connection con = ds.getConnection();
			String sql = "select * from p_like where p_l_num = ?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, num);

			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				count++;

			}
			System.out.println(count + "!@$!");
			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public void increaseNumberLike(int num) {
		Connection con;
		int count = this.likeCount(num);
		try {
			con = ds.getConnection();

			String sql = "update tm_play set p_l_count = ? where p_num= ?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, count);
			pstat.setInt(2, num);

			System.out.println(sql);

			pstat.executeUpdate();

			pstat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int replyCount(int num) {
		int count = 0;

		try {
			Connection con = ds.getConnection();
			String sql = "select * from p_reply where p_r_num = ?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, num);

			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				count++;

			}
			System.out.println(count + "!@$!");
			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public void increaseNumber(int num) {
		Connection con;
		int count = this.replyCount(num);
		try {
			con = ds.getConnection();

			String sql = "update tm_play set p_r_count = ? where p_num= ?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, count);
			pstat.setInt(2, num);

			System.out.println(sql);

			pstat.executeUpdate();

			pstat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Play_Rply> replyPlay(int num) {
		ArrayList<Play_Rply> play_R_List = new ArrayList<Play_Rply>();
		this.increaseNumber(num);
		this.increaseNumberLike(num);

		try {
			Connection con = ds.getConnection();
			String sql = "select p_r_m_id, p_r_content, p_r_date from p_reply join tm_play where p_num = ? and p_r_num =?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, num);
			pstat.setInt(2, num);

			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				Play_Rply p_rply = new Play_Rply();

				String p_r_m_id = rs.getString(1);
				String p_r_content = rs.getString(2);
				String p_r_date = rs.getString(3);

				p_rply.setP_r_m_id(p_r_m_id);
				p_rply.setP_r_content(p_r_content);
				p_rply.setP_r_date(p_r_date);

				play_R_List.add(p_rply);

			}
			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return play_R_List;
	}

	public Play detailPlay(int num) {

		Play play_Bean = new Play();

		try {
			Connection con = ds.getConnection();
			String sql = "select p_img,p_date,p_m_id,p_content,p_location2,p_price,p_session,p_inout,p_l_count,p_r_count from tm_play where p_num = ?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, num);

			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {

				String p_img = rs.getString(1);
				String p_date = rs.getString(2);
				String p_m_id = rs.getString(3);
				String p_content = rs.getString(4);
				String p_location2 = rs.getString(5);
				int p_price = rs.getInt(6);
				String p_session = rs.getString(7);
				String p_inout = rs.getString(8);
				int p_l_count = rs.getInt(9);
				int p_r_count = rs.getInt(10);

				System.out.println(p_m_id + p_content + p_r_count + "@@@@");
				play_Bean.setP_img(p_img);
				play_Bean.setP_date(p_date);
				play_Bean.setP_m_id(p_m_id);
				play_Bean.setP_content(p_content);
				play_Bean.setP_location2(p_location2);
				play_Bean.setP_price(p_price);
				play_Bean.setP_session(p_session);
				play_Bean.setP_inout(p_inout);
				play_Bean.setP_l_count(p_l_count);
				play_Bean.setP_r_count(p_r_count);

			}
			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return play_Bean;
	}

	public Eat detailEat(int num) {

		Eat eat_Bean = new Eat();

		try {
			Connection con = ds.getConnection();
			String sql = "select * from tm_eat where e_num = ?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, num);

			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				int p_num = rs.getInt(1);
				String p_img = rs.getString(2);

			}
			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return eat_Bean;
	}

	public Sleep detailSleep(int num) {

		Sleep play_Bean = new Sleep();

		try {
			Connection con = ds.getConnection();
			String sql = "select * from tm_sleep where s_num = ?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, num);

			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				int p_num = rs.getInt(1);
				String p_img = rs.getString(2);

			}
			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return play_Bean;
	}
}
