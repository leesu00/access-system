import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {
	String stu_num;
	String name;
	String state;
	String time;

	public void Select() {
		
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
			
			while(result.next()) {
				stu_num = result.getString(1);
				name = result.getString(2);
				state = result.getString(3);
				time = result.getString(4);
			}
			result.close();
			stmt.close();
			conn.close();
		}
		catch (Exception e) {
			System.out.println("DB ���� ����");    
		}
	}
}