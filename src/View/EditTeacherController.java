package View;

import Model.Teacher;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by maxim on 19/01/2017.
 */
public class EditTeacherController {

    @FXML
    private TextField textFieldName;
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
