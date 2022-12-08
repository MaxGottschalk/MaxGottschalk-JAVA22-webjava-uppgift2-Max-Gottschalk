package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("view/profile.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		
		String user1 = "Max";
		String password1 = "hej";
		
		String user2 = "Sebbe";
		String password2 = "tack";
		
		if(username.equals(user2) && password.equals(password2) || username.equals(user1) && password.equals(password1)) {
			
			User bean = new User();
			bean.setUsername(username);
			bean.setPassword(password);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("isLoggedIn", bean);
			RequestDispatcher rd = request.getRequestDispatcher("view/profile.jsp");
			rd.forward(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("<html></body>");
			out.print("<p>Wrong username or password</p>");
			out.print("<p>Try again</p>");
			out.print("</body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
	}

}
