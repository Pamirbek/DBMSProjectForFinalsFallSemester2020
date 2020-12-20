package sample.all_students;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.fxml.FXML;
import javafx.stage.StageStyle;
import sample.DBConnector;
import sample.Student;

public class StudentsTableController implements Initializable {

    @FXML
    private TableView<Student> tbData;

    @FXML
    public TableColumn<Student, String> name;

    @FXML
    public TableColumn<Student, String> surname;

    @FXML
    public TableColumn<Student, Integer> id;

    @FXML
    public TableColumn<Student, String> groupName;

    ObservableList<Student> oblist = FXCollections.observableArrayList();

    public Button back, deleteAll;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tbData.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        name.prefWidthProperty().bind(tbData.widthProperty().multiply(0.27));
        surname.prefWidthProperty().bind(tbData.widthProperty().multiply(0.27));
        id.prefWidthProperty().bind(tbData.widthProperty().multiply(0.2));
        groupName.prefWidthProperty().bind(tbData.widthProperty().multiply(0.25));
        name.setResizable(false);
        surname.setResizable(false);
        id.setResizable(false);
        groupName.setResizable(false);

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM students");

            while(rs.next()) {
                oblist.add(new Student(rs.getString("name"), rs.getString("surname"),
                        rs.getInt("id"),rs.getString("groupName")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        groupName.setCellValueFactory(new PropertyValueFactory<>("groupName"));

        tbData.setItems(oblist);

        deleteAll.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("areYouSure.fxml"));
                Parent root1 = null;
                try {
                    root1 = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Are you sure?");
                assert root1 != null;
                stage.setScene(new Scene(root1));
                stage.show();

            }
        });

        back.setOnAction(new EventHandler<>() {
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

