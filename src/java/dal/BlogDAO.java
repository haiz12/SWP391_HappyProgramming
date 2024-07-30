/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Blog;
import model.Mentor;
import model.Skill;

/**
 *
 * @author ADMIN
 */
public class BlogDAO {

    PreparedStatement stm;
    ResultSet rs;
    List<Blog> BlogList = new ArrayList<Blog>();
    List<Skill> ListSkills = new ArrayList<Skill>();
    MentorDAO menterDAO = new MentorDAO();

    public List<Blog> getAllBlog() {
        Connection conn = null;
        String query = "select * from blog ORDER BY updatedate DESC";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idBlog = rs.getInt(1);
                int idMentor = rs.getInt(2);
                Mentor m = menterDAO.getIDMentor(idMentor);
                String fullname = m.getFullname();
                String udate = rs.getString(3);
                String thumbnail = rs.getString(4);
                String title = rs.getString(5);
                String brief = rs.getString(6);
                String detail = rs.getString(7);

                Blog b = new Blog(idBlog, idMentor, fullname, udate, thumbnail, title, brief, detail);
                BlogList.add(b);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return BlogList;
    }

    // getBlog cho Admin
    public List<Blog> getBlog() {
        List<Blog> BlogList4 = new ArrayList<Blog>();
        Connection conn = null;
        String query = "select * from blog ";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idBlog = rs.getInt(1);
                int idMentor = rs.getInt(2);
                Mentor m = menterDAO.getIDMentor(idMentor);
                String fullname = m.getFullname();
                String udate = rs.getString(3);
                String thumbnail = rs.getString(4);
                String title = rs.getString(5);
                String brief = rs.getString(6);
                String detail = rs.getString(7);
                int isAgree = rs.getInt(8);

                Blog b = new Blog(idBlog, idMentor, fullname, udate, thumbnail, title, brief, detail, isAgree);
                BlogList4.add(b);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return BlogList4;
    }

    public List<Blog> getBlogByIdMentor(int idAccount) {
        List<Blog> BlogList5 = new ArrayList<Blog>();
        Mentor m = menterDAO.getIDMentor(idAccount);
        String fullname = m.getFullname();
        Connection conn = null;
        String query = "select idblog, b.idMentor, updatedate, thumbnail, title, briefinfo, detailinfo, isAgree \n"
                + "from blog b join account a on b.idMentor = a.idAccount \n"
                + "where a.idAccount = ? ";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            stm.setInt(1, idAccount);
            rs = stm.executeQuery();

            while (rs.next()) {
                int idblog = rs.getInt(1);

                String updatedate = rs.getString(3);
                String thumbnail = rs.getString(4);
                String title = rs.getString(5);
                String briefinfo = rs.getString(6);
                String detailinfo = rs.getString(7);
                int isAgree = rs.getInt(8);

                Blog b = new Blog(idblog, idAccount, fullname, updatedate, thumbnail, title, briefinfo, detailinfo, isAgree);
                BlogList5.add(b);

            }
        } catch (Exception e) {
        }

