package atm.GUI;

import atm.ScreenTransition;
import atm.Factories.transaction.TransactionInsertFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TransactionScreen {
	Parent parent;
	
	ScreenTransition screenTransition;
	Type transactionType;
	int userId;
	StringProperty balance = new SimpleStringProperty();
	TransactionInsertFactory transactionInsertFactory;
	
	public enum Type {
		deposit,
		withdrawal
	}
	
	public TransactionScreen(ScreenTransition screenTransition, Type transactionType, int userId) {
		this.screenTransition = screenTransition;
		this.transactionType = transactionType;
		transactionInsertFactory = 
				new TransactionInsertFactory();
		this.userId = userId;
	}
	
	private Button withdrawalButton(TextField amountTextField) {
		Button withdrawalButton = new Button("Sacar");
		withdrawalButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					byte withdrawalType = 2;
					transactionInsertFactory.getTransactionInsertController().transactionInsertInputData(balance.get(), amountTextField.getText(), userId, withdrawalType);
					if (transactionInsertFactory.getTransactionInsertPresenter().wasSuccessfullyInserted()) {
						screenTransition.goToRefreshedHomeScreen();
					}
				} catch (Exception e) {
					errorAlert(e.getMessage());
				}
			}
		});
		return withdrawalButton;
	}
	
	private Button depositButton(TextField amountTextField) {
		Button depositButton = new Button("Depositar");
		depositButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					byte depositType = 1;
					transactionInsertFactory.getTransactionInsertController().transactionInsertInputData(balance.get(), amountTextField.getText(), userId, depositType);
					if (transactionInsertFactory.getTransactionInsertPresenter().wasSuccessfullyInserted()) {
						screenTransition.goToRefreshedHomeScreen();
					}
				} catch (Exception e) {
					errorAlert(e.getMessage());
				}
			}
		});
		return depositButton;
	}
	
	private void errorAlert(String message) {
		Alert alert = new Alert(AlertType.ERROR, message, ButtonType.OK);
		alert.showAndWait();
	}
	
	private Button cancelButton() {
		Button cancelButton = new Button("Cancelar");
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				screenTransition.goBackToHomeScreen();
			}
		});
		return cancelButton;
	}
	
	private void createContent() {
		Label amountLabel = new Label("Quantidade");
		TextField amountTextField = new TextField();
		
		GridPane gridPane = new GridPane();
		gridPane.add(amountLabel, 0, 0);
		gridPane.add(amountTextField, 1, 0);
		if (transactionType == Type.deposit) {
			gridPane.add(depositButton(amountTextField), 0, 1);
		} else if (transactionType == Type.withdrawal) {
			gridPane.add(withdrawalButton(amountTextField), 0, 1);
		}
		gridPane.add(cancelButton(), 1, 1);
		gridPane.setHgap(10);
		
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
	
	public void setBalance(String balance) {
		this.balance.set(balance);
	}
}
