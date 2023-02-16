package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.BoardName;
import member.service.MemberService;
import member.vo.Member;

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
		// Servlet은 MVC(Model-View-Controller) pattern에서 controller의 역할을 한다.
		// Model : 1. Data Model => VO class가 이 역할을 담당
		//		   2. Business Logic Model => Service class가 이 역항르 담당
		//		 	  -데이터베이스 처리가 들어올 수 있다. 이 데이터베이스 처리는 DAO가 담당한다.
		// View : HTML, JSP 
		// Controller : View와 Model을 연결해 주는 역항르 담당 => Servlet이 담당
		//				view로부터 사용자데이터를 받아서 Model(Service)에게 전달해서 로직처리 시키고 로직처리된 결과를 Model(Service)로부터 받아온다.
		//				그 결과를 보고 특정 View를 선택(HTML,JSP)해서 그 View를 클라이언트에게 전달하도록 시킨다.
		
		// 1. 입력받고
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		
		// 입력받은 데이터로 VO를 생성한다.
		// 데이터베이스 테이블을 기준으로 VO를 생성해야 하니.. 당연히 테이블이 있어야한다.
		// Table을 생성한 후 VO를 만들고 데이터를 세팅해서 Service에게 넘겨줄 준비를 했다.
		Member member = new Member();
		member.setMemberId(userID);
		member.setMemberPw(userPW);
		
		// 2. 로직처리하고
		// 로직처리를 하기 위해 Service객체를 생성해야한다.
		MemberService service= new MemberService();
		// 객체가 생성되었으면 이제 일을 시킨다.
		// 만약 로그인이 성공하면 VO안의 회원의 이름까지 포함해서 둘고온다.
		// 만약 로그인이 실패하면 null을 리턴받을꺼다.
		Member result =service.login(member);
		
		List<BoardName> list = null; // if 안에서 선언을 하면 날라갈 위험이 있기 때문에 위에 따로 선언을 미리 해둔것이다.
		
		if(result != null) {
			BoardService bservice = new BoardService();
			list = bservice.getAllBoard();
		}
		
		// 3. 출력한다. 
		if(result != null) {
			// 로그인에 성공
			// 로그인에 성공한 흔적은 남겨놔야된다. =>  Session에 남겨놓으면 좋다
			HttpSession session = request.getSession(true);
			session.setAttribute("member", result); // 멤버라는 이름으로 result값을 저장한다는 의미
			// 게시판 HTML페이지를 클라이언트에게 전달한다. (JSP로 전송)
			//  JSP는 그 실체가 Servlet이다. 
			// 제어구조 : html -> servlet -> service-> dao -> service-> controller -> jsp(servlet) -> client
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp"); // 다음에 실행한 jsp가 이거라고 지정해주는역할
			
			request.setAttribute("boardList", list); // request 객체에 내가 얻어온 list를 잠시 저장하는 것이다. jsp에 잠시 전해줘야될 정보는 request에 붙는거다. 
													 // jsp가 끝이 나면 전해준 request와 response 정보가 사라질 것이기 때문이다. 
													 // jsp 에 데이터를 전달하는 방법이 많지만 지금 배운 것은 
													 //	session에 넣어서 전달하는 밥법과 request에 넣어서 전달하는 방법 2가지이다.
			
			dispatcher.forward(request,response);
			
			
		}else {
			// 로그인에 실패
			// 오류 HTML 페이지를 클라이언트에게 전송한다. ( HTML로 전송)
			response.sendRedirect("loginFail.html"); // 클라이언트에게 다시 접속하라고 응답을 보내는 것이다. 
		}
		
	}

}
