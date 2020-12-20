package sample.all_students;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.DBConnector;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AreYouSureController implements Initializable {
    public Text text;
    public Button yes, no;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        yes.setOnAction(event -> {
            Connection con;
            try {
                con = DBConnector.getConnection();

                Statement st = con.createStatement();

                String query = "TRUNCATE TABLE students";
                st.executeUpdate(query);

                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Stage stage = (Stage) yes.getScene().getWindow();
            stage.close();

        });

        no.setOnAction(event -> {
            Stage stage = (Stage) yes.getScene().getWindow();
            stage.close();

        });
    }
}
