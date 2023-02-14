package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyBatisConnectionFactory;
import vo.Book;

/**
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/bookSearch")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리	
		request.setCharacterEncoding("UTF-8");
		
		// 1. 입력을 받아보자.
		String keyword = request.getParameter("keyword");
		String price = request.getParameter("price");
		
		// 2. 로직 처리를 한다. (DB처리를 포함해서)
		// 	  MyBatis세팅부터 하고 왔어요.
		//    1. sqlSessionFactory 설정(SqlMaoConfig.xml)
		// 	  2. 연결정보 따로 분리해서 설정(driver.properties)
		//    3. SQL을 실행하기 위한 mapper설정(sqlmap/Book.xml)
		
		// 클라이언트가 보내준 데이터를 이용해서 VO를 생성
		Book book = new Book();
		book.setBtitle(keyword);
		book.setBprice(Integer.parseInt(price));
		
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession(); // openSession이 있어야지 sql구문을 찾을 수 있다. 
		
		List<Book> result = session.selectList("myBook.selectBookByKeyword", book);
		
		session.close();
		
		// 3. 결과 출력!!!!!
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<h1>검색결과입니다.</h1>");
		out.println("<h3>검색키워:" + keyword + "<h3>");
		out.println("<h3>검색 가격 :" + price + "</h3>");
		out.println("<ul>");
		
		for(Book tmp : result ) {
			out.println("<li>" + tmp.getBtitle() + "," + tmp.getBprice() + "</li>");
		}
		
		out.println("</ul>");
		out.println("</body></html>");
		
		out.close();
	}

}
