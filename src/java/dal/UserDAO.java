package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class UserDAO {

    public User getUser(String username) throws Exception {
        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User n = null;
        String sql = "SELECT [id]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[email]\n"
                + "      ,[type]\n"
                + "  FROM [EasyCMS].[dbo].[Users]\n"
                + "  where [username] = ?";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                n = new User(rs.getString("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getBoolean("type"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, con);
        }
        return n;
    }

    public void insertUser(User user) throws Exception {
        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [dbo].[Users]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[email]\n"
                + "           ,[type])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setBoolean(4, user.isType());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, con);
        }
    }

    public static void main(String[] args) {
        int score = (2 * 100 / 3);
        float raw = (float) score / 10;
        float percent = (float) score;
        
        String strPercent = percent + "";
        String s = raw + "";
        if (s.endsWith(".0")) {
            s = s.substring(0, s.length() - 2);
        }
        if (strPercent.endsWith(".0")) {
            strPercent = strPercent.substring(0, strPercent.length() - 2);
        }
        System.out.println(raw);
    }
}