        return BlogList5;
    }

    public List<Blog> searchByTitle(String title) {
        List<Blog> BlogList1 = new ArrayList<Blog>();
        Connection conn = null;
        String query = "SELECT * FROM blog where title like ?";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            stm.setString(1, "%" + title + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                int idBlog = rs.getInt(1);
                int idMentor = rs.getInt(2);
                Mentor m = menterDAO.getIDMentor(idMentor);
                String fullname = m.getFullname();
                String udate = rs.getString(3);
                String thumbnail = rs.getString(4);
                String title1 = rs.getString(5);
                String brief = rs.getString(6);
                String detail = rs.getString(7);
                Blog b = new Blog(idBlog, idMentor, fullname, udate, thumbnail, title1, brief, detail);
                BlogList1.add(b);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return BlogList1;
    }

    public int count(String title) {
        Connection conn = null;
        String query = "select count(*) from blog where title like ?";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            stm.setString(1, "%" + title + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;

    }

    public int count() {
        Connection conn = null;
        String query = "select count(*) from blog";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);

            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;

    }

    public List<Blog> pagingList(int index, int isAgree) {
        List<Blog> BlogList2 = new ArrayList<Blog>();
        Connection conn = null;
        String query = "SELECT * FROM blog where isAgree = ?\n"
                + "ORDER BY updatedate DESC\n"
                + "OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY;";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            stm.setInt(1, isAgree);
            stm.setInt(2, (index - 1) * 3);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idBlog = rs.getInt(1);
                int idMentor = rs.getInt(2);
                Mentor m = menterDAO.getIDMentor(idMentor);
                String fullname = m.getFullname();
                String udate = rs.getString(3);
                String thumbnail = rs.getString(4);
                String title = rs.getString(5);
                String brief = rs.getString(6);
                String detail = rs.getString(7);
                int ac = isAgree;

//                Blog b = new Blog(idBlog, idMentor, fullname, udate, thumbnail, title, brief, detail);
                Blog b = new Blog(idBlog, idMentor, fullname, udate, thumbnail, title, brief, detail, isAgree);
                BlogList2.add(b);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return BlogList2;
    }

    public List<Blog> getBlogById(int id) {
        List<Blog> BlogList3 = new ArrayList<Blog>();
        Connection conn = null;
        String query = "SELECT * FROM blog where idblog = ?";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idBlog = rs.getInt(1);
                int idMentor = rs.getInt(2);
                Mentor m = menterDAO.getIDMentor(idMentor);
                String fullname = m.getFullname();
                String udate = rs.getString(3);
                String thumbnail = rs.getString(4);
                String title = rs.getString(5);
                String brief = rs.getString(6);
                String detail = rs.getString(7);

                Blog b = new Blog(idBlog, idMentor, fullname, udate, thumbnail, title, brief, detail);
                BlogList3.add(b);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return BlogList3;
    }

    public Blog getBlogByid(int id) {
        Connection conn = null;
        try {
            conn = new DBContext().connection;
            String query = "SELECT * FROM blog where idblog = ?";
            stm = conn.prepareStatement(query);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idblog = rs.getInt(1);
                int idMentor = rs.getInt(2);
                Mentor m = menterDAO.getIDMentor(idMentor);
                String fullname = m.getFullname();
                String udate = rs.getString(3);
                String thumbnail = rs.getString(4);
                String title = rs.getString(5);
                String brief = rs.getString(6);
                String detail = rs.getString(7);
                int isAgree = rs.getInt(8);

                Blog b = new Blog(idblog, idMentor, fullname, udate, thumbnail, title, brief, detail, isAgree);
                return b;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean insertBlog(int idMentor, String updatedate, String thumbnail, String title, String briefinfo, String detailinfo, int isAgree) {
        Connection conn = null;
        String query = "INSERT INTO blog (idMentor, updatedate, thumbnail, title, briefinfo, detailinfo, isAgree) VALUES(?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);

            stm.setInt(1, idMentor);
            stm.setString(2, updatedate);
            stm.setString(3, thumbnail);
            stm.setString(4, title);
            stm.setString(5, briefinfo);
            stm.setString(6, detailinfo);
            stm.setInt(7, isAgree);
            int rowsAffected = stm.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateBlog(String updatedate, String thumbnail, String title, String briefinfo, String detailinfo, int isAgree, int idblog) {
        Connection conn = null;
        String query = "UPDATE [dbo].[blog]\n"
                + "   SET \n"
                + "       [updatedate] = ?\n"
                + "      ,[thumbnail] = ?\n"
                + "      ,[title] = ?\n"
                + "      ,[briefinfo] = ?\n"
                + "      ,[detailinfo] = ?\n"
                + "      ,[isAgree] = ?\n"
                + "      \n"
                + " WHERE idblog = ?";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            stm.setString(1, updatedate);
            stm.setString(2, thumbnail);
            stm.setString(3, title);
            stm.setString(4, briefinfo);
            stm.setString(5, detailinfo);
            stm.setInt(6, isAgree);
            stm.setInt(7, idblog);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean deleteBlog(int id) {
        Connection conn = null;
        try {
            conn = new DBContext().connection;
            String strDELETE = "DELETE FROM blog where idblog = ?";
            stm = conn.prepareStatement(strDELETE);
            stm.setInt(1, id);

            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace(); // In ra thông tin lỗi nếu có
            return false;
        }

    }

    public boolean updateIsAgree(int isAgree, int idblog) {
        Connection conn = null;
        String query = "UPDATE [dbo].[blog]\n"
                + "   SET       \n"
                + "      [isAgree] = ?\n"
                + " WHERE idblog = ?";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            stm.setInt(1, isAgree);
            stm.setInt(2, idblog);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BlogDAO bd = new BlogDAO();
//        int count = bd.count("ipsum");
//        System.out.println(count);
//        List<Blog> BlogList = bd.getAllBlog();
//        for (Blog b : BlogList) {
//            System.out.println(b);
//            
//        }
//        System.out.println(bd.searchByTitle("tắc"));
//        System.out.println(bd.count());

        System.out.println(bd.pagingList(3, 1));
    }
}
