package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.vo.Eat;
import com.vo.Member;
import com.vo.Play;
import com.vo.Sleep;

public class TMModel_Member_MB {
	DataSource ds;

	/**
	 * Create db pool
	 */
	public TMModel_Member_MB() {
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
			System.out.println(id  +  isLogin);
			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isLogin;
	}

	public boolean m_join(String id , String password , String name , String age) {
		boolean isJoin = false;
		Connection con;
		try {
			con = ds.getConnection();

			String sql = "insert into tm_member(m_id,m_password,m_name,m_age,m_phone,m_email,m_session,m_food,m_area,m_sleep,m_img) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstat = con.prepareStatement(sql);
			System.out.println(id);
			pstat.setString(1, id);
			pstat.setString(2, password);
			pstat.setString(3, name);
			pstat.setString(4, age);
			pstat.setString(5, null);		//phone
			pstat.setString(6, null);		//email
			pstat.setString(7, null);		//session
			pstat.setString(8, null);		//food
			pstat.setString(9, null);		//area
			pstat.setString(10, null);	//sleep
			pstat.setString(11, null);	//img

			pstat.executeUpdate();
			
			pstat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isJoin;

	}
	
	

	public Member memberData(String id) {
		Member mem_Data = new Member();
		try {
			Connection con = ds.getConnection();
			String sql = "select m_id,m_name,m_age,m_phone,m_email,m_img from tm_member where m_id=?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, id);
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()){
				String m_id = rs.getString(1);
				String m_name = rs.getString(2);
				int m_age = rs.getInt(3);
				int m_phone = rs.getInt(4);
				String m_email = rs.getString(5);
				String m_img = rs.getString(6);
				
				System.out.println(m_id + m_name + m_age + m_phone + m_email+m_img);
				
				mem_Data.setM_id(m_id);
				mem_Data.setM_name(m_name);
				mem_Data.setM_age(m_age);
				mem_Data.setM_phone(m_phone);
				mem_Data.setM_email(m_email);
				mem_Data.setM_img(m_img);
			}

			rs.close();
			pstat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mem_Data;
	}

	public ArrayList<Play> memberPlay(String id) {

		ArrayList<Play> mem_Play = new ArrayList<Play>();
		
		try {
			Connection con = ds.getConnection();
			String sql = "select p.p_num, p.p_img from tm_member m join tm_play p where m.m_id=? and p.p_m_id=?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, id);
			pstat.setString(2, id);

			ResultSet rs = pstat.executeQuery();
			while(rs.next())
			{
				Play bean = new Play(); 
				int p_num = rs.getInt(1);
				String p_img = rs.getString(2);
				
				bean.setP_num(p_num);
				bean.setP_img(p_img);
				System.out.println(p_img+ "!") ;
				mem_Play.add(bean);
			}
			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mem_Play;
	}

	
	public ArrayList<Eat> memberEat(String id) {

		ArrayList<Eat> mem_Eat = new ArrayList<Eat>();

		try {
			Connection con = ds.getConnection();
			String sql = "select e.e_num, e.e_img from tm_member m join tm_eat e where m.m_id=? and e.e_m_id";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, id);
			pstat.setString(2, id);

			ResultSet rs = pstat.executeQuery();
			while(rs.next())
			{
				Eat bean = new Eat(); 
				int e_num = rs.getInt(1);
				String e_img = rs.getString(2);
				
				System.out.println(e_img +"@");
				bean.sete_num(e_num);
				bean.sete_img(e_img);
				
				mem_Eat.add(bean);
			}
			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return mem_Eat;
	}

	public ArrayList<Sleep> memberSleep(String id) {

		ArrayList<Sleep> mem_Sleep = new ArrayList<Sleep>();

		try {
			Connection con = ds.getConnection();
			String sql = "select s.s_num, s.s_img from tm_member m join tm_sleep s where m.m_id=? and s.s_m_id=?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, id);
			pstat.setString(2, id);

			ResultSet rs = pstat.executeQuery();
			while(rs.next())
			{
				Sleep bean = new Sleep(); 
				int s_num = rs.getInt(1);
				String s_img = rs.getString(2);
				
				System.out.println(s_img+ "#") ;
				bean.sets_num(s_num);
				bean.sets_img(s_img);
				
				mem_Sleep.add(bean);
			}
			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return mem_Sleep;
	}
	
	/*public ArrayList<Band> member_Band(String id) {

		ArrayList<Band> mem_Band = new ArrayList<Band>();

		try {
			Connection con = ds.getConnection();
			String sql = "select * from tm_member where m_id=? and m_password=?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, id);

			ResultSet rs = pstat.executeQuery();

			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mem_Band;
	}
*/

}
