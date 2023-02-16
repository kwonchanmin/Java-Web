package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import board.service.LikeService;
import board.vo.LikeBoard;

/**
 * Servlet implementation class LikeBoardServlet
 */
@WebServlet("/likeboard")
public class LikeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mId = request.getParameter("mId");
		String bNum = request.getParameter("bNum");
		
		LikeBoard likeboard = new LikeBoard();
		likeboard.setMemberId(mId);
		likeboard.setBoardNum(Integer.parseInt(bNum));
		
		
		LikeService service = new LikeService();
		LikeBoard result = service.selectAll(likeboard);
		
		LikeBoard count = null;
		
		
		if( result == null ) {
			LikeService service2 = new LikeService();
			count = service2.insertLike(likeboard);
			System.out.println("New: " + count);
		}else {
			
			LikeService service3 = new LikeService();
			count  = service3.deleteLike(likeboard);
			System.out.println("Del: " + count);	
		}
		
		// 넘겨줄 것에 대한 데이터 타입을 명시한다.
		response.setContentType("application/json; charset=UTF-8");

		// Gson을 사용하기 위한 것이고 , 
		//toJson으로 내가 만든 객체나 배열 문자열(int의 데이터 타입은 안보내지는것은 아니나 가능하면 key와 value의형태로 변환해서 주는 것이 좋다)
		// 을 ()안의 인자로 넣어준다. 
		String gson = new Gson().toJson(count);
		
		// 프린트기 같은 역활
		// 내가 만든 데이터를 detailtaxt.jsp의 ajax로 보내주는 역
		response.getWriter().write(gson);
		
		
	}

}
