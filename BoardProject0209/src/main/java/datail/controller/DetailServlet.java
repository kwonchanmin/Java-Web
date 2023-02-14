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
import comment.service.CommentService;
import comment.vo.Comment;
import datail.service.DetailService;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String num = request.getParameter("num");
		
		
		BoardName boardname = new BoardName();
		boardname.setBoardNum(Integer.parseInt(num));
		
		DetailService service = new DetailService();
		BoardName result = service.detail(boardname);
		
		Comment comment = new Comment();
		comment.setBoardNum(Integer.parseInt(num));
		
		CommentService serve = new CommentService();
		List<Comment> list = serve.searchComment(comment);
		
		if(result != null) {
			
			
			HttpSession session = request.getSession(true);
			session.setAttribute("title", result);
			session.setAttribute("comment", list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("DetailText.jsp");
			request.setAttribute("boardtitle", result);
			request.setAttribute("comments", list);
			
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("lodingfail.html");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
