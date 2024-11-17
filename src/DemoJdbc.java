import java.sql.*;

public class DemoJdbc {
   public static final String[] names = new String[]{"Abhinav","Carlo","John","Rocky","Anapurna","Kali","JFK"};
    public static void main(String[] args)  {
        /*
        * import package
        * load and register
        * create connection
        * create statement execute statement
        * process the results
        * close
        * */

        try{

            Class.forName("org.postgresql.Driver");

            //should provide the network and the IP address

            String url = "jdbc:postgresql://localhost:5432/demo";
            String username = "postgres";
            String password = "12345";
            Connection connection = DriverManager.getConnection(url,username,password);

            System.out.println("Connection established");

            Statement st = connection.createStatement();




            String query = "SELECT * FROM STUDENT";
            ResultSet resultSet= st.executeQuery(query);
//            resultSet.next();
//            String name = resultSet.getString("sname");
//
//            System.out.println("Name of a student is "+ name);
            while(resultSet.next()){
                System.out.println("Student ID: "+resultSet.getInt("sid")+" Student Name: "
                        +resultSet.getString("sname")+" Student Marks: "
                        +resultSet.getInt("marks"));
            }

            connection.close();

        }catch(ClassNotFoundException ex){

            System.out.println("The necessary class was not found in the external libraries");
            ex.printStackTrace();

        }catch(SQLException ex1){

            System.out.println("There was an exception executing the SQL provides");
            ex1.printStackTrace();

        }




    }
}
