package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.Task;


@WebServlet("/addtask")
public class AddingTask extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String description = req.getParameter("description");
		int days = Integer.parseInt(req.getParameter("days"));

		Task t1 = new Task();
		t1.setName(name);
		t1.setDescription(description);
		t1.setTaskdate(LocalDate.now());
		t1.setCompletionDate(LocalDate.now().plusDays(days));

		UserDao dao = new UserDao();
		dao.save(t1);

		resp.getWriter().print("<h1> style='color:green'>Added Sucessfully</h1>");
	
		List<Task> list = dao.fetchAllTasks();
		// set the data in reuqest
		
		req.setAttribute("list", list);
	
		req.getRequestDispatcher("home.jsp").include(req, resp);
		
		
		

	}

}
