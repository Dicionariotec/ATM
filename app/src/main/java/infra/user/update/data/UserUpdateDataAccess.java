package infra.user.update.data;

import usecase.user.update.data.UserUpdateDataGateway;

public class UserUpdateDataAccess implements UserUpdateDataGateway {
	UserUpdateModel userUpdateModel;
	
	public UserUpdateDataAccess(UserUpdateModel userUpdateModel) {
		this.userUpdateModel = userUpdateModel;
	}
	
	@Override
	public synchronized String updateBalance(int userId, String balance) {
		return userUpdateModel.updateBalance(userId, balance);
	}

}
