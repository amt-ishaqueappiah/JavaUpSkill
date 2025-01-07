import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {

    public static void main(String[] args) {
        try {
            String query1 =  "SELECT * FROM MyJavaTable";

            String url ="jdbc:postgresql://localhost:5432/bird_encyclopedia";
            String username="postgres";
            String password ="admin";
            Connection connect = DriverManager.getConnection(url,username,password);
            Statement statement = connect.createStatement();

            ResultSet rs =statement.executeQuery(query1);
            System.out.println("Result of executing query1");
            System.out.println("ID " + "\t" + "FirstName" +  "\t" +  "LastName" + "\t" + "Age");

//looping through the number of row/rows retrieved after executing query2
            while(rs.next())
            {
                System.out.print(rs.getString("ID") + "\t");
                System.out.print(rs.getString("FirstName") + "\t" + "\t");
                System.out.print(rs.getString("LastName")+ "\t" +  "\t");
                System.out.println(rs.getString("Age") + "\t");
            }
            connect.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
