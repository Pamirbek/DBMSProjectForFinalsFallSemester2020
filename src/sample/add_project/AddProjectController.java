package sample.add_project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.DBConnector;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AddProjectController implements Initializable {
    public TextField projectNameField, idField, projectDescriptionField;
    public Button submit, back;
    public Text check;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        submit.setOnAction(event -> {

            if (!projectNameField.getText().isEmpty() && !idField.getText().isEmpty() &&
                    !projectDescriptionField.getText().isEmpty()) {
                String idFieldStr = idField.getText();
                if (idFieldStr.matches("[0-9]+")) {

                    Connection con;
                    try {
                        con = DBConnector.getConnection();

                        Statement st = con.createStatement();

                        String query = "INSERT INTO projects (projectName, id, description)" +
                                "VALUES ( '" + projectNameField.getText() + "', " +
                                "'" + idField.getText() + "', " +
                                "'" + projectDescriptionField.getText() + "')";
                        st.executeUpdate(query);

                        con.close();
                        System.out.println("Projects was successfully added!");
                        check.setText("Project was added");


                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else { check.setText("ID must contain digits"); }
            } else { check.setText("One or several forms are empty"); }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage;
                Parent root = null;

                stage = (Stage) back.getScene().getWindow();
                try {
                    root = FXMLLoader.load(getClass().getResource("../mainPage.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                assert root != null;
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });
    }
}
