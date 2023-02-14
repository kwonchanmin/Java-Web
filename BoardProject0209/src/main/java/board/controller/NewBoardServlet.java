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
import member.vo.Member;

/**
 * Servlet implementation class NewBoardServlet
 */
@WebServlet("/newBoard")
public class NewBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewBoardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String memberId = request.getParameter("memberId");

		Member member = new Member();
		member.setMemberId(memberId);

		CreateBoardService service = new CreateBoardService();
		Member result = service.searchBoard(member);

		if (result != null) {

			HttpSession session = request.getSession(true);
			session.setAttribute("board", result);

			RequestDispatcher dispatcher = request.getRequestDispatcher("NewBoard.jsp");
			request.setAttribute("newboard", result);
			
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("loadingfail.html");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
