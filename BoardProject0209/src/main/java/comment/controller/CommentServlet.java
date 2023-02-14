package comment. controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.service.CommentService;
import comment.vo.Comment;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cContent = request.getParameter("cContent");
		String mId = request.getParameter("mId");
		String bNum = request.getParameter("bNum");
		
		Comment comment = new Comment();
		comment.setCommentId(mId);
		comment.setCommentContent(cContent);
		comment.setBoardNum(Integer.parseInt(bNum));
		
		
		CommentService service1 = new CommentService();
		List<Comment> list = service1.reflash(comment);
		
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
