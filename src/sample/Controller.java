package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    public javafx.scene.control.Button show, add, delete, addProject, deleteProject;
    public VBox vboxRoot;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection con;
        try {
            con = DBConnector.getConnection();

            Statement st = con.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS students (" +
                    "name varchar(50), surname varchar(50), id INT ,groupName varchar(7)," +
                    "PRIMARY KEY (id))";
            st.executeUpdate(query);
            query = "CREATE TABLE IF NOT EXISTS projects (" +
                    "projectName varchar(75) NOT NULL, projectId int NOT NULL, description TEXT DEFAULT NULL," +
                    "PRIMARY KEY (projectId), FOREIGN KEY (projectId) REFERENCES students(id))";
            st.executeUpdate(query);

            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        show.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage;
                Parent root = null;

                stage = (Stage) show.getScene().getWindow();
                try {
                    root = FXMLLoader.load(getClass().getResource("all_students/studentsTable.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                assert root != null;
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });

        add.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage;
                Parent root = null;

                stage = (Stage) add.getScene().getWindow();
                try {
                    root = FXMLLoader.load(getClass().getResource("add_student/addStudent.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                assert root != null;
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });

        delete.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage;
                Parent root = null;

                stage = (Stage) add.getScene().getWindow();
                try {
                    root = FXMLLoader.load(getClass().getResource("delete_student/deleteStudent.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                assert root != null;
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });

        addProject.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage;
                Parent root = null;

                stage = (Stage) add.getScene().getWindow();
                try {
                    root = FXMLLoader.load(getClass().getResource("add_project/AddProject.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                assert root != null;
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });

        deleteProject.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage;
                Parent root = null;

                stage = (Stage) add.getScene().getWindow();
                try {
                    root = FXMLLoader.load(getClass().getResource("delete_project/DeleteProject.fxml"));
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
