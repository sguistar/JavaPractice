import java.sql.*;
import java.util.Scanner;

public class Example
{
    public static void main(String[] args)
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Scanner input = new Scanner(System.in);
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e)
        {
            System.err.println("JDBC Driver 加载失败");
            return;
        }
        //String uri = "jdbc:mysql://localhost:3306/Book?useSSL=false&serverTimezone=GMT";
        //String uri = "jdbc:mysql://120.26.88.83:3306/Book?useSSL=false&serverTimezone=GMT";
        String uri = "jdbc:mysql://rm-bp13z1291yal195860o.mysql.rds.aliyuncs.com:3306/book?useSSL=false&serverTimezone=GMT";
        String user = "root";
        String password = "Giti#73920";
        try
        {
            con = DriverManager.getConnection(uri, user, password);
        }
        catch (SQLException e)
        {
            System.err.println("数据库连接失败：" + e.getMessage());
        }
        System.out.println("请输入你要查询的单词:");
        String word = input.next().trim();
        try
        {
            String sql = "SELECT cname FROM dic WHERE ename = ?";
            assert con != null;
            ps = con.prepareStatement(sql);
            ps.setString(1, word);
            System.out.println("即将执行的 SQL: " + ps);
            rs = ps.executeQuery();
            if (rs.next())
            {
                //查到
                String meaning = rs.getString("cname");
                System.out.printf("“%s”的中文释义是：%s%n", word, meaning);
                //System.out.println("该单词的中文释义是:" + meaning);
            }
            else
            {
                //没查到
                System.err.printf("Error: 未在字典中查到单词“%s”的中文释义%n", word);
            }

        }
        catch (Exception e)
        {
            System.err.println("查询时发生错误:" + e.getMessage());
        }
        //释放资源
        finally
        {
            try
            {
                if (rs != null) rs.close();
            }
            catch (SQLException ignored)
            {
            }
            try
            {
                if (ps != null) ps.close();
            }
            catch (SQLException ignored)
            {
            }
            try
            {
                if (con != null)
                {
                    con.close();
                }
            }
            catch (SQLException ignored)
            {
            }
            input.close();
        }
    }
}
