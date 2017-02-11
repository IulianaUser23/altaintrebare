package anotherquestion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by icondor on 11/02/17.
 */
public class IonelDB {


    List astaResturnez = new ArrayList<String>();
    public List getFaqList(){
        try {
            Class.forName("org.postgresql.Driver");




            // 2. define connection params to db
            final String URL = "jdbc:postgresql://54.93.65.5:5432/5IonelD";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";

            // 3. obtain a connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 4. create a query statement
            Statement st = conn.createStatement();

            String query = "SELECT question,answer FROM faq order by question asc";
            // 5. execute a query
            ResultSet rs = st.executeQuery(query);

            // 6. iterate the result set and print the values
            while (rs.next()) {
                String quest = rs.getString("question").trim();
                astaResturnez.add(quest);

                // 7. close the objects

            }
            rs.close();
            st.close();
            conn.close();


        }
        catch(Exception ex){
                ex.printStackTrace();
            }

        return astaResturnez;
        }



    public void insert(String yyy)  {

        // presupun ca am tabela faq faq (id, intrebare, raspuns)

        // conectez la db
        // prep statememt
        //rules insert into
        //inchid ps
        // inchid conex


        final String URL = "jdbc:postgresql://54.93.65.5:5432/5IonelD";
        final String USERNAME = "fasttrackit_dev";

        final String PASSWORD = "fasttrackit_dev";



        // 3. obtain a connection
        try {

            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 4. create a query statement
            PreparedStatement pSt = conn.prepareStatement("INSERT INTO faq (question, answer) VALUES (?,?)");
            pSt.setString(1, yyy);
            pSt.setString(2, "");

            // 5. execute a prepared statement
            int rowsInserted = pSt.executeUpdate();

            // 6. close the objects
            pSt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
