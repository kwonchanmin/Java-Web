package booksearch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;

import library.BookVO;
import sqlmap.SqlSessionFactorys;

public class BookDAO {
	
	private static BookDAO instance = new BookDAO();
	
	private static SqlSessionFactory sqlSessionFactory = SqlSessionFactorys.getSqlSessionFactory();
	
	public BookVO getBook(String btitle) {
		BookVO bookvo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 1. DBMS에 맞게 Driver를 로드
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2. java SQL 패키지의 DriverManager를 통해서 DBMS에 연결
			conn = DriverManager.getConnection(dburl,username,password);
			
			// 3. Sql 쿼리 String 생성
			String sql = "SELECT btitle,bauthor,bprice FROM book WHERE btitle = ?";
			
			// 4. 쿼리 실행 및 결과얻기
			ps = conn.prepareStatement(sql);
			// dnldp 3번의 ?에 대한 설정, 1번째로 ?의 값을 설정
			ps.setString(1, btitle);
			
			// 5. 쿼리 실행 및 결과 얻기
			rs= ps.executeQuery();
			
			// 결과 값 빼니기 next()함수의 결과 첫번째 컬럼을 빼낸다.
			if(rs.next()) {
				String title = rs.getString("btitle");
				String author = rs.getString("bauthor");
				Integer price = rs.getInt("bprice");
				
				bookvo = new BookVO(title,author,price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return bookvo;
		
	}

	public List<BookVO> select(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
