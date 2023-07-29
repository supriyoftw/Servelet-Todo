package Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/signup")
public class Sign extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobileno"));
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		String address = req.getParameter("address");

		UserDao dao = new UserDao();
		User user = dao.fetchBytEmail(email); // fetching the emails in object

		if (user == null) // checking is its null or not
		{

			user = new User(); 
			user.setName(name);
			user.setEmail(email);
			user.setMobile(mobile);
			user.setPassword(password);
			user.setGender(gender);
			user.setDob(dob);
			user.setAddress(address);

			dao.save(user);
			res.getWriter()
					.print("<h1 style ='color:green'>++++++++Account Has Been Create Sucessfully ++++++++++</h1>");// inserting
			req.getRequestDispatcher("login.html").include(req, res);
		} else {
			res.getWriter().print("<h1 style ='color:red'>++++++++Email Already Exists ++++++++++</h1>"); // checking is email already exist
																											  
			req.getRequestDispatcher("singup.html").include(req, res);

		}

	}

}
