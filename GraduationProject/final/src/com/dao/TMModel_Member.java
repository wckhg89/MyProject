package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.vo.Band;
import com.vo.Eat;
import com.vo.Friend;
import com.vo.Member;
import com.vo.Play;
import com.vo.Sleep;

public class TMModel_Member {
	private static DataSource ds;

	/**
	 * Create db pool
	 */
	public TMModel_Member() {
		try {
			InitialContext context = new InitialContext();

			ds = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean m_login(String id, String pass) {
		boolean isLogin = false;
		try {
			Connection con = ds.getConnection();
			String sql = "select * from tm_member where m_id=? and m_password=?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, id);
			pstat.setString(2, pass);

			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {
				isLogin = true;

			} else {
				isLogin = false;
			}

			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isLogin;
	}

	public boolean m_join(Member m) {
		boolean isJoin = false;
		Connection con;
		try {
			con = ds.getConnection();

			String sql = "insert into tm_member(m_id,m_password,m_name,m_age,m_phone,m_email,m_img) values(?,?,?,?,?,?,?)";
			PreparedStatement pstat = con.prepareStatement(sql);

			pstat.setString(1, m.getM_id());
			pstat.setString(2, m.getM_password());
			pstat.setString(3, m.getM_name());
			pstat.setInt(4, m.getM_age());
			pstat.setInt(5, m.getM_phone());
			pstat.setString(6, m.getM_email());
			pstat.setString(7, m.getM_img());

			System.out.println(sql);
			System.out.println(m.getM_age());

			pstat.executeUpdate();
			isJoin = true;

			pstat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isJoin;

	}

	public boolean meetFriend(String m_id, String f_id) {
		boolean isJoin = false;
		Connection con;
		try {
			con = ds.getConnection();

			String sql = "insert into tm_friend(f_id, f_m_id) values(?,?);";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, f_id);
			pstat.setString(2, m_id);

			pstat.executeUpdate();
			isJoin = true;

			pstat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isJoin;

	}

	public Member memberDetail(String id) {
		Member m = null;

		try {
			Connection con = ds.getConnection();
			String sql = "select m_id, m_name, m_age, m_phone, m_email, m_img from tm_member m where m.m_id=?";

			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, id);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {

				String m_id = rs.getString(1);
				String m_name = rs.getString(2);
				int m_age = rs.getInt(3);
				int m_phone = rs.getInt(4);
				String m_mail = rs.getString(5);
				String m_img = rs.getString(6);

				m = new Member();

				m.setM_id(m_id);
				m.setM_name(m_name);
				m.setM_age(m_age);
				m.setM_phone(m_phone);
				m.setM_email(m_mail);
				m.setM_img(m_img);

			}

			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return m;

	}

	public ArrayList<Friend> friendList(String id) {

		ArrayList<Friend> fl = new ArrayList<Friend>();

		try {

			Connection con = ds.getConnection();
			String sql = "select f.f_id, f.f_m_id, m.m_img,m_name,m_age from tm_friend f join tm_member m where f.f_m_id = ? and f_id=m_id";

			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, id);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {

				String f_id = rs.getString(1);
				String f_m_id = rs.getString(2);
				String m_img = rs.getString(3);
				String m_name = rs.getString(4);
				int m_age = rs.getInt(5);

				Friend f = new Friend();

				f.setF_id(f_id);
				f.setF_m_id(f_m_id);
				f.setM_img(m_img);
				f.setM_name(m_name);
				f.setM_age(m_age);

				fl.add(f);

			}

			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fl;

	}

	public ArrayList<Play> PlayList(String id) {

		ArrayList<Play> pl = new ArrayList<Play>();

		try {

			Connection con = ds.getConnection();
			String sql = "select p_title,p_location2, p_date, p_num,p_m_id from tm_play join tm_member where m_id=? and m_id = p_m_id";

			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, id);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {

				String p_title = rs.getString(1);
				String p_location2= rs.getString(2);
				String p_date = rs.getString(3);
				int p_num = rs.getInt(4);
				String p_m_id = rs.getString(5);
				
				System.out.println(p_date + "@@@@@");
				
				Play p = new Play();
				p.setP_title(p_title);
				p.setP_location2(p_location2);
				p.setP_date(p_date);
				p.setP_num(p_num);
				p.setP_m_id(p_m_id);
				
				pl.add(p);
			}

			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pl;

	}
	public ArrayList<Eat> EatList(String id) {

		ArrayList<Eat> el = new ArrayList<Eat>();

		try {

			Connection con = ds.getConnection();
			String sql = "select e_title,e_location2, e_date, e_num,e_m_id from tm_eat join tm_member where m_id=? and m_id = e_m_id";

			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, id);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {

				String e_title = rs.getString(1);
				String e_location2= rs.getString(2);
				String e_date = rs.getString(3);
				int e_num = rs.getInt(4);
				String e_m_id = rs.getString(5);
				
				
				
				Eat e = new Eat();
				e.setE_title(e_title);
				e.setE_location2(e_location2);
				e.setE_date(e_date);
				e.setE_num(e_num);
				e.setE_m_id(e_m_id);
				
				el.add(e);
			}

			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return el;

	}
	public ArrayList<Sleep> SleepList(String id) {

		ArrayList<Sleep> sl = new ArrayList<Sleep>();

		try {

			Connection con = ds.getConnection();
			String sql = "select s_title,s_location2, s_date, s_num,s_m_id from tm_sleep join tm_member where m_id=? and m_id = s_m_id";

			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, id);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {

				String s_title = rs.getString(1);
				String s_location2= rs.getString(2);
				String s_date = rs.getString(3);
				int s_num = rs.getInt(4);
				String s_m_id = rs.getString(5);
				
				
				
				Sleep s = new Sleep();
				s.setS_title(s_title);
				s.setS_location2(s_location2);
				s.setS_date(s_date);
				s.setS_num(s_num);
				s.setS_m_id(s_m_id);
				
				sl.add(s);
			}

			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sl;

	}
	
	public ArrayList<Band> BandList(String id) {

		ArrayList<Band> bl = new ArrayList<Band>();

		try {

			Connection con = ds.getConnection();
			String sql = "select b_category,b_title,b_img, b_when,b_num,b_m_id from tm_band join tm_member where m_id=? and m_id = b_m_id";

			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, id);

			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {

				String b_category = rs.getString(1);
				String b_title = rs.getString(2);
				String b_img = rs.getString(3);
				String b_when = rs.getString(4);
				int b_num = rs.getInt(5);
				String b_m_id= rs.getString(6);

				Band b = new Band();
				b.setB_category(b_category);
				b.setB_title(b_title);
				b.setB_img1(b_img);
				b.setB_when(b_when);
				b.setB_num(b_num);
				b.setB_m_id(b_m_id);
				
				bl.add(b);

			}

			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bl;

	}
}
