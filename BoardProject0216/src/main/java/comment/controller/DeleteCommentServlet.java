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

import comment.service.DeleteCommentService;
import comment.vo.Comment;

/**
 * Servlet implementation class DeleteCommentServlet
 */
@WebServlet("/deleteCm")
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cNum = request.getParameter("cNum");
		String bNum = request.getParameter("bNum");
		System.out.println("dfda"+bNum);
		
		Comment comment = new Comment();
		comment.setCommentNum(Integer.parseInt(cNum));
		comment.setBoardNum(Integer.parseInt(bNum));
		
		DeleteCommentService service = new DeleteCommentService();
		List<Comment> list = service.deleteComment(comment);
		System.out.println("aaaa"+list.size());
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
