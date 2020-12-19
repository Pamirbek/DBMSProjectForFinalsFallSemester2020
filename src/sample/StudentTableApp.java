//package sample;
//
//import javafx.application.Application ;
//import javafx.scene.control.TableView ;
//import javafx.scene.control.TableColumn ;
//import javafx.scene.control.cell.PropertyValueFactory ;
//import javafx.scene.layout.BorderPane ;
//import javafx.scene.Scene ;
//import javafx.stage.Stage ;
//
//public class StudentTableApp extends Application {
//    private StudentDataAccessor dataAccessor ;
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        dataAccessor = new StudentDataAccessor( "com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=falsev",
//                "root", "tipoparol"); // provide driverName, dbURL, user, password...
//
//        TableView<Student> studentTable = new TableView<>();
//        TableColumn<Student, String> nameCol = new TableColumn<>("name");
//        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
//        TableColumn<Student, String> surnameCol = new TableColumn<>("surname");
//        surnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
//        TableColumn<Student, String> idCol = new TableColumn<>("id");
//        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
//        TableColumn<Student, String> groupCol = new TableColumn<>("group");
//        groupCol.setCellValueFactory(new PropertyValueFactory<>("group"));
//
//        studentTable.getColumns().addAll(nameCol, surnameCol, idCol, groupCol);
//
//        studentTable.getItems().addAll(dataAccessor.getPersonList());
//
//        BorderPane root = new BorderPane();
//        root.setCenter(studentTable);
//        Scene scene = new Scene(root, 600, 400);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    @Override
//    public void stop() throws Exception {
//        if (dataAccessor != null) {
//            dataAccessor.shutdown();
//        }
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
