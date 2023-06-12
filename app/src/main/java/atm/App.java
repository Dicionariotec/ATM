/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package atm;

import atm.GUI.GuestScreen;
import atm.GUI.HomeScreen;
import atm.GUI.TransactionScreen;
import atm.GUI.TransactionScreen.Type;
import infra.user.get.output.UserGetOutputData;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application implements ScreenTransition {
	Stage stage;
	Scene scene;
	
	GuestScreen guestScreen;
	HomeScreen homeScreen;
	TransactionScreen depositTransactionScreen;
	TransactionScreen withdrawalTransactionScreen;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
    	guestScreen = new GuestScreen(this);
    	scene = new Scene(guestScreen.getParent(), 300, 300);
    	
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


	@Override
	public void goToHomeScreen(UserGetOutputData userGetOutputData) {
		if (homeScreen == null) {
			homeScreen = new HomeScreen(this, userGetOutputData.getUserBalance(), userGetOutputData.getUserName(), userGetOutputData.getUserId());
		}
		scene.setRoot(homeScreen.getParent());
	}


	@Override
	public void goToDepositScreen(String balance, int userId) {
		if (depositTransactionScreen == null) {
			depositTransactionScreen = new TransactionScreen(this, Type.deposit, userId);
		}
		depositTransactionScreen.setBalance(balance);
		scene.setRoot(depositTransactionScreen.getParent());
	}


	@Override
	public void goToWithdrawalScreen(String balance, int userId) {
		if (withdrawalTransactionScreen == null) {
			withdrawalTransactionScreen = new TransactionScreen(this, Type.withdrawal, userId);
		}
		withdrawalTransactionScreen.setBalance(balance);
		scene.setRoot(withdrawalTransactionScreen.getParent());
	}


	@Override
	public void goBackToHomeScreen() {
		if (homeScreen != null) {
			scene.setRoot(homeScreen.getParent());
		}
	}


	@Override
	public void goToRefreshedHomeScreen() {
		if (homeScreen != null) {
			homeScreen.refreshScreen();
			scene.setRoot(homeScreen.getParent());
		}
	}


	@Override
	public void goToGuestScreen() {
		homeScreen = null;
		depositTransactionScreen = null;
		withdrawalTransactionScreen = null;
		scene.setRoot(guestScreen.getParent());
	}
}
