package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.vo.Band;
import com.vo.BandMember;
import com.vo.BandReply;
import com.vo.BandReview;
import com.vo.Eat;
import com.vo.EatLike;
import com.vo.EatReply;
import com.vo.Friend;
import com.vo.Member;
import com.vo.Play;
import com.vo.PlayLike;
import com.vo.PlayReply;
import com.vo.Sleep;
import com.vo.SleepLike;
import com.vo.SleepReply;



public class TMModel_Main {
	DataSource ds;
	ArrayList<Play> p_list;
	ArrayList<Eat> e_list;
	ArrayList<Sleep> s_list;

	/**
	 * Create db pool
	 */
	public TMModel_Main() {
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

	public Member member_selectAll(String m_id) {
		Member m_bean = null;

		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_member where m_id ='" + m_id +"'";

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				// 기본 정보
				String m_password = rs.getString(2);
				String m_name = rs.getString(3);
				int m_age = rs.getInt(4);
				int m_phone = rs.getInt(5);
				String m_email = rs.getString(6);
				// 추천을 위한 추가정보
				String m_session = rs.getString(7);
				String m_food = rs.getString(8);
				String m_sleep = rs.getString(9);
				String m_area = rs.getString(10);
				String m_img = rs.getString(11);
				m_bean = new Member(m_id, m_password, m_name, m_age, m_phone,
						m_email, m_session, m_food, m_sleep, m_area, m_img);
			}
			con.close();
			rs.close();
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return m_bean;
	}

