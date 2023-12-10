package jsp_servlet_jsp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Employee employee = new Employee();
		employee.setEmail(email);
		employee.setPassword(password);
		
		EmployeeCRUD employeeCRUD = new EmployeeCRUD();
		try {
			String password1=employeeCRUD.loginEmployee(employee);
			if(password1.equals(password)) {
				List<Employee> employees = employeeCRUD.displayAll();
				req.setAttribute("list", employees);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("successFile.jsp");
				requestDispatcher.forward(req, resp);
			}
			else {
				
				System.out.println("login fail");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
