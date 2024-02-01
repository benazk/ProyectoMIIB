import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionBBDD {
   public static void main(String[] args) throws Exception {

      // Conectar el Driver JDBC
      Class.forName("com.mysql.cj.jdbc.Driver");

      // variables, cambiar según corresponda
      final String url = "jdbc:mysql://localhost:3306/demo";
      final String user = "root";
      final String password = "";

      // establecer la conexión
      Connection con = DriverManager.getConnection(url, user, password);

      // mostrar mensaje de conexión exitosa o fallo
      if (con == null) {
         System.out.println("No se ha establecido la conexión");
         return;
      } else {
         System.out.println("¡Felicidades! Se ha establecido la conexión");
      }
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from prueba");
      while (resultSet.next()) {
          System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
          
      }
      // Cerrar la conexión JDBC
      con.close();
      
   } 
}