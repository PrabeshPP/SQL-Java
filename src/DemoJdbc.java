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


        //Read data from the database






//            for(int i = 3; i<names.length+3; i++){
//                StringBuilder createQuery  = new StringBuilder("INSERT INTO STUDENT (sid,sname,marks) VALUES");
//                String tQuery = "("+i+","+"'"+names[i-3]+"'"+","+(int)(Math.random()*100)+")";
//                createQuery.append(tQuery);
////                System.out.println(createQuery);
//                st.execute(createQuery.toString());
//            }

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


            System.out.println("---------------------Updating a row in the SQL Table-------------------");
            String updateQuery = "UPDATE STUDENT SET SNAME='Charlie' WHERE SID=9";
            st.execute(updateQuery);


             query = "SELECT * FROM STUDENT";
             resultSet= st.executeQuery(query);
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