	public ArrayList<Play> play_selectAll() {
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select p_num, p_m_id, p_img, p_content, p_date, p_location2, p_session, p_location, p_title from tm_play";
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
				String p_title = rs.getString(9);
				
				Play play_bean = new Play(p_num, p_m_id, p_img, p_content,
						p_date, p_location2, p_session, p_location);
				play_bean.setP_title(p_title);

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
			String sql = "select e_num, e_m_id, e_img, e_content, e_date, e_location2, e_session, e_location, e_title from tm_eat";
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
				String e_title = rs.getString(9);

				Eat eat_bean = new Eat(e_num, e_m_id, e_img, e_content, e_date,
						e_location2, e_session, e_location);
				eat_bean.setE_title(e_title);
				

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
			String sql = "select s_num, s_m_id, s_img, s_content, s_date,s_location2, s_session, s_location,s_title from tm_sleep";
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
				String s_title = rs.getString(9);
				
				Sleep sleep_bean = new Sleep(s_num, s_m_id, s_img, s_content,
						s_date, s_location2, s_session, s_location);
				sleep_bean.setS_title(s_title);

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
	public boolean sns_make(int val, Object o) {
		boolean isJoin = false;
		String sql = null;
		try {
			Connection con = ds.getConnection();
			if (val == 1) {
				Play p = (Play) o;
				sql = "insert into tm_play(p_m_id, p_img, p_price,p_session, p_inout,p_title, p_content, p_date, p_location, p_location2)"
						+ " values(?,?,?,?,?,?,?,sysdate(),?,?)";
				PreparedStatement pstat = con.prepareStatement(sql);

				pstat.setString(1, p.getP_m_id());
				pstat.setString(2, p.getP_img());
				pstat.setInt(3, p.getP_price());
				pstat.setString(4, p.getP_session());
				pstat.setString(5, p.getP_inout());
				pstat.setString(6, p.getP_title());
				pstat.setString(7, p.getP_content());
				// date
				pstat.setString(8, p.getP_location());
				pstat.setString(9, p.getP_location2());

				pstat.executeUpdate();
				isJoin = true;

				pstat.close();

			} else if (val == 2) {
				Eat e = (Eat) o;
				sql = "insert into tm_eat(e_m_id, e_img, e_price,e_session, e_inout, e_title, e_content, e_date, e_location, e_location2)"
						+ " values(?,?,?,?,?,?,?,sysdate(),?,?)";

				PreparedStatement pstat = con.prepareStatement(sql);

				pstat.setString(1, e.getE_m_id());
				pstat.setString(2, e.getE_img());
				pstat.setInt(3, e.getE_price());
				pstat.setString(4, e.getE_session());
				pstat.setString(5, e.getE_inout());
				pstat.setString(6, e.getE_title());
				pstat.setString(7, e.getE_content());
				// date
				pstat.setString(8, e.getE_location());
				pstat.setString(9, e.getE_location2());

				pstat.executeUpdate();
				isJoin = true;

				pstat.close();
			} else if (val == 3) {
				Sleep s = (Sleep) o;
				sql = "insert into tm_sleep(s_m_id, s_img, s_price,s_session, s_inout,s_title, s_content, s_date, s_location, s_location2)"
						+ " values(?,?,?,?,?,?,?,sysdate(),?,?)";
			

				PreparedStatement pstat = con.prepareStatement(sql);

				pstat.setString(1, s.getS_m_id());
				pstat.setString(2, s.getS_img());
				pstat.setInt(3, s.getS_price());
				pstat.setString(4, s.getS_session());
				pstat.setString(5, s.getS_inout());
				pstat.setString(6, s.getS_title());
				pstat.setString(7, s.getS_content());
				// date
				pstat.setString(8, s.getS_location());
				pstat.setString(9, s.getS_location2());

				pstat.executeUpdate();
				isJoin = true;

				pstat.close();
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return isJoin;

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
	
	public boolean enterEatReply(String id, int num, String content) {
		boolean isComplete = false;
		Connection con;
		try {
			con = ds.getConnection();

			String sql = "insert into e_reply(e_r_m_id,e_r_num, e_r_content, e_r_date) values(?,?,?,sysdate())";
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
	public boolean enterEatLike(String id, int num) {
		boolean isComplete = false;
		Connection con;
		try {
			con = ds.getConnection();

			String sql = "insert into e_like(e_l_m_id,e_l_num, e_l_date) values(?,?,sysdate())";
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
	
	public boolean enterSleepReply(String id, int num, String content) {
		boolean isComplete = false;
		Connection con;
		try {
			con = ds.getConnection();

			String sql = "insert into s_reply(s_r_m_id,s_r_num, s_r_content, s_r_date) values(?,?,?,sysdate())";
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
	
	public boolean enterSleepLike(String id, int num) {
		boolean isComplete = false;
		Connection con;
		try {
			con = ds.getConnection();

			String sql = "insert into s_like(s_l_m_id,s_l_num, s_l_date) values(?,?,sysdate())";
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
	public void b_rv_add(BandReview brv) {
		Connection con;
		try {
			con = ds.getConnection();
			String sql = "insert into b_review (b_rv_m_id, b_rv_num, b_rv_img, b_rv_content, b_rv_date) "
					+ "values (?, ?, ?, ?, sysdate())";
			PreparedStatement pstat = con.prepareStatement(sql);

			String id = brv.getB_rv_m_id();
			int num = brv.getB_rv_num();
			String img = brv.getB_rv_img();
			String content = brv.getB_rv_content();

			pstat.setString(1, id);
			pstat.setInt(2, num);
			pstat.setString(3, img);
			pstat.setString(4, content);

			pstat.executeUpdate();

			con.close();
			pstat.close();
			content = "";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void s_memberJoin(BandMember bm) {
		try {
			Connection con = ds.getConnection();

			System.out.println("model s_memberJoin");

			String sql = "insert into tm_join values(?,?)";
			PreparedStatement pstat = con.prepareStatement(sql);

			pstat.setInt(1, bm.getJ_num());
			pstat.setString(2, bm.getJ_m_id());

			pstat.executeUpdate();
			pstat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean findJoinMember(String b_rv_m_id, int b_rv_num) {
		boolean isExist = false;
		try {
			Connection con = ds.getConnection();
			String sql = "select * from tm_join where j_m_id=? and J_num=?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, b_rv_m_id);
			pstat.setInt(2, b_rv_num);

			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {
				isExist = true;

			} else {
				isExist = false;
			}

			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isExist;
	}
	public boolean b_make(Band b) {
		boolean isJoin = false;
		try {
			Connection con = ds.getConnection();

			String sql = "insert into tm_band (b_m_id, b_category, b_title, b_img, b_content, b_date, b_people, b_when, b_where)"
					+ " values(?,?,?,?,?,sysdate(),?,?,?)";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, b.getB_m_id());
			pstat.setString(2, b.getB_category());
			pstat.setString(3, b.getB_title());
			pstat.setString(4, b.getB_img1());
			pstat.setString(5, b.getB_content());
			// date
			pstat.setInt(6, b.getB_people());
			pstat.setString(7, b.getB_when());
			pstat.setString(8, b.getB_where());
			
			pstat.executeUpdate();
			isJoin = true;

			pstat.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return isJoin;

	}

	public Band band_category(int num) {
		Band s_bean = null;
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "";
			if (num == 1) {
				sql = "select * from tm_band where b_category='같이놀자!' order by b_when desc";
			} else if (num == 2) {
				sql = "select * from tm_band where b_category='같이타자!' order by b_when desc";
			} else if (num == 3) {
				sql = "select * from tm_band where b_category='같이자자!' order by b_when desc";
			} else if (num == 4) {
				sql = "select * from tm_band where b_category='같이먹자!' order by b_when desc";
			}

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int b_num = rs.getInt(1);
				String b_id = rs.getString(2);
				String b_category = rs.getString(3);
				String b_title = rs.getString(4);
				String b_img1 = rs.getString(5);
				String b_content = rs.getString(6);
				String b_when = rs.getString(7);

				s_bean = new Band(b_num, b_id, b_category, b_title, b_img1,
						b_content, b_when);

				break;
			}

			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s_bean;
	}

	/**
	 * 모임에 대한 상세글을 가져온다. ArrayList 안에는 개시된 모임글 + 모임참여자 정보가 있다.
	 * 
	 * @param band_num
	 * @return
	 */
	public ArrayList b_selectOne(int band_num) {
		Band band = null;
		ArrayList band_List = new ArrayList();

		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_band where b_num=" + band_num;

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int b_num = rs.getInt(1);
				String b_m_id = rs.getString(2);
				String b_category = rs.getString(3);
				String b_title = rs.getString(4);
				String b_img1 = rs.getString(5);
				String b_content = rs.getString(6);
				// date
				int b_people = rs.getInt(8);
				String b_when = rs.getString(9);
				String b_where = rs.getString(10);
				int b_l_count = rs.getInt(11);
				int b_r_count = rs.getInt(12);
				int b_rv_count = rs.getInt(13);
				
				
				
				band = new Band();
				band.setB_num(b_num);
				band.setB_m_id(b_m_id);
				band.setB_category(b_category);
				band.setB_title(b_title);
				band.setB_img1(b_img1);
				band.setB_content(b_content);
				//date
				band.setB_people(b_people);
				band.setB_when(b_when);
				band.setB_where(b_where);
				band.setB_l_count(b_l_count);
				band.setB_r_count(b_r_count);
				band.setB_rv_count(b_rv_count);
				
				band_List.add(band);

			}

			rs = null;// rs 비우고
			sql = null;// 쿼리 비우고

			/*
			 * sql =
			 * "select m.m_name, m.m_age, m.m_img from t_member m, t_mp mp " +
			 * "where mp.mp_id = m.m_id and mp.mp_num=" + s_s_num;
			 */
			/*
			 * 모임 참여자 가져오는 쿼리
			 */
			sql = "select m.m_name, m.m_age,m.m_img from tm_member m, tm_join j "
					+ "where j.j_m_id = m.m_id and j.j_num = " + band_num;
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				String m_name = rs.getString(1);
				int m_age = rs.getInt(2);
				String m_img = rs.getString(3);
				
				System.out.println(m_img+"###MIMG#");

				Member m = new Member(m_name, m_age);
				m.setM_img(m_img);
				band_List.add(m);
			}

			// //모임댓글받아오기

			rs.close();
			stat.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return band_List;
	}

	/**
	 * 모임 상세보기에서 댓글 리스트를 모두 가져온다.
	 * 
	 * @param b_num
	 * @return
	 */
	public ArrayList<BandReply> br_selectOne(int b_num) {
		BandReply br = null;
		ArrayList<BandReply> brl = new ArrayList<BandReply>();

		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from b_relpy where b_r_num=" + b_num;

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int b_r_idx = rs.getInt(1);
				String b_r_m_id = rs.getString(2);
				int b_r_num = rs.getInt(3);
				String b_r_content = rs.getString(4);
				String b_r_date = rs.getString(5);
				
				br = new BandReply();
				br.setB_r_idx(b_r_idx);
				br.setB_r_m_id(b_r_m_id);
				br.setB_r_num(b_r_num);
				br.setB_r_content(b_r_content);
				br.setB_r_date(b_r_date);
				
				brl.add(br);
			}
			con.close();
			stat.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return brl;

	}
	public void b_r_add(BandReply br) {
		Connection con;
		try {
			con = ds.getConnection();
			String sql = "insert into b_relpy (b_r_m_id, b_r_num, b_r_content, b_r_date) "
					+ "values (?, ?, ?, sysdate())";
			PreparedStatement pstat = con.prepareStatement(sql);

			String id = br.getB_r_m_id();
			int num = br.getB_r_num();
			String content = br.getB_r_content();

			pstat.setString(1, id);
			pstat.setInt(2, num);
			pstat.setString(3, content);

			pstat.executeUpdate();

			con.close();
			pstat.close();
			content = "";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 관광지 상세글 보기위한 데이터를 가져온다.
	 * 
	 * @param play_num
	 * @return
	 */
	public Play play_selectOne(int play_num) {
		Play p = null;

		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_play where p_num =" + play_num;

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
				System.out.println(p_r_count + "## " + p_l_count);
				p = new Play(p_num, p_m_id, p_img, p_price, p_session, p_inout,
						p_date, p_content, p_location, p_location2, p_r_count,
						p_l_count);
				p.setP_title(p_title);
			}
			con.close();
			rs.close();
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;

	}
	public Eat eat_selectOne(int eat_num) {
		Eat e = null;

		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_eat where e_num =" + eat_num;

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
				System.out.println(e_r_count + "## " + e_l_count);
				e = new Eat(e_num, e_m_id, e_img, e_price, e_session, e_inout,
						e_date, e_content, e_location, e_location2, e_r_count,
						e_l_count);
				e.setE_title(e_title);
			}
			con.close();
			rs.close();
			stat.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return e;

	}
	public Sleep sleep_selectOne(int sleep_num) {
		Sleep s = null;

		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_sleep where s_num =" + sleep_num;

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
				System.out.println(s_r_count + "##SS " + s_l_count);
				s = new Sleep(s_num, s_m_id, s_img, s_price, s_session, s_inout,
						s_date, s_content, s_location, s_location2, s_r_count,
						s_l_count);
				s.setS_title(s_title);
				
			}
			con.close();
			rs.close();
			stat.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return s;

	}
	public ArrayList<PlayLike> play_selectLike(int play_num) {
		PlayLike pl;
		ArrayList<PlayLike> playLList = new ArrayList<PlayLike>();
		

		try {
			Connection con = ds.getConnection();
			String sql = "SELECT p_l_m_id, p_l_date, m_img FROM p_like p join tm_member m WHERE p.p_l_num = ? and p.p_l_m_id = m.m_id;";
		
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, play_num);
			
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				String p_l_m_id = rs.getString(1);
				String p_l_date = rs.getString(2);
				String m_img = rs.getString(3);
				
				pl = new PlayLike();
				pl.setP_l_m_id(p_l_m_id);
				pl.setP_l_date(p_l_date);
				pl.setM_img(m_img);
				
				playLList.add(pl);
			}
			con.close();
			rs.close();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return playLList;
	}
	public ArrayList<EatLike>eat_selectLike(int eat_num) {
		EatLike el;
		ArrayList<EatLike> eatLList = new ArrayList<EatLike>();
		

		try {
			Connection con = ds.getConnection();
			String sql = "SELECT e_l_m_id, e_l_date, m_img FROM e_like e join tm_member m WHERE e.e_l_num = ? and e.e_l_m_id = m.m_id;";
		
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, eat_num);
			
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				String e_l_m_id = rs.getString(1);
				String e_l_date = rs.getString(2);
				String m_img = rs.getString(3);
				
				el = new EatLike();
				el.setE_l_m_id(e_l_m_id);
				el.setE_l_date(e_l_date);
				el.setM_img(m_img);
				
				eatLList.add(el);
			}
			con.close();
			rs.close();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return eatLList;
	}
	
	public ArrayList<SleepLike>sleep_selectLike(int sleep_num) {
		SleepLike sl;
		ArrayList<SleepLike> sleepLList = new ArrayList<SleepLike>();
		

		try {
			Connection con = ds.getConnection();
			String sql = "SELECT s_l_m_id, s_l_date, m_img FROM s_like s join tm_member m WHERE s.s_l_num = ? and s.s_l_m_id = m.m_id;";
		
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, sleep_num);
			
			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				String s_l_m_id = rs.getString(1);
				String s_l_date = rs.getString(2);
				String m_img = rs.getString(3);
				
				sl = new SleepLike();
				sl.setS_l_m_id(s_l_m_id);
				sl.setS_l_date(s_l_date);
				sl.setM_img(m_img);
				
				sleepLList.add(sl);
			}
			con.close();
			rs.close();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sleepLList;
	}
	
	public ArrayList<PlayReply> play_selectReply(int play_num) {
		PlayReply pr;
		ArrayList<PlayReply> playRList = new ArrayList<PlayReply>();
		this.increaseNumber(play_num);
		this.increaseNumberLike(play_num);

		try {
			Connection con = ds.getConnection();
			String sql = "SELECT p_r_m_id, p_r_content, p_r_date, m_img FROM p_reply p join tm_member m WHERE p.p_r_num = ? and p.p_r_m_id = m.m_id;";
		
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, play_num);
			
			/*String sql = "select p_r_m_id,p_r_content,p_r_date from p_reply where p_r_num ="
					+ play_num;*/

			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				String p_r_m_id = rs.getString(1);
				String p_r_content = rs.getString(2);
				String p_r_date = rs.getString(3);
				String m_img = rs.getString(4);
				
				pr = new PlayReply(p_r_m_id, p_r_content, p_r_date);
				pr.setM_img(m_img);
				playRList.add(pr);
			}
			con.close();
			rs.close();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return playRList;
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
	
	public ArrayList<EatReply> eat_selectReply(int eat_num) {
		EatReply er;
		ArrayList<EatReply> eatRList = new ArrayList<EatReply>();
		this.increaseEatNumber(eat_num);
		this.increaseEatNumberLike(eat_num);

		try {
			Connection con = ds.getConnection();
			String sql = "SELECT e_r_m_id, e_r_content, e_r_date, m_img FROM e_reply e join tm_member m WHERE e.e_r_num = ? and e.e_r_m_id = m.m_id;";
		
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, eat_num);
			
			/*String sql = "select p_r_m_id,p_r_content,p_r_date from p_reply where p_r_num ="
					+ play_num;*/

			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				String e_r_m_id = rs.getString(1);
				String e_r_content = rs.getString(2);
				String e_r_date = rs.getString(3);
				String m_img = rs.getString(4);
				
				er = new EatReply(e_r_m_id, e_r_content, e_r_date);
				er.setM_img(m_img);
				eatRList.add(er);
			}
			con.close();
			rs.close();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return eatRList;
	}
	public void increaseEatNumber(int num) {
		Connection con;
		int count = this.replyEatCount(num);
		
		System.out.println(count + "%%%%" + num);
		try {
			con = ds.getConnection();

			String sql = "update tm_eat set e_r_count = ? where e_num= ?";
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
	public void increaseEatNumberLike(int num) {
		Connection con;
		int count = this.EatlikeCount(num);
		System.out.println(count+"***!!" + num);
		try {
			con = ds.getConnection();

			String sql = "update tm_eat set e_l_count = ? where e_num= ?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, count);
			pstat.setInt(2, num);

			pstat.executeUpdate();

			pstat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int replyEatCount(int num) {
		int count = 0;

		try {
			Connection con = ds.getConnection();
			String sql = "select * from e_reply where e_r_num = ?";
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
	public int EatlikeCount(int num) {
		int count = 0;

		try {
			Connection con = ds.getConnection();
			String sql = "select * from e_like where e_l_num = ?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, num);

			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				count++;

			}
			System.out.println(count + "CCC");
			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}
	
	public ArrayList<SleepReply> sleep_selectReply(int sleep_num) {
		SleepReply sr;
		ArrayList<SleepReply> sleepRList = new ArrayList<SleepReply>();
		this.increaseSleepNumber(sleep_num);
		this.increaseSleepNumberLike(sleep_num);

		try {
			Connection con = ds.getConnection();
			String sql = "SELECT s_r_m_id, s_r_content, s_r_date, m_img FROM s_reply s join tm_member m WHERE s.s_r_num = ? and s.s_r_m_id = m.m_id;";
		
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, sleep_num);
			
			/*String sql = "select p_r_m_id,p_r_content,p_r_date from p_reply where p_r_num ="
					+ play_num;*/

			ResultSet rs = pstat.executeQuery();
			
			while (rs.next()) {
				String s_r_m_id = rs.getString(1);
				String s_r_content = rs.getString(2);
				String s_r_date = rs.getString(3);
				String m_img = rs.getString(4);
				
				sr = new SleepReply(s_r_m_id, s_r_content, s_r_date);
				sr.setM_img(m_img);
				sleepRList.add(sr);
			}
			con.close();
			rs.close();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sleepRList;
	}
	
	public void increaseSleepNumber(int num) {
		Connection con;
		int count = this.replySleepCount(num);
		
		System.out.println(count + "%%%%" + num);
		try {
			con = ds.getConnection();

			String sql = "update tm_sleep set s_r_count = ? where s_num= ?";
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
	public void increaseSleepNumberLike(int num) {
		Connection con;
		int count = this.SleeplikeCount(num);
		System.out.println(count+"***!!" + num);
		try {
			con = ds.getConnection();

			String sql = "update tm_sleep set s_l_count = ? where s_num= ?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, count);
			pstat.setInt(2, num);

			pstat.executeUpdate();

			pstat.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int replySleepCount(int num) {
		int count = 0;

		try {
			Connection con = ds.getConnection();
			String sql = "select * from s_reply where s_r_num = ?";
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
	public int SleeplikeCount(int num) {
		int count = 0;

		try {
			Connection con = ds.getConnection();
			String sql = "select * from s_like where s_l_num = ?";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, num);

			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				count++;

			}
			System.out.println(count + "SSS");
			rs.close();
			pstat.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}
	
	/**
	 * 상세 모임보기에서 후기 리스트를 담고있다.
	 * 
	 * @param b_num
	 * @return
	 */
	public ArrayList<BandReview> brv_selectOne(int b_num) {
		BandReview brv = null;
		ArrayList<BandReview> brvList = new ArrayList<BandReview>();

		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from b_review where b_rv_num=" + b_num;

			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int b_rv_idx = rs.getInt(1);
				String b_rv_m_id = rs.getString(2);
				int b_rv_num = rs.getInt(3);
				String b_rv_img = rs.getString(4);
				String b_rv_content = rs.getString(5);
				String b_rv_date = rs.getString(6);
				
				brv = new BandReview();
				brv.setB_rv_idx(b_rv_idx);
				brv.setB_rv_m_id(b_rv_m_id);
				brv.setB_rv_num(b_rv_num);
				brv.setB_rv_img(b_rv_img);
				brv.setB_rv_content(b_rv_content);
				brv.setB_rv_date(b_rv_date);
				
				brvList.add(brv);
			}
			con.close();
			rs.close();
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return brvList;

	}

	/**
	 * 모임의 주체한 사람의 정보를 가져온다. (모임 상세페이지에 이용!)
	 * 
	 * @param b_m_id
	 * @return
	 */
	public Member m_selectOne(String b_m_id) {
		Member m = null;
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			String sql = "select * from tm_member where m_id='" + b_m_id + "'";
			System.out.println(sql+"@!$");
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				String m_id = rs.getString(1);
				String m_password = rs.getString(2);
				String m_name = rs.getString(3);
				int m_age = rs.getInt(4);
				int m_phone = Integer.parseInt(rs.getString(5));
				String m_email = rs.getString(6);
				String m_img = rs.getString(11);
				
				m = new Member();
				m.setM_id(m_id);
				m.setM_password(m_password);
				m.setM_name(m_name);
				m.setM_age(m_age);
				m.setM_phone(m_phone);
				m.setM_email(m_email);
				m.setM_img(m_img);
				
			}

			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return m;
	}
}
