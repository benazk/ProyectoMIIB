import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionBBDD {
   public static void main(String[] args) throws Exception {

	   Class.forName("com.mysql.cj.jdbc.Driver");
       final String url = "jdbc:mysql://dbrds.c1cqmqwa0ite.us-east-1.rds.amazonaws.com:3306/BBDDProyectoGym1";
       final String user = "admin";
       final String password = "ASdiioqw--ad45";
       Connection con = DriverManager.getConnection(url, user, password);

       if (con == null) {
           System.out.println("No se ha establecido la conexión");
           return;
       } else {
           System.out.println("¡Felicidades! Se ha establecido la conexión");
       }
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from Comensales");
      while (resultSet.next()) {
          System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)+ " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getString(5) + " " + resultSet.getString(6) + " " + resultSet.getInt(7) + " " + resultSet.getInt(8));
          
      }
      con.close();
      
   } 
}