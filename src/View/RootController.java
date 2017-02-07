package View;

import controller.ExportToProlog;
import controller.MainApp;


import controller.TestServer;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;


import java.awt.*;

/**
 * Created by maxime on 13/01/2017.
 */
public class RootController {

    @FXML
    private javafx.scene.control.MenuItem menuItemExport;
    private MainApp mainApp;

    public MenuItem getMenuItemExport() {
        return menuItemExport;
    }

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

    public void generate() {
        TestServer server = new TestServer();
        server.run();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
