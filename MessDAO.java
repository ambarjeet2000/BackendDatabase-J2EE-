package daodta;

import java.sql.*;
import java.util.ArrayList;

public class MessDAO {
    static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9", "root", "sql123");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int addDetails(Mess m)  {
        PreparedStatement pstmt = null;
        int count=0;

        String query = "insert into mess_info (name, number, shift) values (?,?,?)";

        try {
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,m.getName());
            pstmt.setInt(2,m.getNumber());
            pstmt.setString(3,m.getShift());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }

    public int deleteDetails(Mess m) {
        PreparedStatement pstmt = null;
        int count=0;
        String query = "delete from mess_info where id=?";

        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,m.getId());
            count=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }
    public ArrayList<Mess> showList(){
        Statement stmt = null;
        ResultSet rs = null;

        ArrayList<Mess> messArrayList = new ArrayList<>();

        String query = "select * from mess_info";

        try {
            stmt=con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()){
                int id =rs.getInt(1);
                String name = rs.getString(2);
                int number = rs.getInt(3);
                String shift = rs.getString(4);

                Mess m = new Mess();
                m.setId(id);
                m.setName(name);
                m.setNumber(number);
                m.setShift(shift);

                messArrayList.add(m);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return messArrayList;
    }
}
