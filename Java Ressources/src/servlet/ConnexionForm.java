package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import obj.User;

/**
 * Servlet implementation class ConnexionForm
 */
@WebServlet("/ConnexionForm")
public class ConnexionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("password");
		
		String url = "jdbc:postgresql://127.0.0.1:5432/camelitoLocal";
		String user = "postgres";
		String psw = "123";
		String page = "./view/index.jsp";

        HttpSession session=request.getSession();
        
        try (Connection con = DriverManager.getConnection(url, user, psw))
        {
        	PreparedStatement pst = con.prepareStatement("SELECT * FROM public.users WHERE user_name LIKE '"+userName+"' AND password LIKE '"+pwd+"'");
        	ResultSet rs = pst.executeQuery();
			
			if(rs==null) {
				/*
				 * Error of connection
				 */
				
			}else {
				List<User> result = new ArrayList<>();
				User connectedUser;
	            while (rs.next()) {            	
	            	int id = rs.getInt("id");
	            	String user_name = rs.getString("user_name");
	            	String mail = rs.getString("mail");
	            	int type  = rs.getInt("type");
	            	String password = rs.getString("password");
	            	boolean status = rs.getBoolean("status");
	            	
	            	User obj = new User();
	                obj.setId(id);
	                obj.setMail(mail);
	                obj.setPassword(password);
	                obj.setStatus(status);
	                obj.setType(type);
	                obj.setUser_name(user_name);

	                result.add(obj);
	                page = "./view/profil.jsp";

	            }
	            connectedUser=result.get(0);
	            session.setAttribute("user",connectedUser);  
	            session.setAttribute("user_id",connectedUser.getId());  
	            session.setAttribute("mail",connectedUser.getMail());
	            session.setAttribute("userName",connectedUser.getUser_name());
	            //TODO get user details
			  	
			}
			
            
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

		//if request is not from HttpServletRequest, you should do a typecast before
		  //save message in session
		response.sendRedirect(page);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
