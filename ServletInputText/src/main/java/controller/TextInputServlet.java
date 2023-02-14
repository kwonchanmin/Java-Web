package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TextInputServlet
 */
@WebServlet("/inputText")
public class TextInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// field를 만들 수 있다.
	int count = 0 ; // 이 field는 client   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TextInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8"); 이놈은 post방식에서만 한글을 출력할 때 사용하는 것이고 Get 방식은 필요없다.
		
		count += 1;  // 진짜 공유되는지 확인도 할겸.. 
		
		// 1. 입력받고
		String data = request.getParameter("userID");
		// request.setCharacterEncoding("UTF-8"); 여기에 이 코드가 있으면 제대로 한글로 변환이 어렵다 
		// 2. 로직처리하고 
		// 일단 없다.
		// 3. 출력한다.
		//     1. contentType을 설정	
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println(data + "님 환영합니다.");
		out.println("<br><br>");
		out.println("이건 get방식이다.");
		out.println("</body></html>");
		out.close();	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트의 요청을 처리하면 된다.
		// POST 방식일 경우
		// 클라이언트로부터 서블릿으로 전송된 문자 데이터는 ISO_8859_1 인코딩으로 되어있다.
		// 그래서 기본적으로는 한글처리가 안된다.
		// 인코딩을 바꿔서 한글처리를 해줘야한다.
		request.setCharacterEncoding("UTF-8");
		count += 1;  // 진짜 공유되는지 확인도 할겸.. 
		
		// 1. 입력받고
		String data = request.getParameter("userID");
		// request.setCharacterEncoding("UTF-8"); 여기에 이 코드가 있으면 제대로 한글로 변환이 어렵다 
		// 2. 로직처리하고 
		// 일단 없다.
		// 3. 출력한다.
		//     1. contentType을 설정	
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println(data + "님 환영합니다.");
		out.println("</body></html>");
		out.close();
		
		
	}

}
