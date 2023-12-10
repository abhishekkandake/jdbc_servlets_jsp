package jsp_servlet_jsp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter name");
		String name = scanner.next();
		System.out.println("enter phone");
		long phone = scanner.nextLong();
		System.out.println("enter address");
		String address = scanner.next();
		System.out.println("enter email");
		String email = scanner.next();
		System.out.println("enter password ");
		String password = scanner.next();
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setPhone(phone);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setId(id);
		
		EmployeeCRUD employeeCRUD = new EmployeeCRUD();
		try {
			int result=employeeCRUD.updateController(employee, id);
			if(result!=0) {
				List<Employee> employees = employeeCRUD.displayAll();
				req.setAttribute("list", employees);
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("successFile.jsp");
				requestDispatcher.forward(req, resp);
			}
			else {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
