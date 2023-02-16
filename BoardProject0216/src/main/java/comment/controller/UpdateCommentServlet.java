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

import comment.service.CommentService;
import comment.service.UpdateCommentService;
import comment.vo.Comment;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updateCm")
public class UpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cContent = request.getParameter("cContent");
		String mId = request.getParameter("mId");
		//String bNum = request.getParameter("bNum");
		String cNum = request.getParameter("cNum");
		//System.out.println(bNum);
		String bNum = request.getParameter("bNum");
		
		Comment comment = new Comment();
		comment.setCommentId(mId);
		comment.setCommentContent(cContent);
		//comment.setBoardNum(Integer.parseInt(bNum));
		comment.setCommentNum(Integer.parseInt(cNum));
		comment.setBoardNum(Integer.parseInt(bNum));
		
		
		CommentService service = new CommentService();
		Comment result = service.amendComment(comment);
		
		if (result != null) {

			HttpSession session = request.getSession(true);
			session.setAttribute("comment", result);

			RequestDispatcher dispatcher = request.getRequestDispatcher("updateComment.jsp");
			request.setAttribute("comments", result);

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
