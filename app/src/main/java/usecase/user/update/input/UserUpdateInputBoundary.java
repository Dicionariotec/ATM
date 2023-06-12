package usecase.user.update.input;

public interface UserUpdateInputBoundary {
	void updateUserBalanceInputData(int userId, String currentBalance, String amount, byte type) throws Exception;
}
