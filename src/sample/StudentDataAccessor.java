package sample;
import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ;

import java.util.List ;
import java.util.ArrayList ;

public class StudentDataAccessor {

    private Connection connection ;

    public StudentDataAccessor(String driverClassName, String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName);
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public List<Student> getPersonList() throws SQLException {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("select * from student");
        ){
            List<Student> studentList = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int id = rs.getInt("id");
                String group = rs.getString("email_address");
                Student student = new Student(name, surname, id, group);
                studentList.add(student);
            }
            return studentList ;
        }
    }

    // other methods, eg. addPerson(...) etc
}
