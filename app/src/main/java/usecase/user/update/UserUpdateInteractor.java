package usecase.user.update;

import domain.User.UserUpdateCalculateBalance;
import usecase.user.update.data.UserUpdateDataGateway;
import usecase.user.update.input.UserUpdateInputBoundary;
import usecase.user.update.output.UserUpdateOutputBoundary;

public class UserUpdateInteractor implements UserUpdateInputBoundary {
	UserUpdateOutputBoundary userUpdateOutputBoundary;
	UserUpdateDataGateway userUpdateDataGateway;
	
	public UserUpdateInteractor(UserUpdateOutputBoundary userUpdateOutputBoundary, UserUpdateDataGateway userUpdateDataGateway) {
		this.userUpdateDataGateway = userUpdateDataGateway;
		this.userUpdateOutputBoundary = userUpdateOutputBoundary;
	}
	
	@Override
	public void updateUserBalanceInputData(int userId, String balance, String amount, byte type) throws Exception {
		String newBalance = UserUpdateCalculateBalance.calculate(balance, amount, type);
		String balanceAfter = userUpdateDataGateway.updateBalance(userId, newBalance);
		userUpdateOutputBoundary.generateUserBalanceOutputData(balanceAfter);
	}
}
