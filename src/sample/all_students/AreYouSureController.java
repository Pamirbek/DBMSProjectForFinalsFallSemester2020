package sample.all_students;

import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.DBConnector;

import java.io.IOException;
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

                String query = "DELETE FROM students";
                st.executeUpdate(query);

                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Stage stage = (Stage) yes.getScene().getWindow();
            stage.close();


            Parent root = null;

            stage = (Stage) no.getScene().getWindow();
            try {
                root = FXMLLoader.load(getClass().getResource("../mainPage.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert root != null;
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });

        no.setOnAction(event -> {
            Stage stage = (Stage) yes.getScene().getWindow();
            stage.close();

        });
    }
}
