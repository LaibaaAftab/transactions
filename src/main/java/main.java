import java.util.UUID;
import java.sql.*;
public class main {
    public static void main(String[] args)
    {
        Connection con = null;
        PreparedStatement stm = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/assignment","root","root");
            con.setAutoCommit(false);
            String query = "INSERT INTO reservations(id,check_in_date,check_out_date,status) values(?,?,?,?)";
            String query1 = "INSERT INTO guests(id,reservation_id,first_name,last_name) values(?,?,?,?)";
            stm = con.prepareStatement(query);
            String idd=UUID.randomUUID().toString();
            stm.setString(1,idd);
            stm.setString(2,"2022-10-11");
            stm.setString(3,"2022-10-21");
            stm.setString(4,"Checkedin");

            stm.execute();

            stm = con.prepareStatement(query1);
            stm.setString(1,idd);
            stm.setString(2,"14");
            stm.setString(3,"Laiba");
            stm.setString(4,"Aftab");

            stm.execute();

            stm.setString(1,idd);
            stm.setString(2,"15");
            stm.setString(3,"Batool");
            stm.setString(4,"Fatima");

            stm.execute();

            con.commit();


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
