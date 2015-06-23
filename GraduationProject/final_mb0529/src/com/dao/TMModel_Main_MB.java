package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.vo.Eat;
import com.vo.Play;
import com.vo.Sleep;

public class TMModel_Main_MB {
	DataSource ds;
	ArrayList<Play> p_list;
	ArrayList<Eat> e_list;
	ArrayList<Sleep> s_list;

	/**
	 * Create db pool
	 */
	public TMModel_Main_MB() {
		try {
			InitialContext context = new InitialContext();
			p_list = new ArrayList<Play>();
			e_list = new ArrayList<Eat>();
			s_list = new ArrayList<Sleep>();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Play> play_selectAll() {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select p_num, p_m_id, p_img, p_content, p_date, p_location2, p_session, p_location from tm_play";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int p_num = rs.getInt(1);
				String p_m_id = rs.getString(2);
				String p_img = rs.getString(3);
				String p_content = rs.getString(4);
				String p_date = rs.getString(5);
				String p_location2 = rs.getString(6);
				String p_session = rs.getString(7);
				String p_location = rs.getString(8);
				Play play_bean = new Play(p_num, p_m_id, p_img, p_content,
						p_date, p_location2, p_session, p_location);

				p_list.add(play_bean);
			}
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p_list;
	}

	public ArrayList<Eat> eat_selectAll() {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select e_num, e_m_id, e_img, e_content, e_date, e_location2, e_session, e_location from tm_eat";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int e_num = rs.getInt(1);
				String e_m_id = rs.getString(2);
				String e_img = rs.getString(3);
				String e_content = rs.getString(4);
				String e_date = rs.getString(5);
				String e_location2 = rs.getString(6);
				String e_session = rs.getString(7);
				String e_location = rs.getString(8);

				Eat eat_bean = new Eat(e_num, e_m_id, e_img, e_content, e_date,
						e_location2, e_session, e_location);

				e_list.add(eat_bean);
			}
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return e_list;
	}

	public ArrayList<Sleep> sleep_selectAll() {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select s_num, s_m_id, s_img, s_content, s_date,s_location2, s_session, s_location from tm_sleep";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int s_num = rs.getInt(1);
				String s_m_id = rs.getString(2);
				String s_img = rs.getString(3);
				String s_content = rs.getString(4);
				String s_date = rs.getString(5);
				String s_location2 = rs.getString(6);
				String s_session = rs.getString(7);
				String s_location = rs.getString(8);

				Sleep sleep_bean = new Sleep(s_num, s_m_id, s_img, s_content,
						s_date, s_location2, s_session, s_location);

				s_list.add(sleep_bean);
			}
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return s_list;
	}

}
