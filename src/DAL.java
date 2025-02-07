import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * 数据访问层
 */
public class DAL {
    Connection conn = null;

    public DAL() throws SQLException {
        // Connection conn = Connect.getConnection();
        this.conn = Connect.getConnection();
        // System.out.println(conn);
    }

    // 根据用户名获取用户信息 (具体为根据用户名在数据库中找到密码)
    public String getUserByUsername(String Username) throws SQLException {
        String username = null;
        String password = null;

        String sql = "select username,userpass from users where username = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, Username);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) { // 检查是否有结果
            username = rs.getString("username");
            password = rs.getString("userpass");
            System.out.println("username:" + username);
            System.out.println("passwd:" + password);
        }
        return password;
    }
    // public static void main(String[] args) throws SQLException {
    // String user = "lxd";
    // DAL str = new DAL();
    // str.getUserByUsername(user);
    // }
}
