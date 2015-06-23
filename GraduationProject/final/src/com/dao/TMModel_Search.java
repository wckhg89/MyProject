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

public class TMModel_Search {
	DataSource ds;
	ArrayList<Play> p_list;
	ArrayList<Eat> e_list;
	ArrayList<Sleep> s_list;

	public TMModel_Search() {
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
			String sql = "select * from tm_play";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int p_num = rs.getInt(1);
				String p_m_id = rs.getString(2);
				String p_img = rs.getString(3);
				int p_price = rs.getInt(4);
				String p_session = rs.getString(5);
				String p_inout = rs.getString(6);
				String p_title = rs.getString(7);
				String p_content = rs.getString(8);
				String p_date = rs.getString(9);
				String p_location = rs.getString(10);
				String p_location2 = rs.getString(11);
				int p_r_count = rs.getInt(12);
				int p_l_count = rs.getInt(13);
				
				Play play_bean = new Play();
				play_bean.setP_num(p_num);
				play_bean.setP_m_id(p_m_id);
				play_bean.setP_img(p_img);
				play_bean.setP_price(p_price);
				play_bean.setP_session(p_session);
				play_bean.setP_inout(p_inout);
				play_bean.setP_title(p_title);
				play_bean.setP_content(p_content);
				play_bean.setP_date(p_date);
				play_bean.setP_location(p_location);
				play_bean.setP_location2(p_location2);
				play_bean.setP_r_count(p_r_count);
				play_bean.setP_l_count(p_l_count);
				
				

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
			String sql = "select * from tm_eat";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int e_num = rs.getInt(1);
				String e_m_id = rs.getString(2);
				String e_img = rs.getString(3);
				int e_price = rs.getInt(4);
				String e_session = rs.getString(5);
				String e_inout = rs.getString(6);
				String e_title = rs.getString(7);
				String e_content = rs.getString(8);
				String e_date = rs.getString(9);
				String e_location = rs.getString(10);
				String e_location2 = rs.getString(11);
				int e_r_count = rs.getInt(12);
				int e_l_count = rs.getInt(13);

				Eat eat_bean = new Eat();
				
				eat_bean.setE_num(e_num);
				eat_bean.setE_m_id(e_m_id);
				eat_bean.setE_img(e_img);
				eat_bean.setE_price(e_price);
				eat_bean.setE_session(e_session);
				eat_bean.setE_inout(e_inout);
				eat_bean.setE_title(e_title);
				eat_bean.setE_content(e_content);
				eat_bean.setE_date(e_date);
				eat_bean.setE_location(e_location);
				eat_bean.setE_location2(e_location2);
				eat_bean.setE_r_count(e_r_count);
				eat_bean.setE_l_count(e_l_count);
				

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
			String sql = "select * from tm_sleep";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int s_num = rs.getInt(1);
				String s_m_id = rs.getString(2);
				String s_img = rs.getString(3);
				int s_price = rs.getInt(4);
				String s_session = rs.getString(5);
				String s_inout = rs.getString(6);
				String s_title = rs.getString(7);
				String s_content = rs.getString(8);
				String s_date = rs.getString(9);
				String s_location = rs.getString(10);
				String s_location2 = rs.getString(11);
				int s_r_count = rs.getInt(12);
				int s_l_count = rs.getInt(13);
				
				Sleep sleep_bean = new Sleep();
				
				sleep_bean.setS_num(s_num);
				sleep_bean.setS_m_id(s_m_id);
				sleep_bean.setS_img(s_img);
				sleep_bean.setS_price(s_price);
				sleep_bean.setS_session(s_session);
				sleep_bean.setS_inout(s_inout);
				sleep_bean.setS_title(s_title);
				sleep_bean.setS_content(s_content);
				sleep_bean.setS_date(s_date);
				sleep_bean.setS_location(s_location);
				sleep_bean.setS_location2(s_location2);
				sleep_bean.setS_r_count(s_r_count);
				sleep_bean.setS_l_count(s_l_count);
				
				
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
	public ArrayList<Play> play_New_selectAll() {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_play order by p_date desc";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int p_num = rs.getInt(1);
				String p_m_id = rs.getString(2);
				String p_img = rs.getString(3);
				int p_price = rs.getInt(4);
				String p_session = rs.getString(5);
				String p_inout = rs.getString(6);
				String p_title = rs.getString(7);
				String p_content = rs.getString(8);
				String p_date = rs.getString(9);
				String p_location = rs.getString(10);
				String p_location2 = rs.getString(11);
				int p_r_count = rs.getInt(12);
				int p_l_count = rs.getInt(13);
				
				Play play_bean = new Play();
				play_bean.setP_num(p_num);
				play_bean.setP_m_id(p_m_id);
				play_bean.setP_img(p_img);
				play_bean.setP_price(p_price);
				play_bean.setP_session(p_session);
				play_bean.setP_inout(p_inout);
				play_bean.setP_title(p_title);
				play_bean.setP_content(p_content);
				play_bean.setP_date(p_date);
				play_bean.setP_location(p_location);
				play_bean.setP_location2(p_location2);
				play_bean.setP_r_count(p_r_count);
				play_bean.setP_l_count(p_l_count);
				
				

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

	public ArrayList<Eat> eat_New_selectAll() {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_eat order by e_date desc";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int e_num = rs.getInt(1);
				String e_m_id = rs.getString(2);
				String e_img = rs.getString(3);
				int e_price = rs.getInt(4);
				String e_session = rs.getString(5);
				String e_inout = rs.getString(6);
				String e_title = rs.getString(7);
				String e_content = rs.getString(8);
				String e_date = rs.getString(9);
				String e_location = rs.getString(10);
				String e_location2 = rs.getString(11);
				int e_r_count = rs.getInt(12);
				int e_l_count = rs.getInt(13);

				Eat eat_bean = new Eat();
				
				eat_bean.setE_num(e_num);
				eat_bean.setE_m_id(e_m_id);
				eat_bean.setE_img(e_img);
				eat_bean.setE_price(e_price);
				eat_bean.setE_session(e_session);
				eat_bean.setE_inout(e_inout);
				eat_bean.setE_title(e_title);
				eat_bean.setE_content(e_content);
				eat_bean.setE_date(e_date);
				eat_bean.setE_location(e_location);
				eat_bean.setE_location2(e_location2);
				eat_bean.setE_r_count(e_r_count);
				eat_bean.setE_l_count(e_l_count);
				

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

	public ArrayList<Sleep> sleep_New_selectAll() {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_sleep order by s_date desc";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int s_num = rs.getInt(1);
				String s_m_id = rs.getString(2);
				String s_img = rs.getString(3);
				int s_price = rs.getInt(4);
				String s_session = rs.getString(5);
				String s_inout = rs.getString(6);
				String s_title = rs.getString(7);
				String s_content = rs.getString(8);
				String s_date = rs.getString(9);
				String s_location = rs.getString(10);
				String s_location2 = rs.getString(11);
				int s_r_count = rs.getInt(12);
				int s_l_count = rs.getInt(13);
				
				Sleep sleep_bean = new Sleep();
				
				sleep_bean.setS_num(s_num);
				sleep_bean.setS_m_id(s_m_id);
				sleep_bean.setS_img(s_img);
				sleep_bean.setS_price(s_price);
				sleep_bean.setS_session(s_session);
				sleep_bean.setS_inout(s_inout);
				sleep_bean.setS_title(s_title);
				sleep_bean.setS_content(s_content);
				sleep_bean.setS_date(s_date);
				sleep_bean.setS_location(s_location);
				sleep_bean.setS_location2(s_location2);
				sleep_bean.setS_r_count(s_r_count);
				sleep_bean.setS_l_count(s_l_count);
				
				
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
	
	public ArrayList<Play> play_Like_selectAll() {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_play order by p_l_count desc";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int p_num = rs.getInt(1);
				String p_m_id = rs.getString(2);
				String p_img = rs.getString(3);
				int p_price = rs.getInt(4);
				String p_session = rs.getString(5);
				String p_inout = rs.getString(6);
				String p_title = rs.getString(7);
				String p_content = rs.getString(8);
				String p_date = rs.getString(9);
				String p_location = rs.getString(10);
				String p_location2 = rs.getString(11);
				int p_r_count = rs.getInt(12);
				int p_l_count = rs.getInt(13);
				
				Play play_bean = new Play();
				play_bean.setP_num(p_num);
				play_bean.setP_m_id(p_m_id);
				play_bean.setP_img(p_img);
				play_bean.setP_price(p_price);
				play_bean.setP_session(p_session);
				play_bean.setP_inout(p_inout);
				play_bean.setP_title(p_title);
				play_bean.setP_content(p_content);
				play_bean.setP_date(p_date);
				play_bean.setP_location(p_location);
				play_bean.setP_location2(p_location2);
				play_bean.setP_r_count(p_r_count);
				play_bean.setP_l_count(p_l_count);
				
				

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

	public ArrayList<Eat> eat_Like_selectAll() {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_eat order by e_l_count desc";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int e_num = rs.getInt(1);
				String e_m_id = rs.getString(2);
				String e_img = rs.getString(3);
				int e_price = rs.getInt(4);
				String e_session = rs.getString(5);
				String e_inout = rs.getString(6);
				String e_title = rs.getString(7);
				String e_content = rs.getString(8);
				String e_date = rs.getString(9);
				String e_location = rs.getString(10);
				String e_location2 = rs.getString(11);
				int e_r_count = rs.getInt(12);
				int e_l_count = rs.getInt(13);

				Eat eat_bean = new Eat();
				
				eat_bean.setE_num(e_num);
				eat_bean.setE_m_id(e_m_id);
				eat_bean.setE_img(e_img);
				eat_bean.setE_price(e_price);
				eat_bean.setE_session(e_session);
				eat_bean.setE_inout(e_inout);
				eat_bean.setE_title(e_title);
				eat_bean.setE_content(e_content);
				eat_bean.setE_date(e_date);
				eat_bean.setE_location(e_location);
				eat_bean.setE_location2(e_location2);
				eat_bean.setE_r_count(e_r_count);
				eat_bean.setE_l_count(e_l_count);
				

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

	public ArrayList<Sleep> sleep_Like_selectAll() {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_sleep order by s_l_count desc";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int s_num = rs.getInt(1);
				String s_m_id = rs.getString(2);
				String s_img = rs.getString(3);
				int s_price = rs.getInt(4);
				String s_session = rs.getString(5);
				String s_inout = rs.getString(6);
				String s_title = rs.getString(7);
				String s_content = rs.getString(8);
				String s_date = rs.getString(9);
				String s_location = rs.getString(10);
				String s_location2 = rs.getString(11);
				int s_r_count = rs.getInt(12);
				int s_l_count = rs.getInt(13);
				
				Sleep sleep_bean = new Sleep();
				
				sleep_bean.setS_num(s_num);
				sleep_bean.setS_m_id(s_m_id);
				sleep_bean.setS_img(s_img);
				sleep_bean.setS_price(s_price);
				sleep_bean.setS_session(s_session);
				sleep_bean.setS_inout(s_inout);
				sleep_bean.setS_title(s_title);
				sleep_bean.setS_content(s_content);
				sleep_bean.setS_date(s_date);
				sleep_bean.setS_location(s_location);
				sleep_bean.setS_location2(s_location2);
				sleep_bean.setS_r_count(s_r_count);
				sleep_bean.setS_l_count(s_l_count);
				
				
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
	
	public ArrayList<Play> play_Date_selectAll(String date) {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_play where p_date='" + date+"'";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int p_num = rs.getInt(1);
				String p_m_id = rs.getString(2);
				String p_img = rs.getString(3);
				int p_price = rs.getInt(4);
				String p_session = rs.getString(5);
				String p_inout = rs.getString(6);
				String p_title = rs.getString(7);
				String p_content = rs.getString(8);
				String p_date = rs.getString(9);
				String p_location = rs.getString(10);
				String p_location2 = rs.getString(11);
				int p_r_count = rs.getInt(12);
				int p_l_count = rs.getInt(13);
				
				Play play_bean = new Play();
				play_bean.setP_num(p_num);
				play_bean.setP_m_id(p_m_id);
				play_bean.setP_img(p_img);
				play_bean.setP_price(p_price);
				play_bean.setP_session(p_session);
				play_bean.setP_inout(p_inout);
				play_bean.setP_title(p_title);
				play_bean.setP_content(p_content);
				play_bean.setP_date(p_date);
				play_bean.setP_location(p_location);
				play_bean.setP_location2(p_location2);
				play_bean.setP_r_count(p_r_count);
				play_bean.setP_l_count(p_l_count);
				
				

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

	public ArrayList<Eat> eat_Date_selectAll(String date) {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_eat where e_date='" + date+"'";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int e_num = rs.getInt(1);
				String e_m_id = rs.getString(2);
				String e_img = rs.getString(3);
				int e_price = rs.getInt(4);
				String e_session = rs.getString(5);
				String e_inout = rs.getString(6);
				String e_title = rs.getString(7);
				String e_content = rs.getString(8);
				String e_date = rs.getString(9);
				String e_location = rs.getString(10);
				String e_location2 = rs.getString(11);
				int e_r_count = rs.getInt(12);
				int e_l_count = rs.getInt(13);

				Eat eat_bean = new Eat();
				
				eat_bean.setE_num(e_num);
				eat_bean.setE_m_id(e_m_id);
				eat_bean.setE_img(e_img);
				eat_bean.setE_price(e_price);
				eat_bean.setE_session(e_session);
				eat_bean.setE_inout(e_inout);
				eat_bean.setE_title(e_title);
				eat_bean.setE_content(e_content);
				eat_bean.setE_date(e_date);
				eat_bean.setE_location(e_location);
				eat_bean.setE_location2(e_location2);
				eat_bean.setE_r_count(e_r_count);
				eat_bean.setE_l_count(e_l_count);
				

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

	public ArrayList<Sleep> sleep_Date_selectAll(String date) {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_sleep where s_date='" + date+"'";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int s_num = rs.getInt(1);
				String s_m_id = rs.getString(2);
				String s_img = rs.getString(3);
				int s_price = rs.getInt(4);
				String s_session = rs.getString(5);
				String s_inout = rs.getString(6);
				String s_title = rs.getString(7);
				String s_content = rs.getString(8);
				String s_date = rs.getString(9);
				String s_location = rs.getString(10);
				String s_location2 = rs.getString(11);
				int s_r_count = rs.getInt(12);
				int s_l_count = rs.getInt(13);
				
				Sleep sleep_bean = new Sleep();
				
				sleep_bean.setS_num(s_num);
				sleep_bean.setS_m_id(s_m_id);
				sleep_bean.setS_img(s_img);
				sleep_bean.setS_price(s_price);
				sleep_bean.setS_session(s_session);
				sleep_bean.setS_inout(s_inout);
				sleep_bean.setS_title(s_title);
				sleep_bean.setS_content(s_content);
				sleep_bean.setS_date(s_date);
				sleep_bean.setS_location(s_location);
				sleep_bean.setS_location2(s_location2);
				sleep_bean.setS_r_count(s_r_count);
				sleep_bean.setS_l_count(s_l_count);
				
				
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
