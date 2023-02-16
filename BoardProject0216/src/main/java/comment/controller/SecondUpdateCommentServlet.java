package comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.service.UpdateCommentService;
import comment.vo.Comment;

/**
 * Servlet implementation class SecondUpdateCommentServlet
 */
@WebServlet("/updateCom")
public class SecondUpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SecondUpdateCommentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cContent = request.getParameter("cContent");
		String cNum = request.getParameter("cNum");
		String bNum = request.getParameter("bNum"); 

		Comment comment = new Comment();
		comment.setCommentNum(Integer.parseInt(cNum));
		comment.setCommentContent(cContent);
		comment.setBoardNum(Integer.parseInt(bNum));
		
		UpdateCommentService service = new UpdateCommentService();
		List<Comment> list = service.updateComment(comment);

		if (list != null) {

			HttpSession session = request.getSession(true);
			session.setAttribute("comment", list);

			RequestDispatcher dispatcher = request.getRequestDispatcher("DetailText.jsp");
			request.setAttribute("comments", list);

			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("loadingfail.html");
		}

	}

}
