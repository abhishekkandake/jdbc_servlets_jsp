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
@WebServlet("/delete")
public class EmployeeDelete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		EmployeeCRUD employeeCRUD = new EmployeeCRUD();
		try {
			int count=employeeCRUD.deleteEmployee(id);
			if(count!=0) {
				List<Employee> employees = employeeCRUD.displayAll();
				req.setAttribute("list", employees);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("successFile.jsp");
				requestDispatcher.forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
