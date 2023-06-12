package infra.user.get.data;

import domain.User.User;
import usecase.user.get.data.UserGetData;
import usecase.user.get.data.UserGetDataGateway;

public class UserGetDataAccess implements UserGetDataGateway {
	UserGetData userGetData;
	UserGetModel userGetModel;
	
	public UserGetDataAccess(UserGetModel userGetModel) {
		this.userGetModel = userGetModel;
	}

	@Override
	public synchronized User getUser(String number, String password) {		
		if (userGetData == null || userGetData.getNumber() != number) {
			userGetData = userGetModel.selectByNumber(number, password);
		}
		
		int userId = userGetData.getId();
		String userNumber = userGetData.getNumber();
		String userName = userGetData.getName();
		String userBalance = userGetData.getBalance();
		return new User(userId, userNumber, userName, userBalance);
	}
}
