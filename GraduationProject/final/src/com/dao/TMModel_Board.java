package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.vo.Info;
import com.vo.Notice;
import com.vo.NoticeReply;
import com.vo.Pride;

public class TMModel_Board {
	DataSource ds;
	ArrayList<Notice> n_list;
	ArrayList<Pride> p_list;
	ArrayList<Info> i_list;

	public TMModel_Board() {
		try {
			InitialContext context = new InitialContext();

			ds = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
			n_list = new ArrayList<Notice>();
			p_list = new ArrayList<Pride>();
			i_list = new ArrayList<Info>();
		} catch (Exception w) {
			w.printStackTrace();
		}
	}

	public ArrayList<Notice> n_selectAll() {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select n_num, n_title, n_content, n_date, n_count, n_r_count from tm_notice order by n_date desc";
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int n_num = rs.getInt(1);
				String n_title = rs.getString(2);
				String n_content = rs.getString(3);
				String n_date = rs.getString(4);
				int n_count = rs.getInt(5);
				int n_r_count = rs.getInt(6);

				Notice n_bean = new Notice(n_num, n_title, n_content, n_date,
						n_count, n_r_count);

				n_list.add(n_bean);
			}
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n_list;
	}

	public void n_insert(Notice n) {
		try {
			Connection con = ds.getConnection();

			String sql = "insert into tm_notice(n_title,n_content,n_date,n_count,n_r_count) values(?,?,sysdate(),0,0)";
			PreparedStatement pstat = con.prepareStatement(sql);

			pstat.setString(1, n.getN_title());
			pstat.setString(2, n.getN_content());
			pstat.executeUpdate();

			pstat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList n_selectOne(int s_n_num) {
		Notice n = null;
		ArrayList nr = new ArrayList();
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_notice where n_num=" + s_n_num;

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int n_num = rs.getInt(1);
				String n_title = rs.getString(2);
				String n_content = rs.getString(3);
				String n_date = rs.getString(4);
				int n_count = rs.getInt(5);
				int n_r_count = rs.getInt(6);
				n_count++;

				String csql = "update tm_notice set n_count=" + n_count
						+ " where n_num=" + n_num;
				stat.executeUpdate(csql);
				n = new Notice(n_num, n_title, n_content, n_date, n_count,
						n_r_count);

				nr.add(n);
			}
			// 상세글내용
			// ////////////////////////////

			rs = null;// rs 비우고
			sql = null;// 쿼리 비우고
			System.out.println(s_n_num+"!@%!^!^@!");
			sql = "select * from n_reply where tn_num=" + s_n_num;
			// 댓글을 가져오는 쿼리

			rs = stat.executeQuery(sql); // 새로운 쿼리로 rs채우기(댓글이 담길것임)

			while (rs.next()) {
				int tn_idx = rs.getInt(1);
				int tn_num = rs.getInt(2);
				String tn_id = rs.getString(3);
				String tn_content = rs.getString(4);
				String tn_date = rs.getString(5);
				// 댓글 정보를 빼온다.
				System.out.println(tn_content+"!@%!@%");
				NoticeReply r = new NoticeReply(tn_idx, tn_num, tn_id,
						tn_content, tn_date);

				nr.add(r);
			}

			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return nr;
	}

	public void r_add(NoticeReply nr) {
		Connection con;
		try {
			con = ds.getConnection();
//			"insert into tm_notice(n_title,n_content,n_date,n_count,n_r_count) values(?,?,sysdate(),0,0)";
			String sql = "insert into n_reply(tn_id,tn_num,tn_content,tn_date) values(?, ?, ?, sysdate())";
			PreparedStatement pstat = con.prepareStatement(sql);

			String id = nr.getTn_id();
			int num = nr.getTn_num();
			String contents = nr.getTn_content();

			System.out.println(id + "  " + num + "  " + contents);

			pstat.setString(1, id);
			pstat.setInt(2, num);
			pstat.setString(3, contents);

			pstat.executeUpdate();

			Statement stat = con.createStatement();
			String sql2 = "select count(*) from n_reply where tn_num=" + num;
			ResultSet rs = stat.executeQuery(sql2);
			while (rs.next()) {
				int rcount = rs.getInt(1);
				System.out.println(rcount+"!!");
				Statement stat2 = con.createStatement();
				String sql3 = "update tm_notice set n_r_count=" + rcount
						+ " where n_num=" + num;
				stat2.executeUpdate(sql3);
			}

			con.close();
			pstat.close();
			contents = "";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void r_delete(String r_idx, int r_num) {
		try {
			Connection con = ds.getConnection();
			System.out.println("r_idx: " + r_idx);
			System.out.println("r_num: " + r_num);
			String sql = "delete from n_reply where tn_index=?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, r_idx);
			pstat.executeUpdate();
			pstat.close();

			Statement stat = con.createStatement();
			String sql2 = "select count(*) from n_reply where tn_num="
					+ r_num;
			ResultSet rs = stat.executeQuery(sql2);
			while (rs.next()) {
				int rcount = rs.getInt(1);

				Statement stat2 = con.createStatement();
				String sql3 = "update tm_notice set n_r_count=" + rcount
						+ "where n_num=" + r_num;
				stat2.executeUpdate(sql3);
			}

			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void n_update(Notice n) {

		try {
			Connection con = ds.getConnection();

			String sql = "update tm_notice set "
					+ "n_title=?, n_content=?, n_date=sysdate,"
					+ "n_count=0, n_r_count=0" + "where n_num=?";

			PreparedStatement pstat = con.prepareStatement(sql);

			pstat.setString(1, n.getN_title());
			pstat.setString(2, n.getN_content());
			pstat.setInt(3, n.getN_num());

			pstat.executeUpdate();
			pstat.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void b_delete(int n_num) {
		try {
			Connection con = ds.getConnection();

			String sql = "delete tm_notice where n_num=?";
			PreparedStatement pstat = con.prepareStatement(sql);

			pstat.setInt(1, n_num);
			pstat.executeUpdate();
			pstat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Notice> n_search(String condition, String input) {
		ArrayList<Notice> n_s_List = new ArrayList<Notice>();

		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "";
			if (condition.equals("n_title")) {
				sql = "select * from tm_notice where n_title like '%" + input
						+ "%' order by n_date desc";
			} else if (condition.equals("n_id")) {
				sql = "select * from tm_notice where n_id like '%" + input
						+ "%' order by n_date desc";
			} else if (condition.equals("n_content")) {
				sql = "select * from tm_notice where n_content like '%" + input
						+ "%' order by n_date desc";
			}

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int n_num = rs.getInt(1);
				String n_title = rs.getString(2);
				String n_content = rs.getString(3);
				String n_date = rs.getString(4);
				int n_count = rs.getInt(5);
				int n_r_count = rs.getInt(6);

				Notice i = new Notice(n_num, n_title, n_content, n_date,
						n_count, n_r_count);

				n_s_List.add(i);
			}
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n_s_List;
	}

}
