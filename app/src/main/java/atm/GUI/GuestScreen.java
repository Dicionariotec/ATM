package atm.GUI;

import atm.ScreenTransition;
import atm.Factories.user.UserGetFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GuestScreen {
	Parent parent;
	
	ScreenTransition screenTransition;
	UserGetFactory userGetFactory;
	
	public GuestScreen(ScreenTransition screenTransition) {
		this.screenTransition = screenTransition;
		userGetFactory = new UserGetFactory();
	}
	
	private void createContent() {
    	Label userNameLabel = new Label("Numero usuario");
    	Label userPasswordLabel = new Label("Senha usuario");
    	TextField userNameTextField = new TextField();
    	TextField userPasswordTextField = new TextField();
    	Button submitButton = new Button("Acessar");
    	
    	submitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
		        try {
		        	userGetFactory.getUserGetController().userGetInputData(userNameTextField.getText(), userPasswordTextField.getText());
				} catch (Exception e) {
					Alert alert = new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
					alert.showAndWait();
					// TODO: log
					return;
				}
		        
				screenTransition.goToHomeScreen(userGetFactory.getUserGetPresenter().getUserGetOutputData());
			}
		});
    	
    	GridPane gridPane = new GridPane();
    	gridPane.add(userNameLabel, 0, 0);
    	gridPane.add(userNameTextField, 1, 0);
    	gridPane.add(userPasswordLabel, 0, 1);
    	gridPane.add(userPasswordTextField, 1, 1);
    	gridPane.add(submitButton, 0, 2);
    	gridPane.setHgap(10);
    	gridPane.setVgap(2);
    	
    	HBox hBox = new HBox(gridPane);
    	hBox.setAlignment(Pos.CENTER);
    	
    	VBox vBox = new VBox(hBox);
    	vBox.setAlignment(Pos.TOP_CENTER);
    	
        parent = vBox;
    }
	
	public Parent getParent() {
		if (parent == null) {
			createContent();
		}
		
		return parent;
	}
}
