
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	
	public static User login(String username, String password) {
		Connection conn = null;
		
		try {
			conn = JDBCTool.getConnection();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM user WHERE username='"+username+"' AND password='"+password+"'");
			
			System.out.println("SELECT * FROM user WHERE username='"+username+"' AND password='"+password+"'");
			if(rs.next()) {
				
				String un = rs.getString("username");
				String p = rs.getString("password");
				String email = rs.getString("email");
				User u = new User(un,p,email);
				return u;
	
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return null;
	}

}
