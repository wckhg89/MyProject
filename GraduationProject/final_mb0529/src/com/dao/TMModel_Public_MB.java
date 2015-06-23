package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.vo.Eat;
import com.vo.Play;
import com.vo.Public_eat;
import com.vo.Public_play;
import com.vo.Public_sleep;
import com.vo.Sleep;

public class TMModel_Public_MB {
	DataSource ds;
	ArrayList<Public_play> pp_list;
	ArrayList<Public_eat> pe_list;
	ArrayList<Public_sleep> ps_list;

	/**
	 * Create db pool
	 */
	public TMModel_Public_MB() {
		try {
			InitialContext context = new InitialContext();
			pp_list = new ArrayList<Public_play>();
			pe_list = new ArrayList<Public_eat>();
			ps_list = new ArrayList<Public_sleep>();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Public_play> play_selectAll() {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select name, textarea from tm_public_play";
			ResultSet rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				String name = rs.getString(1);
				String textarea = rs.getString(2);
				
				System.out.println(name +" " + textarea);
				
				Public_play pplay_bean = new Public_play(name , textarea);

				pp_list.add(pplay_bean);
			}
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pp_list;
	}

	public ArrayList<Public_eat> eat_selectAll() {
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
//
//				Public_eat eat_bean = new Public_eat(e_num, e_m_id, e_img, e_content, e_date,
//						e_location2, e_session, e_location);
//
//				ppe_list.add(eat_bean);
			}
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pe_list;
	}

	public ArrayList<Public_sleep> sleep_selectAll() {
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

//				Sleep sleep_bean = new Sleep(s_num, s_m_id, s_img, s_content,
//						s_date, s_location2, s_session, s_location);
//
//				ps_list.add(sleep_bean);
			}
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ps_list;
	}

}
