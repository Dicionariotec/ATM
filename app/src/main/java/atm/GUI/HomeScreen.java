package atm.GUI;

import atm.ScreenTransition;
import atm.Factories.transaction.TransactionGetFactory;
import atm.Factories.user.UserUpdateFactory;
import infra.transaction.get.output.TransactionGetOutputData;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import usecase.user.get.output.UserGetOutputData;

public class HomeScreen {
	Parent parent;
	TableView<TransactionGetOutputData> transactionsTableView = new TableView<>();
	StringProperty currentBalance = new SimpleStringProperty();
	String userName;
	int userId;
	
	ObservableList<TransactionGetOutputData> transactions = FXCollections.observableArrayList();
	ScreenTransition screenTransition;
	TransactionGetFactory transactionGetFactory;
	UserUpdateFactory userUpdateFactory;
	
	public HomeScreen(ScreenTransition screenTransition, String currentBalance, String userName, int userId) {
		this.screenTransition = screenTransition;
		this.currentBalance.set(currentBalance);
		this.userName = userName;
		this.userId = userId;
		
		transactionGetFactory = new TransactionGetFactory();
		userUpdateFactory = new UserUpdateFactory();
	}
	
	private Button depositButton() {
		Button depositButton = new Button("Deposito");
    	depositButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				screenTransition.goToDepositScreen(currentBalance.get(), userId);
			}
		});
    	
    	return depositButton;
	}
	
	private Button withdrawalButton() {
		Button withdrawalButton = new Button("Saque");
		withdrawalButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				screenTransition.goToWithdrawalScreen(currentBalance.get(), userId);
			}
		});
    	
    	return withdrawalButton;
	}
	
	private void errorAlert() {
		Alert alert = new Alert(AlertType.ERROR, "Historico de transicoes nao pode ser obtido", ButtonType.OK);
		alert.showAndWait();
	}
	
	@SuppressWarnings("unchecked")
	private void createContent() {
		Label userLabel = new Label("Usuario: ");
		Label balanceLabel = new Label("Balanco: ");
		Label userNameLabel = new Label(userName);
		Label userBalanceLabel = new Label(currentBalance.get());
		userBalanceLabel.textProperty().bind(currentBalance);
    	
    	try {
    		transactionGetFactory.getTransactionGetController().transactionGetInputData(userId);
		} catch (Exception e) {
			errorAlert();
			return;
		}
    	
    	transactions.addAll(transactionGetFactory.getTransactionGetPresenter().getTransactionGetOutputData());
    	
    	TableColumn<TransactionGetOutputData, String> amounTableColumn = new TableColumn<>("Quantia");
    	TableColumn<TransactionGetOutputData, String> typeTableColumn = new TableColumn<>("Tipo");
    	TableColumn<TransactionGetOutputData, String> datetimeTableColumn = new TableColumn<>("Data");
    	transactionsTableView.getColumns().addAll(amounTableColumn, typeTableColumn, datetimeTableColumn);
    	transactionsTableView.setItems(transactions);
    	amounTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
    	typeTableColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
    	datetimeTableColumn.setCellValueFactory(new PropertyValueFactory<>("datetime"));
    	transactionsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
    	
    	GridPane gridPane = new GridPane();
    	gridPane.add(userLabel, 0, 0);
    	gridPane.add(userNameLabel, 1, 0);
    	gridPane.add(balanceLabel, 0, 1);
    	gridPane.add(userBalanceLabel, 1, 1);
    	gridPane.add(depositButton(), 0, 2);
    	gridPane.add(withdrawalButton(), 1, 2);
    	gridPane.setAlignment(Pos.CENTER);
    	gridPane.setHgap(10);
    	
    	HBox hBox = new HBox(gridPane);
    	hBox.setAlignment(Pos.TOP_CENTER);
    	
    	VBox vBox = new VBox(hBox, transactionsTableView);
    	vBox.setAlignment(Pos.TOP_CENTER);
    	
        parent = vBox;
	}
	
	public Parent getParent() {
		if (parent == null) {
			createContent();
		}
		
		return parent;
	}
	
	public void refreshScreen() {
		try {
			// Obtem lista atualizada do historico de transacoes
			transactionGetFactory.getTransactionGetController().transactionGetInputData(userId);
		} catch (Exception e) {
			errorAlert();
		}
		
		TransactionGetOutputData[] transactionGetOutputData = transactionGetFactory.getTransactionGetPresenter().getTransactionGetOutputData();
		TransactionGetOutputData lastTransactionGetOutputData = transactionGetOutputData[transactionGetOutputData.length - 1];
		
		try {
			// Atualiza o balanco do usuario
			userUpdateFactory.getUserUpdateController().userInputUpdateData(userId, currentBalance.get(), lastTransactionGetOutputData.getAmount(), lastTransactionGetOutputData.getType());
		} catch (Exception e) {
			errorAlert();
		}
		
		currentBalance.set(userUpdateFactory.getUserUpdatePresenter().getBalanceAfter());

		transactions.clear();
		transactions.addAll(transactionGetOutputData);
		transactionsTableView.refresh();
	}
 }
