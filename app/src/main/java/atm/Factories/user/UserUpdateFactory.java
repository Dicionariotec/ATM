package atm.Factories.user;

import atm.DB.User.UserMysql;
import infra.user.update.data.UserUpdateDataAccess;
import infra.user.update.data.UserUpdateModel;
import infra.user.update.input.UserUpdateController;
import infra.user.update.output.UserUpdatePresenter;
import usecase.user.update.UserUpdateInteractor;

public class UserUpdateFactory {
	// UseCase
	UserUpdateInteractor userUpdateInteractor;

	// Input
	UserUpdateController userUpdateController;

	// Output
	UserUpdatePresenter userUpdatePresenter;

	// Gateway
	UserUpdateDataAccess userUpdateDataAccess;

	// Database
	UserUpdateModel userUpdateModel;

	public UserUpdateFactory() {
		userUpdateModel = new UserMysql();
		userUpdateDataAccess = new UserUpdateDataAccess(userUpdateModel);

		userUpdatePresenter = new UserUpdatePresenter();
		userUpdateInteractor = new UserUpdateInteractor(userUpdatePresenter, userUpdateDataAccess);
		userUpdateController = new UserUpdateController(userUpdateInteractor);
	}

	public UserUpdateController getUserUpdateController() {
		return userUpdateController;
	}

	public UserUpdatePresenter getUserUpdatePresenter() {
		return userUpdatePresenter;
	}
}
