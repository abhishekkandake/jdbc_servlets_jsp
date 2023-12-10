package jsp_servlet_jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

public class EmployeeCRUD {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","root");
		return connection;
	}
	public int saveEmployee(Employee employee) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3, employee.getPhone());
		preparedStatement.setString(4, employee.getAddress());
		preparedStatement.setString(5, employee.getEmail());
		preparedStatement.setString(6, employee.getPassword());
		
		int count=preparedStatement.executeUpdate();
		if(count!=0) {
			System.out.println("deta is sucessfully inserted");
			
		}
		else {
			System.out.println("deta is not insert");
		}
		return count;
	}
	public String loginEmployee(Employee employee) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where email = ?");
		preparedStatement.setString(1, employee.getEmail());
		ResultSet resultSet=preparedStatement.executeQuery();
		String password = " ";
		while(resultSet.next()) {
			password = resultSet.getString("password");
			
		}
		connection.close();
		return password;
	}
	public List<Employee> displayAll() throws ClassNotFoundException, SQLException{
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");
		ResultSet resultSet=preparedStatement.executeQuery();
		ArrayList<Employee> employees = new ArrayList();
		while(resultSet.next()) {
			Employee employee = new Employee();
			employee.setId(resultSet.getInt(1));
			employee.setName(resultSet.getString(2));
			employee.setPhone(resultSet.getLong(3));
			employee.setAddress(resultSet.getString(4));
			employee.setEmail(resultSet.getString(5));
			employee.setPassword(resultSet.getString(6));
			
			employees.add(employee);
		}
		connection.close();
		return employees;
	}
	public int deleteEmployee(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where id =?");
		preparedStatement.setInt(1, id);
		int count=preparedStatement.executeUpdate();
		if(count!=0) {
			System.out.println("deta is deleted");
		}
		else {
			System.out.println("deta is not deleted");
		}
		return count;
	}
	public int updateController(Employee employee,int  id) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update employee set name = ?,phone = ?,address=?,email=?,password=? where id =?");
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setLong(2, employee.getPhone());
		preparedStatement.setString(3, employee.getAddress());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.setString(5, employee.getPassword());
		preparedStatement.setInt(6, id);
		
		int result=preparedStatement.executeUpdate();
		if(result!=0) {
			System.out.println("sucessfully updated");
		}
		else
		{
			System.out.println("fail to update");
		}
		return result;
	}
}
