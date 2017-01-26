package View;

import Model.Course;
import Model.Teacher;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Created by maxim on 19/01/2017.
 */
public class EditTeacherController {

    @FXML
    private TextField textFieldName;
    @FXML
    private ComboBox<Course> comboBoxMatières;
    private Stage stage;

    private Teacher teacher;
    private boolean okClicked = false;

    public boolean isOkClicked(){
        return okClicked;
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
    public  void setTeacher(Teacher teacher){
        this.teacher = teacher;
        this.textFieldName.setText(teacher.getName());
    }
    public ComboBox<Course> getComboBoxMatières(){
        return comboBoxMatières;
    }

    /**
     * Permet d'afficher le nom de la matière dans le comboBox
     * Pour cela il faut crée une cellFactory et la lier au comboBox
     * @param c
     */
    public void setComboBoxMatières(ObservableList<Course> c){

        Callback<ListView<Course>, ListCell<Course>> cellFactory = new Callback<ListView<Course>, ListCell<Course>>() {
            @Override
            public ListCell<Course> call(ListView<Course> courseListView) {
                return new ListCell<Course>(){
                    @Override
                    protected void updateItem(Course course, boolean b) {
                        super.updateItem(course, b);
                        if(null == course) return;
                        setText(course.getName());
                    }
                };
            }
        };

        comboBoxMatières.setCellFactory(cellFactory);
        comboBoxMatières.setButtonCell(cellFactory.call(null));

        comboBoxMatières.setItems(c);
    }


    /**
     * Transforme une observableList<Course> en une observableList<String> pour pouvoir
     * les affichers comme il faut dans la comboBox d'edition d'un proffesseur
     */

    private void handleOk(){
        if(this.isInputValid()){
            this.teacher.setName(textFieldName.getText());
            this.okClicked = true;
            this.stage.close();
        }
    }

    //Structure de controle pour s'assurer que l'utilisateur complète bien tous les champs
    private boolean isInputValid(){
        String errorMessage="";
        if(this.textFieldName.getText()==null || this.textFieldName.getText().length() == 0){
            errorMessage = "Please complete the item name";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(this.stage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}
