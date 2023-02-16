package datail.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.vo.BoardName;
import datail.service.DeleteService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		
		BoardName boardname= new BoardName();
		boardname.setBoardNum(Integer.parseInt(num));
		
		DeleteService service= new DeleteService();
		List<BoardName> list = service.deleteBoard(boardname);
		
		if (list != null) {

			HttpSession session = request.getSession(true);
			session.setAttribute("listboard", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			request.setAttribute("boardList", list);

			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("loadingfail.html");
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
