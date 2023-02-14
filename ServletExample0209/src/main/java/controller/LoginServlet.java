package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyBatisConnectionFactory;
import vo.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userID");
		String userpw = request.getParameter("userPW");
		
		Login login =  new Login();
		login.setId(userid);
		login.setPassword(userpw);
		
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		Login result = sqlSession.selectOne("myLogin.selectLoginByKeyword",login);
		
		if(result != null) {
			// 로그인 성공
			//  Servlet container에게 session객체를 요청한다
			// requesr.getSession(true)의 의미는
			// 만약 기존에 내가 할당받은 세션객체가 있으면 그거 줘라
			// 기존에 할당받은 세션객체가 없으면 만들어 줘라.
			HttpSession session = request.getSession(true);
			// 이 세션객체는 Map 형태
			session.setAttribute("loginName", result.getName()); // loginName = key 값이다.
		}
		
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		if(result != null) {
			out.println("<h1>환영합니다." +result.getName() +"님 </h1>");
			out.println("<a href='board'> 게시판 들어가기 </a>");
			
		}else {
			
			out.println("<h1>가입한 정보가 없습니다.</h1>");
		}
		out.println("<ul>");
		
		out.println("</ul>");
		out.println("</body></html>");
		
		out.close();
	}

}
