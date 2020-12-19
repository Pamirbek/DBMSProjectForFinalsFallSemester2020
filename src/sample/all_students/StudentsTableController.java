package sample.all_students;

import com.mysql.cj.NativeSession;
import javafx.beans.value.ObservableValue;
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
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import javafx.fxml.FXML;
import sample.DBConnector;
import sample.Student;

public class StudentsTableController implements Initializable {

    @FXML
    private TableView<Student> tbData;

    @FXML
    public TableColumn<Student, String> colName;

    @FXML
    public TableColumn<Student, String> colSurname;

    @FXML
    public TableColumn<Student, Integer> colId;

    @FXML
    public TableColumn<Student, String> colGroup;

    ObservableList<Student> oblist = FXCollections.observableArrayList();

    public Button back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from student");

            while(rs.next()) {
                oblist.add(new Student(rs.getString("name"), rs.getString("surname"),
                        rs.getInt("id"),rs.getString("group")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colGroup.setCellValueFactory(new PropertyValueFactory<>("group"));

        tbData.setItems(oblist);

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

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }});

        }
    }

