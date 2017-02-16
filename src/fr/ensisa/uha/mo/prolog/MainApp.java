package fr.ensisa.uha.mo.prolog;

import fr.ensisa.uha.mo.prolog.Model.Course;
import fr.ensisa.uha.mo.prolog.Model.Item;
import fr.ensisa.uha.mo.prolog.Model.Room;
import fr.ensisa.uha.mo.prolog.Model.Teacher;
import fr.ensisa.uha.mo.prolog.View.EditItemController;
import fr.ensisa.uha.mo.prolog.View.EditTeacherController;
import fr.ensisa.uha.mo.prolog.View.FileOverviewController;
import fr.ensisa.uha.mo.prolog.View.RootController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by maxime on 08/12/2016.
 */
public class MainApp extends Application {

    private ObservableList<Teacher> teachers = FXCollections.observableArrayList();
    private ObservableList<Course> courses = FXCollections.observableArrayList();
    private ObservableList<Room> rooms = FXCollections.observableArrayList();
    private ObservableList<String> items = FXCollections.observableArrayList();

    private Stage primaryStage;
    private BorderPane root;


    public ObservableList<Course> getCourses() {
        return courses;
    }


    public MainApp(){

        teachers.add(new Teacher("Perronne"));
        teachers.add(new Teacher("Hassenforder"));
        teachers.add(new Teacher("Thirion"));
        teachers.add(new Teacher("Bourgeois"));
        teachers.add(new Teacher("Studer"));
        teachers.add(new Teacher("Ruma"));

        courses.add(new Course("Java"));
        courses.add(new Course("C++"));
        courses.add(new Course("Android"));
        courses.add(new Course("Mathémathiques"));
        courses.add(new Course("Logique Floue"));
        courses.add(new Course("Anglais"));

        rooms.add(new Room("E25"));
        rooms.add(new Room("E24"));
        rooms.add(new Room("Grand Amphi"));
        rooms.add(new Room("Petit Amphi"));
        rooms.add(new Room("PC Master"));

        //items2.addAll(teachers,courses);

        /**
         *  Liste de gauche du Panel : affiche les catégories d'items
         */
        items.add("Enseignants");
        items.add("Cours");
        items.add("Salles");

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("EDT-Prolog");
        initRoot();
        showFileOverview();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<Teacher> getTeachers() {
        return teachers;
    }

    public ObservableList<String> getItems() {
        return this.items;
    }

    public ObservableList<Room> getRooms() {
        return rooms;
    }

    public Stage getPrimaryStage() {
        return this.primaryStage;
    }

    public void initRoot() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/root.fxml"));
        try {
            this.root = loader.load();
            Scene scene = new Scene((this.root));
            this.primaryStage.setScene(scene);

            //Donne accès au fr.ensisa.uha.mo.prolog.controller à fr.ensisa.uha.mo.prolog.MainApp
            RootController rootController = loader.getController();
            rootController.setMainApp(this);


            rootController.getMenuItemExport().setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));

            this.primaryStage.show();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showFileOverview(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View/fileOverview.fxml"));
            AnchorPane fileOverview = loader.load();
            this.root.setCenter(fileOverview);

            FileOverviewController controller = loader.getController();
            controller.setMainApp(this);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean showEditItemOverview(Item item){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View/editItem.fxml"));
            AnchorPane editItem = loader.load();
            Stage editDialog = new Stage();
            editDialog.setTitle("Edit Item Dialog");
            editDialog.initModality(Modality.WINDOW_MODAL);
            editDialog.initOwner(this.primaryStage);

            Scene scene = new Scene(editItem);
            editDialog.setScene(scene);
            EditItemController controller = loader.getController();
            controller.setStage(editDialog);
            controller.setItem(item);
            editDialog.showAndWait();
            return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showEditTeacherOverview(Teacher teacher){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View/editTeacher.fxml"));
            AnchorPane editItem = loader.load();
            Stage editDialog = new Stage();
            editDialog.setTitle("Edit Teacher Dialog");
            editDialog.initModality(Modality.WINDOW_MODAL);
            editDialog.initOwner(this.primaryStage);

            Scene scene = new Scene(editItem);
            editDialog.setScene(scene);
            EditTeacherController controller = loader.getController();
            controller.setStage(editDialog);
            controller.setTeacher(teacher);

            controller.setComboBoxMatières(courses);

            editDialog.showAndWait();
            return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
