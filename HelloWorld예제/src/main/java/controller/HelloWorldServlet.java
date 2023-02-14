package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/sayHello")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloWorldServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 방식으로 호출되면 .. 결국 돌고돌아 이 method가 thread에 의해서 호출되는 거다. 
		// 1.client가 보내주는 데이터를 받는다. => request객체를 이용.
		// 2. 로직처리를 한다.( DB처리 포함) 
		// 3. 출력처리한다. => response객체를 이용.
		//    1. 처리된 결과를 보내주기 전에 .. 먼저 처리한 결과가 어떤 데이터 인지를 먼저 알려줘야 된다.
		// response(응답된).setContentType(내용의 데이터를 설정해준다.)(이 안에는 문자열이 온다.)
		// text/plain은 일반 문장 / charactorset 줄임말 ->charset 
		// setCOntentType(이 안의 문자열 안의 문자가 제대로 입력되지 않으면 브라우져에서 서버가 보내주는 정보를 다운로드 해버린다. -> text/html; 이거 말하는거다. )
		response.setContentType("text/html; charset=UTF-8");
		//    2. 실제 결과 데이터를 전송하면 된다.
		//	  network를 통해서 전송해야되기 때문에 stream을 열어서 데이터를 전송
		PrintWriter out = response.getWriter(); // 이 문장을 많이 쓰니 숙지하고 있자
		out.println("<html><head></head><body>꿍까!</body></html>");
		out.close(); // 사용하고 난 후에는 stream을 닫아줘야된다. 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
