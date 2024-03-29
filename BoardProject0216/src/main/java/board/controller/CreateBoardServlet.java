package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.CreateBoardService;
import board.vo.BoardName;

/**
 * Servlet implementation class CreateBoardServlet
 */
@WebServlet("/createBoard")
public class CreateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateBoardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String memId = request.getParameter("memId");
		
		BoardName boardname = new BoardName();
		boardname.setBoardTitle(title);
		boardname.setBoardContent(content);
		boardname.setBoardAuthor(memId);
		
		CreateBoardService service = new CreateBoardService();
		List<BoardName> list = service.createBoard(boardname);
		
		if (list != null) {

			HttpSession session = request.getSession(true);
			session.setAttribute("board", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			request.setAttribute("boardList", list);

			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("loadingfail.html");
		}
	
	}
	

}
