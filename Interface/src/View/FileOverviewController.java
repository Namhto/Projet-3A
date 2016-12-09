package View;

import Model.Teacher;
import controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

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

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        this.itemListView.setItems(mainApp.getItems());
        //this.itemColumn.setCellFactory();
    }

}
