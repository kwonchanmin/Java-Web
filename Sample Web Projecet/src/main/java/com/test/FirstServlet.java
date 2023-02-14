package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/myservlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		// init() 의 목적은 servlet instance를 초기화하는데 있다.
		System.out.println("init()가 호출되었다.");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 GET방식으로 이 servlet을 호출하면 이 method가 호출된다.
		// 결과적으로 보았을 때 doGet() method가 호출된다.
		// 클라이언트의 호출 URL => http://127.0.0.1:8080/sample/myservlet
 		// 이 클레스 안에 있는 doGet()이 호출된다.
		
		// 여기에 코드를 작성하면 된다.
		// 프로그램 처리방식대로 작성해보자.
		// 1. 입력을 받는다.
		//		입력 받을게 없으니 넘어가자.
		// 2. 로직처리한다.
		// 		로직처리도 넘어간다.
		// 3. 출력처리한다.
		//  이건 해야된다,.
		// 1. 내가 클라이언트에게 전달한 데이터가 어떤 데이터인지 설정부터 해야된다.
		response.setContentType("text/html; charset=UTF-8");
		// 2. 클라이언트에게 데이터를 전달하기 위해 stream을 연다.
		PrintWriter out = response.getWriter();
		// 3. 통로가 열렸으니 이제 통로를 통해서 데이터를 전달한다.
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>이건 서블릿의 결과다.소리벗고 팬티질러 </body>");
		out.println("</html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
