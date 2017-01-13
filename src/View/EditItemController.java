package View;

import Model.Item;
import Model.Teacher;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by maxime on 12/12/2016.
 */
public class EditItemController {

    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField setItemNameTextField;
    private Stage stage; // on s'en sert pour fermer la fenetre de dialogue lorsque l'on appuie sur Ok ou Cancel.

    private Teacher teacher;
    private Item item;
    private boolean okClicked = false;

    public boolean isOkClicked(){
        return okClicked;
    }

    public void setItem(Item it){
        this.item = it;
        this.setItemNameTextField.setText(item.getName());
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    @FXML
    private void handleOk(){
        if(this.isInputValid()) {
            this.item.setName(setItemNameTextField.getText());
            this.okClicked = true;
            this.stage.close();
        }
    }

    //Structure de controle pour s'assurer que l'utilisateur complète bien tous les champs
    private boolean isInputValid(){
        String errorMessage="";
        if(this.setItemNameTextField.getText()==null || this.setItemNameTextField.getText().length() == 0){
            errorMessage = "Please complete the item name";
        }

        if(errorMessage.length() == 0) {
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
