package View;

import Model.Course;
import Model.Item;
import Model.Room;
import Model.Teacher;
import controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * Created by maxime on 09/12/2016.
 */
public class FileOverviewController {

    @FXML
    private ListView itemListView;
    @FXML
    private TableView itemTableView;
    @FXML
    private TableColumn itemColumn;
    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane menu;
    @FXML
    private AnchorPane table;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;


    private MainApp mainApp;

    public void addItem() {
        System.out.println("11111111111");
        if (itemListView.getSelectionModel().getSelectedItem() == "Enseignants") {
            Teacher newTeacher = new Teacher();
            boolean okClicked = this.mainApp.showEditItemOverview(newTeacher);
            if (okClicked) {
                mainApp.getTeachers().add(newTeacher);
            }
        }

        if (itemListView.getSelectionModel().getSelectedItem() == "Cours") {
            Course newCourse = new Course();
            boolean okClicked = this.mainApp.showEditItemOverview(newCourse);
            if (okClicked) {
                mainApp.getCourses().add(newCourse);
            }
        }

        if(itemListView.getSelectionModel().getSelectedItem() == "Salles"){
            Room newRoom = new Room();
            boolean okClicked = this.mainApp.showEditItemOverview(newRoom);
            if (okClicked) {
                mainApp.getRooms().add(newRoom);
            }
        }
    }
    public void editItem(){
        Item selectedItem = (Item) this.itemTableView.getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            boolean alert = this.mainApp.showEditItemOverview(selectedItem);
            if(alert){
                System.out.println("Something");
            }
        }

    }
    public void deleteItem(){
        int selectedItem = itemTableView.getSelectionModel().getSelectedIndex();
        if(selectedItem >= 0){
            this.itemTableView.getItems().remove(selectedItem);
            System.out.println(selectedItem);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(this.mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No item Selected");
            alert.setContentText("Please select a item in the table.");
            alert.showAndWait();
        }
    }
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize(){
        //Handle ListView selection changes.
        itemListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == "Enseignants"){
                // Définie les données à afficher dans cette colonne.
                this.itemColumn.setCellValueFactory(new PropertyValueFactory<Teacher,String>("name"));
                this.itemTableView.setItems(mainApp.getTeachers());
                this.itemColumn.setText("Enseignants");
            }
            if(newValue == "Cours"){
                // Définie les données à afficher dans cette colonne.
                this.itemColumn.setCellValueFactory(new PropertyValueFactory<Course,String>("name"));
                this.itemTableView.setItems(mainApp.getCourses());
                this.itemColumn.setText("Cours");
            }
            if(newValue == "Salles"){
                this.itemColumn.setCellValueFactory(new PropertyValueFactory<Course,String>("name"));
                this.itemTableView.setItems(mainApp.getRooms());
                this.itemColumn.setText("Salles");
            }
        });
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        this.itemListView.setItems(mainApp.getItems());

        // Définie les données à afficher dans cette colonne.
        this.itemColumn.setCellValueFactory(new PropertyValueFactory<Teacher,String>("name"));
        // Une fois les setCelleValueFactory de chaque colone défini, on appele la methode setItems de TableView
        this.itemTableView.setItems(mainApp.getTeachers());
        this.itemColumn.setText("Enseignants");
    }



}
