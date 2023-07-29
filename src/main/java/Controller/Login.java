package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.Task;
import dto.User;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserDao dao = new UserDao(); // object for userdao class to get the fetch by email method
		User user = dao.fetchBytEmail(email);

		if (user == null) { // checking if its null or not

			res.getWriter().print("<h1> style='color'red'>Invalid Email</h1>");
			// logic to tell it to go to login page
			req.getRequestDispatcher("login.html").include(req, res);

		} else {
			if (user.getPassword().equals(password)) {
				res.getWriter().print("<h1> style='color:green'Login sucessfull</h1>");
				
				// fetch the database
				List<Task> list = dao.fetchAllTasks();
				// set the data in reuqest
				
				req.setAttribute("list", list);
				
				
				req.getRequestDispatcher("home.jsp").include(req, res);
				

			}

			else {
				res.getWriter().print("<h1> style='color:red'</h1>Invalid Password");
				req.getRequestDispatcher("login.html").include(req, res);
			}

		}

	}
}