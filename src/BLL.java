import java.sql.SQLException;

/*
 * 业务逻辑层
 */
public class BLL {
    public boolean verifyPassword(String username, String inputPassword) throws SQLException {
        DAL Look = new DAL();

        String dbPassword = Look.getUserByUsername(username);
        // 检查是否找到了用户以及密码是否匹配
        if (dbPassword != null && dbPassword.equals(inputPassword)) {
            return true; // 密码匹配
        }
        return false; // 密码不匹配或用户不存在
    }

    public static void main(String[] args) throws SQLException {
        BLL test = new BLL();
        String inputusername = "lxd";
        String inputpassword = "456";
        if (test.verifyPassword(inputusername, inputpassword)) {
            System.out.println("密码正确");
        } else {
            System.out.println("用户名或密码错误");
        }
    }
}
