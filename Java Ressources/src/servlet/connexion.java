package servlet;

import java.io.IOException;
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

import obj.User;

/**
 * Servlet implementation class connexion
 */
@WebServlet(name = "connexion", urlPatterns = { "/connexion" })
public class connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = "jdbc:postgresql://127.0.0.1:5432/camelitoLocal";
		String user = "postgres";
		String psw = "123";
		try (Connection con = DriverManager.getConnection(url, user, psw);
                PreparedStatement pst = con.prepareStatement("SELECT * FROM public.\"User\"");
                ResultSet rs = pst.executeQuery()) {

			List<User> result = new ArrayList<>();
		
            while (rs.next()) {            	
            	int id = rs.getInt("id");
            	String user_name = rs.getString("user_name");
            	String mail = rs.getString("Mail");
            	int type  = rs.getInt("Type");
            	String password = rs.getString("Password");
            	boolean status = rs.getBoolean("Status");
            	
            	User obj = new User();
                obj.setId(id);
                obj.setMail(mail);
                obj.setPassword(password);
                obj.setStatus(status);
                obj.setType(type);
                obj.setUser_name(user_name);

                result.add(obj);

            }
            result.forEach(x -> System.out.println(x.toString()));

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
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
