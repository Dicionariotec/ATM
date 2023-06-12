package infra.user.update.output;

import usecase.user.update.output.UserUpdateOutputBoundary;

public class UserUpdatePresenter implements UserUpdateOutputBoundary {
	String balanceAfter;
	
	@Override
	public void generateUserBalanceOutputData(String balanceAfter) {
		this.balanceAfter = balanceAfter;
	}

	public String getBalanceAfter() {
		return balanceAfter;
	}
}
