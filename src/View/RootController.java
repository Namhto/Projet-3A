package View;

import controller.ExportToProlog;
import controller.MainApp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.web.WebView;
import javafx.util.Duration;




import java.awt.*;

/**
 * Created by maxime on 13/01/2017.
 */
public class RootController {

    @FXML
    private MenuItem menuItemExport;



    MainApp mainApp;

    /**
     * Export the objects (teachers, rooms,...) to prolog files so that the server prolog can handle them.
     */
    public void export(){
        ExportToProlog exportToProlog = new ExportToProlog();
        exportToProlog.exportTeachers(mainApp.getTeachers());
        exportToProlog.exportRooms(mainApp.getRooms());
        exportToProlog.exportCourses(mainApp.getCourses());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText(null);
        alert.setContentText("L'exportation c'est bien passé !");

        alert.showAndWait();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
