package atm.Factories.user;

import atm.DB.User.UserMysql;
import infra.user.get.data.UserGetDataAccess;
import infra.user.get.data.UserGetModel;
import infra.user.get.input.UserGetController;
import infra.user.get.output.UserGetPresenter;
import usecase.user.get.UserGetInteractor;

public class UserGetFactory {
	// UseCase
	UserGetInteractor userGetInteractor;
	
	// Input
	UserGetController userGetController;
	
	// Output
	UserGetPresenter userGetPresenter;
	
	// Gateway
	UserGetDataAccess userGetDataAccess;
	
	// Database
	UserGetModel userGetModel;
	
	public UserGetFactory() {
		userGetModel = new UserMysql();
		userGetDataAccess = new UserGetDataAccess(userGetModel);
		
		userGetPresenter = new UserGetPresenter();
		userGetInteractor = new UserGetInteractor(userGetPresenter, userGetDataAccess);
        userGetController = new UserGetController(userGetInteractor);
	}
	
	public UserGetController getUserGetController() {
		return userGetController;
	}
	
	public UserGetPresenter getUserGetPresenter() {
		return userGetPresenter;
	}
}
