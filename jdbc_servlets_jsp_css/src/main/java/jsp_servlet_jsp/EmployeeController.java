package jsp_servlet_jsp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class EmployeeController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setPhone(phone);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(password);
		
		EmployeeCRUD employeeCRUD = new EmployeeCRUD();
		try {
			int count=employeeCRUD.saveEmployee(employee);
			if(count!=0) {
				System.out.println("login to signup sucessfully");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Signup.jsp");
				requestDispatcher.forward(req, resp);
			}
			else {
				System.out.println("fail to signup");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Signup.jsp");
				requestDispatcher.forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
