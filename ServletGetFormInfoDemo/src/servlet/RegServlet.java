package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Users;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet(
		urlPatterns = { "/servlet/RegServlet" }, 
		initParams = { 
				@WebInitParam(name = "RegServlet", value = "")
		})
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		Users u = new Users();
		String username,mypassword,gender,email,introduce,isAccept;
		Date birthday;
		String[] favorites;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		
		try {
			username = request.getParameter("username");
			mypassword = request.getParameter("mypassword");
			gender = request.getParameter("gender");
			email = request.getParameter("email");
			introduce = request.getParameter("introduce");
			if (request.getParameter("birthday")!=null) {
				//birthday = sdf.parse(request.getParameter("birthday"));
				//页面获取日期控件不可用..
				birthday = new Date();
			}else {
				birthday = new Date();
			}
			
			if (request.getParameter("isAccept")!=null) {
				isAccept = request.getParameter("isAccept");
			}else {
				isAccept = "false";
			}
			
			//用来获取多个复选的按钮的值
			favorites = request.getParameterValues("favorite");
			
			u.setUsername(username);
			u.setMypassword(mypassword);
			u.setGender(gender);
			u.setEmail(email);
			u.setFavorites(favorites);
			if (isAccept.equals("true")) {
				u.setFlag(true);
			}else {
				u.setFlag(false);
			}
			u.setBirthday(birthday);
			
			//把注册成功的用户对象保存到Session当中
			request.getSession().setAttribute("regUser", u);
			
			//跳转到注册成功页面
			request.getRequestDispatcher("../userinfo.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
