import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Team_Project_Select_2 {
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
			if(rs.getString("state").equals("0")) {
				stu_num += rs.getString("stu_num");
				name += rs.getString("name");
				state += rs.getString("state");
				time += rs.getString("time");
			}
		}
	}
}
