// Java JDBC(java database Connectivity)
//7 steps to follow

/*
1. import package----> java.sql
2. Load and register the driver ---> Class.forName(com.mysql.jdbc.driver)
3. Establish the connection--> getconnection() interface
4. Create the statement --> createStatement() interface
5. Execute the query
6. Process the query
7. Close
*/
//To insert the value into the database using prepared Statement
import java.sql.*;
import java.io.*;
import java.util.*;
class JDBC4
{
    public static void main(String agrs[])throws Exception
    {
        //url = "jdbc:mysql//localhostname:port no./name of db
        String url="jdbc:mysql://localhost:3306/student";
        String uname="abc";
        String pwd="";
        //String query="insert into  student values (4,'Ram')";
        String name="ali";
        int id=6;
        String query1="insert into  student values (?,?)";
        Class.forName("com.mysql.jdbc.driver");        //class is  used to load the class and not to create the instance of class
        Connection con =DriverManager.getConnection(url,uname,pwd);
        PreparedStatement st=con.prepareStatement(query1);
        st.setInt(1,id);
        st.setString(2, name);
        //ResultSet rs=st.executeQuery(query);
        int count = st.executeUpdate();
        System.out.println(count +"rows affected");
        /*while(rs.next())
        {
            String name = rs.getInt(1)+" "+rs.getString(1);
            System.out.println(name);
        }
        */
        
        st.close();
        con.close();
                
                
        
        
        
    }
}