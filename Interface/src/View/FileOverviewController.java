package View;

import Model.Curse;
import Model.Teacher;
import controller.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

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

    private MainApp mainApp;
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize(){
        //Handle ListView selection changes.
        itemListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == "Teachers"){
                // Définie les données à afficher dans cette colonne.
                this.itemColumn.setCellValueFactory(new PropertyValueFactory<Teacher,String>("name"));
                this.itemTableView.setItems(mainApp.getTeachers());
                this.itemColumn.setText("Teachers");
            }
            if(newValue == "Classes"){
                // Définie les données à afficher dans cette colonne.
                this.itemColumn.setCellValueFactory(new PropertyValueFactory<Curse,String>("curse"));
                this.itemTableView.setItems(mainApp.getCurses());
                this.itemColumn.setText("Curses");
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
        this.itemColumn.setText("Teachers");
    }

}
