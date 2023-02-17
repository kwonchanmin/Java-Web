package member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import member.service.LoginService;
import member.vo.Member;

/**
 * Servlet implementation class RegisterMemberServlet
 */
@WebServlet("/registermember")
public class RegisterMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterMemberServlet() {
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
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userid = request.getParameter("userid");
		
		Member member = new Member();
		member.setMemberId(userid);
		member.setMemberName(username);
		member.setMemberPw(password);
		
		LoginService service = new LoginService();
		Member result = service.selectUser(member);
		
		HashMap<String, String> map = new HashMap<String,String>();
		
		if(result == null) {
			LoginService service1 = new LoginService();
			Member register = service1.registeUser(member);

			map.put("msg", "성공");
			
			response.setContentType("application/json; charset=UTF-8");
			
			String gson = new Gson().toJson(map);
			
			response.getWriter().write(gson);
			
		} else {
			
			
			map.put("msg", "실패");
			
			response.setContentType("application/json; charset=UTF-8");
			
			String gson = new Gson().toJson(map);
			
			response.getWriter().write(gson);
			
		}
		
	}

}
