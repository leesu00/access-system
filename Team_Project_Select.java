import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

final class Information
{
	public String stu_num;
	public String name;
	public String state;
	public String time;
	 
    public Information(String stu_num, String name, String state, String time)
	{
	    this.stu_num = stu_num;
	    this.name = name;
	    this.state = state;
	    this.time = time;
	}
}

public class Team_Project_Select {
	static String stu_num ="";
	static String name ="";
	static String state ="";
    static String time ="";

	public static Information selectInfo() {
		stu_num ="";
		name ="";
		state ="";
		time ="";
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
			
		String url = "jdbc:mysql://localhost:3306/dbstu_info?";
			
		Connection conn;
					
		String id = "root";
		String pw = "1234";
			
		Statement stmt = null;
			
		ResultSet result = null;
			
		try {
			Class.forName(jdbcDriver);  
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement();//3�ܰ� Statement ����
			result = stmt.executeQuery("SELECT stu_num,name,state,time FROM record;");//4�ܰ� SQL�� ���� & 5�ܰ� ����ޱ�
			//result = stmt.executeQuery("select NAME, Dept, ID from student where name = "�ں���"");
			selectData(result, "stu_num", " name", "state", "time");
			
			conn.close();
			stmt.close();
			result.close();
		} 
		catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		} 
		catch (SQLException e) {
			System.out.println("DB ���� ����");    
		}
		return new Information(stu_num, name, state, time);
	}
	private static void selectData(ResultSet rs, String c1, String c2, String c3, String c4) throws SQLException {
		while (rs.next()) {
			if(!c1.equals("")) {
				stu_num += "\n" + rs.getString("stu_num");
				name += "\n" + rs.getString("name");
				state += "\n" + rs.getString("state");
				time += "\n" + rs.getString("time");
			}
		}
	}
}
