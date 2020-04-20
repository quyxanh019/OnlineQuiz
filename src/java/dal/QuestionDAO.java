package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Question;

public class QuestionDAO {

    public ArrayList<Question> getRandomQuestion(int count) throws Exception {
        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Question> question = new ArrayList<>();
        String sql = "SELECT top(?) [id]\n"
                + "      ,[content]\n"
                + "      ,[option1]\n"
                + "      ,[option2]\n"
                + "      ,[option3]\n"
                + "      ,[option4]\n"
                + "      ,[answer]\n"
                + "      ,[created]\n"
                + "  FROM [EasyCMS].[dbo].[Question]\n"
                + "  order by NEWID()";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question s = new Question(rs.getString("id"), rs.getString("content"), rs.getString("option1"), rs.getString("option2"),
                        rs.getString("option3"), rs.getString("option4"), rs.getString("answer"), rs.getDate("created"));
                question.add(s);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, con);
        }
        return question;
    }

    public void insertQuestion(Question question) throws Exception {
        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [dbo].[Question]\n"
                + "           ([content]\n"
                + "           ,[option1]\n"
                + "           ,[option2]\n"
                + "           ,[option3]\n"
                + "           ,[option4]\n"
                + "           ,[answer])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, question.getContent());
            ps.setString(2, question.getOption1());
            ps.setString(3, question.getOption2());
            ps.setString(4, question.getOption3());
            ps.setString(5, question.getOption4());
            ps.setString(6, question.getAnswer());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, con);
        }
    }

    public boolean deleteQuestion(int id) throws Exception {
        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DELETE FROM [dbo].[Question]\n"
                + "      WHERE [id] = ?";
        int result;
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            result = ps.executeUpdate();
            if (result == 0) {
                return false;
            }
            return true;
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, con);
        }

    }

    public int count() throws Exception {
        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM Question";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, con);
        }
        return 0;
    }

    public ArrayList<Question> paging(int pageIndex, int pageSize) throws Exception {
        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Question> questions = new ArrayList<>();
        int firstQuestion = (pageIndex - 1) * pageSize + 1;
        int lastQuestion = pageIndex * pageSize;
        String sql = "SELECT *\n"
                + "   FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY id DESC) as row_num \n"
                + "              FROM  Question) quiz\n"
                + "   where row_num >= ? and row_num <= ?";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, firstQuestion);
            ps.setInt(2, lastQuestion);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question s = new Question(rs.getString("id"), rs.getString("content"), rs.getString("option1"), rs.getString("option2"),
                        rs.getString("option3"), rs.getString("option4"), rs.getString("answer"), rs.getDate("created"));
                questions.add(s);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, con);
        }
        return questions;
    }

    public int countQuestionPaging(int pageIndex, int pageSize) throws Exception {
        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Question> questions = new ArrayList<>();
        int firstQuestion = (pageIndex - 1) * pageSize + 1;
        int lastQuestion = pageIndex * pageSize;
        String sql = "SELECT COUNT(*)\n"
                + "   FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY id DESC) as row_num \n"
                + "              FROM  Question) quiz\n"
                + "   where row_num >= ? and row_num <= ?";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, firstQuestion);
            ps.setInt(2, lastQuestion);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, con);
        }
        return 0;
    }

    public void insertHistory(String studentID, String score, String status) throws Exception {
        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [dbo].[QuizHistory]\n"
                + "           ([studenID]\n"
                + "           ,[score]\n"
                + "           ,[status])\n"
                + "     VALUES\n"
                + "           (?"
                + "           ,?"
                + "           ,?)";
        try {
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, studentID);
            ps.setString(2, score);
            ps.setString(3, status);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, con);
        }
    }


}
