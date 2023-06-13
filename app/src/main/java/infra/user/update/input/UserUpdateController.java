package infra.user.update.input;

import application.user.update.input.UserUpdateInputBoundary;

public class UserUpdateController {
	UserUpdateInputBoundary userUpdateInputBoundary;
	
	public UserUpdateController(UserUpdateInputBoundary userUpdateInputBoundary) {
		this.userUpdateInputBoundary = userUpdateInputBoundary;
	}
	
	public void userInputUpdateData(int userId, String currentBalance, String amount, byte type) throws Exception {
		userUpdateInputBoundary.updateUserBalanceInputData(userId, currentBalance, amount, type);
	}
}
