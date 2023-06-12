package atm;

import infra.user.get.output.UserGetOutputData;

public interface ScreenTransition {
	void goToHomeScreen(UserGetOutputData userGetOutputData);
	void goBackToHomeScreen();
	void goToDepositScreen(String balance, int userId);
	void goToWithdrawalScreen(String balance, int userId);
	void goToRefreshedHomeScreen();
	void goToGuestScreen();
}
