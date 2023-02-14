package servlet;

import arguments.HttpServletRequest;
import arguments.HttpServletResponse;

// Servlet(서블릿)이라고 불리는 이 클래스는 원래 특정 클래스(HttpServlet)를 상속해서 만들어야한다.
public class AddServlet {

	public void init() {
		// Servlet instance의 초기화를 담당
		// 생성자에게 하지 않고 여기서 한다.
	}

	public void service(HttpServletRequest request, HttpServletResponse response) {
		// 이 method는 하는 일이 정해져 있다. 
		// request 객체를 수색해서 클라이언트의 요청방식이 어떤 방식인지 알아낸다.
		// 만약 GET방식이면 = doGet() 호출
		doGet(request, response);
		// 만약 Post방식이면 = doPost() 호출
		doPost(request , response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		// service에서 준 자료 그대로 () 안에 인자로 넣어준다.
		// 여기가 최종 종착점이며, 
		// request 객체와 response객체를 이용해서 입력처리와 로직처리 그리고 출력처리를 진행 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		// service에서 준 자료 그대로 () 안에 인자로 넣어준다.
		// 여기가 최종 종착점이며, 
		// request 객체와 response객체를 이용해서 입력처리와 로직처리 그리고 출력처리를 진행 
	}
}
